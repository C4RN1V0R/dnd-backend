package ch.datamanager.carnivor.dndbackend.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StoryRepository extends JpaRepository<Story, UUID> {
    @Override
    Optional<Story> findById(UUID uuid);

    List<Story> findAllByCreator(UUID uuid);
}
