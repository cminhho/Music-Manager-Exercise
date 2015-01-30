package com.tma.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tma.model.Song;

public interface SongServiceImpl extends PagingAndSortingRepository<Song, String>{
	public Page<Song> getAllPagging(Pageable pageable);
	public Page<Song> findByNameSongPagging(String namesong, Pageable pageable);
	public List<Song> getAll();
//	public List<Song> getQueryPaging();
//	public List<Song> findBySongName(String songname, Pageable pageable);
//	public Song getWithId(String id);
//	public void addSong(Song song);
//	public void deleteSong(String id);
	public void updateSong(String id, Song song);
}
