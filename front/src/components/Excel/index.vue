<template>
  <div>
     <el-input placeholder="请输入 名称/种类 查询" v-model="input" class="input-with-select search" size="small">
     <el-button slot="append" icon="el-icon-search" @click="search"></el-button>
     </el-input>
     <el-button type="success" size="small" icon="el-icon-check" @click="add">添加</el-button>
     <el-button type="primary" size="small"  @click="handleDownLoad" :disabled="pending">导出excel</el-button>
     <el-progress :percentage="csvProcess" :format="format" v-if="lineShow"></el-progress>
  </div>
</template>

<script>
import { exportCsv } from '@/components/Excel/index.js'
export default {
  props: {
    title: String,
    tableData: Array,
    tableHead: Array,
    total: Number
  },
  data () {
    return {
      pending: false,
      lineShow: false,
      csvProcess: 0,
      Data: [],
      input:"",
      loadingbuttext: '导出Excel'
    }
  },
  watch: {
    tableData (newValue) {
      if (newValue instanceof Array && newValue.length) {
        this.Data = JSON.parse(JSON.stringify(newValue))
      }
    }
  },
  computed: {},

  mounted () {
  },

  methods: {
    add(){
      this.$emit('insert')
    },
    search(){
      this.$emit('search',this.input)
    },
    format (percentage) {
      return percentage === 100 ? '完成' : `${percentage}%`
    },
    async handleDownLoad () {
      try {
        this.pending = true
        this.lineShow = true
        await exportCsv(this.Data, this.tableHead, this.total, this.title, 10000, (process) => {
          this.csvProcess = process
        })
      } catch (error) {
        alert(error)
      } finally {
        this.lineShow = false
        this.pending = false
      }
    }
  }
}

</script>
<style lang='scss' scoped>
.search{
  margin-right:10px;
  width:300px;
}
</style>
