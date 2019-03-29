import Vue from 'vue'
import axios from 'axios'
import App from './App.vue'
import router from './router'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import './assets/css/style.css'
import store from './store'
import { library } from '@fortawesome/fontawesome-svg-core'
import { faCoffee, faHome, faWrench, faInfo, faDoorOpen, faCut, faPlus, faBook, faUserPlus, faListAlt, faThumbsUp, faThumbsDown, faAddressCard, faDraftingCompass, faTools, faDatabase, faCubes, faCogs, faChessKnight, faSave, faFile } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

library.add(faCoffee, faHome, faWrench, faInfo, faDoorOpen, faCut, faPlus, faBook, faUserPlus, faListAlt, faThumbsUp, faThumbsDown, faAddressCard, faDraftingCompass, faTools, faDatabase, faCubes, faCogs, faChessKnight, faSave, faFile)
Vue.component('font-awesome-icon', FontAwesomeIcon)
Vue.config.productionTip = false
// Bootstrap
Vue.use(BootstrapVue)

const token = localStorage.getItem('user-token')
if (token) {
  axios.defaults.headers.common['Authorization'] = token
}

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')

