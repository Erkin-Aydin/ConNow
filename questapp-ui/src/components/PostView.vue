<template>
  <div id="axios-get" style="background-color: azure">
    <ul>
      <li v-for="post in posts" :key="post.id" style="background-color: antiquewhite">
        <hr><strong>{{ post.title }}</strong><br>{{ post.text }}
          <v-spacer>
            <b-button pill variant="outline-danger"><v-icon>mdi-heart</v-icon></b-button>
            <b-button pill variant="outline-danger"><v-icon>mdi-comment</v-icon></b-button>
          </v-spacer>
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
      errors: []
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