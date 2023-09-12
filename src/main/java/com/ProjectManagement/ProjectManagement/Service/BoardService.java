package com.ProjectManagement.ProjectManagement.Service;

import com.ProjectManagement.ProjectManagement.Model.Board;
import com.ProjectManagement.ProjectManagement.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Board getBoardById(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new EntityNotFoundException("Board not found with id: " + boardId));
    }

    public void deleteBoard(Long boardId) {
        boardRepository.deleteById(boardId);
    }
}
