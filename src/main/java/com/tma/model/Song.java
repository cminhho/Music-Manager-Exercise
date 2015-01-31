package com.tma.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "A song is a person's best friend")
@Document(collection="Song")
public class Song {
	
	@Id
	private String id;
	private String name;
	private String genre;
	private String file;
	
	public Song() {
	}
	
	public Song(String name, String genre, String file) {
		super();
		this.name = name;
		this.genre = genre;
		this.file = file;
	}

	public Song(String id, String name, String genre, String file) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.file = file;
	}
	
	@ApiModelProperty(value = "Order Status", required=true, allowableValues = "placed,approved,delivered")	  
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
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", genre=" + genre
				+ ", file=" + file + "]";
	}
	
	
		
}
