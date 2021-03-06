import Vue from 'vue'
import VueRouter from 'vue-router'
import MainPage from '../views/MainPage'
import ViewMovies from '../views/ViewMovies'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'main-page',
    component: MainPage
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/your-movies',
    name: 'view-movies',
    component: ViewMovies
  },
]

const router = new VueRouter({
  routes
})

export default router
