package com.codingdojo.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{

	
//	Retrieves all songs in the database. 
	List<Song> findAll();
	
	// Retrieves songs containing the artists name, ignoring upper/lower casing
	List<Song> findByArtistIgnoreCaseContaining(String artistName);
	
	// Lists top 10 songs in descending order 
	List<Song> findTop10ByOrderByRatingDesc();
}
