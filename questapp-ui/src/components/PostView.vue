<template>
  <div id="axios-get" style="background-color: azure">
    <ul>
      <li v-for="post in posts" :key="post.id" style="background-color: antiquewhite">
        <v-card>
          <v-card-title>{{ post.title }}</v-card-title>
          <v-card-subtitle><strong>{{ post.userResponse.userName }}</strong></v-card-subtitle>
          <v-card-text>{{ post.text }}</v-card-text>
          <v-card-actions>
            <div width="200">
              <v-btn x-small class="like" ><v-icon>mdi-chevron-up</v-icon></v-btn>
              <v-btn x-small class="like" ><v-icon>mdi-chevron-down</v-icon></v-btn>
            </div>
            <v-expansion-panels accordion focusable inset style="color: azure" >
              <v-expansion-panel>
                <v-expansion-panel-header style="width: 200px">
                <span><v-btn small class="display" color="primary"><v-icon>mdi-comment</v-icon></v-btn> Comments</span>
                </v-expansion-panel-header>
                <v-expansion-panel-content :style="{  'align-items' : left }">
                  <v-list v-for="(comment, index) in post.commentResponseList" :key="comment.text + index">
                    <v-list-item>
                          <span><v-list-item-title>{{ comment.userName }}</v-list-item-title></span>
                          <v-list-item-action-text style="margin-left: 20px">{{ comment.text }}</v-list-item-action-text>
                    </v-list-item>
                  </v-list>
                </v-expansion-panel-content>
              </v-expansion-panel>
            </v-expansion-panels>
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
      comments: [],
      display: false,
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
          .then(response => console.log(response))
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