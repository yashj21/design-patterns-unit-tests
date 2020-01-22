package com.compositepattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yashjain
 *
 */
public class Playlist implements IPlaylist {
	private List<IPlaylist> playlist = new ArrayList();
	private String playlistName;
	
	public Playlist(String playlistName) {
		this.playlistName = playlistName;
	}
	
	public Playlist() {
	}

	public void play() {
		for (IPlaylist playlst : playlist) {
			playlst.play();
		}
	}

	public void setPlayBackSpeed(float speed) {
		for (IPlaylist playlst : playlist) {
			playlst.setPlayBackSpeed(speed);
		}
	}
	public void add(IPlaylist playlist) {
		this.playlist.add(playlist);
	}
	public void remove (IPlaylist iPlaylist) {
		this.playlist.remove(iPlaylist);
	}
	
	public String getName() {
		return playlistName;
	}
	
}
