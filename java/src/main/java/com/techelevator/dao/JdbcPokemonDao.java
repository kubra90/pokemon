package com.techelevator.dao;

import com.techelevator.model.PokemonDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class JdbcPokemonDao implements PokemonDao{
    private JdbcTemplate template;

    public JdbcPokemonDao(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void savePokemon(PokemonDTO dto) {
      String sql = "INSERT INTO pokemon (api_id, name, url) VALUES (?, ?, ?)";
      template.update(sql, dto.getApiId(), dto.getName(), dto.getUrl());
    }
}
