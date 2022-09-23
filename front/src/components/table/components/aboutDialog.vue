<template>
  <div>
    <el-dialog
      :title="title"
      :visible.sync="dialogVisible"
      width="80%"
      top="2vh"
    >
      <el-input
        v-model="input1"
        placeholder="请输入种类"
        class="m-10"
      ></el-input>
      <el-input
        v-model="input2"
        placeholder="请输入论文"
        class="m-10"
      ></el-input>
      <el-input
        v-model="input3"
        placeholder="请输入学科"
        class="m-10"
      ></el-input>
      <el-input
        v-model="input4"
        placeholder="请输入作者"
        class="m-10"
      ></el-input>
      <el-input
        v-model="input5"
        placeholder="请输入时间"
        class="m-10"
      ></el-input>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button v-if="hanllerule===1" type="primary" @click="handleadd()">添 加</el-button>
        <el-button v-if="hanllerule===2" type="primary" @click="handleupdate()">修 改</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import {updateMessage, insertMessage } from "@/server/api.js";
export default {
  data () {
    return {
    title:'',
    id: 0,
    input1: "",
    input2: "",
    input3: "",
    input4: "",
    input5: "",
    dialogVisible:false
    }
  },

  components: {},
  
  computed: {
    hanllerule() {
      var result = this.title==='add'? 1 : 2
      return result
    }
  },
  watch:{
    dialogVisible(newValue) {
      if (!newValue) {
        this.input1 = "";
        this.input2 = "";
        this.input3 = "";
        this.input4 = "";
        this.input5 = "";
        this.id = 0;
      }
    },

  },
  mounted(){},

  methods: {
    init({title:title,row:row}={}){
      this.title = title
      if(this.title==='update'){
      this.id = row.id
      this.input1 = row.child1
      this.input2 = row.child2
      this.input3 = row.child3
      this.input4 = row.child4
      this.input5 = row.child5
      }
      this.dialogVisible = true
    },
    handleupdate() {
      var obj = {
        id:this.id,
        child1:this.input1,
        child2:this.input2,
        child3:this.input3,
        child4:this.input4,
        child5:this.input5
      }
      updateMessage(obj).then((res) => {
        if (res.data === 1) {
          this.$message.success("修改成功!");
          this.dialogVisible = false
          this.init();
        } else if (res.data === 0) {
          this.$message.wraning("当前列不存在!");
        } else {
          this.$message.error("程序修改异常!");
        }
      });
    },
    handleadd(){
      var obj = {
        child1:this.input1,
        child2:this.input2,
        child3:this.input3,
        child4:this.input4,
        child5:this.input5
      }
      insertMessage(obj).then((res) => {
        if (res.data === 1) {
          this.$message.success("添加成功!");
          this.dialogVisible = false
          this.init();
        } else if (res.data === 0) {
          this.$message.wraning("已经存在!");
        } else {
          this.$message.error("程序添加异常!");
        }
      })  
    },
  }
}

</script>
<style lang='scss' scoped>
</style>