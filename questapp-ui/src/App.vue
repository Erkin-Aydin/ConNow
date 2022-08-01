<template>
  <v-app>
    <div style="background-color: peru; text-align: center">
      <router />
      <b-nav tabs>
        <b-nav-item>
          <router-link to="/">Home</router-link> |
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
      </b-nav>
    </div>
    <router-view />
  </v-app>
</template>

<script>
//import HelloWorld from './components/HelloWorld';
//import HomeView from "@/components/HomeView";
//import PostView from "@/components/PostView";

export default {
  name: 'App',

  components: {

  },

  data: () => ({
    //
  }),
};
</script>
