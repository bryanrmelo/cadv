package edu.ifrs.conhecimentoatravesvideos.session;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import edu.ifrs.conhecimentoatravesvideos.model.Usuario;
import edu.ifrs.conhecimentoatravesvideos.servicos.UsuarioServico;

@Component
public class SessionFilter extends OncePerRequestFilter {
    private final SessionHandler sessionHandler;
    private final UsuarioServico usuarioServico;

    @Autowired
    public SessionFilter(final  SessionHandler sessionHandler, final UsuarioServico usuarioServico) {
        this.sessionHandler = sessionHandler;
        this.usuarioServico = usuarioServico;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String sessionId = request.getHeader(HttpHeaders.AUTHORIZATION);        
        if(sessionId == null || sessionId.length() == 0) {
            chain.doFilter(request, response);
            return;
        }

        final Long userId = sessionHandler.getUsernameForSession(sessionId);
        if(userId == null) {
            chain.doFilter(request, response);
            return;
        }

        final Usuario usuario = usuarioServico.buscarPorId(userId);

        final UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
            usuario, 
            null
            usuario.getAuthorities()
        )

        auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(auth);
        chain.doFilter(request, response);
    }
}
