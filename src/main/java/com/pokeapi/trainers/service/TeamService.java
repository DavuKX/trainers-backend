package com.pokeapi.trainers.service;

import com.pokeapi.trainers.dto.TeamRequestDTO;
import com.pokeapi.trainers.dto.TeamResponseDTO;
import com.pokeapi.trainers.dto.TeamUpdateRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TeamService implements ITeamService {
    private final WebClient webClient;

    @Value("${app.teams-service.url}")
    private String url;

    public TeamService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(url).build();
    }

    @Override
    public TeamResponseDTO create(TeamRequestDTO dto) {
        return webClient.post()
                .uri("/api/equipos")
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(TeamResponseDTO.class)
                .block();
    }

    @Override
    public TeamResponseDTO findById(Long id) {
        return webClient.get()
                .uri("/api/equipos/{id}", id)
                .retrieve()
                .bodyToMono(TeamResponseDTO.class)
                .block();
    }

    @Override
    public TeamResponseDTO update(Long id, TeamUpdateRequestDTO dto) {
        return webClient.put()
                .uri("/api/equipos/{id}", id)
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(TeamResponseDTO.class)
                .block();
    }

    @Override
    public void delete(Long id) {
        webClient.delete()
                .uri("/api/equipos/{id}", id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
