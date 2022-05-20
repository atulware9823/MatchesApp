package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.Matches;

public interface MatchesRepository extends MongoRepository<Matches, Integer> {

}
