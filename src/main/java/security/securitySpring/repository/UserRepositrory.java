package security.securitySpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import security.securitySpring.controller.entity.User;

import java.util.Optional;

public interface UserRepositrory extends JpaRepository<User, Long> {
Optional<User> findUserByEmail(String email);
}
