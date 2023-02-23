package ch.datamanager.carnivor.dndbackend.init;

import ch.datamanager.carnivor.dndbackend.entities.User;
import ch.datamanager.carnivor.dndbackend.entities.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @EventListener(ApplicationReadyEvent.class)
  public void setup() {
    if (userRepository.count() != 0) {
      // database already initialized -- skip
      return;
    }

    var users = List.of(
        User.builder()
            .username("admin")
            .passwd(passwordEncoder.encode("nimda"))
            .mail("admin@dndnav.com")
            .build(),
        User.builder()
            .username("none")
            .passwd(passwordEncoder.encode(""))
            .mail("none@dndnav.com")
            .build(),
        User.builder()
            .username("user1")
            .passwd(passwordEncoder.encode("pass1"))
            .mail("user1@dndnav.com")
            .build()
    );

    userRepository.saveAll(users);
  }

}
