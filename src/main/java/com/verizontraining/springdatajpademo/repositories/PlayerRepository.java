package com.verizontraining.springdatajpademo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizontraining.springdatajpademo.models.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
