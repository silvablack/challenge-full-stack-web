<template>
  <transition
    name="component-fade"
    mode="out-in">
    <component :is="layout">
      <router-view />
    </component>
  </transition>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator'
import MainTemplate from '@/components/template/layout/MainTemplate.vue'

@Component({
  components: {
    MainTemplate
  }
})
export default class App extends Vue {
    get layout () {
        document.title = this.$route.meta.title
        return this.$route.meta.layout
    }
}
</script>
