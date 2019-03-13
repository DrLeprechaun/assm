<template>

<div class="builder">
    <div class="builder-content">
        <h3>ASSM Builder</h3>
        <hr>
        <p> Select existing project or <b-button variant="primary" class="btn-violet">Create New Project</b-button>
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
export default {
    name: 'builder',
    data() {
          return {
            fields: ['customer', 'open'],
            items: [
              { customer: 'GMF'},
              { customer: 'GMF'}
            ]
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