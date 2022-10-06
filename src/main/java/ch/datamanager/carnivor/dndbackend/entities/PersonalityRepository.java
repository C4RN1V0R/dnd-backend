package ch.datamanager.carnivor.dndbackend.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PersonalityRepository extends JpaRepository<Personality, UUID> {
    @Override
    Optional<Personality> findById(UUID uuid);
}
