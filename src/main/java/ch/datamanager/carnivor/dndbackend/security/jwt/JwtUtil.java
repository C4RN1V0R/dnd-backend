package ch.datamanager.carnivor.dndbackend.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

  private static final String AUTHORIZATION_HEADER = HttpHeaders.AUTHORIZATION;

  @Value("${jwt.secret}")
  private String jwtSecret;

  @Value("${jwt.validity}")
  private Period jwtValidity;

  public static Optional<String> extractTokenFromRequest(HttpServletRequest request) {
    try {
      return Optional.ofNullable(request.getHeader(AUTHORIZATION_HEADER))
          .filter(header -> header.startsWith("Bearer "))
          .map(header -> header.substring(7)) // "Bearer " including the space
          .filter(token -> !token.isBlank());
    } catch (IndexOutOfBoundsException e) {
      return Optional.empty();
    }
  }

  public String issueToken(String username) {
    ZonedDateTime expiryDate = ZonedDateTime.now().plus(jwtValidity);
    return JWT.create()
        .withSubject(username)
        .withExpiresAt(Date.from(expiryDate.toInstant()))
        .sign(Algorithm.HMAC256(jwtSecret.getBytes()));
  }

  public Optional<DecodedJWT> decode(HttpServletRequest request) {
    return extractTokenFromRequest(request)
        .flatMap(this::decode);
  }

  public Optional<DecodedJWT> decode(String token) {
    if (Objects.isNull(token) || token.isBlank()) {
      return Optional.empty();
    }

    try {
      DecodedJWT decoded = JWT.require(Algorithm.HMAC256(jwtSecret.getBytes()))
          .build()
          .verify(token);
      return Optional.ofNullable(decoded);
    } catch (JWTVerificationException e) {
      // todo: logging, or proper exception handling
      return Optional.empty();
    }

  }
}
