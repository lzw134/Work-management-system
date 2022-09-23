import api from '@/server/index'

/*登录api*/ 
export function login(data){
    return api.get('/login',{
        params: {
            iphone: data.iphone,
            pass: data.pass
        }
    })
}

/*注册api*/ 
export function register(data){
    return api.get('/register',{
        params: {
          iphone: data.iphone,
          idcard: data.idcard,
          pass: data.pass
        }
    })
}

/*忘记密码api*/
export function forget(data){
    return api.get('/forget',{
      params: {
        iphone: data.iphone,
        idcard: data.idcard,
        pass: data.pass
      }
    })
}