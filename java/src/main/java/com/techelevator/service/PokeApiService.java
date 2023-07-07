package com.techelevator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techelevator.model.Pokemon;
import com.techelevator.model.PokemonDetail;

import java.util.List;

public interface PokeApiService {

    List<Pokemon> getPokemon() throws JsonProcessingException;

    PokemonDetail getPokemonDetailById(int id);
}
