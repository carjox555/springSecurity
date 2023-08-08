package security.securitySpring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import security.securitySpring.models.AuthResponseDto;
import security.securitySpring.models.AuthenticationRequestDto;
import security.securitySpring.models.RegisterRequestDto;
import security.securitySpring.service.IAuthService;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IAuthService authService;

    @PostMapping("register/")
    public ResponseEntity<AuthResponseDto>register(@RequestBody RegisterRequestDto request){
        return  ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("authenticate")
    public ResponseEntity<AuthResponseDto>authenticate(@RequestBody AuthenticationRequestDto request){
        return  ResponseEntity.ok(authService.authenticate(request));
    }
}
