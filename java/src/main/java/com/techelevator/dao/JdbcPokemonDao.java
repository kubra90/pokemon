package com.techelevator.dao;

import com.techelevator.model.PokemonDTO;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcPokemonDao implements PokemonDao{
    private JdbcTemplate template;
    @Override
    public void savePokemon(PokemonDTO dto) {

    }
}
