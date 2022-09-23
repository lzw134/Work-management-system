import Vue from 'vue'
import Vuex from 'vuex'
import user from './user'
//挂载VUEX
Vue.use(Vuex)
const store =  new Vuex.Store({
state:{
},
mutations:{
},
actions:{
},
modules:{ 
user 
}
})
export default store