package com.example.game_service_api.controller;

import com.example.game_service_api.commons.constants.ApiPathVariables;
import com.example.game_service_api.commons.entities.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathVariables.V1_ROUTE + ApiPathVariables.GAME_ROUTE) // Endpoint
public interface GameApi {
    @PostMapping
    ResponseEntity<Game> saveGame(@RequestBody Game game);
    @GetMapping("/{id}")
    ResponseEntity<Game> getGameById(@PathVariable String id);

    // PUT + DELETE ??
    @PutMapping
    ResponseEntity<Game> updateGame(@RequestBody Game game);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteGame(@PathVariable String id);
}
