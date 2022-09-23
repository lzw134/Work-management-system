import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)
const routes = [
  {
  path: '/',
  name: 'splash',
  component:()=>import('../views/splash/index.vue'),
  meta:{
  title:'加载中'
  }
  },
  {
  path: '/login',
  name: 'login',
  component:()=>import('../views/login/index.vue'),
	meta:{
	title:'登录'
	}
  },
  {
  path: '/forget',
  name: 'forget',
  component:()=>import('../views/forget/index.vue'),
  meta:{
  title:'修改密码'
  }
  },
  {
  path: '/register',
  name: 'register',
  component:()=>import('../views/register/index.vue'),
  meta:{
  title:'注册'
  } 
  },
  {
  path: '/main',
  name: 'main',
  component:()=>import('../views/index/index.vue'),
  meta:{
  title:'主页面'
  }   
  }
]
const router = new VueRouter({
    routes
  })

/*路由前置守卫*/
router.beforeEach((to,from,next)=>{
    /*修改头部标题信息*/
    if(to.meta.title){
      document.title = to.meta.title   
    }else{
      document.title = ''
    }
    next();  
})
export default router
