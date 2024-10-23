package com.example.game_service_api.controller.impl;

import com.example.game_service_api.commons.entities.Game;
import com.example.game_service_api.controller.GameApi;
import com.example.game_service_api.services.GameService;
import com.example.game_service_api.services.impl.GameServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Game controller
 */
@RestController
public class GameController implements GameApi {

    private final GameService gameService;

    /**
     * Instantiates a new Game Controller
     *
     * @param gameService the game service
     */
    public GameController(GameServiceImpl gameService) {
        this.gameService = gameService;
    }

    /**
     * Save game response entity
     *
     * @param game The game
     * @return the response entity
     */
    @Override
    public ResponseEntity<Game> saveGame(@RequestBody Game game) {
        var gameCreated = this.gameService.saveGame(game);
        return ResponseEntity.ok(gameCreated);
    }

    @Override
    public ResponseEntity<Game> getGameById(String id) {
        return ResponseEntity.ok(this.gameService.getGameById(id));
    }
}
