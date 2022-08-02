<template>
  <div id="axios-get" style="background-color: azure">
    <ul>
      <li v-for="post in posts" :key="post.id" style="background-color: antiquewhite">
        <v-card>
          <v-card-title>{{ post.title }}</v-card-title>
          <v-card-subtitle>{{ post.get }}</v-card-subtitle>
          <v-card-text>{{ post.text }}</v-card-text>
        </v-card>
        <hr>
        <!--

        -->
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
  name: "PostView",
  components: {},

  created() {
    this.getAllPosts();

  },
  data() {
    return {
      posts: [],
      errors: [],
      users: []
    }
  },
  methods: {
    getAllPosts() {
      axios
          .get("http://localhost:8080/posts/list")
          .then(response => (this.posts = response.data))
          .catch(error => {
            this.errors.push(error);
          })
    }
  }
}
</script>

<style scoped>

</style>