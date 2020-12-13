package com.codingdojo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

@Controller
public class LookifyController {

	@Autowired
	private SongService songServ;
	
	
	
	@GetMapping("")
	public String index() {
		return "index.jsp";
	}
	
	//-------------------------Retrieves a song or all songs-------------------------//
	
	@GetMapping("/songs/{id}")
	public String showSong(@PathVariable("id")Long id, Model model) {
		
		// Retrieve one song
		Song oneSong = songServ.findSongById(id);
		
		// Pass song object to jsp to display
		model.addAttribute("song", oneSong);
		
		return "songpage.jsp";
		
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		
		// Retrieving all songs 
		List<Song> allSongs = songServ.allSongs();
		
		// Displaying all songs on dashboard
		model.addAttribute("allSongs", allSongs);
		
		return "dashboard.jsp";
	}
	
	//-------------------------Retrieves a song or all songs-------------------------//
	
	
	//-------------------------CREATING A SONG-------------------------//
	
		// Rendering the new song page
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("SongObj") Song song) {
		return "newsong.jsp";
	}
	
		// Processing the creation of the song
	@PostMapping("/songs/new")
	public String createSong(@Valid @ModelAttribute("SongObj") Song song, BindingResult results) {
		if(results.hasErrors()) {
			return "newsong.jsp";
		} else {
			songServ.createSong(song);
			return "redirect:/dashboard";
		}
		
	}
	
	//-------------------------CREATING A SONG-------------------------//

	
	//-------------------------DELETING A SONG-------------------------//
	
	@GetMapping("/songs/{id}/delete")
	public String deleteSongById(@PathVariable("id") Long id) {
		// Deletes particualar song by its Id
		songServ.deleteSong(id);
		return"redirect:/dashboard";
	}
	
	//-------------------------DELETING A SONG-------------------------//

	
	//-------------------------FIND SONG BY ARTIST-------------------------//

	@GetMapping("/search")
	public String searchByArtist(@RequestParam(value="search") String artistName, Model model) {
		
		List<Song> artistSongs = songServ.findSongsByArtist(artistName);
		
		model.addAttribute("songs", artistSongs);
		
		return "searchartist.jsp";
	}
	//-------------------------FIND SONG BY ARTIST-------------------------//
	
	
	//-------------------------FIND TOP 10 SONGS-------------------------//
	
	@GetMapping("/search/topTen")
	public String searchTopTen(Model model) {
		
		List<Song> topTenSongs = songServ.findTopTenSongs();
		
		model.addAttribute("topSongs", topTenSongs);
		
		return "toptensongs.jsp";
	}
}
