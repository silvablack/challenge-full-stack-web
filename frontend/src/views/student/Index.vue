<template>
  <v-main>
    <v-row>
      <v-col
        cols="12"
        class="ma-5">
        <h1>Alunos</h1>
        <form-student :state="getFormState" />
        <list-student
          @deleteStudent="deleteStudent"
          @updateStudent="openFormStateUpdateStudent" />
      </v-col>
    </v-row>
  </v-main>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator'
import ListStudent from '@/views/student/components/ListStudent.vue'
import FormStudent from '@/views/student/components/FormStudent.vue'
import { StateForm } from '@/domain/student/enums'
import { Student } from '@/types/student'
import studentStore from '@/store/modules/student'

@Component({
  components: { ListStudent, FormStudent }
})
export default class Index extends Vue {
  
  private stateForm = StateForm.REGISTER
  
  get getFormState () {
    return this.stateForm
  }

  async deleteStudent (student: Student) {
    await studentStore.deleteStudent(student)
  }

  openFormStateUpdateStudent () {
    this.stateForm = StateForm.UPDATE
  }
}
</script>