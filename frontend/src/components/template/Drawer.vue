<template>
  <v-navigation-drawer
    class="drawer"
    permanent
    color="#000000"
    app>
    <v-list-item>
      <v-list-item-content>
        <v-list-item-title class="title">
          <img
            alt="Grupo A Educação"
            height="40px"
            :src="logo">
        </v-list-item-title>
      </v-list-item-content>
    </v-list-item>

    <v-divider />

    <v-list
      dense
      nav>
      <v-list-item
        v-for="item in items"
        :key="item.title"
        link>
        <v-list-item-icon>
          <v-icon>{{ item.icon }}</v-icon>
        </v-list-item-icon>

        <v-list-item-content>
          <v-list-item-title>
            <router-link :to="{name: item.route}">
              {{ item.title }}
            </router-link>
          </v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
import Vue from 'vue'
export default Vue.extend({
    name: 'Drawer',
    props: {
        items: {
            type: Array,
            default: () => []
        }
    },
    data () {
        return {
            right: null,
            logo: require('@/assets/grupoa-logo.png')
        }
    }
})
</script>
<style>
  .theme--light .v-icon {
    color: #FFFFFF !important;
  }
</style>