<template>
  <v-row>
    <v-col cols="12">
      <base-dialog-form @returnObject="getStudent" />
    </v-col>
  </v-row>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator'
import BaseDialogForm from '@/components/common/BaseDialogForm.vue'
import { Student } from '@/types/student'
import studentStore from '@/store/modules/student'
import { StateForm } from '@/domain/student/enums'

@Component({
    components: { BaseDialogForm }
})
export default class FormStudent extends Vue {
  @Prop({ default: StateForm.REGISTER }) readonly state: number
  
  private student: Student = {} as Student

  getStudent (student: Student) {
    this.student = student
    if(this.state === StateForm.REGISTER) {
      this.register(student)
    }
  }

  async register (student: Student) {
    await studentStore.createStudent(student)
  }
}
</script>