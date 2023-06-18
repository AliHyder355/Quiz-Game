package com.quiz.kbc.Repositories;

import com.quiz.kbc.Entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    public Player findByplayerName(String playerName);
}
