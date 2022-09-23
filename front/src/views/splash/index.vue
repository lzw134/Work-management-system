<!--splash页面刷新-->
<template>
<div></div>   
</template>
<script>
export default {
  name:'splash',
  created(){
     this.init()
  },
  methods: {
     init(){
      const loading = this.$loading({
        lock: true,
        text: '请稍候'
      })
      if(this.$store.state.user.idcard){
        loading.close()
        this.$router.replace('/main')
      }else{
        console.log(this.$store.state.user.idcard)
        loading.close()
        this.$router.replace('/login')
        this.$message.warning('请获取身份验证!');
      }
     }
  }
}
</script>
