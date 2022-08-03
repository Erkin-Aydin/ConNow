<template>
  <div>
    <v-input>
      <v-text-field
          label="Username"
          :rules="rules"
          hide-details="auto"
      ></v-text-field>
      <v-text-field label="Password"></v-text-field>
    </v-input>
  </div>
</template>

<script>
export default {
  name: "LoginView"
}
</script>

<style scoped>

</style>