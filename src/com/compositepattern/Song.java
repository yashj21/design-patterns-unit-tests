package com.compositepattern;

public class Song implements IPlaylist {
	private String songName;
	private String artist;
	private float speed = 1;
	
	public Song(String songName, String artist) {
		this.songName = songName;
		this.artist = artist;
	}

	public void play() {
		System.out.println("Playing song..."+this.songName);
	}

	public void setPlayBackSpeed(float speed) {
		this.speed+=speed;
	}

	public String getName() {
		return this.songName;
	}
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}


	
}
