<!--  -->
<template>
  <div>
      <el-dialog
      title="查看内容"
      :visible.sync="dialogVisible"
      width="80%"
      top="5vh"
    >
    <div :style="{'height': maxHeight}">
          <iframe
            frameborder="0"
            :src="url"
            style="width: 100%; height: 100%"
          ></iframe>
    </div> 
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import {select} from '@/server/about-api.js'
export default {
  data () {
    return {
      id:0,
      url:'',
      dialogVisible:false
    }
  },
  computed:{
   maxHeight(){
     return 400 + 'px'
   }
  },
  methods: {
    init({id=id}={}){
       this.textarea = ''
       select(id).then(res=>{
         if(res.data[0]){
            this.id = res.data[0].id
            this.url = res.data[0].about
            this.dialogVisible = true
         }else{
            this.$message.warning('该论文未查询到内容!')
         }
       })
    }
  }
}

</script>
<style lang='scss' scoped>
</style>