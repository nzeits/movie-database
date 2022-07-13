<template>
  <div id="main">
    <div id="movie-cards" v-for="movie in movies" v-bind:key="movie.id">
        <div id="title">
        <h2>{{movie.title}}</h2>
        </div>
        <div id="date">
        <h4>Date Watched:</h4>
        <h4>{{dateConverter(movie.dateAdded)}}</h4>
        </div>
        <div id="rating">
            <!-- <img src="../assets/star.png" alt="star ratings" v-for="n in movie.myRating" v-bind:key="n"> -->
            <!-- Trying to display a star for the rating. Doesn't work with a decimal -->
        <p>{{movie.myRating}}</p>
        </div>
    </div>
  </div>
</template>

<script>
import MovieService from "../services/MovieService"

export default {
    name: "view-movies",
    data(){
        return {
            movies: [],
        }
    },
    created(){
        MovieService.getAllMovies()
        .then((response) => {
            this.movies = response.data
        })
    },
    methods: {
        dateConverter(date){
        let newDate = new Date(date).toString();
        return newDate.substring(0, 11);            
        }
    }
}
</script>

<style scoped>
#movie-cards{
    width: 300px;
    height: auto;
    margin: 15px;
    padding: 5px;
    /* background-color: white; */
    border-radius: 5px;
    backdrop-filter: blur(8px);
    box-shadow: 0px 10px 15px 10px rgb(0 0 0 / 20%);
    color: white;
}
#main{
    display: flex;
    flex-wrap: wrap;
}
#title{
    margin: -10px 0px;
}
#date{
    display: flex;
    justify-content: space-evenly;
    margin: -20px 15px;
    font-size: 20px;

}
#rating{
    margin: -10px 0px;
    font-size: 20px;
}
#date :first-child{
    font-style: italic;
}

</style>