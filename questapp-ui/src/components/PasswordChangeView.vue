<template>
  <div>
    <v-alert dense dismissible type="success" v-if="displayAccountFound"
             style="width: 15%">Account Found!</v-alert>
    <v-alert dense dismissible type="error" v-if="displayAccountNotFound"
             style="width: 15%">Account Not Found!</v-alert>
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
      <p>An email has been sent. click the link there and continue.</p>
      <p>Please close this page.</p>
    </div>
  </div>
</template>

<script>
import axios from "axios";

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
      displayAccountNotFound: false,
      emailVerified: false,
      passwordChanged: false,
      userPassword: '',
      curPasswordValid: true,
      rules: {
        required: value => !!value || 'Required.',
        counter: value => value.length >= 5 || 'Min 5 characters',
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
            this.found = response.data
            console.log(this.found)
            if(!this.found) {
              this.displayAccountNotFound = true
              setTimeout(() => this.displayAccountNotFound = false ,2000)
            }
            else {
              this.emailVerified = true
              this.displayAccountFound = true
              axios.post("http://localhost:8080/sendMail", {
                recipient: this.email,
                //messageBody: "http://localhost:8081/#/passwordChangeProcess",
                messageBody: "Please click the link below to change your password:<br>"
                    + "<h3><a href=\"http://localhost:8081/#/passwordChangeProcess\" target=\"_self\">Change</a></h3>"
                    + "Thank you,<br>"
                    + "ConNow!.",
                subject: "Password Change Request"
              })
              setTimeout(() => this.displayAccountFound = false, 2000)
            }
          })
    },
  }
}
</script>

<style scoped>

</style>