package com.pokeapi.trainers.security.services;

import com.pokeapi.trainers.model.Trainer;
import com.pokeapi.trainers.repository.TrainerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final TrainerRepository trainerRepository;

    public UserDetailsServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Trainer trainer = trainerRepository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("Username not found"));

        return UserDetailsImpl.build(trainer);
    }
}