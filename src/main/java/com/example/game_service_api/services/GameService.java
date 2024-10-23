package com.example.game_service_api.services;

import com.example.game_service_api.commons.entities.Game;

public interface GameService {
    // POST
    Game saveGame(Game gameRequest);
    // GET
    Game getGameById(String id);
    // PUT
    Game updateGame(Game game);
    // DElETE
    void deleteGame(String id);
}
