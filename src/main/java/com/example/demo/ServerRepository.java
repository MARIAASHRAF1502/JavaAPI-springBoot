package com.example.demo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServerRepository  extends MongoRepository<ServerDetails,Integer>{

	List<ServerDetails> findByName(String serverName);
	

}

