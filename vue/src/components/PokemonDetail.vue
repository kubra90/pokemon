<template>
  <div>
    <h2> {{name}}</h2>
    <p> Height: {{ pokemon.height }}</p>
    <img v-bind:src="spriteImgFront" /> &nbsp;
    <img :src= "spriteImgBack"  />  
    <div>   
        <button v-on:click="savePokemon">Save as Favorite?</button>    
    </div>
</div>

</template>

<script>
import pokemonService from '../services/PokemonService.js';
export default {
     name: "pokemon-detail",
     props: {
        //id can be either number and string
        id: Number, String,
        name : String
     },
     data() {
        return {
            pokemon : {},
            spriteImgFront: "",
            spriteImgBack: ""
        }
     },
     methods: {
        savePokemon() { 
            let pokemonToSave = {
                id :this.id,
                name: this.name,
                url : this.$route.params.url
            }
            pokemonService.saveFavorite(pokemonToSave)
            .then(() => {
                alert(`${this.name} has been saved to Favorites`);
                //this push the route name pokemon
                this.$router.push({ name : 'pokemon'});
                // this.$store.commit("GET_NEXT_PREVIOUS_POKEMON");
            })
        }
     },
created() {
    pokemonService.getPokemonById(this.id)
    .then(response => {
      this.pokemon = response.data;
      this.spriteImgFront = response.data.sprites.front_default;
      this.spriteImgBack =response.data.sprites.back_default;
    })
}
}
</script>

<style>

</style>