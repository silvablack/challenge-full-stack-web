<template>
  <v-card
    elevation="2"
    class="pa-3">
    <v-data-table
      v-if="load"
      :headers="headers"
      :items="items"
      :items-per-page="5"
      no-data-text="Nenhum aluno encontrado"
      class="elevation-1" />
    <v-skeleton-loader
      v-else
      class="pt-2"
      type="table" />
  </v-card>
</template>
<script>
import Vue from 'vue'
export default Vue.extend({
    name: 'BaseDataTable',
    props: {
        headers: {
            type: Array,
            default: () => []
        },
        items: {
            type: Array,
            default: () => []
        },
        loaded: {
            type: Boolean,
            default: false
        }
    },
    data () {
        return {
            load: false
        }
    },
    watch: {
        loaded: {
            immediate: true,
            handler (loaded) {
                this.load = loaded
            }
        }
    }
})
</script>
<style scoped>
    .label {
        font-size: 18px;
        color: #333333;
    }
    .link{
        color: #121826;
        font-size: 12px;
    }
</style>