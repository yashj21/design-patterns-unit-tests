package com.compositepattern;

public class StartMain {
	public static void main(String[] args) {
		Playlist studyPlaylist = new Playlist("Study");
		Playlist synthPopPlaylist = new Playlist("test2");
		Song synthPopSong1 = new Song("Girl Like You", "abcd" );
		Song synthPopSong2 = new Song("experiment", "cdef");
		synthPopPlaylist.add(synthPopSong1);
		synthPopPlaylist.add(synthPopSong2);
		Playlist experimentalPlaylist = new Playlist("Experimental");		
		Song experimentalSong1 = new Song("About you", "XXYYXX");
		Song experimentalSong2 = new Song("Motivation", "test12");	
		Song experimentalSong3 = new Song("Computer Vision", " test");
		experimentalPlaylist.add(experimentalSong1);
		experimentalPlaylist.add(experimentalSong2);
		experimentalPlaylist.add(experimentalSong3);
		float slowSpeed = 0.5f;
		experimentalPlaylist.setPlayBackSpeed(slowSpeed);
		
		// Add the "Synth Pop" playlist to the "Experimental" playlist
		experimentalPlaylist.add(synthPopPlaylist);

		// Add the "Experimental" playlist to the "Study" playlist
		studyPlaylist.add(experimentalPlaylist);

		// Create a new song and set its playback speed to 1.25x, play this song, 
		// get the name of glitchSong → "Textuell", then get the artist of this song → "Oval"
		Song glitchSong = new Song("hello12", "hello");
		float fasterSpeed = 1.25f;
		glitchSong.setPlayBackSpeed(fasterSpeed);
		glitchSong.play(); 
		String name = glitchSong.getName();
		String artist = glitchSong.getArtist(); 
		System.out.println ("The song name is " + name );
		System.out.println ("The song artist is " + artist );

		// Add glitchSong to the "Study" playlist
		// Add glitchSong to the "Study" playlist
		studyPlaylist.add(glitchSong);

		// Play "Study" playlist.
		studyPlaylist.play(); 

		// Get the playlist name of studyPlaylist → "Study"
		System.out.println ("The Playlist's name is " + studyPlaylist.getName() );


	}
}
