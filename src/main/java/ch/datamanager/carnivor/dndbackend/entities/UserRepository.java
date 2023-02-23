package ch.datamanager.carnivor.dndbackend.entities;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Override
    Optional<User> findById(UUID uuid);

    List<User> findAll();

    Optional<User> findByUsername(String s);

    boolean existsByUsername(String username);

}
