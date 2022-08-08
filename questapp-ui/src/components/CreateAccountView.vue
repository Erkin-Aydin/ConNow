<template>
  <div>
    <v-card style="width: 20%; margin-left: 40%; margin-top: 10%">
      <v-input>
        <div style="text-align: center; margin-left: 20%">
          <div>
            <v-form>
              <v-text-field
                  label="E-mail"
                  append-outer-icon="mdi-email"
                  :rules="[rules.required, rules.email]"
                  clearable></v-text-field>
            </v-form>
          </div>
          <div>
            <v-form>
              <v-text-field
                  label="Username"
                  append-outer-icon="mdi-account"
                  :rules="[rules.required, rules.username]"
                  clearable></v-text-field>
            </v-form>
          </div>
          <div>
            <v-form>
              <v-text-field
                  label="Password"
                  append-outer-icon="mdi-key"
                  :rules="[rules.required, rules.counter]"
                  clearable></v-text-field>
            </v-form>
          </div>
          <div>
            <v-btn><v-icon>mdi-card-account-details-outline</v-icon>Create!</v-btn>
          </div>
          <div>
            <router-link to="/login">Already have an account?</router-link>
          </div>
        </div>
      </v-input>
    </v-card>
  </div>
</template>

<script>
//import axios from "axios";

export default {
  name: "CreateAccountView",
  components: {},

  created() {
    this.createUser();
  },
  data() {
    return {
      password: 'Password',
      email: '',
      rules: {
        required: value => !!value || 'Required.',
        counter: value => value.length >= 5 || 'Min 5 characters',
        username: value => value.length >= 5 || 'Min 5 characters',
        email: value => {
          const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
          return pattern.test(value) || 'Invalid e-mail.'
        }
      },
    }
  },
  methods: {
    createUser(userCreateRequest) {
      axios
        .post("http://localhost:8080/users/create", )
    }
  }
}
</script>

<style scoped>

</style>