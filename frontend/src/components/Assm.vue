<template>

<div class="assm">

<!--<div>
  <b-card no-body>
    <b-tabs pills card>
      <b-tab title="General Information" title-item-class="'mytab'" active>
        <b-card-text><p class="tab-title">
            <div>
              <b-button v-b-toggle.collapse1 variant="primary">Databases</b-button>
              <b-collapse id="collapse1" class="mt-2">
                <b-card>
                  <p class="card-text">Databases</p>
                </b-card>
              </b-collapse>
            </div>
        </p></b-card-text>
      </b-tab>
      <b-tab title="Architecture">
        <b-card-text>Tab Contents 2</b-card-text>
      </b-tab>
      <b-tab title="Used Services">
         <b-card-text>Tab Contents 3</b-card-text>
      </b-tab>
      <b-tab title="Servers">
          <b-card-text>Tab Contents 4</b-card-text>
      </b-tab>
      <b-tab title="Software">
          <b-card-text>Tab Contents 5</b-card-text>
      </b-tab>
      <b-tab title="Reference">
          <b-card-text>Reference</b-card-text>
      </b-tab>
    </b-tabs>
  </b-card>
</div>-->

<div class="main-content">
  <b-card no-body>
    <b-tabs pills card vertical>
      <b-tab title="General Information" active>
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
      <b-tab title="Architecture">
      <b-card-text>
        <b-form-group label="Architechture details:">
              <b-form-checkbox
                v-for="option in arch_options"
                v-model="selected"
                :key="option.value"
                :value="option.value"
                name="flavour3a"
              >
                {{ option.text }}
              </b-form-checkbox>
            </b-form-group>
      </b-card-text>
      </b-tab>
      <b-tab title="Used Services">
        <b-card-text>
            <b-card no-body>
                      <b-tabs pills card>
                         <b-tab title="Databases">
                              <b-card-text>
                                <b-list-group>
                                  <b-list-group-item class="d-flex justify-content-between align-items-center">
                                    MS SQL Server
                                    <b-badge variant="primary" pill>3</b-badge>
                                  </b-list-group-item>

                                  <b-list-group-item class="d-flex justify-content-between align-items-center">
                                    Oracle Database
                                    <b-badge variant="primary" pill>2</b-badge>
                                  </b-list-group-item>

                                  <b-list-group-item class="d-flex justify-content-between align-items-center">
                                    MariaDB/MySQL
                                    <b-badge variant="primary" pill>1</b-badge>
                                  </b-list-group-item>
                                </b-list-group>
                              </b-card-text>
                                        </b-tab>
                                        <b-tab title="Infrastructure">
                                            <b-card-text>Infrastructure</b-card-text>
                                        </b-tab>
                                        <b-tab title="Features">
                                            <b-card-text>Features</b-card-text>
                                        </b-tab>
                                  </b-tabs>
                              </b-card>
        </b-card-text>
      </b-tab>
      <b-tab title="Servers"><b-card-text>Used Services</b-card-text></b-tab>
      <b-tab title="Software"><b-card-text>Software</b-card-text></b-tab>
      <b-tab title="Reference"><b-card-text>Reference</b-card-text></b-tab>
    </b-tabs>
  </b-card>
  <!--<hr>
  <b-button class="btn-violet" href="#" variant="primary">Save</b-button>-->
</div>

</div>


</div>

</template>

<script>
export default {
    name: 'assm',
    data() {
        return {
            arch_options: [
                      { text: 'Three-tier architecture', value: 'Three-tier architecture' },
                      { text: 'Two-tier architecture', value: 'Two-tier architecture' },
                      { text: 'Using a separate DB', value: 'Using a separate DB' },
                      { text: 'Using DB with other environments', value: 'Using DB with other environments' }
                    ]
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

</style>