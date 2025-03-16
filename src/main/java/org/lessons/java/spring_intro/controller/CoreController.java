package org.lessons.java.spring_intro.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.lessons.java.spring_intro.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;



@Controller
@RequestMapping("/")

public class CoreController {
    @GetMapping("/welcome")
    public String welcome(@RequestParam(name="name") String name, Model model) {
        
        model.addAttribute("name",name);
        

        
        
        return "best";
    }

    @GetMapping("/songs")
    public String about(Model model) {
        model.addAttribute("songs",getBestSongs());
        return "songs";
    }

    @GetMapping("/songs/{id}")
    public String getSongById(@PathVariable("id") int id, Model model) {
        List<Song> songs = getBestSongs();
        Song song=songs.stream().filter(s -> s.getId()==id).findFirst().orElseThrow(()-> new RuntimeException("Song with id:"+id+"not found."));
        model.addAttribute("song",song);
        return "detailSong";
    }
    
    private List<Song> getBestSongs() {
        List<Song> newSongList= new ArrayList<>();
        newSongList.add(new Song(1,"imagine"));
        newSongList.add(new Song(2,"fix you"));
        newSongList.add(new Song(3,"big city life"));
        newSongList.add(new Song(4,"thriller"));

        return newSongList;
    }
    
}
