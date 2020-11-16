import { RouteConfig } from 'vue-router'
import Index from '../../views/student/Index.vue'

const routes: Array<RouteConfig> = [
    {
        path: '/',
        name: 'student',
        component: Index,
        meta: {
            title: 'Alunos',
            layout: 'mainTemplate'
        }
    }
]

export default routes
