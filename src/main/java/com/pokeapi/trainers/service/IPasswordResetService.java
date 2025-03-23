package com.pokeapi.trainers.service;

public interface IPasswordResetService {
    void sendResetToken(String email);
    void resetPassword(String token, String newPassword);
}
