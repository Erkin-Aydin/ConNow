<template>
  <nav>
      <v-toolbar dense elevation="6px" style="background-color: grey">

        <v-toolbar-title class="grey--text">
          <span class="font-weight-light">Con</span>
          <span class="font-weight-black">Now!</span>
        </v-toolbar-title>

        <v-toolbar-items>
          <div>
            <v-btn icon>
              <v-icon @mouseenter.native="hover = true" @mouseleave.native="hover = false;">mdi-post</v-icon>
              <p v-if="hover">My Posts</p>
            </v-btn>
          </div>
          <v-breadcrumbs divider="|"></v-breadcrumbs>
          <div>
            <v-btn icon>
              <v-icon>mdi-comment</v-icon>
            </v-btn>
          </div>
          <v-breadcrumbs divider="|"></v-breadcrumbs>
          <div>
            <v-btn icon>
              <v-icon>mdi-heart</v-icon>
            </v-btn>
          </div>
          <v-breadcrumbs divider="|"></v-breadcrumbs>
          <div>
            <v-btn icon>
              <v-icon>mdi-contacts</v-icon>
            </v-btn>
          </div>
          <v-breadcrumbs divider="|"></v-breadcrumbs>
          <div>
            <v-btn icon>
              <v-icon>mdi-dots-vertical</v-icon>
            </v-btn>
          </div>
          <v-app-bar-nav-icon></v-app-bar-nav-icon>
        </v-toolbar-items>
        <v-spacer></v-spacer>
        <v-btn flat color="grey">
          <span>Sign Out</span>
          <v-icon right>mdi-exit-to-app</v-icon>
        </v-btn>
      </v-toolbar>
  </nav>
</template>

<script>
export default {
  name: "NavBar",
  data() {
    return {
      hover: false,
    };
  }
}
</script>

<style scoped>

</style>