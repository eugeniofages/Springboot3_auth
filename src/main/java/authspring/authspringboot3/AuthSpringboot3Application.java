package authspring.authspringboot3;

import authspring.authspringboot3.auth.AuthService;
import authspring.authspringboot3.auth.RegisterRequest;
import authspring.authspringboot3.auth.User.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuthSpringboot3Application {

    public static void main(String[] args) {
        SpringApplication.run(AuthSpringboot3Application.class, args);
    }

//    @Bean
// TEST USER
//    public CommandLineRunner commandLineRunner(
//            AuthService service
//    ) {
//        return args -> {
//            var admin = RegisterRequest.builder()
//                    .username("admin")
//                    .firstname("admin")
//                    .lastname("Admin")
//                    .country("Canada")
//                    .password("123456")
//                    .role(Role.ADMIN)
//                    .build()
//                    ;
//
//            System.out.println("ADMIN token: " +service.register(admin).getToken());
//
//
//            var manager = RegisterRequest.builder()
//                    .username("manager")
//
//                    .firstname("manager")
//                    .lastname("manager")
//                    .country("Canada")
//                    .password("123456")
//                    .role(Role.MANAGER)
//                    .build()
//                    ;
//
//            System.out.println("ADMIN token: " +service.register(manager).getToken());
//        };
//    }

}
