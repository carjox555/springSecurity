package security.securitySpring.models;

import lombok.*;

@Setter @Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequestDto {
    private String email;
    private String password;
}
