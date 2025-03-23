package com.pokeapi.trainers.service;

import com.pokeapi.trainers.model.PasswordResetToken;
import com.pokeapi.trainers.model.Trainer;
import com.pokeapi.trainers.repository.PasswordResetTokenRepository;
import com.pokeapi.trainers.repository.TrainerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PasswordResetService implements IPasswordResetService {
    private final PasswordResetTokenRepository tokenRepository;
    private final TrainerRepository trainerRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.frontend.url}")
    private String frontEndUrl;

    public PasswordResetService(PasswordResetTokenRepository passwordResetTokenRepository, TrainerRepository trainerRepository, EmailService emailService, PasswordEncoder passwordEncoder) {
        this.tokenRepository = passwordResetTokenRepository;
        this.trainerRepository = trainerRepository;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void sendResetToken(String email) {
        trainerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        String token = UUID.randomUUID().toString();
        PasswordResetToken resetToken = new PasswordResetToken(token, email, 30);
        tokenRepository.deleteByEmail(email);
        tokenRepository.save(resetToken);

        String resetLink = frontEndUrl + "/auth/reset-password?token=" + token;
        emailService.sendPasswordResetEmail(email, resetLink);
    }

    @Transactional
    public void resetPassword(String token, String newPassword) {
        PasswordResetToken passwordResetToken = tokenRepository.findByToken(token)
                .orElseThrow(() -> new IllegalArgumentException("Token invalida o expirado"));

        if (passwordResetToken.isExpired()) {
            throw new IllegalArgumentException("Token has expired");
        }

        Trainer trainer = trainerRepository.findByEmail(passwordResetToken.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        trainer.setPassword(passwordEncoder.encode(newPassword));
        trainerRepository.save(trainer);
        tokenRepository.delete(passwordResetToken);
    }
}
