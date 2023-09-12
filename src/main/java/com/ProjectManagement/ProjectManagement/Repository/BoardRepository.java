package com.ProjectManagement.ProjectManagement.Repository;

import com.ProjectManagement.ProjectManagement.Model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
