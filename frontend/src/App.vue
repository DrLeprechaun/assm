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
    <b-navbar>
      <b-navbar-brand id="nav-brand" href="#">ASSM</b-navbar-brand>
      <img height="50px" src="./assets/xentaurs-poweredby-logo-v2.png" alt="Powered by Xentaurs" />
      <router-link to="/" class="nav-link nav-link-xentaurs">Home</router-link>
      <router-link to="/builder" class="nav-link nav-link-xentaurs">Builder</router-link>
      <router-link to="/about" class="nav-link nav-link-xentaurs">About</router-link>
      <router-link to="/login" class="nav-link nav-link-xentaurs nav-right">Login</router-link>
    </b-navbar>
    <router-view :hellomsg="msg"></router-view>
  </div>


</template>

<script>

export default {
  name: 'app',
  data () {
    return {
      msg: 'Welcome to your Vue.js powered Spring Boot App'
    }
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

nav {
    background-color: #906bae;
}

#nav-brand {
    margin-left: 10%;
    color: #ffffff;
    text-shadow: 1px 1px 2px black, 0 0 1em #b59cc9;
}

/*.nav-link {
    color: #e6deed;
    text-decoration: none;
}

.nav-link:hover,
.nav-link:focus {
      color: #ffffff;
      text-decoration: none;
}*/

.nav-link-xentaurs {
    color: #e6deed;
    text-decoration: none;
}

.nav-link-xentaurs:hover,
.nav-link-xentaurs:focus {
      color: #ffffff;
      text-decoration: none;
}

.nav-right {
    margin-left: 40%;
}

.btn-violet {
	color: #fff;
	background-color: #906bae;
	border-color: #694884;
}
	.btn-violet:hover {
	color: #fff;
	background-color: #765194;
	border-color: #5c3f73;
}
.btn-violet:focus, .btn-violet.focus {
	background-color: #765194;
	box-shadow: 0 0 0 0.2rem rgba(144, 107, 174, 0.5);
}
.btn-violet.disabled, .btn-violet:disabled {
	color: #fff;
	background-color: #906bae;
	border-color: #4f3663;
}

</style>
