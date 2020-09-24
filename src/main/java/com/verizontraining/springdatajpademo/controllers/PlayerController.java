package com.verizontraining.springdatajpademo.controllers;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.verizontraining.springdatajpademo.models.Player;
import com.verizontraining.springdatajpademo.repositories.PlayerRepository;
import com.verizontraining.springdatajpademo.requestPOJO.PlayerRequest;

@RestController
public class PlayerController {
	
	@Autowired
	private PlayerRepository playerRepository;
 
	@PostMapping("/player")
	public Player createPlayer(@RequestBody PlayerRequest playerRequest) {
		
		Player player = new Player();
		player.setName(playerRequest.getName());
		player.setFranchise(playerRequest.getFranchise());
		playerRepository.save(player);
		return player;
	}
	
	@GetMapping("/players")
	public List<Player> getPlayers(){
		return playerRepository.findAll();
	}
	
	@GetMapping("/player/{id}")
	public Optional<Player> getPlayer(@PathVariable Long id) {
		
		return playerRepository.findById(id);
	}
	
	@PutMapping("/player/{id}")
	
	public Player updatePlayer(@PathVariable Long id, @RequestBody PlayerRequest playerRequest ) {
		Player player = new Player();
		player.setName(playerRequest.getName());
		player.setFranchise(playerRequest.getFranchise());
		player.setId(id);
		return playerRepository.save(player);
	}
	
	
	@DeleteMapping("/player/{id}")
	
	public void deletePlayer(@PathVariable Long id) {
		 playerRepository.deleteById(id);
	}
	
	
}
