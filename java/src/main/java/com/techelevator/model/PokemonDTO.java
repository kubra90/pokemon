package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonDTO {

    private int pokemonId;
    @JsonProperty("id")
    private int apiId;
    private String name;
    private String url;

    public int getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "PokemonDTO{" +
                "pokemonId=" + pokemonId +
                ", apiId=" + apiId +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
