package ch.datamanager.carnivor.dndbackend.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlayerCharacterRepository extends JpaRepository<PlayerCharacter, UUID> {
    @Override
    Optional<PlayerCharacter> findById(UUID uuid);

    List<PlayerCharacter> findAllByUserAndPersonality_Story(User user, Story story);

    List<PlayerCharacter> findAllByUser(User user);

    List<PlayerCharacter> findAllByPersonality_Story(Story story);

}
