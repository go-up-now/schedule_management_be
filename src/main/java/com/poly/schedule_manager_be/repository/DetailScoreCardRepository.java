package com.poly.schedule_manager_be.repository;

import com.poly.schedule_manager_be.entity.Detail_Score_Cards;
import com.poly.schedule_manager_be.entity.Study_History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailScoreCardRepository extends JpaRepository<Detail_Score_Cards, Integer> {
    List<Detail_Score_Cards> findAllByStudyHistory(Study_History studyHistory);
}
