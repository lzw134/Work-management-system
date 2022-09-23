<template>
  <div>
  <div class="top-bar">
    <el-row type="flex" justify="space-between" align="middle">
      <el-col class="title">{{title}}</el-col>
      <el-col :span="10" class="text-right">
        <el-dropdown @command="handleDropdown">
          <div class="user">
            <span>{{ userName }}</span>
            <i class="el-icon-caret-bottom"></i>
          </div>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item divided command="detailed">详细信息</el-dropdown-item>
            <el-dropdown-item divided command="logout">退出</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-col>
    </el-row>
  </div>
  <idcard ref="idcard"/>
  </div>
</template>

<script>
export default {
  data () {
    return {
      title: process.env.VUE_APP_TITLE
    }
  },
  components:{
    idcard: () => import('@/components/IdCard/index.vue')
  },
  methods: {
    handleDropdown (command) {
      if (command === 'logout') {
        this.$store.dispatch('user/logout')
        this.$router.push('/login')
      }
      if(command === 'detailed'){
        /*弹出详细信息框*/ 
        this.$refs.idcard.init()
      }
    }
  },
   computed:{
     userName(){
         return this.$store.state.user.username
     }
  }
}
</script>

<style lang="scss" scoped>
/*可以引入外面的css样式*/ 
@import '@/style/variables';

.top-bar {
  padding: 10px 20px;
  background-color: $main-color;
  color: #ffffff;
  .title {
    font-size: 20px;
  }
  .user {
    color: #ffffff;
  }
}
@media (max-width: 960px) {
  .top-bar .title {
    font-size: 14px;
  }
}
</style>
