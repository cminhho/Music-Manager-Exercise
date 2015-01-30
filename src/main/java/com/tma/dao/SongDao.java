package com.tma.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tma.model.Song;

public interface SongDao extends MongoRepository<Song, String> {

}
