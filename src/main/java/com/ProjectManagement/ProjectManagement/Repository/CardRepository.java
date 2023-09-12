package com.ProjectManagement.ProjectManagement.Repository;

import com.ProjectManagement.ProjectManagement.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByBoardId(Long boardId);
}
