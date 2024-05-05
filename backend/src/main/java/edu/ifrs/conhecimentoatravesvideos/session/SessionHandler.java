package edu.ifrs.conhecimentoatravesvideos.session;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class SessionHandler {
    private static final HashMap<String, Long> SESSIONS = new HashMap<>();

    public String registerSession(final Long userId) {
        if(userId == null) {
            throw new RuntimeException("Usuário precisa ser informado");
        }

        final String sessionId = generateSessionId();
        SESSIONS.putIfAbsent(sessionId, userId);
        return sessionId;
    }

    public Long getUsernameForSession(final String sessionId) {
        return SESSIONS.get(sessionId);
    }

    private String generateSessionId() {
        return new String(
            Base64.getEncoder().encode(
                UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8)
            )
        );
    }
}
