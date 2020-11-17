import { shallowMount } from '@vue/test-utils'
import BaseDataTable from '@/components/commom/BaseDataTable.vue'
import Vue from 'vue'
import Vuetify from 'vuetify'

Vue.use(Vuetify)

describe('BaseDataTable.vue', () => {
  it('should test be a build items and headers', () => {
    const items = [
        {
          name: 'Frozen Yogurt',
          calories: 159,
          fat: 6.0,
          carbs: 24,
          protein: 4.0,
          iron: '1%',
        }
     ]
    const headers = [
      {
        text: 'Dessert (100g serving)',
        value: 'name',
      },
      { text: 'Calories', value: 'calories' },
      { text: 'Fat (g)', value: 'fat' },
      { text: 'Carbs (g)', value: 'carbs' },
      { text: 'Protein (g)', value: 'protein' },
      { text: 'Iron (%)', value: 'iron' },
    ]
    const wrapper = shallowMount(BaseDataTable, {
      propsData: { items, headers }
    })
    expect(wrapper.classes()).toContain('BaseDataTable')
  })
})
