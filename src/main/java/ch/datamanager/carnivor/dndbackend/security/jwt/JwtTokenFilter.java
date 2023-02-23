package ch.datamanager.carnivor.dndbackend.security.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

  @Value("${jwt.allowed-endpoints}")
  private Set<String> allowedEndpoints;

  private final JwtUtil jwtUtil;

  private final UserDetailsService userDetailsService;


  @Override
  protected void doFilterInternal(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, FilterChain filterChain)
      throws ServletException, IOException {
    Optional<DecodedJWT> potentialDecodedToken = jwtUtil.decode(httpServletRequest);

    if (potentialDecodedToken.isPresent()) {
      DecodedJWT decodedJWT = potentialDecodedToken.get();
      authenticate(decodedJWT);
    } else if (!allowedEndpoints.contains(httpServletRequest.getRequestURI())) {
      SecurityContextHolder.clearContext();
      httpServletResponse.sendError(HttpStatus.UNAUTHORIZED.value(), "Token validation failed");
      return;
    }

    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }

  private void authenticate(DecodedJWT token) {
    UserDetails userDetails = userDetailsService.loadUserByUsername(token.getSubject());
    Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails,
        Strings.EMPTY, userDetails.getAuthorities());
    SecurityContextHolder.getContext().setAuthentication(authentication);
  }

}
