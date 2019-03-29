<template>

<div class="home">

    <b-jumbotron>
        <template slot="header">Xentaurs ASSM Portal</template>

        <template slot="lead">
          The result of usage ASSM product for the Customer will be the IT infrastructure migration strategy, filled with ASSM data, that will suggest the Customer to move (or not to move) its infrastructure to the public cloud, plus comparison of usage GCP, AWS or Microsoft Azure clouds for the Customer (including cost comparison), personnel development, reduce stuff overload
        </template>

        <hr class="my-4" />

        <p>
          Login and build Application Segmentation Scoring Matrix
        </p>

        <router-link to="/login">
            <b-button variant="primary" class="btn-violet">Login</b-button>
        </router-link>

      </b-jumbotron>

</div>

</template>

<script>
export default {
    name: 'home'
  }

</script>


<style scoped>

.welcome-container {
    width: 75%;
    margin: auto;
}

</style>