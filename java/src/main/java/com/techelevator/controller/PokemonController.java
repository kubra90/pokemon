package com.techelevator.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.techelevator.dao.PokemonDao;
import com.techelevator.model.Pokemon;
import com.techelevator.model.PokemonDTO;
import com.techelevator.model.PokemonDetail;
import com.techelevator.service.PokeApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PokemonController {

    @Autowired
    PokeApiService service;
    //spring is charge of the object and construction that i need
    @Autowired
    PokemonDao dao;


    //localhost:9000/pokemon
    @RequestMapping(path = "/pokemon", method = RequestMethod.GET)
    public List<Pokemon> getAllPokemon() throws JsonProcessingException {
        return service.getPokemon();
    }

    @GetMapping(path = "/pokemon/{id}")
    public PokemonDetail getPokemonDetailById(@PathVariable int id) {
        return service.getPokemonDetailById(id);
    }

    @PostMapping("/pokemon")
    public void saveFavoritePokemon(@RequestBody PokemonDTO pokemon) {
        dao.savePokemon(pokemon);
    }

    @GetMapping("/pokemon/{startVal}/{endVal}")
    public List<Pokemon> getMorePokemon(@PathVariable int startVal, @PathVariable int endVal) {
     return service.getMorePokemon(startVal, endVal);
    }
}
