package security.securitySpring.service;

import security.securitySpring.models.AuthResponseDto;
import security.securitySpring.models.AuthenticationRequestDto;
import security.securitySpring.models.RegisterRequestDto;

public interface IAuthService {

    AuthResponseDto register(RegisterRequestDto request);
    AuthResponseDto authenticate(AuthenticationRequestDto request);
}
