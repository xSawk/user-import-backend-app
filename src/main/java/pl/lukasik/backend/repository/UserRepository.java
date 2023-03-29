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

    UserEntity findByName(String name);

    @Query("SELECT u FROM UserEntity u WHERE u.name LIKE %:searchTerm% OR u.surname LIKE %:searchTerm% OR u.login LIKE %:searchTerm%")
    public Page<UserEntity> searchUsers(@Param("searchTerm") String searchTerm, Pageable pageable);
}
