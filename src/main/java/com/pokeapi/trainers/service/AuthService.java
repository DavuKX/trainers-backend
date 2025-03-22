package com.pokeapi.trainers.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import com.pokeapi.trainers.dto.JwtResponse;
import com.pokeapi.trainers.exception.EmailAlreadyExistsException;
import com.pokeapi.trainers.exception.InvalidCredentialsException;
import com.pokeapi.trainers.exception.InvalidDateException;
import com.pokeapi.trainers.security.services.UserDetailsImpl;
import com.pokeapi.trainers.security.services.jwt.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pokeapi.trainers.dto.TrainerResponseDTO;
import com.pokeapi.trainers.mapper.TrainerMapper;
import com.pokeapi.trainers.model.Trainer;
import com.pokeapi.trainers.repository.TrainerRepository;

@Service
public class AuthService implements IAuthService {
    private final TrainerRepository trainerRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    AuthService(TrainerRepository trainerRepository, AuthenticationManager authenticationManager, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.trainerRepository = trainerRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public JwtResponse login(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtUtil.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Trainer trainer = trainerRepository.findByEmail(userDetails.getUsername()).orElseThrow(InvalidCredentialsException::new);

        return new JwtResponse(jwtToken, "Bearer", trainer.getEmail(), trainer.getId());
    }

    @Override
    public TrainerResponseDTO register(String firstName, String lastName, String email, String password, String birthDate) {
        trainerRepository.findByEmail(email).ifPresent(trainer -> {
            throw new EmailAlreadyExistsException("Email already exists");
        });

        Trainer trainer = new Trainer();
        trainer.setFirstName(firstName);
        trainer.setLastName(lastName);
        trainer.setEmail(email);
        trainer.setPassword(passwordEncoder.encode(password));

        if (birthDate != null) {
            try {
                trainer.setBirthDate(formatter.parse(birthDate));
            } catch (ParseException e) {
                throw new InvalidDateException("La fecha " + birthDate + " es inválida. Debe tener el formato dd-MM-yyyy");
            }
        }

        Trainer savedTrainer = trainerRepository.save(trainer);
        return TrainerMapper.entityToResponse(savedTrainer);
    }

    @Override
    public TrainerResponseDTO me() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Trainer> trainer = trainerRepository.findByEmail(userDetails.getUsername());

        if (trainer.isEmpty()) {
            throw new InvalidCredentialsException();
        }

        return TrainerMapper.entityToResponse(trainer.get());
    }
}
