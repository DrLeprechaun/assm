<template>

<div class="main-content">
    <div>
      <b-card no-body>
        <b-tabs pills card vertical v-model="tabIndex">
          <!--<b-tab title="Azure" :title-link-class="linkClass(0)" active>-->
          <b-tab :title-link-class="linkClass(0)" active>
            <template slot="title">
               <!--<img height="30px" src="./../assets/img/azure.png" alt="Microsoft Azure" />-->
               <span style="font-size: 1em; color: #906bae;">
                 <i class="fab fa-windows"></i>
               </span>
               <span> Azure</span>
            </template>
            <b-card-text>
                <b-card no-body>
                    <b-tabs pills card v-model="subTabIndex">
                        <b-tab :title-link-class="subLinkClass(0)" active>
                            <template slot="title">
                                <span><font-awesome-icon icon="list-alt" />  Data</span>
                            </template>
                            <b-card-text>
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Cost $</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr v-for="a_s in azureServices">
                                            <td><input class="form-control" type="text" v-model="a_s.name"></td>
                                            <td><input class="form-control" type="number" min="0" v-model="a_s.cost"></td>
                                            <td><b-button style="width: 110px;" v-on:click="removeAzureService(a_s.name)" class="btn-violet"><font-awesome-icon icon="cut" /> Remove</b-button></td>
                                        </tr>
                                        <tr style="background-color: #e6d4f5">
                                            <td>
                                                <input class="form-control" type="text" v-model="azureServiceName">
                                            </td>
                                            <td>
                                                <input class="form-control" type="number" min="0" v-model="azureServiceCost">
                                            </td>
                                            <td>
                                                <b-button v-on:click="addAzureService" style="width: 110px;" class="add-component-button btn-violet"><font-awesome-icon icon="plus" /> Add</b-button>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </b-card-text>
                        </b-tab>
                        <b-tab :title-link-class="subLinkClass(1)">
                            <template slot="title">
                                <span><font-awesome-icon icon="thumbs-up" />  Positive Experience</span>
                            </template>
                            <b-card-text>
                                Positive Experience
                            </b-card-text>
                        </b-tab>
                        <b-tab title="Negative Experience" :title-link-class="subLinkClass(2)">
                            <template slot="title">
                                <span><font-awesome-icon icon="thumbs-down" />  Negative Experience</span>
                            </template>
                            <b-card-text>
                                Negative Experience
                            </b-card-text>
                        </b-tab>
                    </b-tabs>
                </b-card>
            </b-card-text>
          </b-tab>
          <b-tab :title-link-class="linkClass(1)">
            <template slot="title">
                <span style="font-size: 1em; color: #906bae;">
                 <i class="fab fa-aws"></i>
               </span>
               <span> AWS</span>
             </template>
            <b-card-text>
                <b-card no-body>
                    <b-tabs pills card v-model="subTabIndex">
                        <b-tab :title-link-class="subLinkClass(0)" active>
                            <template slot="title">
                                <span><font-awesome-icon icon="list-alt" />  Data</span>
                            </template>
                            <b-card-text>
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Cost $</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr v-for="a_s in azureServices">
                                        </tr>
                                    </tbody>
                                </table>
                            </b-card-text>
                        </b-tab>
                        <b-tab :title-link-class="subLinkClass(1)">
                            <template slot="title">
                                <span><font-awesome-icon icon="thumbs-up" />  Positive Experience</span>
                            </template>
                            <b-card-text>
                                Positive Experience
                            </b-card-text>
                        </b-tab>
                        <b-tab title="Negative Experience" :title-link-class="subLinkClass(2)">
                            <template slot="title">
                                <span><font-awesome-icon icon="thumbs-down" />  Negative Experience</span>
                            </template>
                            <b-card-text>
                                Negative Experience
                            </b-card-text>
                        </b-tab>
                    </b-tabs>
                </b-card>
            </b-card-text>
          </b-tab>
          <b-tab :title-link-class="linkClass(2)">
                <template slot="title">
                    <span style="font-size: 1em; color: #906bae;">
                     <i class="fab fa-google"></i>
                   </span>
                   <span> GCP</span>
                </template>
            <b-card-text>
                <b-card no-body>
                    <b-tabs pills card v-model="subTabIndex">
                        <b-tab :title-link-class="subLinkClass(0)" active>
                            <template slot="title">
                                <span><font-awesome-icon icon="list-alt" />  Data</span>
                            </template>
                            <b-card-text>
                                Data
                            </b-card-text>
                        </b-tab>
                        <b-tab :title-link-class="subLinkClass(1)">
                            <template slot="title">
                                <span><font-awesome-icon icon="thumbs-up" />  Positive Experience</span>
                            </template>
                            <b-card-text>
                                Positive Experience
                            </b-card-text>
                        </b-tab>
                        <b-tab title="Negative Experience" :title-link-class="subLinkClass(2)">
                            <template slot="title">
                                <span><font-awesome-icon icon="thumbs-down" />  Negative Experience</span>
                            </template>
                            <b-card-text>
                                Negative Experience
                            </b-card-text>
                        </b-tab>
                    </b-tabs>
                </b-card>
            </b-card-text>
          </b-tab>
        </b-tabs>
      </b-card>
    </div>
</div>

</template>

<script>
export default {
    data() {
      return {
        tabIndex: 0,
        subTabIndex: 0,
        azureServices: [
            {name: 'Azure DevOps', cost: 350},
            {name: 'Azure Databricks', cost: 200},
            {name: 'Data Lake Analytics', cost: 250},
            {name: 'Power BI Embedded', cost: 300}
        ],
        azureServiceName: '',
        azureServiceCost: 0
      }
    },
    methods: {
      linkClass(idx) {
        if (this.tabIndex === idx) {
          return ['btn-tab', 'btn-tab-active']
        } else {
          return ['btn-tab']
        }
      },
      subLinkClass(idx) {
        if (this.subTabIndex === idx) {
          return ['btn-tab', 'btn-tab-active']
        } else {
          return ['btn-tab']
        }
      },
      addAzureService(){
      },
      removeAzureService(){
      }
    }
  }
</script>

<style scoped>
.main-content {
    margin-left: 10%;
    margin-right: 10%;
    margin-top: 20px;
}
</style>