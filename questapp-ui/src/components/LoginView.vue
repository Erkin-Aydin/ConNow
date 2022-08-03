<template>
  <div>
    <v-card style="width: 20%; margin-left: 40%; margin-top: 10%">
      <v-input>
        <div style="text-align: center; margin-left: 20%">
          <div>
            <v-form>
              <v-text-field label="Username"></v-text-field>
            </v-form>
          </div>
          <div>
            <v-form>
              <v-text-field label="Password"></v-text-field>
            </v-form>
          </div>
          <div>
            <v-btn><v-icon>mdi-login</v-icon> Login</v-btn>
          </div>
          <div>
            <router-link to="/account">Create an account</router-link>
          </div>
          <div>
            <router-link to="/password">Forgot your password?</router-link>
          </div>
        </div>
      </v-input>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "LoginView"
}
</script>

<style scoped>

</style>