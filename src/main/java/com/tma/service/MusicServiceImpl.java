package com.tma.service;

import java.util.List;

import com.tma.model.Music;
import com.tma.model.User;

public interface MusicServiceImpl {
	public List<Music> getAll();
	public Music getId(String id);
	public void addMusic(Music music);
	public void updateMusic(String id, Music music);
	public void deleteMusic(String id);
}