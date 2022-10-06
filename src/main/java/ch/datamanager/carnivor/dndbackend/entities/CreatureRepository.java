package ch.datamanager.carnivor.dndbackend.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CreatureRepository extends JpaRepository<Creature, UUID> {
    @Override
    Optional<Creature> findById(UUID uuid);
}
