<template>
<nav>
  <v-toolbar><v-toolbar-title>ConNow!</v-toolbar-title>
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link> |
      <router-link to="/users">Users</router-link>
    </nav>
    <router-view/></v-toolbar>
</nav>
</template>

<script>
export default {
  name: "NavigationBar"
}
</script>

<style scoped>

</style>