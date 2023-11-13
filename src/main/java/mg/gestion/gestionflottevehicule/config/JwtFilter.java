package mg.gestion.gestionflottevehicule.config;

import java.io.IOException;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.NonNull;
import mg.gestion.gestionflottevehicule.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import static mg.gestion.gestionflottevehicule.handler.ResponseHandler.showError;


@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	UtilisateurService utilisateurService;

	@Autowired
	JwtGeneratorValidator jwtgenVal;

	@Override
	protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
			throws ServletException, IOException {
		String authorizationHeader = request.getHeader("Authorization");
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return ;
		}
		String token;
		String userName = null;

		token = authorizationHeader.substring("Bearer ".length());

		try {
			userName = jwtgenVal.extractUsername(token);
		} catch (ExpiredJwtException exception) {
			showError(response, new Exception("Your token is expired"), HttpStatus.FORBIDDEN);
			return;
		} catch (MalformedJwtException exception) {
			showError(response, new Exception("Your token is malformed"), HttpStatus.BAD_REQUEST);
			return;
		}

		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = utilisateurService.loadUserByUsername(userName);

			if (jwtgenVal.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = jwtgenVal.getAuthenticationToken(token, userDetails);
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}
}
