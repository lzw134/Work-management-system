import axios from 'axios'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
let instance =  axios.create({
	baseURL:'/api',
	timeout:3000
})
const HTTP={
	get:async function(url,config={}){		
		var response = {}
        try{
			response = await instance.get(url,config)
		}catch(err){
			response = err
		}
        return response
	},
	post:async function(url,config={}){
		var  response = {}	
		try{
			response = await instance.post(url,config)
		}catch(err){
			response = err
		}
        return response
	},
}
/*请求拦截器*/
instance.interceptors.request.use(config => {
    NProgress.start()
	return config
}, err => {
	return Promise.reject(err)
})
/*响应拦截器*/
instance.interceptors.response.use(config => {
    NProgress.done()
	return config
}, err => {
	return Promise.reject(err)
})


export default HTTP
