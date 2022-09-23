<!--忘记密码-->
<template>
  <div>
    <div style="display: flex; justify-content: center; margin-top: 150px">
      <el-card style="width: 600px">
        <div style="text-align:center;font-size:20px;" slot="header" class="clearfix">
          <span>修改密码</span>
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
          <el-form-item label="身份证" prop="idcard">
            <el-input v-model="ruleForm.idcard"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="pass">
            <el-input
              type="password"
              v-model="ruleForm.pass"
              autocomplete="off"
            ></el-input>
          </el-form-item>
          <el-form-item label="确认密码" prop="checkPass">
            <el-input
              type="password"
              v-model="ruleForm.checkPass"
              autocomplete="off"
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')"
              >修改</el-button
            >
            <el-button @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>
        </el-form>
      </el-card>
    </div>
  </div>
</template>

<script>
import {forget} from '@/server/login-api.js'
export default {
  data() {
    var checkIdcord = (rule, value, callback) => {
      if (!value) {
        return callback(new Error("身份证不能为空"));
      }else {
        var re = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        if (re.test(value)) {
          callback();
        } else {
          callback(new Error("请输入正确身份证号码"));
        }
      }
    };
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
        if (this.ruleForm.checkPass !== "") {
          this.$refs.ruleForm.validateField("checkPass");
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== this.ruleForm.pass) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };
    return {
      ruleForm: {
        number: "",
        pass: "",
        checkPass: "",
        idcard: "",
      },
      rules: {
        number: [{ validator: validateNumber, trigger: "blur" }],
        pass: [{ validator: validatePass, trigger: "blur" }],
        checkPass: [{ validator: validatePass2, trigger: "blur" }],
        idcard: [{ validator: checkIdcord, trigger: "blur" }],
      },
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          const query = {
             iphone:this.ruleForm.number,
             idcard:this.ruleForm.idcard,
             pass:this.ruleForm.pass
          }
          forget(query).then(res=>{
             if(res.data === 1){
               this.$message.success('修改密码成功!')
               this.$router.replace('/')
             }else{
               this.$message.error('修改失败!');
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