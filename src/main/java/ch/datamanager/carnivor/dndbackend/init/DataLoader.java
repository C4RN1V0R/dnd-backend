package ch.datamanager.carnivor.dndbackend.init;

import ch.datamanager.carnivor.dndbackend.entities.User;
import ch.datamanager.carnivor.dndbackend.entities.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    private Iterable<User> users = Arrays.asList(new User[]{
            User.builder()
                    .username("admin")
                    .passwd("nimda")
                    .mail("admin@dndnav.com")
                    .build(),
            User.builder()
                    .username("none")
                    .passwd("")
                    .mail("none@dndnav.com")
                    .build(),
            User.builder()
                    .username("user1")
                    .passwd("pass1")
                    .mail("user1@dndnav.com")
                    .build()
    });

    public void run(ApplicationArguments args) {
        userRepository.saveAll(users);
    }
}
