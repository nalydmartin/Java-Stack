package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.SongRepository;

@Service
public class SongService {

	@Autowired
	private SongRepository songRepo;
	
	
	
	// Returns all songs from the repository
	public List<Song> allSongs() {
		return songRepo.findAll();
	}
	
	
	public Song findSongById(Long id) {
		Optional<Song> song = songRepo.findById(id);
		
		if(song.isPresent()) {
			return song.get();
		} else {
			return null;
		}
	}
	
	
	public Song createSong(Song song) {
		songRepo.save(song);
		return song;
	}
	
	// Deletes a song by its id
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
	
	
	public List<Song> findSongsByArtist(String artistName) {
		return songRepo.findByArtistIgnoreCaseContaining(artistName);
	}
	
	
	public List<Song> findTopTenSongs() {
		return songRepo.findTop10ByOrderByRatingDesc();
	}
	
}
