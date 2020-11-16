<template>
  <v-main>
    <v-row>
      <v-col
        cols="12"
        class="ma-5">
        <h1>Alunos</h1>
        <list-student />
      </v-col>
    </v-row>
  </v-main>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator'
import ListStudent from '@/views/student/components/ListStudent.vue'
@Component({
  components: { ListStudent }
})
export default class Index extends Vue {

}
</script>