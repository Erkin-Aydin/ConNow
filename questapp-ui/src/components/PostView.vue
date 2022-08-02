<template>
  <div id="axios-get" style="background-color: azure">
    <ul>
      <li v-for="(post, index) in posts" :key="post.id" style="background-color: antiquewhite">
        <v-card>
          <v-card-title>{{ post.title }}</v-card-title>
          <v-card-subtitle>{{ getUserNameByPost(post.id) }}</v-card-subtitle>
          <v-card-text>{{ post.text }}</v-card-text>
          <v-card-actions>
            <v-btn class="like" color="error"><v-icon>mdi-heart</v-icon></v-btn>
            <v-btn class="display" color="primary" @click="isClicked[index] = !isClicked[index]"><v-icon>mdi-comment</v-icon></v-btn>
            <!--<v-card v-if="isClicked[index]">{{ getAllCommentsByPostId(post.id) }}</v-card>-->
          </v-card-actions>
        </v-card>
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
      users: [],
      comments: []
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
    },
    getUserNameByPost(postId) {
      return axios
          .get("http://localhost:8080/posts/user?postId=" + postId)
          .catch(error => {
            this.errors.push(error);
          });
    },
    getAllCommentsByPostId(postId) {
      axios
          .get("http://localhost:8080/comment/commentList/" + postId)
          .then(response => (this.comments[postId] = response.data))
          .catch(error => {
            this.errors.push(error);
          })
    }
  }
}
</script>

<style scoped>

</style>