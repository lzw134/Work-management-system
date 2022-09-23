<!--登录页面-->
<template>
  <div>
    <div style="display: flex; justify-content: center; margin-top: 150px">
      <el-card style="width: 600px">
        <div style="text-align:center;font-size:20px;" slot="header" class="clearfix">
          <span>用户登录</span>
        </div>
        <el-form
          :model="ruleForm"
          status-icon
          :rules="rules"
          ref="ruleForm"
          label-width="100px"
          class="demo-ruleForm"
        >
          <el-form-item label="手机号码" prop="number">
            <el-input
              type="text"
              v-model="ruleForm.number"
              autocomplete="off"
            ></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="pass">
            <el-input
              type="password"
              v-model="ruleForm.pass"
              autocomplete="off"
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')"
              >提交</el-button
            >
            <el-button @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>
        </el-form>
        <span class="f-r">
          <router-link to="/register">注册</router-link>&nbsp;
          <router-link to="/forget">忘记密码</router-link>
        </span>
      </el-card>
    </div>
  </div>
</template>

<script>
import {login} from '@/server/login-api.js'
import {personSelect} from '@/server/person-api.js'
export default {
  data() {
    var validateNumber = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入账号"));
      } else {
        var re = /^1\d{10}$/;
        if (re.test(value)) {
          callback();
        } else {
          callback(new Error("请输入正确手机号码"));
        }
      }
    };
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        callback();
      }
    };
    return {
      ruleForm: {
        number: "",
        pass: ""
      },
      rules: {
        number: [{ validator: validateNumber, trigger: "blur" }],
        pass: [{ validator: validatePass, trigger: "blur" }]
      },
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          const query = {
             iphone:this.ruleForm.number,
             pass:this.ruleForm.pass
          }
          login(query).then(res=>{
             if(res.data && res.data instanceof Array){
               if(res.data[0]){
                 this.$message.success('登录成功!')
                 personSelect(res.data[0].idcards).then(res=>{
                  if(res.data && res.data.length!==0){
                    this.$store.commit('user/SET_USERNAME', res.data[0].username)
                  }
                 })
                 // this.$store.state.user.userName 
                 this.$store.commit('user/SET_IDCARD', res.data[0].idcards)
                 this.$router.replace('/main')
               }else{
                 this.$message.error('密码错误!');
               }
             }else{
                 this.$message.error('系统异常!')
             }
          })
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
};
</script>
<style lang='scss' scoped>
</style>