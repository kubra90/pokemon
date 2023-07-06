package com.techelevator.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.techelevator.model.Pokemon;
import com.techelevator.service.PokeApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PokemonController

{

    @Autowired
    PokeApiService service;
    //spring is charge of the object and construction that i need


    //localhost:9000/pokemon
    @RequestMapping(path= "/pokemon", method= RequestMethod.GET)
    public List<Pokemon> getAllPokemon() throws JsonProcessingException {
        return service.getPokemon();
    }

}
