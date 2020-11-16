import Vue from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import VueMoment from 'vue-moment'
import moment from 'moment'
import Vuelidate from 'vuelidate'

require('moment/locale/pt-br')

Vue.config.productionTip = false

Vue.use(VueMoment, {
  moment
})

Vue.use(Vuelidate)

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
