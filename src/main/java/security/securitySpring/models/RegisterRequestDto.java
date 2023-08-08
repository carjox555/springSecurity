package security.securitySpring.models;

import lombok.*;

@Setter @Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
