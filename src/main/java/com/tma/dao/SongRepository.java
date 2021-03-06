package com.tma.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tma.model.Song;

public interface SongRepository extends MongoRepository<Song, String> {
	
	@Query("{'name':?0}")
	Page<Song> findByName(String name, Pageable pageable);
	
}
