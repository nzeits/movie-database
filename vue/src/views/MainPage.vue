<template>
  <div id="main">
    <div id="text">
      <h1>It's <br> Movie Time.</h1>
      <p>Never forget what movie you've watched again.<br>
      Movie Time keeps track of the movies you watch <br> 
      and the ratings you give them.</p>      
    </div>
    <div id="graphic">
        <img class="image" src="../assets/home-page-graphic.jpg" alt="movie image">
    </div>
  </div>
</template>

<script>

export default {
 components: { 
  
  }, 
  name: "main-page"
};
</script>

<style scoped>
h1{
  color: #112D4E;
  padding: 20px 0px;
  font-size: 5em;
  text-align: left;
}
p{
  color: #112D4E;
  font-size: 20px;
  /* margin-top: -30px; */
  font-weight: normal;
  text-align: left;
}
.image{
  width: 80%;
  padding: 50px 0px;
}
#main{
  padding: 3%;
  display: grid;
  grid-template-columns: 1fr 0.8fr;
  grid-template-areas: 
  "text graphic";
}
#text{
  grid-area: text;
  padding-left: 5%;
}
#graphic{
  grid-area: graphic;
}
</style>