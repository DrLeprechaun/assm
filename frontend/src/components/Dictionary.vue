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
                                <span><font-awesome-icon icon="list-alt" />  Services</span>
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
                                                <input class="form-control" type="text" v-model="azureService.name">
                                            </td>
                                            <td>
                                                <input class="form-control" type="number" min="0" v-model="azureService.cost">
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
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>Case</th>
                                            <th>Section</th>
                                            <th>Risk</th>
                                            <th>Complexity</th>
                                            <th>Solution</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr v-for="e in azurePositiveExperience">
                                             <td><input class="form-control" type="text" v-model="e.case"></td>
                                             <td>
                                                <select class="custom-select" aria-label="Select section" v-model="e.section">
                                                     <option v-for="s in sectionList">{{ s }}</option>
                                                </select>
                                             </td>
                                             <td><input class="form-control" type="number" min="0" max="10" v-model="e.risk"></td>
                                             <td><input class="form-control" type="number" min="0" max="10" v-model="e.complexity"></td>
                                             <td>
                                                <select class="custom-select" aria-label="Select solution" v-model="e.solution">
                                                      <option v-for="s in azureServices">{{ s.name }}</option>
                                                 </select>
                                             </td>
                                             <td><b-button style="width: 110px;" v-on:click="removeAzurePositive(e.case)" class="btn-violet"><font-awesome-icon icon="cut" /> Remove</b-button></td>
                                        </tr>
                                        <tr style="background-color: #e6d4f5">
                                            <td>
                                                <input class="form-control" type="text" v-model="azurePositive.case">
                                            </td>
                                            <td>
                                                <select class="custom-select" aria-label="Select section" v-model="azurePositive.section">
                                                     <option v-for="s in sectionList">{{ s }}</option>
                                                </select>
                                            </td>
                                            <td>
                                                <input class="form-control" type="number" min="0" max="10" v-model="azurePositive.risk">
                                            </td>
                                            <td>
                                                <input class="form-control" type="number" min="0" max="10" v-model="azurePositive.complexity">
                                            </td>
                                            <td>
                                                <select class="custom-select" aria-label="Select solution" v-model="azurePositive.solution">
                                                      <option v-for="s in azureServices">{{ s.name }}</option>
                                                 </select>
                                            </td>
                                            <td>
                                                <b-button v-on:click="addAzurePositive" style="width: 110px;" class="add-component-button btn-violet"><font-awesome-icon icon="plus" /> Add</b-button>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </b-card-text>
                        </b-tab>
                        <b-tab title="Negative Experience" :title-link-class="subLinkClass(2)">
                            <template slot="title">
                                <span><font-awesome-icon icon="thumbs-down" />  Negative Experience</span>
                            </template>
                            <b-card-text>
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>Case</th>
                                            <th>Section</th>
                                            <th>Risk</th>
                                            <th>Complexity</th>
                                            <th>Solution</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr v-for="e in azureNegativeExperience">
                                             <td><input class="form-control" type="text" v-model="e.case"></td>
                                             <td>
                                                <select class="custom-select" aria-label="Select section" v-model="e.section">
                                                     <option v-for="s in sectionList">{{ s }}</option>
                                                </select>
                                             </td>
                                             <td><input class="form-control" type="number" min="0" max="10" v-model="e.risk"></td>
                                             <td><input class="form-control" type="number" min="0" max="10" v-model="e.complexity"></td>
                                             <td>
                                                <select class="custom-select" aria-label="Select solution" v-model="e.solution">
                                                      <option v-for="s in azureServices">{{ s.name }}</option>
                                                 </select>
                                             </td>
                                             <td><b-button style="width: 110px;" v-on:click="removeAzureNegative(e.case)" class="btn-violet"><font-awesome-icon icon="cut" /> Remove</b-button></td>
                                        </tr>
                                        <tr style="background-color: #e6d4f5">
                                            <td>
                                                <input class="form-control" type="text" v-model="azureNegative.case">
                                            </td>
                                            <td>
                                                <select class="custom-select" aria-label="Select section" v-model="azureNegative.section">
                                                     <option v-for="s in sectionList">{{ s }}</option>
                                                </select>
                                            </td>
                                            <td>
                                                <input class="form-control" type="number" min="0" max="10" v-model="azureNegative.risk">
                                            </td>
                                            <td>
                                                <input class="form-control" type="number" min="0" max="10" v-model="azureNegative.complexity">
                                            </td>
                                            <td>
                                                <select class="custom-select" aria-label="Select solution" v-model="azureNegative.solution">
                                                      <option v-for="s in azureServices">{{ s.name }}</option>
                                                 </select>
                                            </td>
                                            <td>
                                                <b-button v-on:click="addAzureNegative" style="width: 110px;" class="add-component-button btn-violet"><font-awesome-icon icon="plus" /> Add</b-button>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
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
                                <span><font-awesome-icon icon="list-alt" />  Services</span>
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
                                        <tr v-for="a_s in awsServices">
                                            <td><input class="form-control" type="text" v-model="a_s.name"></td>
                                            <td><input class="form-control" type="number" min="0" v-model="a_s.cost"></td>
                                            <td><b-button style="width: 110px;" v-on:click="removeAwsService(a_s.name)" class="btn-violet"><font-awesome-icon icon="cut" /> Remove</b-button></td>
                                        </tr>
                                        <tr style="background-color: #e6d4f5">
                                            <td>
                                                <input class="form-control" type="text" v-model="awsService.name">
                                            </td>
                                            <td>
                                                <input class="form-control" type="number" min="0" v-model="awsService.cost">
                                            </td>
                                            <td>
                                                <b-button v-on:click="addAwsService" style="width: 110px;" class="add-component-button btn-violet"><font-awesome-icon icon="plus" /> Add</b-button>
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
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>Case</th>
                                            <th>Section</th>
                                            <th>Risk</th>
                                            <th>Complexity</th>
                                            <th>Solution</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr v-for="e in awsPositiveExperience">
                                             <td><input class="form-control" type="text" v-model="e.case"></td>
                                             <td>
                                                <select class="custom-select" aria-label="Select section" v-model="e.section">
                                                     <option v-for="s in sectionList">{{ s }}</option>
                                                </select>
                                             </td>
                                             <td><input class="form-control" type="number" min="0" max="10" v-model="e.risk"></td>
                                             <td><input class="form-control" type="number" min="0" max="10" v-model="e.complexity"></td>
                                             <td>
                                                <select class="custom-select" aria-label="Select solution" v-model="e.solution">
                                                      <option v-for="s in awsServices">{{ s.name }}</option>
                                                 </select>
                                             </td>
                                             <td><b-button style="width: 110px;" v-on:click="removeAwsPositive(e.case)" class="btn-violet"><font-awesome-icon icon="cut" /> Remove</b-button></td>
                                        </tr>
                                        <tr style="background-color: #e6d4f5">
                                            <td>
                                                <input class="form-control" type="text" v-model="awsPositive.case">
                                            </td>
                                            <td>
                                                <select class="custom-select" aria-label="Select section" v-model="awsPositive.section">
                                                     <option v-for="s in sectionList">{{ s }}</option>
                                                </select>
                                            </td>
                                            <td>
                                                <input class="form-control" type="number" min="0" max="10" v-model="awsPositive.risk">
                                            </td>
                                            <td>
                                                <input class="form-control" type="number" min="0" max="10" v-model="awsPositive.complexity">
                                            </td>
                                            <td>
                                                <select class="custom-select" aria-label="Select solution" v-model="awsPositive.solution">
                                                      <option v-for="s in awsServices">{{ s.name }}</option>
                                                 </select>
                                            </td>
                                            <td>
                                                <b-button v-on:click="addAwsPositive" style="width: 110px;" class="add-component-button btn-violet"><font-awesome-icon icon="plus" /> Add</b-button>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </b-card-text>
                        </b-tab>
                        <b-tab title="Negative Experience" :title-link-class="subLinkClass(2)">
                            <template slot="title">
                                <span><font-awesome-icon icon="thumbs-down" />  Negative Experience</span>
                            </template>
                            <b-card-text>
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>Case</th>
                                            <th>Section</th>
                                            <th>Risk</th>
                                            <th>Complexity</th>
                                            <th>Solution</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr v-for="e in awsNegativeExperience">
                                             <td><input class="form-control" type="text" v-model="e.case"></td>
                                             <td>
                                                <select class="custom-select" aria-label="Select section" v-model="e.section">
                                                     <option v-for="s in sectionList">{{ s }}</option>
                                                </select>
                                             </td>
                                             <td><input class="form-control" type="number" min="0" max="10" v-model="e.risk"></td>
                                             <td><input class="form-control" type="number" min="0" max="10" v-model="e.complexity"></td>
                                             <td>
                                                <select class="custom-select" aria-label="Select solution" v-model="e.solution">
                                                      <option v-for="s in awsServices">{{ s.name }}</option>
                                                 </select>
                                             </td>
                                             <td><b-button style="width: 110px;" v-on:click="removeAwsNegative(e.case)" class="btn-violet"><font-awesome-icon icon="cut" /> Remove</b-button></td>
                                        </tr>
                                        <tr style="background-color: #e6d4f5">
                                            <td>
                                                <input class="form-control" type="text" v-model="awsNegative.case">
                                            </td>
                                            <td>
                                                <select class="custom-select" aria-label="Select section" v-model="awsNegative.section">
                                                     <option v-for="s in sectionList">{{ s }}</option>
                                                </select>
                                            </td>
                                            <td>
                                                <input class="form-control" type="number" min="0" max="10" v-model="awsNegative.risk">
                                            </td>
                                            <td>
                                                <input class="form-control" type="number" min="0" max="10" v-model="awsNegative.complexity">
                                            </td>
                                            <td>
                                                <select class="custom-select" aria-label="Select solution" v-model="awsNegative.solution">
                                                      <option v-for="s in awsServices">{{ s.name }}</option>
                                                 </select>
                                            </td>
                                            <td>
                                                <b-button v-on:click="addAwsNegative" style="width: 110px;" class="add-component-button btn-violet"><font-awesome-icon icon="plus" /> Add</b-button>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
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
                                 <span><font-awesome-icon icon="list-alt" />  Services</span>
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
                                         <tr v-for="a_s in gcpServices">
                                             <td><input class="form-control" type="text" v-model="a_s.name"></td>
                                             <td><input class="form-control" type="number" min="0" v-model="a_s.cost"></td>
                                             <td><b-button style="width: 110px;" v-on:click="removeGcpService(a_s.name)" class="btn-violet"><font-awesome-icon icon="cut" /> Remove</b-button></td>
                                         </tr>
                                         <tr style="background-color: #e6d4f5">
                                             <td>
                                                 <input class="form-control" type="text" v-model="gcpService.name">
                                             </td>
                                             <td>
                                                 <input class="form-control" type="number" min="0" v-model="gcpService.cost">
                                             </td>
                                             <td>
                                                 <b-button v-on:click="addGcpService" style="width: 110px;" class="add-component-button btn-violet"><font-awesome-icon icon="plus" /> Add</b-button>
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
                                 <table class="table table-striped">
                                     <thead>
                                         <tr>
                                             <th>Case</th>
                                             <th>Section</th>
                                             <th>Risk</th>
                                             <th>Complexity</th>
                                             <th>Solution</th>
                                             <th></th>
                                         </tr>
                                     </thead>
                                     <tbody>
                                         <tr v-for="e in gcpPositiveExperience">
                                              <td><input class="form-control" type="text" v-model="e.case"></td>
                                              <td>
                                                 <select class="custom-select" aria-label="Select section" v-model="e.section">
                                                      <option v-for="s in sectionList">{{ s }}</option>
                                                 </select>
                                              </td>
                                              <td><input class="form-control" type="number" min="0" max="10" v-model="e.risk"></td>
                                              <td><input class="form-control" type="number" min="0" max="10" v-model="e.complexity"></td>
                                              <td>
                                                 <select class="custom-select" aria-label="Select solution" v-model="e.solution">
                                                       <option v-for="s in gcpServices">{{ s.name }}</option>
                                                  </select>
                                              </td>
                                              <td><b-button style="width: 110px;" v-on:click="removeGcpPositive(e.case)" class="btn-violet"><font-awesome-icon icon="cut" /> Remove</b-button></td>
                                         </tr>
                                         <tr style="background-color: #e6d4f5">
                                             <td>
                                                 <input class="form-control" type="text" v-model="gcpPositive.case">
                                             </td>
                                             <td>
                                                 <select class="custom-select" aria-label="Select section" v-model="gcpPositive.section">
                                                      <option v-for="s in sectionList">{{ s }}</option>
                                                 </select>
                                             </td>
                                             <td>
                                                 <input class="form-control" type="number" min="0" max="10" v-model="gcpPositive.risk">
                                             </td>
                                             <td>
                                                 <input class="form-control" type="number" min="0" max="10" v-model="gcpPositive.complexity">
                                             </td>
                                             <td>
                                                 <select class="custom-select" aria-label="Select solution" v-model="gcpPositive.solution">
                                                       <option v-for="s in gcpServices">{{ s.name }}</option>
                                                  </select>
                                             </td>
                                             <td>
                                                 <b-button v-on:click="addGcpPositive" style="width: 110px;" class="add-component-button btn-violet"><font-awesome-icon icon="plus" /> Add</b-button>
                                             </td>
                                         </tr>
                                     </tbody>
                                 </table>
                             </b-card-text>
                         </b-tab>
                         <b-tab title="Negative Experience" :title-link-class="subLinkClass(2)">
                             <template slot="title">
                                 <span><font-awesome-icon icon="thumbs-down" />  Negative Experience</span>
                             </template>
                             <b-card-text>
                                 <table class="table table-striped">
                                     <thead>
                                         <tr>
                                             <th>Case</th>
                                             <th>Section</th>
                                             <th>Risk</th>
                                             <th>Complexity</th>
                                             <th>Solution</th>
                                             <th></th>
                                         </tr>
                                     </thead>
                                     <tbody>
                                         <tr v-for="e in gcpNegativeExperience">
                                              <td><input class="form-control" type="text" v-model="e.case"></td>
                                              <td>
                                                 <select class="custom-select" aria-label="Select section" v-model="e.section">
                                                      <option v-for="s in sectionList">{{ s }}</option>
                                                 </select>
                                              </td>
                                              <td><input class="form-control" type="number" min="0" max="10" v-model="e.risk"></td>
                                              <td><input class="form-control" type="number" min="0" max="10" v-model="e.complexity"></td>
                                              <td>
                                                 <select class="custom-select" aria-label="Select solution" v-model="e.solution">
                                                       <option v-for="s in gcpServices">{{ s.name }}</option>
                                                  </select>
                                              </td>
                                              <td><b-button style="width: 110px;" v-on:click="removeGcpNegative(e.case)" class="btn-violet"><font-awesome-icon icon="cut" /> Remove</b-button></td>
                                         </tr>
                                         <tr style="background-color: #e6d4f5">
                                             <td>
                                                 <input class="form-control" type="text" v-model="gcpNegative.case">
                                             </td>
                                             <td>
                                                 <select class="custom-select" aria-label="Select section" v-model="gcpNegative.section">
                                                      <option v-for="s in sectionList">{{ s }}</option>
                                                 </select>
                                             </td>
                                             <td>
                                                 <input class="form-control" type="number" min="0" max="10" v-model="gcpNegative.risk">
                                             </td>
                                             <td>
                                                 <input class="form-control" type="number" min="0" max="10" v-model="gcpNegative.complexity">
                                             </td>
                                             <td>
                                                 <select class="custom-select" aria-label="Select solution" v-model="gcpNegative.solution">
                                                       <option v-for="s in gcpServices">{{ s.name }}</option>
                                                  </select>
                                             </td>
                                             <td>
                                                 <b-button v-on:click="addGcpNegative" style="width: 110px;" class="add-component-button btn-violet"><font-awesome-icon icon="plus" /> Add</b-button>
                                             </td>
                                         </tr>
                                     </tbody>
                                 </table>
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
        sectionList: ['Databases', 'Infrastructure', 'Features', 'Apps', 'Additional'],
        azureServices: [
            {name: 'Azure DevOps', cost: 350},
            {name: 'Azure Databricks', cost: 200},
            {name: 'Data Lake Analytics', cost: 250},
            {name: 'Power BI Embedded', cost: 300},
            {name: 'Azure Cosmos DB', cost: 100},
            {name: 'SQL Server Stretch Database', cost: 150},
            {name: 'Azure for PostgreSQL', cost: 150},
            {name: 'Azure DNS', cost: 400},
            {name: 'Azure Migration', cost: 400}
        ],
        azureService: {name: '', cost: 0},
        azurePositiveExperience: [
            {case: 'CI/CD Pipeline', section: 'Features', risk: 0, complexity: 1, solution: 'Azure DevOps'},
            {case: 'MS SQL Server', section: 'Databases', risk: 0, complexity: 0, solution: 'SQL Server Stretch Database'},
            {case: 'PostgreSQL', section: 'Databases', risk: 0, complexity: 0, solution: 'Azure for PostgreSQL'},
        ],
        azureNegativeExperience: [
            {case: 'DB-DB dependency', section: 'Features', risk: 8, complexity: 10, solution: 'Azure Cosmos DB'},
            {case: 'DNS servers', section: 'Features', risk: 8, complexity: 8, solution: 'Azure DNS'},
            {case: 'VMware virtualization', section: 'Features', risk: 10, complexity: 10, solution: 'Azure Migration'},
        ],
        azurePositive: {case: '', section: '', risk: 0, complexity: 0, solution: ''},
        azureNegative: {case: '', section: '', risk: 0, complexity: 0, solution: ''},
        awsServices: [
            {name: 'AWS CloudFormation Validation Pipeline', cost: 350},
            {name: 'AWS Database Migration Service', cost: 500},
            {name: 'Red Hat Openshift on AWS', cost: 100},
            {name: 'Data Lake On AWS', cost: 450},
            {name: 'Amazon Cloud Migration', cost: 1000}
        ],
        awsService: {name: '', cost: ''},
        awsPositiveExperience: [
            {case: 'CI/CD Pipeline', section: 'Features', risk: 2, complexity: 2, solution: 'AWS CloudFormation Validation Pipeline'},
            {case: 'Linux Servers', section: 'Infrastructure', risk: 1, complexity: 1, solution: 'Red Hat Openshift on AWS'},
            {case: 'Data Lake', section: 'Infrastructure', risk: 0, complexity: 0, solution: 'Data Lake On AWS'}
        ],
        awsNegativeExperience: [
            {case: 'DB-DB dependency', section: 'Features', risk: 8, complexity: 8, solution: 'AWS Database Migration Service'},
            {case: 'MS SQL Server', section: 'Databases', risk: 10, complexity: 8, solution: 'AWS Database Migration Service'},
            {case: 'VMware virtualization', section: 'Features', risk: 10, complexity: 10, solution: 'Amazon Cloud Migration'},
        ],
        awsPositive: {case: '', section: '', risk: 0, complexity: 0, solution: ''},
        awsNegative: {case: '', section: '', risk: 0, complexity: 0, solution: ''},
        gcpServices: [
            {name: 'Cloud SQL', cost: 100},
            {name: 'Compute Engine', cost: 550},
            {name: 'Gradle App Engine Plugin ', cost: 50}
        ],
        gcpService: {name: '', cost: ''},
        gcpPositiveExperience: [
            {case: 'MySQL', section: 'Databases', risk: 1, complexity: 0, solution: 'Cloud SQL'},
            {case: 'Linux Servers', section: 'Infrastructure', risk: 1, complexity: 1, solution: 'Compute Engine'},
            {case: 'Automatic Gradle Build', section: 'Infrastructure', risk: 0, complexity: 0, solution: 'Gradle App Engine Plugin'}
        ],
        gcpNegativeExperience: [
            {case: 'DB-DB dependency', section: 'Features', risk: 8, complexity: 8, solution: 'Cloud SQL'},
            {case: 'MS SQL Server', section: 'Databases', risk: 10, complexity: 8, solution: 'Cloud SQL'},
            {case: 'VMware virtualization', section: 'Features', risk: 10, complexity: 10, solution: 'Compute Engine'},
        ],
        gcpPositive: {case: '', section: '', risk: 0, complexity: 0, solution: ''},
        gcpNegative: {case: '', section: '', risk: 0, complexity: 0, solution: ''}
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
        if (this.$data.azureService.name !== '' && this.$data.azureService.name !== null && this.$data.azureService.cost !== '' && this.$data.azureService.cost !== null) {
            this.$data.azureServices.push(this.$data.azureService);
            this.$data.azureService = {name: '', cost: 0};
        }
      },
      removeAzureService(serviceName){
        for (var i = 0; i < this.$data.azureServices.length; i++) {
            if (this.$data.azureServices[i].name === serviceName) {
                this.$data.azureServices.splice(i, 1);
            }
        }
      },
      removeAzurePositive(caseName) {
        for (var i = 0; i < this.$data.azurePositiveExperience.length; i++) {
            if (this.$data.azurePositiveExperience[i].case === caseName) {
                this.$data.azurePositiveExperience.splice(i, 1);
            }
        }
      },
      addAzurePositive() {
        this.$data.azurePositiveExperience.push(this.$data.azurePositive);
        this.$data.azurePositive = {case: '', section: '', risk: 0, complexity: 0, solution: ''};
      },
      removeAzureNegative(caseName) {
        for (var i = 0; i < this.$data.azureNegativeExperience.length; i++) {
            if (this.$data.azureNegativeExperience[i].case === caseName) {
                this.$data.azureNegativeExperience.splice(i, 1);
            }
        }
      },
      addAzureNegative() {
        this.$data.azureNegativeExperience.push(this.$data.azureNegative);
        this.$data.azureNegative = {case: '', section: '', risk: 0, complexity: 0, solution: ''};
      },
addAzureService(){
        if (this.$data.azureService.name !== '' && this.$data.azureService.name !== null && this.$data.azureService.cost !== '' && this.$data.azureService.cost !== null) {
            this.$data.azureServices.push(this.$data.azureService);
            this.$data.azureService = {name: '', cost: 0};
        }
      },
      removeAzureService(serviceName){
        for (var i = 0; i < this.$data.azureServices.length; i++) {
            if (this.$data.azureServices[i].name === serviceName) {
                this.$data.azureServices.splice(i, 1);
            }
        }
      },
      removeAzurePositive(caseName) {
        for (var i = 0; i < this.$data.azurePositiveExperience.length; i++) {
            if (this.$data.azurePositiveExperience[i].case === caseName) {
                this.$data.azurePositiveExperience.splice(i, 1);
            }
        }
      },
      addAzurePositive() {
        this.$data.azurePositiveExperience.push(this.$data.azurePositive);
        this.$data.azurePositive = {case: '', section: '', risk: 0, complexity: 0, solution: ''};
      },
      removeAzureNegative(caseName) {
        for (var i = 0; i < this.$data.azureNegativeExperience.length; i++) {
            if (this.$data.azureNegativeExperience[i].case === caseName) {
                this.$data.azureNegativeExperience.splice(i, 1);
            }
        }
      },
      addAzureNegative() {
        this.$data.azureNegativeExperience.push(this.$data.azureNegative);
        this.$data.azureNegative = {case: '', section: '', risk: 0, complexity: 0, solution: ''};
      },
      addAwsService(){
        if (this.$data.awsService.name !== '' && this.$data.awsService.name !== null && this.$data.awsService.cost !== '' && this.$data.awsService.cost !== null) {
            this.$data.awsServices.push(this.$data.awsService);
            this.$data.awsService = {name: '', cost: 0};
        }
      },
      removeAwsService(serviceName){
        for (var i = 0; i < this.$data.awsServices.length; i++) {
            if (this.$data.awsServices[i].name === serviceName) {
                this.$data.awsServices.splice(i, 1);
            }
        }
      },
      removeAwsPositive(caseName) {
        for (var i = 0; i < this.$data.awsPositiveExperience.length; i++) {
            if (this.$data.awsPositiveExperience[i].case === caseName) {
                this.$data.awsPositiveExperience.splice(i, 1);
            }
        }
      },
      addAwsPositive() {
        this.$data.awsPositiveExperience.push(this.$data.awsPositive);
        this.$data.awsPositive = {case: '', section: '', risk: 0, complexity: 0, solution: ''};
      },
      removeAwsNegative(caseName) {
        for (var i = 0; i < this.$data.awsNegativeExperience.length; i++) {
            if (this.$data.awsNegativeExperience[i].case === caseName) {
                this.$data.awsNegativeExperience.splice(i, 1);
            }
        }
      },
      addAwsNegative() {
        this.$data.awsNegativeExperience.push(this.$data.awsNegative);
        this.$data.awsNegative = {case: '', section: '', risk: 0, complexity: 0, solution: ''};
      },
      addGcpService(){
        if (this.$data.gcpService.name !== '' && this.$data.gcpService.name !== null && this.$data.gcpService.cost !== '' && this.$data.gcpService.cost !== null) {
            this.$data.gcpServices.push(this.$data.gcpService);
            this.$data.gcpService = {name: '', cost: 0};
        }
      },
      removeGcpService(serviceName){
        for (var i = 0; i < this.$data.gcpServices.length; i++) {
            if (this.$data.gcpServices[i].name === serviceName) {
                this.$data.gcpServices.splice(i, 1);
            }
        }
      },
      removeGcpPositive(caseName) {
        for (var i = 0; i < this.$data.gcpPositiveExperience.length; i++) {
            if (this.$data.gcpPositiveExperience[i].case === caseName) {
                this.$data.gcpPositiveExperience.splice(i, 1);
            }
        }
      },
      addGcpPositive() {
        this.$data.gcpPositiveExperience.push(this.$data.gcpPositive);
        this.$data.gcpPositive = {case: '', section: '', risk: 0, complexity: 0, solution: ''};
      },
      removeGcpNegative(caseName) {
        for (var i = 0; i < this.$data.gcpNegativeExperience.length; i++) {
            if (this.$data.gcpNegativeExperience[i].case === caseName) {
                this.$data.gcpNegativeExperience.splice(i, 1);
            }
        }
      },
      addGcpNegative() {
        this.$data.gcpNegativeExperience.push(this.$data.gcpNegative);
        this.$data.gcpNegative = {case: '', section: '', risk: 0, complexity: 0, solution: ''};
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