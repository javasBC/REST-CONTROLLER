package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

    public static List<Restaurant> listOfRest=new ArrayList<>();
    static{
        listOfRest.add(new Restaurant(1,"BBB",new Adress("menahim begin",13,(short)(1)),"Burgers",75.12));
        listOfRest.add(new Restaurant(2,"aad haetsem",new Adress("yad lpanim",33,(short)(1)),"Burgers",88.0));
        listOfRest.add(new Restaurant(3,"burger salon",new Adress("King goerge",21,(short)(1)),"Burgers",44.12));
        listOfRest.add(new Restaurant(4,"vetrina",new Adress("yaffo",15,(short)(1)),"Burgers",37.12));
    }


    @GetMapping("/restaurant")
    public List<Restaurant> getAllRestaurant(){

        return listOfRest;
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant getRestaurantById(@PathVariable String id ){
        var _id = Integer.parseInt(id);
        for(var r : listOfRest)
            if(r.id==_id)
                return r;

        return new Restaurant();
    }


    @GetMapping("/restaurantname/{name}")
    public Restaurant getRestaurantByName(@PathVariable String name ){
        for(var r : listOfRest)
            if(r.name.equals(name))
                return r;

        return new Restaurant();
    }



    @PostMapping("/restaurant")
    public void add(@RequestBody Restaurant restaurant ){
        listOfRest.add(restaurant);
    }

    @PutMapping("/restaurant/{id}")
    public void put(@RequestBody Restaurant restaurant,@PathVariable String id  ){
        var _id = Integer.parseInt(id);
        for(var r : listOfRest)
            if(r.id==_id){
                listOfRest.remove(r);
                listOfRest.add(restaurant);
            }
    }


    @DeleteMapping("/restaurant")
    public Boolean delete(){
        listOfRest.clear();
        return true;
    }

    @DeleteMapping("/restaurant/{id}")
    public void deletebyId(@PathVariable String id  ){
        var _id = Integer.parseInt(id);
        for(var r : listOfRest)
            if(r.id==_id){
                listOfRest.remove(r);
            }
    }











}
