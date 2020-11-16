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
      class="elevation-1">
      <template v-slot:item.actions="{ item }">
        <v-icon
          small
          class="mr-2"
          @click="editItem(item)">
          mdi-pencil
        </v-icon>
        <v-icon
          small
          @click="deleteItem(item)">
          mdi-delete
        </v-icon>
      </template>
    </v-data-table>
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
    },
    methods: {
        editItem (item) {
            this.$emit('editItem', item)
        },
        deleteItem (item) {
            this.$emit('deleteItem', item)
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