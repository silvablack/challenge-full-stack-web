import Vue from 'vue'
import VueRouter, { RouteConfig } from 'vue-router'
import RouterStudent from '@/domain/student/router'

Vue.use(VueRouter)

const routes: Array<RouteConfig> = [
    ...RouterStudent
]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router
