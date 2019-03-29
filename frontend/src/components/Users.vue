<template>

<div class="main-content">

<table class="table table-striped">
    <thead>
        <tr>
            <th>Username</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Admin</th>
            <th></th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <tr v-for="user in users">
            <td> {{ user.username }} </td>
            <td> {{ user.firstName }} </td>
            <td> {{ user.lastName }} </td>
            <td> {{ user.email }} </td>
            <td>
                <span v-if="user.isAdmin"><font-awesome-icon icon="check" /></span>
            </td>
            <td>
                <b-button v-if="!user.isAdmin" v-on:click="makeAdmin(user.id)" style="width: 150px;" class="btn-violet"><font-awesome-icon icon="crown" /> Make Admin</b-button>
                <b-button v-if="user.isAdmin" v-on:click="makeRegular(user.id)" style="width: 150px;" class="btn-violet"><font-awesome-icon icon="chess-knight" /> Make Regular</b-button>
            </td>
            <td>
                <b-button v-on:click="deleteUser(user.id, user.username)" style="width: 100px;" class="btn-violet"><font-awesome-icon icon="user-alt-slash" /> Delete</b-button>
            </td>
        </tr>
    </tbody>
</table>

</div>

</template>

<script>

import {AXIOS} from './http-common'
import { store } from './../store';

export default {
    name: 'users',
    data() {
        return {
            users: []
        }
    },
    mounted() {
        this.getAccounts();
    },
    methods: {
        getAccounts() {
              const header = {'Authorization': 'Bearer ' + this.$store.getters.getToken};
              AXIOS.get(`/getaccounts`, { headers: header })
              .then(response => {
                this.$data.users = response.data;
                console.log(response.data);
              })
              .catch(e => {
                console.log(e);
              })
            },
        makeAdmin(id) {
            var params = new URLSearchParams();
            params.append('id', id);
            AXIOS.defaults.headers.post['Authorization'] = 'Bearer ' + this.$store.getters.getToken;
            AXIOS.post(`/makeAdmin`, params)
            .then(response => {
              console.log(response.data);
              this.getAccounts();
            })
            .catch(e => {
              console.log(e.response.data.message);
            })
        },
        makeRegular(id) {
            var params = new URLSearchParams();
            params.append('id', id);
            AXIOS.defaults.headers.post['Authorization'] = 'Bearer ' + this.$store.getters.getToken;
            AXIOS.post(`/makeRegular`, params)
            .then(response => {
              console.log(response.data);
              this.getAccounts();
            })
            .catch(e => {
              console.log(e.response.data.message);
            })
        },
        deleteUser(id, name) {
          this.$dialog
            .confirm('Do you really want to delete user ' + name + '?', {loader: true})
            .then(dialog => {
              setTimeout(() => {
                    this.deleteRequest(id);
                    console.log('Delete action completed ');
                    dialog.close();
                  }, 2500);
            })
            .catch(function() {
              console.log('Cancelled');
            });
        },
        deleteRequest(id) {
            var params = new URLSearchParams();
            params.append('id', id);
            AXIOS.defaults.headers.post['Authorization'] = 'Bearer ' + this.$store.getters.getToken;
            AXIOS.post(`/deleteUser`, params)
            .then(response => {
              console.log(response.data);
              this.getAccounts();
              return true;
            })
            .catch(e => {
              console.log(e.response.data.message);
            })
        }
    }
  }

</script>

<style scoped>
.main-content {
    margin-left: 10%;
    margin-right: 10%;
    margin-top: 20px;
    margin-bootom: 50px;
}

</style>