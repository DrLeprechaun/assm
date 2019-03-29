<template>

<div class="login">


          <div class="login-form">
            <b-card
              title="Login"
              tag="article"
              style="max-width: 20rem;"
              class="mb-2"
            >
            <div>
                <b-alert
                      :show="dismissCountDown"
                      dismissible
                      variant="danger"
                      @dismissed="dismissCountDown=0"
                      @dismiss-count-down="countDownChanged"
                    > Invalid Credentials
                    </b-alert>
            </div>
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
import {AXIOS} from './http-common'

export default {
    name: 'login',
    data() {
          return {
          username: '',
          password: '',
          dismissSecs: 5,
          dismissCountDown: 0
      }
    },
    methods: {
      login() {
        //this.$store.dispatch('login', {'token': 'tttoken', 'roles': ['USER', 'ADMIN']});
        AXIOS.post(`/auth/signin`, {'username': this.$data.username, 'password': this.$data.password})
          .then(response => {
            this.$store.dispatch('login', {'token': response.data.accessToken, 'roles': response.data.authorities, 'username': response.data.username});
            this.$router.push('/projects')
          })
          .catch(e => {
            console.log(e);
            this.showAlert();
          })
      },
      countDownChanged(dismissCountDown) {
          this.dismissCountDown = dismissCountDown
      },
      showAlert() {
          this.dismissCountDown = this.dismissSecs
      },
    }
  }

</script>


<style scoped>

.login-form {
    margin-left: 38%;
    margin-top: 50px;
}

</style>
