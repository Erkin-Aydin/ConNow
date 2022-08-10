<template>
  <div>
    <v-alert dense dismissible type="success" v-if="isSuccessful"
             style="width: 15%">Account Created Successfully!</v-alert>
    <v-alert dense dismissible type="error" v-if="displayError"
             style="width: 15%">Can't create this account!</v-alert>
    <v-card style="width: 20%; margin-left: 40%; margin-top: 10%">
      <div style="text-align: center; padding-left: 10%; padding-right: 10%; padding-top: 10%">
        <div>
          <v-form @submit.prevent="createUser">
            <v-text-field
                label="E-mail"
                type="email"
                append-outer-icon="mdi-email"
                :rules="[rules.required, rules.email]"
                clearable
                v-model="email">
            </v-text-field>
            <v-text-field
                label="Username"
                type="text"
                append-outer-icon="mdi-account"
                :rules="[rules.required, rules.username]"
                clearable
                v-model="userName">
            </v-text-field>
            <v-text-field
                label="Password"
                type="password"
                append-outer-icon="mdi-key"
                :rules="[rules.required, rules.counter]"
                clearable
                v-model="password">
            </v-text-field>
            <v-btn type="submit"><v-icon>mdi-card-account-details-outline</v-icon>Create!</v-btn>
          </v-form>
          <div style="padding-top: 4%; padding-bottom: 4%">
            <router-link to="/login">Already have an account?</router-link>
          </div>
        </div>
      </div>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "PasswordChangeView"
}
</script>

<style scoped>

</style>