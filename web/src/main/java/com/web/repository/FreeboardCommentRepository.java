package com.web.repository;

import com.web.domain.FreeboardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreeboardCommentRepository extends JpaRepository<FreeboardComment, Long> {
    List<FreeboardComment> findByFreeId(Long freeId);
}
