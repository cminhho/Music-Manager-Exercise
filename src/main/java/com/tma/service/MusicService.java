package com.tma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tma.dao.MusicDao;
import com.tma.dao.UserDao;
import com.tma.model.Music;

public class MusicService implements MusicServiceImpl{

	private MusicDao musicDao;
	
	@Autowired
	public MusicService(MusicDao musicDao){
		this.musicDao = musicDao;
	}
	
	@Override
	public List<Music> getAll() {
		return musicDao.findAll();
	}

	@Override
	public Music getId(String id) {
		return musicDao.findOne(id);
	}

	@Override
	public void addMusic(Music music) {
		musicDao.save(music);
	}

	@Override
	public void updateMusic(String id, Music music) {
		if(musicDao.findOne(id) != null){
			musicDao.save(music);
		}
	}

	@Override
	public void deleteMusic(String id) {
		musicDao.delete(id);
	}



}
