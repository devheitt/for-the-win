package com.github.for_the_win.blackjack.infrastructure

import com.github.for_the_win.blackjack.application.GetGameState
import com.github.for_the_win.blackjack.application.StartGame
import com.github.for_the_win.blackjack.domain.*
import com.github.for_the_win.blackjack.infrastructure.dtos.StartGameDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/blackjack")
class BlackJackController
constructor(
    private val getGameState: GetGameState,
    private val startGame: StartGame,
) {

    @GetMapping("{id}")
    fun gameStateById(@PathVariable id: String): ResponseEntity<GameState> {
        val gameId = GameId(id)
        val state = getGameState.invoke(gameId)
        return ResponseEntity.ok(state)
    }

    @PostMapping("/")
    fun createGame(@RequestBody dto: StartGameDTO): ResponseEntity<Game> {
        val gameId = GameId(dto.gameId)
        val players = dto.players.map { Player.fromPrimitives(it.id, it.name, it.cash) }

        val game = startGame.invoke(gameId, players)
        return ResponseEntity.ok(game)
    }
}
