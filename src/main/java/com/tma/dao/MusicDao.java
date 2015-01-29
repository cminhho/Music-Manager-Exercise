package com.tma.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tma.model.Music;

@Repository
public interface MusicDao extends MongoRepository<Music, String>{

}
