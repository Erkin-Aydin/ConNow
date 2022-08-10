<template>
  <div>
    <v-alert dense dismissible type="success" v-if="found"
             style="width: 15%">Account Found!</v-alert>
    <v-card style="width: 20%; margin-left: 40%; margin-top: 10%">
      <div style="text-align: center; padding-left: 10%; padding-right: 10%; padding-top: 10%">
        <div>
          <h4>Let us help you to change your password!</h4>
          <v-form @submit.prevent="passwordChangeRequest">
            <v-text-field
                label="E-mail"
                type="email"
                append-outer-icon="mdi-email"
                :rules="[rules.required, rules.email]"
                clearable
                v-model="email">
            </v-text-field>
            <v-btn type="submit"><v-icon>mdi-card-account-details-outline</v-icon>Create!</v-btn>
          </v-form>
        </div>
      </div>
    </v-card>
  </div>
</template>

<script>
import axios from "axios";
import router from "@/router";

export default {
  name: "PasswordChangeView",
  data() {
    return {
      email: '',
      found: false,
      rules: {
        required: value => !!value || 'Required.',
        email: value => {
          const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
          return pattern.test(value) || 'Invalid e-mail.'
        }
      }
    }
  },
  methods: {
    passwordChangeRequest() {
      axios
          .get("http://localhost:8080/users/" + this.email)
          .then((response) => {
            console.log(response)
            this.found = response
                if(this.found) {
                  setTimeout(() => this.found = false, 2000)
                  setTimeout(() => router.push("/changeProcess"), 2100)
                }
          })
    }
  }
}
</script>

<style scoped>

</style>