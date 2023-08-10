package security.securitySpring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import security.securitySpring.config.JwtService;
import security.securitySpring.controller.entity.Rol;
import security.securitySpring.controller.entity.User;
import security.securitySpring.models.AuthResponseDto;
import security.securitySpring.models.AuthenticationRequestDto;
import security.securitySpring.models.RegisterRequestDto;
import security.securitySpring.repository.UserRepositrory;

@Service
@RequiredArgsConstructor
public class AutServiceImpl implements IAuthService {

    private final UserRepositrory userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    @Override
    public AuthResponseDto register(RegisterRequestDto request) {
        var user = User.builder()
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .rol(Rol.USER)
        .build();
        userRepository.save(user);
        //Generamos el token
        var jwtToken = jwtService.generateToken(user);

        return AuthResponseDto.builder()
                .token(jwtToken).build();
    }

    @Override
    public AuthResponseDto authenticate(AuthenticationRequestDto request) {
        return null;
    }
}
