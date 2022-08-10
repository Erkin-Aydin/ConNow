<template>
  <div>
    <v-card style="width: 20%; margin-left: 40%; margin-top: 10%">
      <v-input>
        <div style="text-align: center; margin-left: 15%">
          <div>
            <v-form>
              <v-text-field
                  inputmode="email"
                  label="E-mail"
                  type="text"
                  hint="Enter your E-mail"
                  append-outer-icon="mdi-email"
                  :rules="[rules.required, rules.email]"
                  clearable></v-text-field>
            </v-form>
          </div>
          <div>
            <v-form>
              <v-text-field
                  inputmode="text"
                  label="Password"
                  type="text"
                  hint="Enter your password"
                  append-outer-icon="mdi-key"
                  :rules="[rules.required]"
                  clearable></v-text-field>
            </v-form>
          </div>
          <div>
            <v-btn><v-icon>mdi-login</v-icon> Login</v-btn>
          </div>
          <div>
            <router-link to="/account">Create an account</router-link>
          </div>
          <div>
            <router-link to="/passwordChange">Forgot your password?</router-link>
          </div>
        </div>
      </v-input>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "LoginView",

  data () {
    return {
      password: 'Password',
      email: '',
      rules: {
        required: value => !!value || 'Required.',
        counter: value => value.length >= 5 || 'Min 5 characters',
        email: value => {
          const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
          return pattern.test(value) || 'Invalid e-mail.'
        },
      },
    }
  },
}
</script>

<style scoped>

</style>