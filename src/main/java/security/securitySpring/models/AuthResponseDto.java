package security.securitySpring.models;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDto {
    //Respondemos con el Token
    private String token;

}
