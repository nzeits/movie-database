<template>
  <div>
    <h1>Your Rated Movies</h1>
    <p>Keep track of the movies you watch and how you would rate them.</p>
    <view-movies />
  </div>
</template>

<script>
import ViewMovies from "../components/ViewMovies.vue"

export default {
 components: { 
  ViewMovies 
  }, 
  name: "main-page"
};
</script>

<style scoped>
h1{
  color: white;
  padding: 20px 0px;
  font-size: 50px;
}
p{
  color: white;
  font-size: 20px;
  /* margin-top: -30px; */
  font-weight: normal;
}
</style>