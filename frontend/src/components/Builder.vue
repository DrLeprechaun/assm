<template>

<div class="builder">
    <div class="builder-content">
        <h3>ASSM Builder</h3>
        <hr>
        <p> Select existing project or <router-link to="/assm">
                                                   <b-button variant="primary" class="btn-violet">Create New Project</b-button>
                                               </router-link>
        </p>

        <template>
          <div>
            <b-table striped hover :items="items" :fields="fields">

            <template slot="open" slot-scope="row">
                    <b-button variant="primary" class="btn-violet">Open</b-button>
                  </template>

            </b-table>
          </div>
        </template>

    </div>
</div>

</template>

<script>
import {AXIOS} from './http-common'

export default {
    name: 'builder',
    data() {
          return {
            fields: ['customer', 'date', 'open'],
            items: [
              /*{ customer: 'GMF', date: ''},
              { customer: 'GMF', date: ''}*/
            ],
          retrievedAssm: {},
          }
        },
    mounted() {
        this.retrieveAssm();
    },
    methods: {
        retrieveAssm () {
                AXIOS.get(`/getassm`)
                  .then(response => {
                    // JSON responses are automatically parsed.
                    this.retrievedAssm = response.data
                    console.log(response.data.customer)
                   this.items.push(response.data)
                  })
                  .catch(e => {
                    this.errors.push(e)
                  })
        }
    }
  }

</script>


<style scoped>
.builder-content {
    margin-top: 30px;
    margin-left: 10%;
    margin-right: 10%;
}
</style>