package com.soluinoon.hasearch.repository;

import com.soluinoon.hasearch.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
