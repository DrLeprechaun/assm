import Vue from 'vue'
import App from './App.vue'
import router from './router'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import './assets/css/style.css'
import { store } from './store';
import VuejsDialog from 'vuejs-dialog';
import 'vuejs-dialog/dist/vuejs-dialog.min.css';
import { library } from '@fortawesome/fontawesome-svg-core'
import { faCoffee, faHome, faWrench, faInfo, faDoorOpen, faCut, faPlus, faBook, faUserPlus, faListAlt, faThumbsUp, faThumbsDown, faAddressCard, faDraftingCompass, faTools, faDatabase, faCubes, faCogs, faChessKnight, faSave, faFile, faUsers, faUserCog, faUserMinus, faCheck, faCrown, faUserAltSlash } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

library.add(faCoffee, faHome, faWrench, faInfo, faDoorOpen, faCut, faPlus, faBook, faUserPlus, faListAlt, faThumbsUp, faThumbsDown, faAddressCard, faDraftingCompass, faTools, faDatabase, faCubes, faCogs, faChessKnight, faSave, faFile, faUsers, faUserCog, faUserMinus, faCheck, faCrown, faUserAltSlash)
Vue.component('font-awesome-icon', FontAwesomeIcon)
Vue.config.productionTip = false
// Bootstrap
Vue.use(BootstrapVue)
Vue.use(VuejsDialog);

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
