package security.securitySpring.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY ="6927d993a6639955241f6dda5e2e8f6068a5b264121313524ef7b2ededa1e17e";

    public String generateToken(UserDetails userDetails){
        return  generateToken(new HashMap<>(),userDetails);
    }
    /*
    Metodo para generar el token
     */
    public String generateToken(Map<String, Object>extracClaims,UserDetails userDetails){
        return Jwts.builder().setClaims(extracClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000 *60*24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUserName(String token){
        return getClaim(token, Claims::getSubject);
    }
    public <T> T getClaim(String token, Function<Claims, T>claimsResolver){
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaims(String token){
      return Jwts
              .parserBuilder()
              .setSigningKey(getSignInKey())
              .build()
              .parseClaimsJws(token)
              .getBody();
    }

    private Key getSignInKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username= getUserName(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }

    private Date getExpiration(String token) {
        return getClaim(token, Claims::getExpiration);
    }
}
