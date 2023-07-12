<template>
  <div></div>

</template>

<script>
import pokemonService from '../services/PokemonService';
export default {
     name: 'pokemon-detail',
     props: {
        //id can be either number and string
        id: Number, String
     },
     data() {
        return {
            pokemon : {},
            spriteImgFront: "",
            spriteImgBack: ""
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