<!--身份信息卡片-->
<template>
  <div>
    <el-dialog
      :title="dialog.type === 'add' ? '查看信息' : '修改信息'"
      :visible.sync="dialog.visible"
      width="50%"
      top="10vh"
      center
    >
       <el-form ref="form" label-width="300px">
       <el-form-item label="身份证:" prop="idcard">{{this.person.idcard}}</el-form-item>
       <el-form-item label="名称:" prop="name">
       <el-input
        v-model="person.username"
        placeholder="请输入姓名"
        style="width:220px;"
       ></el-input>
       </el-form-item>
       <el-form-item label="职称:" prop="title">
      <el-select  v-model="person.title" placeholder="请选择">
       <el-option
        v-for="item in options.title"
        :key="item.value"
        :label="item.label"
        :value="item.value">
       </el-option>
  </el-select>
       </el-form-item>
       <el-form-item label="学历:" prop="education">
       <el-select v-model="person.education" placeholder="请选择">
       <el-option
        v-for="item in options.education"
        :key="item.value"
        :label="item.label"
        :value="item.value">
       </el-option>
       </el-select>
       </el-form-item>
      <el-form-item label="生日:" prop="birthday">
       <el-date-picker
       v-model="person.birthday"
       type="month"
       placeholder="选择日期">
       </el-date-picker>
      </el-form-item>
       </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialog.visible = false">取 消</el-button>
        <el-button type="primary" @click="handleupdate()">修 改</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import {personSelect,personUpdate} from '@/server/person-api.js'
export default {
  data () {
    return {
      person: {
       idcard:'',
       username:'',
       title:'',
       education:'',
       birthday:''
      },
      dialog: {
        visible: false,
        type: 'add'
      },
      options:{
        title:[
        {
          value: '教授',
          label: '教授'
        },
        {
          value: '副教授',
          label: '副教授'
        },
        {
          value: '助理教授',
          label: '助理教授'
        },
        {
          value: '讲师',
          label: '讲师'
        },
        {
          value: '助教',
          label: '助教'
        },
        {
          value: '高级教师',
          label: '高级教师'
        },
        {
          value: '中级教师',
          label: '中级教师'
        },
        {
          value: '初级教师',
          label: '初级教师'
        },
        {
          value: '其他',
          label: '其他'
        },
       ],
       education:[
        {
          value: '博士',
          label: '博士'
        }, 
        {
          value: '硕士',
          label: '硕士'
        },
        {
          value: '学士',
          label: '学士'
        },
        {
          value: '学士以下',
          label: '学士以下'
        },
       ]
      }
    };
  },

  components: {},

  computed:{
  },

  methods: {
    init(){
       personSelect(this.$store.state.user.idcard).then(res=>{
       if(res.data && res.data.length!==0){
       this.$set(this.person,'idcard',this.$store.state.user.idcard)
       this.$set(this.person,'username',res.data[0].username)
       this.$set(this.person,'title',res.data[0].title)
       this.$set(this.person,'education',res.data[0].education)
       this.$set(this.person,'birthday',res.data[0].birthday)
       this.dialog.visible = true
       }else{
       this.$message.warning('未查到人员信息!')
       }
       })
    },
    handleupdate(){
       const query = {
          idcard:this.$store.state.user.idcard,
          username:this.person.username,
          title:this.person.title,
          education:this.person.education,
          birthday:this.person.birthday
       }
       personUpdate(query).then(res=>{
         if(res.data===1){
           this.$message.success('更新成功!')
           this.$store.commit('user/SET_USERNAME', this.person.username)
           this.init()
         }else{
           this.$message.error('更新失败!')
         }
       })
    }
  }
}

</script>
<style lang='scss' scoped>
</style>