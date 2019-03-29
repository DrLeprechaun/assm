<template>
  <!--<div id="app">
    <div id="nav">
      <router-link to="/">Hello</router-link> |
      <router-link to="/callservice">Service</router-link> |
      <router-link to="/bootstrap">Bootstrap</router-link> |
      <router-link to="/user">User</router-link>
    </div>
    <router-view :hellomsg="msg"></router-view>
  </div>-->


  <div id="app">
    <b-navbar style="width: 100%">
      <router-link to="/" class="nav-link nav-link-xentaurs"><b-navbar-brand id="nav-brand">ASSM</b-navbar-brand></router-link>
      <router-link to="/" class="nav-link nav-link-xentaurs"><img height="50px" src="./assets/img/xentaurs-poweredby-logo-v2.png" alt="Powered by Xentaurs" /></router-link>
      <!--<router-link to="/" class="nav-link nav-link-xentaurs"><font-awesome-icon icon="home" /> Home</router-link>-->
      <router-link to="/projects" class="nav-link nav-link-xentaurs" v-if="isAuthenticated"><font-awesome-icon icon="wrench" /> Projects</router-link>
      <router-link to="/dictionary" class="nav-link nav-link-xentaurs" v-if="isAuthenticated"><font-awesome-icon icon="book" /> Dictionary</router-link>
      <router-link to="/about" class="nav-link nav-link-xentaurs"><font-awesome-icon icon="info" /> About</router-link>
      <router-link to="/register" class="nav-link nav-link-xentaurs" v-if="!isAuthenticated && !authLoading"><font-awesome-icon icon="user-plus" /> Register</router-link>
      <router-link to="/login" class="nav-link nav-link-xentaurs" v-if="!isAuthenticated && !authLoading"><font-awesome-icon icon="door-open" /> Login</router-link>
      <!--<router-link to="/login" class="nav-link nav-link-xentaurs" v-if="isAuthenticated"><font-awesome-icon icon="door-open" /> Logout</router-link>-->
      <a href="#" class="nav-link nav-link-xentaurs" v-if="isAuthenticated" v-on:click="logout"><font-awesome-icon icon="door-open" /> Logout </a>
    </b-navbar>
    <router-view :hellomsg="msg"></router-view>
  </div>


</template>

<script>
import store from './store'
import axios from 'axios'
import { USER_REQUEST } from './store/actions/user'
import { mapGetters, mapState } from 'vuex'
import { AUTH_LOGOUT } from './store/actions/auth'

export default {
  name: 'app',
  data () {
    return {
      msg: 'Welcome to ASSM'
    }
  },
  methods: {
      logout: function () {
        this.$store.dispatch(AUTH_LOGOUT).then(() => this.$router.push('/login'));
        this.$router.push('/');
      }
  },
  created: function () {
    axios.interceptors.response.use(undefined, function (err) {
      return new Promise(function (resolve, reject) {
        if (err.status === 401 && err.config && !err.config.__isRetryRequest) {
        // if you ever get an unauthorized, logout the user
          this.$store.dispatch(AUTH_LOGOUT)
        // you can also redirect to /login if needed !
        }
        throw err;
      });
    });
  },
  computed: {
      ...mapGetters(['getProfile', 'isAuthenticated', 'isProfileLoaded']),
      ...mapState({
        authLoading: state => state.auth.status === 'loading',
        name: state => `${state.user.profile.title} ${state.user.profile.name}`,
      })
    }
}
</script>

<style lang="scss">
/*#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 20px;
}

#nav {
  padding: 30px;
  a {
    font-weight: bold;
    color: #2c3e50;
    &.router-link-exact-active {
     color: #42b983;
    }
  }
}*/

</style>
