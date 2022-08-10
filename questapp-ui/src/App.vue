<template>
  <v-app>
    <div style="background-color: peru; text-align: center">
      <router />
      <div>
        <b-nav-item>
          <router-link to="/account">Create Account</router-link> |
        </b-nav-item>
        <b-nav-item>
          <router-link to="/">Login</router-link> |
        </b-nav-item>
        <b-nav-item>
          <router-link to="/home">Home</router-link> |
        </b-nav-item>
        <b-nav-item>
          <router-link to="/comment">Comments</router-link> |
        </b-nav-item>
        <b-nav-item>
          <router-link to="/posts">Posts</router-link> |
        </b-nav-item>
        <b-nav-item>
          <router-link to="/users">Users</router-link>
        </b-nav-item>
      </div>
    </div>
    <router-view />
  </v-app>
</template>

<script>

export default {
  name: 'App',

  components: {

  },

  data: () => ({
    //
  }),
};
</script>
