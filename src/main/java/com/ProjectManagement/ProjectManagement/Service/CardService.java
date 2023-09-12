package com.ProjectManagement.ProjectManagement.Service;

import com.ProjectManagement.ProjectManagement.Model.Board;
import com.ProjectManagement.ProjectManagement.Model.Card;
import com.ProjectManagement.ProjectManagement.Repository.BoardRepository;
import com.ProjectManagement.ProjectManagement.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    BoardRepository boardRepository;

    public Card createCard(Long boardId, Card card) {
        Board board = boardRepository.findById(boardId).get();
        Card newCard = new Card();
        newCard.setBoard(board);
        newCard.setId(card.getId());
        newCard.setTitle(card.getTitle());
        newCard.setSection(card.getSection());
        newCard.setDescription(card.getDescription());
        return cardRepository.save(newCard);
    }

    public List<Card> getCardsInBoard(Long boardId) {
        return cardRepository.findByBoardId(boardId);
    }

    public Card getCardById(Long boardId, Long cardId) {
        return cardRepository.findById(cardId)
                .orElseThrow(() -> new EntityNotFoundException("Card not found with id: " + cardId));
    }

    public Card updateCard(Long boardId, Long cardId, Card updatedCard) {
        Card card = getCardById(boardId, cardId);

        card.setTitle(updatedCard.getTitle());
        card.setDescription(updatedCard.getDescription());
        card.setSection(updatedCard.getSection());

        return cardRepository.save(card);
    }

    public void deleteCard(Long boardId, Long cardId) {
        Card card = getCardById(boardId, cardId);
        cardRepository.delete(card);
    }
}
