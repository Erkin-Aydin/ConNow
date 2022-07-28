<template>

  <v-app>
    <div>
      <ul>
        <li><router-link to="/">Home</router-link></li>
        <li><router-link to="/comment">Comments</router-link></li>
        <li><router-link to="/posts">Posts</router-link></li>
        <li><router-link to="/users">Users</router-link></li>
        <router-view />
      </ul>
    </div>
    <!--
    <v-app-bar
      app
      color="primary"
      dark
    >
      <div class="d-flex align-center">
        <v-img
          alt="Vuetify Logo"
          class="shrink mr-2"
          contain
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png"
          transition="scale-transition"
          width="40"
        />

        <v-img
          alt="Vuetify Name"
          class="shrink mt-1 hidden-sm-and-down"
          contain
          min-width="100"
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-name-dark.png"
          width="100"
        />
      </div>

      <v-spacer></v-spacer>

      <v-btn
        href="https://github.com/vuetifyjs/vuetify/releases/latest"
        target="_blank"
        text
      >
        <span class="mr-2">Latest Release</span>
        <v-icon>mdi-open-in-new</v-icon>
      </v-btn>
    </v-app-bar>
    -->

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
