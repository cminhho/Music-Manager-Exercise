package com.tma.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Song")
public class Song {
	private String id;
	private String name;
	private String genre;
	private String lastedUpdate;
	
	public Song() {
	}
	
	public Song(String name, String genre) {
		super();
		this.name = name;
		this.genre = genre;
	}

	public Song(String id, String name, String genre, String lastedUpdate) {
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.lastedUpdate = lastedUpdate;
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
	public String getLastedUpdate() {
		return lastedUpdate;
	}
	public void setLastedUpdate(String lastedUpdate) {
		this.lastedUpdate = lastedUpdate;
	}
	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", genre=" + genre
				+ ", lastedUpdate=" + lastedUpdate + "]";
	}
		
}
