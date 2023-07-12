<template>
    <div>
<ul>    
  <li v-for = "pokemon in pokemonArray" v-bind:key="pokemon.id">
{{ pokemon.name }}</li>
</ul>
    </div>
  
</template>

<script>
import pokemonService from '../services/PokemonService.js';
export default {
  name: 'pokemon-list',
   data() {
      return {
        pokemonArray : []
      }
   },
   created() {
    // use a service to query the backend
    pokemonService.getAllPokemon() //this returns a promise
    .then(response => {
       console.log(response);
       this.pokemonArray = response.data
    })
   }
}
</script>

<style>

</style>