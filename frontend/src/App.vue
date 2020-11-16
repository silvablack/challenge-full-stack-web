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
import { Vue, Component, Watch } from 'vue-property-decorator'
import MainTemplate from '@/components/template/layout/MainTemplate.vue'

@Component({
  components: {
    'main': MainTemplate
  }
})
export default class App extends Vue {
    get layout () {
        return this.$route.meta.layout
    }
  
    @Watch('$route.meta.title')
    observerRoute (title: string) {
      document.title = title
    }
}
</script>
