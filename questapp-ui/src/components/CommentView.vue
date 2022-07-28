<template>
  <div id="axios-get">
    <ul>
      <li v-for="comment in comments" :key="comment.id">{{ comment.text }}</li>
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
  name: "CommentView",
  created() {
    this.getAllComments();
  },
  data() {
    return {
      comments: [],
      errors: []
    }
  },
  methods: {
    getAllComments() {
      axios
          .get("http://localhost:8080/comment/list")
          .then(response => (this.comments = response.data))
          .catch(error => {
            this.errors.push(error);
          })
    }
  }
}
</script>

<style scoped>

</style>