<template>

<div>
  <div class="login-form">
    <b-card
        title="Account Info"
        tag="article"
        style="max-width: 20rem;"
        class="mb-2"
      >
      <div>
        <hr>
        <div>
          <b-alert
              variant="success"
              :show="dismissCountDownSuccess"
              @dismissed="dismissSuccessCountDown=0"
              dismissible
              @dismiss-count-down="countDownSuccessChanged"
            >
            Saved
          </b-alert>
        </div>
        <div>
          <b-alert
              variant="danger"
              :show="dismissCountDown"
              @dismissed="dismissSuccessCount=0"
              dismissible
              @dismiss-count-down="countDownChanged"
            >
            {{ alertMessage }}
          </b-alert>
        </div>
        <p><b>Username: </b>{{ username }} </p>
        <p><b>Email: </b> {{ email }} </p>
        <hr>
        <p><b-input-group prepend="First name" class="mb-2 mr-sm-2 mb-sm-0">
          <b-input placeholder="First name" v-model="firstName"></b-input>
        </b-input-group></p>
        <p><b-input-group prepend="Last name" class="mb-2 mr-sm-2 mb-sm-0">
          <b-input placeholder="Last name" v-model="lastName"></b-input>
        </b-input-group></p>
        <b-button class="btn-violet" v-on:click="saveNames" variant="primary">Save</b-button>
        <hr>
        <p><b-form-input type="password" placeholder="Password" v-model="password" /></p>
        <p><b-form-input type="password" placeholder="New password" v-model="newPassword" /></p>
        <p><b-form-input type="password" placeholder="Confirm new password" v-model="confirmPassword" /></p>
        <b-button class="btn-violet" v-on:click="changePassword" variant="primary">Change password</b-button>
      </div>
    </b-card>
  </div>

</div>

</template>

<script>
import {AXIOS} from './http-common'
import { store } from './../store';

export  default {
  name: 'account',
  data () {
    return {
      username: '',
      email: '',
      firstName: '',
      lastName: '',
      password: '',
      newPassword: '',
      confirmPassword: '',
      dismissSecs: 5,
      dismissCountDown: 0,
      dismissCountDownSuccess: 0,
      alertMessage: ''
    }
  },
  mounted() {
    this.getAccount();
  },
  methods: {
    getAccount() {
      const header = {'Authorization': 'Bearer ' + this.$store.getters.getToken};
      AXIOS.get(`/getaccount`, { headers: header })
      .then(response => {
        console.log(response.data);
        this.$data.username = response.data.username;
        this.$data.email = response.data.email;
        this.$data.firstName = response.data.firstName;
        this.$data.lastName = response.data.lastName;
      })
      .catch(e => {
        console.log(e);
      })
    },
    saveNames() {
        var params = new URLSearchParams();
        params.append('firstName', this.$data.firstName);
        params.append('lastName', this.$data.lastName);
        AXIOS.defaults.headers.post['Authorization'] = 'Bearer ' + this.$store.getters.getToken;
        AXIOS.post(`/updateAccount`, params)
        .then(response => {
          console.log(response.data);
          this.$data.username = response.data.username;
          this.$data.email = response.data.email;
          this.$data.firstName = response.data.firstName;
          this.$data.lastName = response.data.lastName;
          this.successAlert();
        })
        .catch(e => {
          console.log(e);
          this.showAlert('Error');
        })
    },
    changePassword() {
      if (this.checkPasswords()) {
        var params = new URLSearchParams();
        params.append('password', this.$data.password);
        params.append('newPassword', this.$data.newPassword);
        params.append('confirmPassword', this.$data.confirmPassword);
        AXIOS.defaults.headers.post['Authorization'] = 'Bearer ' + this.$store.getters.getToken;
        AXIOS.post(`/updatePassword`, params)
        .then(response => {
          console.log(response.data);
          this.$data.password = '';
          this.$data.newPassword = '';
          this.$data.confirmPassword = '';
          this.successAlert();
        })
        .catch(e => {
          console.log(e.response.data.message);
          this.showAlert(e.response.data.message);
        })
      } else {
        this.showAlert('Passwords are not match');
      }
    },
    checkPasswords() {
    console.log(this.$data.newPassword == this.$data.confirmPassword);
      return this.$data.newPassword == this.$data.confirmPassword;
    },
    countDownChanged(dismissCountDown) {
        this.dismissCountDown = dismissCountDown
    },
    countDownSuccessChanged(dismissCountDownSuccess) {
        this.dismissCountDownSuccess = dismissCountDownSuccess
    },
    showAlert(message) {
        this.$data.alertMessage = message;
        this.dismissCountDown = this.dismissSecs;
    },
    successAlert() {
      this.dismissCountDownSuccess = this.dismissSecs
    }
  }
}
</script>

<style>

.login-form {
    margin-left: 38%;
    margin-top: 50px;
    margin-bottom: 100px;
}

</style>
