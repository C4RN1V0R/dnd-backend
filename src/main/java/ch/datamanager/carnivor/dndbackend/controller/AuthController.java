package ch.datamanager.carnivor.dndbackend.controller;

import ch.datamanager.carnivor.dndbackend.service.AuthService;
import javax.annotation.Resource;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Resource
  private AuthService authService;

  @PostMapping("/sign-in")
  public String signIn(@RequestBody AuthRequest request) {
    return authService.signIn(request.getUsername(), request.getPassword());
  }

  @PostMapping("/sign-up")
  public String signUp(@RequestBody AuthRequest request) {
    return authService.signUp(request.getUsername(), request.getPassword());
  }

  @Data
  @FieldDefaults(level = AccessLevel.PRIVATE)
  public static class AuthRequest {
    String username;
    String password;
  }

}
