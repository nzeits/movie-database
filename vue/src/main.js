import Vue from 'vue'
import App from './App.vue'
import axios from 'axios'
import router from './router'

Vue.config.productionTip = false
axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;


new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
