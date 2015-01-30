package com.tma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.tma.dao.SongDao;
import com.tma.dao.UserDao;
import com.tma.model.Song;

public class SongService implements SongServiceImpl{

	private SongDao songDao;

	@Autowired
	public SongService(SongDao songDao) {
		this.songDao = songDao;
	}

	@Override
	public Page<Song> findByNameSongPagging(String namesong, Pageable pageable) {
		// TODO Auto-generated method stub
		return songDao.findAll(pageable);
	}

	@Override
	public Page<Song> getAllPagging(Pageable pageable) {
		return songDao.findAll(pageable);
	}

	@Override
	public List<Song> getAll() {
		return songDao.findAll();
	}

	@Override
	public void updateSong(String id, Song song) {
		if(songDao.findOne(id) != null){
			songDao.save(song);
		}
	}
	
//	-----------------------------------------------
	@Override
	public Iterable<Song> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Song> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String id) {
		songDao.delete(id);
	}

	@Override
	public void delete(Song song) {
		songDao.delete(song);
	}

	@Override
	public void delete(Iterable<? extends Song> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Song> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Song> findAll(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Song findOne(String id) {
		// TODO Auto-generated method stub
		return songDao.findOne(id);
	}

	@Override
	public <S extends Song> S save(S arg0) {
		// TODO Auto-generated method stub
		songDao.save(arg0);
		return null;
	}

	@Override
	public <S extends Song> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
//
//	@Override
//	public Song getWithId(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void addSong(Song song) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteSong(String id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void updateSong(String id, Song song) {
//		// TODO Auto-generated method stub
//		
//	}

	
	
//	@Override
//	public List<Song> getAll() {
//		return songDao.findAll();
//	}
//
//	@Override
//	public Song getWithId(String id) {
//		return songDao.findOne(id);
//	}
//
//	@Override
//	public void addSong(Song song) {
//		songDao.save(song);
//	}
//
//	@Override
//	public void deleteSong(String id) {
//		songDao.delete(id);
//	}
//
//	@Override
//	public void updateSong(String id, Song song) {
//		if(songDao.findOne(id) != null){
//			songDao.save(song);
//		}
//	}

}
