package server.server.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.server.user.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    User findByUserName(String userName);
}