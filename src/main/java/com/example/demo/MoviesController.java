package com.example.demo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MoviesController {

    public static List<Movie> Movies = new ArrayList<>();
    public static int ID=0;

    //static constructor
    static{
        Movies.add(new Movie(getID(),"Dog",120,130,"comedy"));
        Movies.add(new Movie(getID(),"Go",180,150,"drama"));
        Movies.add(new Movie(getID(),"fast 9",150,48,"action"));
        Movies.add(new Movie(getID(),"Adam project",119,65,"sci fi"));
    }

    private static int getID() {
        return ++ID;
    }
    ;


    @RequestMapping("/movie/{id}")
    public Movie getMovie(@PathVariable String id){
        var _id = Integer.parseInt(id);
        for (var movie:Movies) {
            if(movie.id==_id)
                return movie;
        }
        return new Movie();

    }

    @GetMapping("/movie")
    public List<Movie> getAllMovies(){
        return Movies;
    }



    @RequestMapping(method=RequestMethod.POST,value = "/movie")
        public Movie addMovie( @RequestBody Movie movie){
        movie.id=getID();
        Movies.add(movie);
        return movie;
    }

    @PutMapping("/movie/{id}")
    public boolean updateMove(@RequestBody Movie movie,@PathVariable String id)
    {
        var _id = Integer.parseInt(id);
        for (var m:Movies) {
            if(m.id==_id){
                movie.id=_id;
                var index= Movies.indexOf(m);
                Movies.remove(index);
                Movies.add(index,movie);
                return true;
            }
        }
        return  false;
    }


    @DeleteMapping("/movie/{id}")
    public String removeMovie(@PathVariable String id){
        var _id = Integer.parseInt(id);
        for (var m: Movies) {
            if(m.id==_id){
                Movies.remove(m);
                return "Done";
            }
        }
        return "something went wrong";
    }



}
