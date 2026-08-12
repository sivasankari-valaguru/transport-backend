package transport_backend.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String requestPath = request.getServletPath();

        // ============================================
        // PUBLIC ENDPOINTS
        // No JWT token required
        // ============================================

        if (requestPath.equals("/api/login")
                || requestPath.equals("/api/register")
                || requestPath.equals("/")
                || requestPath.startsWith("/swagger-ui")
                || requestPath.startsWith("/v3/api-docs")
                || requestPath.equals("/error")) {

            filterChain.doFilter(request, response);
            return;
        }

        // ============================================
        // GET AUTHORIZATION HEADER
        // ============================================

        String authHeader = request.getHeader("Authorization");

        // No token
        if (authHeader == null
                || !authHeader.startsWith("Bearer ")) {

            filterChain.doFilter(request, response);
            return;
        }

        // ============================================
        // EXTRACT JWT TOKEN
        // ============================================

        String token = authHeader.substring(7);

        try {

            // ============================================
            // VALIDATE TOKEN
            // ============================================

            if (jwtService.validateToken(token)) {

                String email =
                        jwtService.extractUsername(token);

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                email,
                                null,
                                Collections.emptyList()
                        );

                authentication.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );

                SecurityContextHolder
                        .getContext()
                        .setAuthentication(authentication);
            }

        } catch (Exception e) {

            // Invalid/expired token.
            // Continue the filter chain.
            // Spring Security will decide whether the
            // requested endpoint requires authentication.

            SecurityContextHolder.clearContext();
        }

        filterChain.doFilter(request, response);
    }
}