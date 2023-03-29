package pl.lukasik.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.lukasik.backend.model.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

        @Query("SELECT u FROM UserEntity u WHERE " +
                "LOWER(u.name) = LOWER(:searchValue) OR " +
                "LOWER(u.surname) = LOWER(:searchValue) OR " +
                "LOWER(u.login) = LOWER(:searchValue)")
        Page<UserEntity> searchUsers(@Param("searchValue") String searchValue, Pageable pageable);

}
