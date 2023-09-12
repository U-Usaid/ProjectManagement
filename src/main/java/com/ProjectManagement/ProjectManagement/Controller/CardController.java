package com.ProjectManagement.ProjectManagement.Controller;

import com.ProjectManagement.ProjectManagement.Model.Card;
import com.ProjectManagement.ProjectManagement.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards/{boardId}/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    // Create Card
    @PostMapping
    public ResponseEntity<Card> createCard(@PathVariable Long boardId, @RequestBody Card card) {
        Card createdCard = cardService.createCard(boardId, card);
        return new ResponseEntity<>(createdCard, HttpStatus.CREATED);
    }

    // Get Cards in a Board
    @GetMapping
    public ResponseEntity<List<Card>> getCardsInBoard(@PathVariable Long boardId) {
        List<Card> cards = cardService.getCardsInBoard(boardId);
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    // Get Card by ID in a Board
    @GetMapping("/{cardId}")
    public ResponseEntity<Card> getCardById(@PathVariable Long boardId, @PathVariable Long cardId) {
        Card card = cardService.getCardById(boardId, cardId);
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    // Update Card in a Board
    @PutMapping("/{cardId}")
    public ResponseEntity<Card> updateCard(@PathVariable Long boardId, @PathVariable Long cardId, @RequestBody Card card) {
        Card updatedCard = cardService.updateCard(boardId, cardId, card);
        return new ResponseEntity<>(updatedCard, HttpStatus.OK);
    }

    // Delete Card by ID in a Board
    @DeleteMapping("/{cardId}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long boardId, @PathVariable Long cardId) {
        cardService.deleteCard(boardId, cardId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
