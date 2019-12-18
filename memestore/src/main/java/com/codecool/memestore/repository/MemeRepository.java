package com.codecool.memestore.repository;

import com.codecool.memestore.model.Meme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemeRepository extends JpaRepository<Meme, Long> {

    List<Meme> findAllByOrderByUpVoteDesc();
}
