package com.techelevator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.Pokemon;
import com.techelevator.model.PokemonDetail;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component //or @Service do the same thing
// connects through SpringBoot so that Spring knows that this is the class
//to run when we create a PokeApiService object. Because we can't create object from
//the interface class.
public class RestPokeApiService implements PokeApiService {

    RestTemplate restTemplate = new RestTemplate(); //talking to the external API By using Restful API
    private final String API_URL = "https://pokeapi.co/api/v2/pokemon/";
    @Override
    public List<Pokemon> getPokemon() throws JsonProcessingException {
        //resttemplate method
        String response = restTemplate.getForObject(API_URL, String.class);
//        System.out.println(response);
        ObjectMapper mapper = new ObjectMapper(); // create an object of this class
        List<Pokemon> pokemonList = new ArrayList<>(); //programming to the interface -- create our data structure

        JsonNode jsonNode = mapper.readTree(response); //turns the string response into a tree with nodes for us to grab.
        JsonNode root =jsonNode.path("results");
        for(int i=0; i <root.size(); i++){
            //root is "results" array;
            //path(i) --what array element
            String name =root.path(i).path("name").asText();
            String url = root.path(i).path("url").asText();
            int id =i +1;

            //create pokemon object and set the values and adding the values to the List.
            Pokemon temp = new Pokemon();
            temp.setId(id);
            temp.setName(name);
            temp.setUrl(url);
            pokemonList.add(temp);
        }

        return pokemonList;
    }

    @Override
    public PokemonDetail getPokemonDetailById(int id) {
        PokemonDetail pokemonDetail = restTemplate.getForObject(API_URL + id, PokemonDetail.class);
        System.out.println(pokemonDetail);
        return pokemonDetail;
    }
}
