<template>
  <div id="app">
    <nav>      
      <img :src="require('./assets/movie-time-logo.png')" class="logo"/>
      <router-link :to="{name: 'main-page'}">Home</router-link>  
      <router-link :to="{name: 'view-movies'}">Your Movies</router-link>
    </nav>
        <div id="page-divider"></div>        
    <router-view/>
  </div>
</template>

<style scoped>
#app {
  font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /* background-image: url(assets/vintage-movie-theater-darker.jpg);
  background-size: cover, contain; */
  height: 100vh;
}

nav {
  padding: 10px;
  text-align: left;
  display: flex;
  justify-content: space-evenly;
  margin-right: 40%;
}
#page-divider{
    border-bottom: solid 2px #F9F7F7;
}
nav a {
  font-weight: bold;
  color: #2c3e50;
  text-decoration: none;
  font-size: 1.7em;
  padding: 0px 30px;
  margin-top: 20px;
}

nav a.router-link-exact-active {
  color: rgb(101, 173, 197);
}

.logo{
  width: 20%;
}
</style>
