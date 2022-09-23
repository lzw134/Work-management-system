import api from '@/server/index'

export function getMessage(query){
    return api.get('/select-servlet',{
        params:{
          type:query.prop,
          child:query.label
        }
    })
}

export function getMessagebycode(child){
    return api.get('/select-code-servlet',{
        params:{
          child:child
        }
    })
}

export function insertMessage(item){
    return api.get(`/insert-servlet?child1=${item.child1}&child2=${item.child2}&child3=${item.child3}&child4=${item.child4}&child5=${item.child5}`)
}

export function updateMessage(item){
    return api.get(`/update-servlet?id=${item.id}&child1=${item.child1}&child2=${item.child2}&child3=${item.child3}&child4=${item.child4}&child5=${item.child5}`)
}

export function deleteMessage(item){
    return api.get(`/delete-servlet?id=${item.id}`)
}
