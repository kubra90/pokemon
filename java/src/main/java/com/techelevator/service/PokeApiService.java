package com.techelevator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techelevator.model.Pokemon;

import java.util.List;

public interface PokeApiService {

    List<Pokemon> getPokemon() throws JsonProcessingException;
}
