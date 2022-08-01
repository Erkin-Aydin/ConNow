<template>
  <div id="axios-get" style="background-color: azure">
    <ul>
      <li v-for="user in users" :key="user.id" style="background-color: antiquewhite">
        <hr> Username: <strong>{{ user.userName }}</strong> <br> Password: {{ user.password }}<hr>
      </li>
    </ul>
    <ul v-if="errors && errors.length">
      <li v-for="(error, index) of errors" :key="index">
        {{ index + 1 }} - {{ error.message }}
      </li>
    </ul>
  </div>
</template>

<script>

import axios from "axios"

export default {
  name: "UserView",
  created() {
    this.getAllUsers();
  },
  data() {
    return {
      users: [],
      errors: []
    };
  },
  methods: {
    getAllUsers() {
      axios
          .get("http://localhost:8080/users/list")
          .then(response => (this.users = response.data))
          .catch(error => {
            this.errors.push(error);
          })
    }
  }
}
</script>

<style scoped>

</style>