<template>

<div class="login">

     <!--<b-jumbotron>

             <div>
                 <b-form-input type="text" placeholder="Username" />
                 <div class="mt-2"></div>

                 <b-form-input type="password" placeholder="Password" />
                 <div class="mt-2"></div>
               </div>


            <hr class="my-4" />

            <b-button variant="link">Forget password?</b-button>

          </b-jumbotron>-->

          <div class="login-form">
            <b-card
              title="Login"
              tag="article"
              style="max-width: 20rem;"
              class="mb-2"
            >
              <div>
                 <b-form-input type="text" placeholder="Username" v-model="username" />
                 <div class="mt-2"></div>

                 <b-form-input type="password" placeholder="Password" v-model="password" />
                 <div class="mt-2"></div>
              </div>

              <b-button class="btn-violet" v-on:click="login" variant="primary">Login</b-button>

              <hr class="my-4" />

              <b-button variant="link">Forget password?</b-button>
            </b-card>
          </div>

</div>

</template>

<script>
/*import axios from 'axios'*/
import {AUTH_REQUEST} from '../store/actions/auth'

export default {
    name: 'login',
    data () {
          return {
            username: '',
            password: '',
          }
    },
    methods: {
        login: function () {
           const { username, password } = this
           this.$store.dispatch(AUTH_REQUEST, { username, password }).then(() => {
             this.$router.push('/')
           })
        }
    }
}

</script>


<style scoped>

.login-form {
    margin-left: 38%;
    margin-top: 50px;
}

</style>