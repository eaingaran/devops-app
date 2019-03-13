package xyz.aingaran.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.aingaran.spring.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
