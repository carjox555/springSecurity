package security.securitySpring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
    @Override
    public AuthResponseDto register(RegisterRequestDto request) {
        var user = User.builder()
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .email(request.getEmail())
        .password(request.getPassword())
        .rol(Rol.USER)
        .build();
        userRepository.save(user);
        return null;
    }

    @Override
    public AuthResponseDto authenticate(AuthenticationRequestDto request) {
        return null;
    }
}
