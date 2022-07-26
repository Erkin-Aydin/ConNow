<template>
  <v-app>
    <NavBar />
    <ProfileBar />
    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>

import NavBar from "@/components/NavBar";
import ProfileBar from "@/components/ProfileBar";
export default {
  name: 'App',
  components: {NavBar, ProfileBar},
  data: () => ({
    //
  }),
};
</script>
