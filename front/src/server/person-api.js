import api from '@/server/index'

/*查询api*/ 
export function personSelect(idcard){
    return api.get('/person-select',{
        params: {
            idcard: idcard
        }
    })
}

/*修改api*/
export function personUpdate(data){
    return api.get('/person-update',{
        params: {
            idcard: data.idcard,
            username: data.username,
            title:data.title,
            education:data.education,
            birthday:data.birthday
        }
    })
} 