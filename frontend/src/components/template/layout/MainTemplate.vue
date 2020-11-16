<template>
  <v-app>
    <template>
      <drawer
        v-model="drawer"
        :items="items" />
    </template>
    <template>
      <v-app-bar
        color="#757575"
        app
        clipped-left
        dense>
        <v-toolbar-title>
          <img
            height="40"
            src="">
        </v-toolbar-title>
        <v-spacer />
        <span class="white--text">Olá, <b>Usuário</b></span>
        <v-btn
          text
          color="#FFFFFF"
          style="padding:0 15px">
          Sair
        </v-btn>
      </v-app-bar>
      <Content
        class="fill-height"
        style="background-color: #F2F2F2" />
    </template>
  </v-app>
</template>

<script>
import Vue from 'vue'
import Drawer from '../Drawer.vue'
import Content from '../Content.vue'

export default Vue.extend({
    name: 'MainTemplate',
    components: { Content, Drawer },
    props: {
        source: {
            type: String,
            default: ''
        }
    },
    data: () => ({
        drawer: true,
        items: [
            { title: 'Alunos', icon: 'mdi-view-dashboard', route: 'student' }
        ]
    }),
    created () {
        this.$vuetify.theme.dark = false
        this.drawer = this.$vuetify.isMobile
    }
})
</script>
