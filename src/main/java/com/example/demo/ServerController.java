package com.example.demo;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class ServerController {
	
	@Autowired
	public ServerRepository serverRepository;
	
//	Insertion operation...
	@PostMapping(value = "/create")
	public ResponseEntity<String> createServerRecord(@RequestBody ServerDetails server) {
		ServerDetails insertedRecord = serverRepository.insert(server);		
		return new ResponseEntity<>("Server "+insertedRecord.getName().toUpperCase()+" details inserted in Mongodb Database successfully ",HttpStatus.CREATED);
	}
	
//	FetchAll operation when no server Id is provided...
	
	@GetMapping(value = "/getServer")
	public ResponseEntity<List<ServerDetails>> getAllDetails() {
		return new ResponseEntity<>(serverRepository.findAll(),HttpStatus.OK);	
	}
	
//	Fetch operation when Server Id is passed as a parameter and return 404 when data not found...
	@GetMapping(value = "/getServer/{serverId}")
	public ResponseEntity<Optional<ServerDetails>> getDetails(@PathVariable Integer serverId) {
		Optional<ServerDetails> data = serverRepository.findById(serverId);
		if(data.isEmpty()) {
			return new ResponseEntity<>(serverRepository.findById(serverId),HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(serverRepository.findById(serverId),HttpStatus.OK);
	}
	
	
//	Delete operation based on the Server Id and return 404 when data not found...
	@DeleteMapping(value = "/deleteRecord/{serverId}")
	public ResponseEntity<String> deleteServerRecord(@PathVariable Integer serverId) {
		Optional<ServerDetails> data = serverRepository.findById(serverId);
		if(data.isEmpty()) {
			return new ResponseEntity<>("Record Not Found",HttpStatus.NOT_FOUND);
		}		
		serverRepository.deleteById(serverId);
		return new ResponseEntity<>("Record Deleted successfully",HttpStatus.OK); 
		
	}

	
//	Find operation based on the Server Name and return 404 when data not found... 
	@GetMapping(value = "/findRecord/{serverName}")
	public ResponseEntity<List<ServerDetails>> findRecord(@PathVariable String serverName){
		List<ServerDetails> data = serverRepository.findByName(serverName);
		if(data.isEmpty()) {
			return new ResponseEntity<>(serverRepository.findByName(serverName),HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(serverRepository.findByName(serverName), HttpStatus.OK);
	}

}
