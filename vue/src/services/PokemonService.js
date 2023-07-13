import axios from 'axios';

const http = axios.create ( {
    baseURL: 'http://localhost:9000'
})

export default {

    //get all Pokemon
    getAllPokemon() {
        return http.get('/pokemon');
    },
    getPokemonById(id){
        return http.get(`/pokemon/${id}`)
    },

    saveFavorite(pokemon) {
        return http.post('/pokemon', pokemon)
    },

    getNewPokemonList(start, end){
        return  http.get(`/pokemon/${start}/${end}`);
    }


}