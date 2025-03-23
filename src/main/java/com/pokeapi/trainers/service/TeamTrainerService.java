package com.pokeapi.trainers.service;

import com.pokeapi.trainers.dto.TeamTrainerRequestDTO;
import com.pokeapi.trainers.dto.TeamTrainerResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TeamTrainerService implements ITeamTrainerService {
    private final WebClient webClient;

    @Value("${app.teams-service.url}")
    private String url;

    public TeamTrainerService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(url).build();
    }

    @Override
    public TeamTrainerResponseDTO createTeamTrainer(TeamTrainerRequestDTO dto) {
        return webClient.post()
                .uri("/api/equipos-entrenador")
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(TeamTrainerResponseDTO.class)
                .block();
    }

    @Override
    public TeamTrainerResponseDTO getTeamTrainer(Long id) {
        return webClient.get()
                .uri("/api/equipos-entrenador/{id}", id)
                .retrieve()
                .bodyToMono(TeamTrainerResponseDTO.class)
                .block();
    }

    @Override
    public TeamTrainerResponseDTO getTeamTrainerByTrainerId(Long trainerId) {
        return webClient.get()
                .uri("/api/equipos-entrenador/entrenador/{trainerId}", trainerId)
                .retrieve()
                .bodyToMono(TeamTrainerResponseDTO.class)
                .block();
    }

    @Override
    public TeamTrainerResponseDTO updateTeamTrainer(Long id, TeamTrainerRequestDTO dto) {
        return webClient.put()
                .uri("/api/equipos-entrenador/{id}", id)
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(TeamTrainerResponseDTO.class)
                .block();
    }

    @Override
    public void deleteTeamTrainer(Long id) {
        webClient.delete()
                .uri("/api/equipos-entrenador/{id}", id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
