import Vue from 'vue'
import App from './App.vue'
import router from './router'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import './assets/css/style.css'
import { library } from '@fortawesome/fontawesome-svg-core'
import { faCoffee, faHome, faWrench, faInfo, faDoorOpen, faCut, faPlus, faBook, faUserPlus, faListAlt, faThumbsUp, faThumbsDown } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

library.add(faCoffee, faHome, faWrench, faInfo, faDoorOpen, faCut, faPlus, faBook, faUserPlus, faListAlt, faThumbsUp, faThumbsDown)
Vue.component('font-awesome-icon', FontAwesomeIcon)
Vue.config.productionTip = false
// Bootstrap
Vue.use(BootstrapVue)

new Vue({
    router,
    render: h => h(App)
}).$mount('#app')

