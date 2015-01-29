package com.tma.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="music")
public class Music {
	
	@Id
	private String id;
	private String name;
	private String genre;
	private String path;
	private String lastUpdate;
	
	public Music() {
	}
	
	public Music(String id, String name, String genre, String path,
			String lastUpdate) {
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.path = path;
		this.lastUpdate = lastUpdate;
	}
	
	public Music(String name, String genre, String path) {
		this.name = name;
		this.genre = genre;
		this.path = path;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Music [id=" + id + ", name=" + name + ", genre=" + genre
				+ ", path=" + path + ", lastUpdate=" + lastUpdate + "]";
	}
	
	
	
}
