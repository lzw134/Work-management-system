<!--目录-->
<template>
  <div class="box">
    <el-menu
      default-active="2"
      class="el-menu-vertical-demo"
      @select="handleSelect"
      @close="handleClose"
    >
      <el-submenu index="1">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>检索如下</span>
        </template>
        <el-submenu index="1-1">
          <template slot="title">论文类型</template>
          <el-menu-item index="0">期刊论文</el-menu-item>
          <el-menu-item index="1">会议论文集</el-menu-item>
          <el-menu-item index="2">报纸</el-menu-item>
          <el-menu-item index="3">学位论文</el-menu-item>
        </el-submenu>
        <el-submenu index="2-1">
          <template slot="title">论文领域</template>
          <el-menu-item index="4">计算机</el-menu-item>
          <el-menu-item index="5">教育</el-menu-item>
          <el-menu-item index="6">科学</el-menu-item>
        </el-submenu>
      </el-submenu>
    </el-menu>
  </div>
</template>
<script>
export default {
  data(){
    return{
       Array:[
         {prop:'child1',label:'期刊论文'},
         {prop:'child1',label:'会议论文集'},
         {prop:'child1',label:'报纸'},   
         {prop:'child1',label:'学位论文'},
         {prop:'child3',label:'计算机'},
         {prop:'child3',label:'教育'},
         {prop:'child3',label:'科学'}
       ]
    }
  },
  methods: {
    handleSelect(index) {
      const data = this.Array[index]
      this.$emit('transmit',data)
    },
    handleClose(index){
      console.log(index)
    }
  },
};
</script>
<style lang='scss' scoped>
.box{
width: 200px;
}
</style>