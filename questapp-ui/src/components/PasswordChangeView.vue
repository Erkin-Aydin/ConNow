<template>
  <div>
    <v-alert dense dismissible type="success" v-if="displayAccountFound"
             style="width: 15%">Account Found!</v-alert>
    <v-alert dense dismissible type="error" v-if="!curPasswordValid"
             style="width: 15%">Current Password Not Correct!</v-alert>
    <div v-if="!found">
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
    <div v-if="emailVerified">
      <v-card style="width: 20%; margin-left: 40%; margin-top: 10%">
        <div style="text-align: center; padding-left: 10%; padding-right: 10%; padding-top: 10%">
          <div>
            <h4>Let us help you to change your password!</h4>
            <v-form @submit.prevent="passwordChangeProcess">
              <v-text-field
                  label="Current Password"
                  type="password"
                  append-outer-icon="mdi-key"
                  :rules="[rules.required, rules.counter]"
                  clearable
                  v-model="curPassword">
              </v-text-field>
              <v-text-field
                  label="New Password"
                  type="password"
                  append-outer-icon="mdi-key"
                  :rules="[rules.required, rules.counter]"
                  clearable
                  v-model="newPassword">
              </v-text-field>
              <v-text-field
                  label="New Password Again"
                  type="password"
                  append-outer-icon="mdi-key"
                  :rules="[rules.required, rules.counter]"
                  clearable
                  v-model="newPasswordRepeat">
              </v-text-field>
              <div
                  v-if="!(newPassword === newPasswordRepeat)"
                  style="color: red; padding-bottom: 5%">Passwords do not match!</div>
              <v-btn
                  type="submit"
                  style="padding-top: 5%; padding-bottom: 5%"
                  v-if="(newPasswordRepeat === newPassword)
                      && newPassword.length >= 5
                      && newPasswordRepeat.length >= 5"><v-icon>mdi-card-account-details-outline</v-icon>Create!</v-btn>
              <v-btn
                  disabled
                  type="submit"
                  style="padding-top: 5%; padding-bottom: 5%"
                  v-if="!(newPasswordRepeat === newPassword)
                      || newPassword.length < 5
                      || newPasswordRepeat.length < 5"><v-icon>mdi-card-account-details-outline</v-icon>Create!</v-btn>
            </v-form>
          </div>
        </div>
      </v-card>
    </div>
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
      curPassword: '',
      newPassword: '',
      newPasswordRepeat: '',
      found: false,
      displayAccountFound: false,
      emailVerified: false,
      passwordChanged: false,
      userPassword: '',
      curPasswordValid: true,
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
          .get("http://localhost:8080/users/email/" + this.email)
          .then((response) => {
            console.log(response)
            this.found = response
            this.emailVerified = this.found
            this.displayAccountFound = this.found
            if(this.found) {
              setTimeout(() => this.displayAccountFound = false, 2000)
            }
          })
    },
    passwordChangeProcess() {
      axios
          .get("http://localhost:8080/users/checkPassword", {
            email: this.email,
            password: this.curPassword
          })
          .then((response) => {
            this.curPasswordValid = response

          })
          if(this.curPasswordValid){
            setTimeout(() => this.curPasswordValid = true, 2000)
          }
          else {
            axios
                .put("http://localhost:8080/users/passwordChange/",
                    {email: this.email, password: this.newPassword})
                .then((response) => {
                  console.log(response)
                  this.passwordChanged = response
                  if(this.passwordChanged) {
                    setTimeout(() => this.passwordChanged = false, 2000)
                    setTimeout(() => router.push('/'), 2100)
                  }
                })
          }
    }
  }
}
</script>

<style scoped>

</style>