import {setStorage,getStorage,clearStorage} from '@/utils/auth'
const state = {
idcard: getStorage('idcard'),
username: getStorage('username')
}
const mutations = {
SET_IDCARD: (state, idcard) => {
state.idcard = idcard
setStorage('idcard', idcard)
},
SET_USERNAME: (state,username) => {
state.username = username
setStorage('username',username)
}
}
const actions = {
    logout ({commit}) {
        return new Promise((resolve) => {
          commit('SET_IDCARD', null)
          commit('SET_USERNAME',null)
          clearStorage()
          resolve()
        })
      }
}
export default {
namespaced: true,
state,
mutations,
actions
}