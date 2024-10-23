package com.example.game_service_api.services.impl;

import com.example.game_service_api.commons.entities.Game;
import com.example.game_service_api.commons.exceptions.GameException;
import com.example.game_service_api.repositories.GameRepository;
import com.example.game_service_api.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * The tye Game service
 */
@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    /**
     * Instantiates a new Game service
     *
     * @param gameRepository the game repository
     */
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    /**
     * Save game game
     *
     * @param gameRequest the game request
     * @return the game
     */
    @Override
    public Game saveGame(Game gameRequest) {
        return this.gameRepository.save(gameRequest);
    }

    @Override
    public Game getGameById(String id) {
        return this.gameRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND, "Game not found"));
    }

    /**
     * Put (Update) a existing game
     *
     * @param game the game request
     * @return
     */
    @Override
    public Game updateGame(Game game) {
        // comprovamos existe
        Game existingGame = this.gameRepository.findById(game.getId())
                .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND, "Game not found"));

        // Actualizar los campos de Game
        existingGame.setName(game.getName());
        existingGame.setUserId(game.getUserId());

        // Guarda el juego actualizado
        return this.gameRepository.save(existingGame);
    }

    @Override
    public void deleteGame(String id) {
        Game exisitingGame = this.gameRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND, "Game not found"));

        // Eliminar el juego existente
        this.gameRepository.delete(exisitingGame);
    }
}
