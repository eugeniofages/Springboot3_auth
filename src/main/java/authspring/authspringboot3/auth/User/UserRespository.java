package authspring.authspringboot3.auth.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User,Integer>{
        Optional<User> findByUsername(String username);
}
