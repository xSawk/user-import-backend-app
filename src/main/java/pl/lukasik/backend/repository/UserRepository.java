package pl.lukasik.backend.repository;

import org.hibernate.cfg.beanvalidation.ValidationMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import pl.lukasik.backend.model.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
