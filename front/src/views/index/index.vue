<!--主页面-->
<template>
  <div class="box">
    <NavBar/>
    <div class="main-container">
      <div class="flex-wrap">
        <div class="m-r-10">
           <Menu @transmit="getData"/>
        </div>
        <div class="flex-1 content-container">
          <transition name="fade-transform" mode="out-in">
             <Table ref="table"/>
          </transition>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
    };
  },
  components: {
     Menu: () => import('@/components/menu/index.vue'),
     NavBar: () => import('@/components/navbar/index.vue'),
     Table: () => import('@/components/table/index.vue')
  },
  updated(){
    this.$refs.table.init({query:{prop:'all',label:''}})
  },
  methods: {
    getData(data){
      this.$refs.table.init({query:data})
    }
  }
}

</script>
<style lang='scss' scoped>
.main-container {
padding: 10px;
}

.content-container{
width: calc(100vw - 200px);
}

.p-b-10 {
padding-bottom: 10px;
}

.menu-wrap {
max-width: 200px;
}

.m-r-10 {
margin-right: 10px;
}
</style>