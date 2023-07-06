package com.techelevator.service;

import com.techelevator.model.Pokemon;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestPokeApiService implements PokeApiService {

    RestTemplate restTemplate = new RestTemplate();
    @Override
    public List<Pokemon> getPokemon() {
        return null;
    }
}
