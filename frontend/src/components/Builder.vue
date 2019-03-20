<template>

<div class="assm">

<div class="main-content">
  <b-card no-body>
    <b-tabs pills card vertical v-model="tabIndex">
      <b-tab active :title-link-class="linkClass(0)">
        <template slot="title">
           <span><font-awesome-icon icon="address-card" />  General Information</span>
        </template>
        <b-card-text>
            <div class="general-information-container">
                <b-form-input type="text" placeholder="Name" />
                <div class="mt-2"></div>
                <b-form-input type="text" placeholder="Vendor" />
                <div class="mt-2"></div>
                <b-form-input type="text" placeholder="Version" />
                <div class="mt-2"></div>
            </div>
        </b-card-text>
      </b-tab>
      <b-tab :title-link-class="linkClass(1)">
        <template slot="title">
           <span><font-awesome-icon icon="drafting-compass" />  Architecture</span>
        </template>
      <b-card-text>
        <b-form-group label="Architechture details:">
              <b-form-checkbox
                v-for="option in arch_options"
                :key="option.value"
                :value="option.value"
                name="flavour3a"
              >
                {{ option.text }}
              </b-form-checkbox>
            </b-form-group>
      </b-card-text>
      </b-tab>
      <b-tab :title-link-class="linkClass(2)">
        <template slot="title">
           <span><font-awesome-icon icon="tools" />  Used Services</span>
         </template>
        <b-card-text>
            <b-card no-body>
                      <b-tabs pills card v-model="subTabIndex">
                         <b-tab :title-link-class="subLinkClass(0)">
                                <template slot="title">
                                    <span><font-awesome-icon icon="database" />  Database</span>
                                 </template>
                              <b-card-text>

                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Quantity</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr v-for="u_db in used_dbs_list">
                                        <td>{{u_db.name}}</td>
                                        <td><input class="form-control" type="number" min="1" v-model="u_db.quantity"></td>
                                        <td><b-button style="width: 110px;" v-on:click="removeUsedDb(u_db.name)" class="btn-violet"><font-awesome-icon icon="cut" /> Remove</b-button></td>
                                        </tr>
                                        <tr style="background-color: #e6d4f5" v-if="dbs_list.length > 0">
                                            <td>
                                                <select id="dbSelector" class="custom-select" aria-label="Select database to add" v-model="db_to_add">
                                                     <option v-for="db in dbs_list">{{ db }}</option>
                                                </select>
                                            </td>
                                            <td>
                                                <input class="form-control" type="number" min="1" v-model="db_quantity">
                                            </td>
                                            <td>
                                                <b-button v-on:click="addUsedDb" style="width: 110px;" class="add-component-button btn-violet"><font-awesome-icon icon="plus" /> Add</b-button>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>


                              </b-card-text>
                                        </b-tab>
                                        <b-tab :title-link-class="subLinkClass(1)">
                                            <template slot="title">
                                                   <span><font-awesome-icon icon="cubes" />  Infrastructure</span>
                                                </template>
                                            <b-card-text>

                                                <table class="table table-striped">
                                                    <thead>
                                                        <tr>
                                                            <th>Name</th>
                                                            <th>Quantity</th>
                                                            <th></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr v-for="u_infr in used_infr_list">
                                                        <td>{{u_infr.name}}</td>
                                                        <td><input class="form-control" type="number" min="1" v-model="u_infr.quantity"></td>
                                                        <td><b-button style="width: 110px;" v-on:click="removeUsedInfr(u_infr.name)" class="btn-violet"><font-awesome-icon icon="cut" /> Remove</b-button></td>
                                                        </tr>
                                                        <tr style="background-color: #e6d4f5" v-if="infr_list.length > 0">
                                                            <td>
                                                                <select id="infrSelector" class="custom-select" aria-label="Select infrastructure component to add" v-model="infr_to_add">
                                                                     <option v-for="infr in infr_list">{{ infr }}</option>
                                                                </select>
                                                            </td>
                                                            <td>
                                                                <input class="form-control" type="number" min="1" v-model="infr_quantity">
                                                            </td>
                                                            <td>
                                                                <b-button v-on:click="addUsedInfr" style="width: 110px;" class="add-component-button btn-violet"><font-awesome-icon icon="plus" /> Add</b-button>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>

                                            </b-card-text>
                                        </b-tab>


                                        <b-tab :title-link-class="subLinkClass(2)">
                                            <template slot="title">
                                                   <span><font-awesome-icon icon="cogs" />  Features</span>
                                                </template>
                                            <b-card-text>

                                                <table class="table table-striped">
                                                    <thead>
                                                        <tr>
                                                            <th>Name</th>
                                                            <th>Usage</th>
                                                            <th></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr v-for="u_f in used_features_list">
                                                        <td>{{u_f.name}}</td>
                                                        <td>
                                                            <select class="custom-select" v-model="u_f.usage">
                                                                <option>Yes</option>
                                                                <option>Partically</option>
                                                                <option>No</option>
                                                            </select>
                                                        </td>
                                                        <td><b-button style="width: 110px;" v-on:click="removeUsedFeature(u_f.name)" class="btn-violet"><font-awesome-icon icon="cut" /> Remove</b-button></td>
                                                        </tr>
                                                        <tr style="background-color: #e6d4f5" v-if="features_list.length > 0">
                                                            <td>
                                                                <select id="featureSelector" class="custom-select" aria-label="Select feature to add" v-model="feature_to_add">
                                                                     <option v-for="f in features_list">{{ f }}</option>
                                                                </select>
                                                            </td>
                                                            <td>
                                                                <select class="custom-select" v-model="feature_usage">
                                                                    <option>Yes</option>
                                                                    <option>Partically</option>
                                                                    <option>No</option>
                                                                </select>
                                                            </td>
                                                            <td>
                                                                <b-button v-on:click="addUsedFeature" style="width: 110px;" class="add-component-button btn-violet"><font-awesome-icon icon="plus" /> Add</b-button>
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
      <b-tab :title-link-class="linkClass(3)">
        <template slot="title">
                 <span><font-awesome-icon icon="chess-knight" />  Apps</span>
              </template>
        <b-card-text>
                    <table class="table table-striped">
                                                    <thead>
                                                        <tr>
                                                            <th>Name</th>
                                                            <th>Quantity</th>
                                                            <th></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr v-for="u_app in used_apps_list">
                                                        <td>{{u_app.name}}</td>
                                                        <td><input class="form-control" type="number" min="1" v-model="u_app.quantity"></td>
                                                        <td><b-button style="width: 110px;" v-on:click="removeUsedApp(u_app.name)" class="btn-violet"><font-awesome-icon icon="cut" /> Remove</b-button></td>
                                                        </tr>
                                                        <tr style="background-color: #e6d4f5" v-if="apps_list.length > 0">
                                                            <td>
                                                                <select id="appSelector" class="custom-select" aria-label="Select application to add" v-model="app_to_add">
                                                                     <option v-for="app in apps_list">{{ app }}</option>
                                                                </select>
                                                            </td>
                                                            <td>
                                                                <input class="form-control" type="number" min="1" v-model="apps_quantity">
                                                            </td>
                                                            <td>
                                                                <b-button v-on:click="addUsedApp" style="width: 110px;" class="add-component-button btn-violet"><font-awesome-icon icon="plus" /> Add</b-button>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
        </b-card-text>
      </b-tab>
      <b-tab :title-link-class="linkClass(4)">
        <template slot="title">
                 <span><font-awesome-icon icon="user-plus" />  Additional</span>
              </template>
        <b-card-text>
                            <table class="table table-striped">
                                                    <thead>
                                                        <tr>
                                                            <th>Name</th>
                                                            <th>Quantity</th>
                                                            <th></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr v-for="u_add in used_adds_list">
                                                        <td>{{u_add.name}}</td>
                                                        <td><input class="form-control" type="number" min="1" v-model="u_add.quantity"></td>
                                                        <td><b-button style="width: 110px;" v-on:click="removeUsedAdd(u_add.name)" class="btn-violet"><font-awesome-icon icon="cut" /> Remove</b-button></td>
                                                        </tr>
                                                        <tr style="background-color: #e6d4f5" v-if="adds_list.length > 0">
                                                            <td>
                                                                <select id="addSelector" class="custom-select" aria-label="Select additional requirement to add" v-model="add_to_add">
                                                                     <option v-for="add in adds_list">{{ add }}</option>
                                                                </select>
                                                            </td>
                                                            <td>
                                                                <input class="form-control" type="number" min="1" v-model="adds_quantity">
                                                            </td>
                                                            <td>
                                                                <b-button v-on:click="addUsedAdd" style="width: 110px;" class="add-component-button btn-violet"><font-awesome-icon icon="plus" /> Add</b-button>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
        </b-card-text>
      </b-tab>
      <b-tab :title-link-class="linkClass(5)">
        <template slot="title">
                 <span><font-awesome-icon icon="list-alt" />  Reference</span>
              </template>
        <b-card-text>
            <table class="table table-stripped">
                            <thead>
                                <tr>
                                    <th>Server Name</th>
                                    <th>Address</th>
                                    <th>OS</th>
                                    <th>CPU cores</th>
                                    <th>RAM</th>
                                    <th>Memory</th>
                                    <th>Services</th>
                                    <th></th>
                                 </tr>
                            </thead>
                            <tbody>
                                <tr v-for="ref in reference_list">
                                    <td><input class="form-control" type="text" v-model="ref.name"></td>
                                    <td><input class="form-control" type="text" v-model="ref.address"></td>
                                    <td><input class="form-control" type="text" v-model="ref.os"></td>
                                    <td><input class="form-control" type="number" min="1" v-model="ref.cpu"></td>
                                    <td><input class="form-control" type="number" min="1" v-model="ref.ram"></td>
                                    <td><input class="form-control" type="number" min="1" v-model="ref.memory"></td>
                                    <td><input class="form-control" type="text" v-model="ref.services"></td>
                                    <td><b-button style="width: 110px;" v-on:click="removeReference(ref.id)" class="btn-violet"><font-awesome-icon icon="cut" /> Remove</b-button></td>
                                </tr>
                                <tr style="background-color: #e6d4f5">
                                    <td><input class="form-control" type="text" v-model="ref_to_add.name"></td>
                                    <td><input class="form-control" type="text" v-model="ref_to_add.address"></td>
                                    <td><input class="form-control" type="text" v-model="ref_to_add.os"></td>
                                    <td><input class="form-control" type="number" min="1" v-model="ref_to_add.cpu"></td>
                                    <td><input class="form-control" type="number" min="1" v-model="ref_to_add.ram"></td>
                                    <td><input class="form-control" type="number" min="1" v-model="ref_to_add.memory"></td>
                                    <td><input class="form-control" type="text" v-model="ref_to_add.services"></td>
                                    <td><b-button v-on:click="addReference" style="width: 110px;" class="add-component-button btn-violet"><font-awesome-icon icon="plus" /> Add</b-button></td>
                                </tr>
                            </tbody>
                        </table>
        </b-card-text>
      </b-tab>
      <b-tab :title-link-class="linkClass(6)">
              <template slot="title">
                       <span><font-awesome-icon icon="save" />  Save</span>
                    </template>
              <b-card-text>
                <div style="margin: auto; margin-top: 50px; width: 200px; text-align: center;">
                    <b-button class="btn-violet btn-save" href="#" variant="primary"><font-awesome-icon icon="save" /> Save Project</b-button>
                    <b-button class="btn-violet btn-save" href="#" variant="primary"><font-awesome-icon icon="file" /> Save and View ASSM</b-button>
                </div>
              </b-card-text>
      </b-tab>
    </b-tabs>
    <!--<hr style="margin-left: 2%; margin-right: 2%;">
    <div>
        <b-button class="btn-violet float-right" href="#" variant="primary">Save</b-button>
    </div>-->
  </b-card>
  <!--<hr>
  <b-button class="btn-violet" href="#" variant="primary">Save</b-button>-->
</div>

</div>


</div>

</template>

<script>
export default {
    name: 'builder',
    data() {
        return {
            tabIndex: 0,
            subTabIndex: 0,
            arch_options: [
                      { text: 'Three-tier architecture', value: 'Three-tier architecture' },
                      { text: 'Two-tier architecture', value: 'Two-tier architecture' },
                      { text: 'Using a separate DB', value: 'Using a separate DB' },
                      { text: 'Using DB with other environments', value: 'Using DB with other environments' }
                    ],
            used_dbs_list: [
                /*{ name: "MySQL/MariaDB", quantity: 7},
                { name: "MS SQL Server", quantity: 2},
                { name: "Oracle Database", quantity: 3}*/
            ],
            dbs_list: [
                "MySQL/MariaDB",
                "MS SQL Server",
                "Oracle Database",
                "PostgreSQL",
                "MongoDB"
            ],
            used_dbs_fields: ['name', 'quantity'],
            db_quantity: 1,
            db_to_add: '',
            used_infr_list: [],
            infr_list: [
                "Windows servers",
                "Linux servers",
                "ADFS",
                "MS Exchange Server"
            ],
            infr_quantity: 1,
            infr_to_add: '',
            used_features_list: [],
            features_list: [
                "DB-DB dependency?",
                "Use Docker?",
                "Use Kubernetes?",
                "Already use Azure?",
                "Use AWS?",
                "Use Google Cloud?",
                "Use Alibaba Cloud ?",
                "Use ESXi virtualization?",
                "Use KVM virtualization?",
                "Use Hyper-V virtualization?"
            ],
            feature_usage: '',
            feature_to_add: '',
            used_apps_list: [],
            apps_list: [
                "Exim",
                "ServiceNow",
                "WebLogic Server",
                "IBM WebSphere Application Server",
                "Node.js",
                "Apache Hadoop"
            ],
            apps_quantity: 1,
            app_to_add: '',
            used_adds_list: [],
            adds_list: [
                "Save naming policy",
                "Monitoring",
                "Disaster Recovery",
                "DR site",
                "Decentralized Firewall",
                "VPN tunnels",
                "HTTPS tunnels",
                "Disaster Recovery in 24 hours"
            ],
            adds_quantity: 1,
            add_to_add: '',
            reference_list: [],
            ref_id_counter: 0,
            ref_to_add: {id: 0, name: '', address: '', os: '', cpu: 1, ram: 2, services: '', memory: 10}
        }
    },
    mounted() {
        this.$data.dbs_list.sort();
        this.$data.infr_list.sort();
        this.$data.features_list.sort();
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
        mydeb: function() {
            /*console.log(this.$data.used_dbs_list[0].quantity);
            console.log(this.$data.db_to_add);*/
        },
        addUsedDb: function() {
            if (this.$data.db_to_add !== '' && this.$data.db_to_add != null) {
                this.$data.used_dbs_list.push({name: this.$data.db_to_add, quantity: this.$data.db_quantity});
                for (var i = 0; i < this.$data.dbs_list.length; i++) {
                    if (this.$data.dbs_list[i] == this.$data.db_to_add) {
                        this.$data.dbs_list.splice(i, 1);
                        break;
                    }
                }
            this.$data.db_to_add = '';
            this.$data.db_quantity = 1;
            this.$data.dbs_list.sort();
            }
        },
        removeUsedDb(dbName) {
            for (var i = 0; i < this.$data.used_dbs_list.length; i++) {
                if (this.$data.used_dbs_list[i].name === dbName) {
                    this.$data.used_dbs_list.splice(i, 1);
                }
            }
            this.$data.dbs_list.push(dbName);
            this.$data.dbs_list.sort();
        },
        addUsedInfr: function() {
                if (this.$data.infr_to_add !== '' && this.$data.infr_to_add != null) {
                    this.$data.used_infr_list.push({name: this.$data.infr_to_add, quantity: this.$data.infr_quantity});
                    for (var i = 0; i < this.$data.infr_list.length; i++) {
                        if (this.$data.infr_list[i] == this.$data.infr_to_add) {
                            this.$data.infr_list.splice(i, 1);
                            break;
                        }
                    }
                this.$data.infr_to_add = '';
                this.$data.infr_quantity = 1;
                this.$data.infr_list.sort();
                }
            },
            removeUsedInfr(infrName) {
                for (var i = 0; i < this.$data.used_infr_list.length; i++) {
                    if (this.$data.used_infr_list[i].name === infrName) {
                        this.$data.used_infr_list.splice(i, 1);
                    }
                }
                this.$data.infr_list.push(infrName);
                this.$data.infr_list.sort();
            },
            addUsedFeature: function() {
                if (this.$data.feature_to_add !== '' && this.$data.feature_to_add != null && this.$data.feature_usage != '' && this.$data.feature_usage != null) {
                    this.$data.used_features_list.push({name: this.$data.feature_to_add, usage: this.$data.feature_usage});
                    for (var i = 0; i < this.$data.features_list.length; i++) {
                        if (this.$data.features_list[i] == this.$data.feature_to_add) {
                            this.$data.features_list.splice(i, 1);
                            break;
                        }
                    }
                this.$data.feature_to_add = '';
                this.$data.feature_usage = '';
                this.$data.features_list.sort();
                }
            },
            removeUsedFeature(featureName) {
                for (var i = 0; i < this.$data.used_features_list.length; i++) {
                    if (this.$data.used_features_list[i].name === featureName) {
                        this.$data.used_features_list.splice(i, 1);
                    }
                }
                this.$data.features_list.push(featureName);
                this.$data.features_list.sort();
            },
            addUsedApp: function() {
                if (this.$data.app_to_add !== '' && this.$data.app_to_add != null) {
                    this.$data.used_apps_list.push({name: this.$data.app_to_add, quantity: this.$data.apps_quantity});
                    for (var i = 0; i < this.$data.apps_list.length; i++) {
                        if (this.$data.apps_list[i] == this.$data.app_to_add) {
                            this.$data.apps_list.splice(i, 1);
                            break;
                        }
                    }
                this.$data.app_to_add = '';
                this.$data.apps_quantity = 1;
                this.$data.apps_list.sort();
                }
            },
            removeUsedApp(appName) {
                for (var i = 0; i < this.$data.used_apps_list.length; i++) {
                    if (this.$data.used_apps_list[i].name === appName) {
                        this.$data.used_apps_list.splice(i, 1);
                    }
                }
                this.$data.apps_list.push(appName);
                this.$data.apps_list.sort();
            },
            addUsedAdd: function() {
                if (this.$data.add_to_add !== '' && this.$data.add_to_add != null) {
                    this.$data.used_adds_list.push({name: this.$data.add_to_add, quantity: this.$data.adds_quantity});
                    for (var i = 0; i < this.$data.adds_list.length; i++) {
                        if (this.$data.adds_list[i] == this.$data.add_to_add) {
                            this.$data.adds_list.splice(i, 1);
                            break;
                        }
                    }
                this.$data.add_to_add = '';
                this.$data.adds_quantity = 1;
                this.$data.adds_list.sort();
                }
            },
            removeUsedAdd(addName) {
                for (var i = 0; i < this.$data.used_adds_list.length; i++) {
                    if (this.$data.used_adds_list[i].name === addName) {
                        this.$data.used_adds_list.splice(i, 1);
                    }
                }
                this.$data.adds_list.push(addName);
                this.$data.adds_list.sort();
            },
            addReference() {
                /*this.$data.reference_list.push({
                    id: this.$data.ref_id_counter,
                    name: this.$data.ref_to_add.name,
                    address: this.$data.ref_to_add.address,
                    os: this.$data.ref_to_add.os,
                    cpu: this.$data.ref_to_add.cpu,
                    ram: this.$data.ref_to_add.ram,
                    services: this.$data.ref_to_add.services,
                    memory: this.$data.ref_to_add.memory
                });*/
                this.$data.reference_list.push(this.$data.ref_to_add);
                this.$data.ref_id_counter++;
                this.$data.ref_to_add = {id: this.$data.ref_id_counter, name: '', address: '', os: '', cpu: 1, ram: 2, services: '', memory: 10}
            },
            removeReference(id) {
                /*this.$data.reference_list.splice(id, 1);*/
                for (var i = 0; i < this.$data.reference_list.length; i++) {
                    if (this.$data.reference_list[i].id == id) {
                        this.$data.reference_list.splice(i, 1);
                        break;
                    }
                }
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
.general-information-container {
    width: 400px;
}
.add-container {
    display: grid;
}
.btn-save {
    margin-bottom: 20px;
}
</style>