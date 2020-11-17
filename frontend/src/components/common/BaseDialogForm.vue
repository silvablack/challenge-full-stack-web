<template>
  <v-dialog
    v-model="open"
    persistent
    max-width="600px">
    <template v-slot:activator="{ on, attrs }">
      <v-btn
        color="primary"
        dark
        data-cy="submit_register"
        v-bind="attrs"
        v-on="on">
        {{ label }}
      </v-btn>
    </template>
    <v-card>
      <v-card-title>
        <span class="headline">Aluno</span>
      </v-card-title>
      <v-card-text>
        <v-container>
          <v-row>
            <v-col
              cols="12"
              sm="6"
              md="4">
              <v-text-field
                v-model="student.name"
                label="Nome"
                required />
            </v-col>
            <v-col
              cols="12"
              sm="6"
              md="4">
              <v-text-field
                v-model="student.cpf"
                label="CPF"
                required />
            </v-col>
            <v-col
              cols="12"
              sm="6"
              md="4">
              <v-text-field
                v-model="student.email"
                label="Email"
                required />
            </v-col>
          </v-row>
        </v-container>
      </v-card-text>
      <v-card-actions>
        <v-spacer />
        <v-btn
          color="blue darken-1"
          text
          @click="open = false">
          Sair
        </v-btn>
        <v-btn
          color="blue darken-1"
          text
          @click="returnObject">
          {{ label }}
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>
<script lang="ts">
import { Vue, Component, Prop, Watch } from 'vue-property-decorator'
import { Student } from '@/types/student'
    
@Component
export default class BaseDialogForm extends Vue{
    @Prop({ default: false }) readonly dialog: boolean
    @Prop({ default: 'Cadastrar' }) readonly label: string
  
    private student: Student = {} as Student

    private open = false

    @Watch('dialog', { immediate: true })
    observerDialog (dialog: boolean) {
        this.open = dialog
    }

    returnObject() {
      this.open = false
      this.$emit('returnObject', this.student)
    }
}
</script>