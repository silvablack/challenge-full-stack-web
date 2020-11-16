import { Action, getModule, Module, Mutation, VuexModule } from 'vuex-module-decorators'
import store from '@/store'
import { Student } from '@/types/student'
import { StudentService } from '@/domain/student/service'

const studentService = new StudentService({})

@Module({
    namespaced: true,
    name: 'studentStore',
    store,
    dynamic: true,
    stateFactory: true
})
class StudentStoreModule extends VuexModule {
    student: Student = {} as Student
    students: Student[] = []

    @Mutation
    SET_STUDENT(student: Student){
        this.student = student
    }
    @Mutation
    SET_STUDENTS(students: Student[]){
        this.students = students
    }

    @Action({ commit: 'SET_STUDENTS', rawError: true })
    async getStudents (): Promise<Student[] | undefined> {
        try{
            return await studentService.all()
        }catch (error) {
            return undefined
        }
    }
}

export default getModule(StudentStoreModule)
