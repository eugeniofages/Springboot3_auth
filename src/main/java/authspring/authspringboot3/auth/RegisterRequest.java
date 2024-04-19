package authspring.authspringboot3.auth;
import authspring.authspringboot3.auth.User.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
        String username;
        String password;
        String firstname;
        String lastname;
        String country;
        private Role role;
}
