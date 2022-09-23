import api from '@/server/index'

/*添加api*/ 
export function add(data){
    return api.get('/about-insert',{
        params: {
            id: data.id,
            about: data.about
        }
    })
}

/*查询api*/ 
export function select(id){
    return api.get('/about-select',{
        params: {id: id}
    })
}

/*更新api*/ 
export function update(data){
    return api.get('/about-update',{
        params: {
            id: data.id,
            about: data.about
        }
    })
}