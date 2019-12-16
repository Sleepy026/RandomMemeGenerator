package com.codecool.textgenerator.repository;

import com.codecool.textgenerator.model.MemeText;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemeTextRepository extends JpaRepository<MemeText, Long> {
}
