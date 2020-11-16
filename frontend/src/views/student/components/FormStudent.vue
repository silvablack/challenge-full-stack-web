<template>
  <v-row>
    <v-col cols="12">
      <base-dialog-form
        :label="labelFormAction"
        @returnObject="getStudent" />
    </v-col>
  </v-row>
</template>

<script lang="ts">
import { Vue, Component, Prop, Watch } from 'vue-property-decorator'
import BaseDialogForm from '@/components/common/BaseDialogForm.vue'
import { Student } from '@/types/student'
import studentStore from '@/store/modules/student'
import { StateForm } from '@/domain/student/enums'

@Component({
    components: { BaseDialogForm }
})
export default class FormStudent extends Vue {
  @Prop({ default: StateForm.REGISTER }) readonly state: number
  @Prop({ default: false }) readonly dialog: boolean
  
  private student: Student = {} as Student
  
  private open = false

  get labelFormAction() {
    if(this.state === StateForm.REGISTER) {
      return 'Cadastrar'
    } else {
      return 'Atualizar'
    }
  }
  
  @Watch('dialog', { immediate: true })
  observeDialog (dialog: boolean) {
    this.open = dialog
  }
  

  getStudent (student: Student) {
    this.student = student
    if(this.state === StateForm.REGISTER) {
      this.register(student)
    } else if (this.state === StateForm.UPDATE) {
      this.update(student)
    }
  }

  async register (student: Student) {
    await studentStore.createStudent(student)
  }

  async update (student: Student) {
    await studentStore.updateStudent(student)
  }
}
</script>