<template>
  <base-data-table
    v-if="students"
    :loaded="loaded"
    :headers="headersStudents"
    :items="students"
    @deleteItem="deleteStudent" />
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator'
import BaseDataTable from '@/components/common/BaseDataTable.vue'
import studentStore from '@/store/modules/student'
import { Student } from '@/types/student'

@Component({
    components: {
        BaseDataTable
    }
})
export default class ListStudent extends Vue {

    private loaded = false

    async mounted() {
        await studentStore.getStudents()
        this.loaded = true
    }

    get students () {
        return studentStore.students
    }

    get headersStudents () {
        if(this.students.length > 0) {
            const headers: any = []
            const keys = Object.keys(studentStore.students[0])
            keys.forEach(key => {
                const objectHeader = {  text: key.toUpperCase(), value: key.toLowerCase() }
                headers.push(objectHeader)
            })
            headers.push({ text: 'Actions', value: 'actions', sortable: false })
            return headers
        }
        return []
    }

    deleteStudent (student: Student) {
      this.$emit('deleteStudent', student)
    }
}
</script>