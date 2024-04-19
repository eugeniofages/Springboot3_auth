package authspring.authspringboot3.auth;

import org.springframework.stereotype.Service;

import authspring.authspringboot3.Jwt.JwtService;
import authspring.authspringboot3.auth.User.Role;
import authspring.authspringboot3.auth.User.User;
import authspring.authspringboot3.auth.User.UserRespository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class AuthService {
  private final UserRespository userRepository;
  private final JwtService jwtService;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;


  public AuthResponse login(LoginRequest request) {
    authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
    UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
    String token = jwtService.getToken(user);
    return AuthResponse.builder().token(token).build();
  }

  public AuthResponse register(RegisterRequest request) {
    String encodedPassword = passwordEncoder.encode(request.getPassword());

    User user = User.builder().username(request.getUsername())
        .password(encodedPassword)
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .country(request.getCountry())
        .role(request.getRole())
        .build();
    userRepository.save(user);
    return AuthResponse.builder()
        .token(jwtService.getToken(user))
        .build();
  }

}
