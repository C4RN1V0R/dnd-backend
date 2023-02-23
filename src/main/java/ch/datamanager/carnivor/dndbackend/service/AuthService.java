package ch.datamanager.carnivor.dndbackend.service;

import ch.datamanager.carnivor.dndbackend.entities.User;
import ch.datamanager.carnivor.dndbackend.entities.UserRepository;
import ch.datamanager.carnivor.dndbackend.security.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@RequiredArgsConstructor
public class AuthService {

  private final JwtUtil jwtUtil;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;

  public String signIn(String username, String password) {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(username, password));
      return jwtUtil.issueToken(username);
    } catch (AuthenticationException e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
          "Invalid username/password supplied");
    }
  }

  public String signUp(String username, String password) {
    if (userRepository.existsByUsername(username)) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already in use");
    }

    User user = User.builder()
        .username(username)
        .passwd(passwordEncoder.encode(password))
        .build();

    userRepository.save(user);

    return jwtUtil.issueToken(username);
  }

}
