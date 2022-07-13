<template>
  <div id="app">
    <nav>
      <router-link to="/">Your Movies</router-link>
    </nav>
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
  background-image: url(assets/vintage-movie-theater-darker.jpg);
  background-size: cover, contain;
  height: 100vh;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
  text-decoration: none;
}

nav a.router-link-exact-active {
  color: white;
}
</style>
