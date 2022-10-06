package ch.datamanager.carnivor.dndbackend.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WorldRepository extends JpaRepository<World, UUID> {
    @Override
    Optional<World> findById(UUID uuid);
}
