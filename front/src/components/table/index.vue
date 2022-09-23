<template>
  <div>
    <DownLoad
      :tableData="tableData"
      :tableHead="excelHeaders"
      :total="total"
      :title="excelTitle"
      class="m-10"
      @insert="add"
      @search="search"
    />
    <el-table 
    :data="
    tableData.slice((currentPage - 1) * pagesize, currentPage * pagesize)
    "
    style="width:100%" 
    :height="MaxHeight"
    @row-dblclick="clickTr"
    v-loading="loading"
    >
      <el-table-column prop="id" align="center" width="100" label="序号"> </el-table-column>
      <el-table-column prop="child1" align="center" width="200" label="种类">
      </el-table-column>
      <el-table-column prop="child2" align="center" width="200" label="论文">
      </el-table-column>
      <el-table-column prop="child3" align="center" width="200" label="学科">
      </el-table-column>
      <el-table-column prop="child4" align="center" width="200" label="作者">
      </el-table-column>
      <el-table-column prop="child5" align="center" width="200" label="时间">
      </el-table-column>
      <el-table-column align="center" label="操作">
        <template slot-scope="scope">
          <el-button
            type="primary"
            icon="el-icon-edit"
            @click="update(scope.row)"
            size="small"
            >修改</el-button
          >
          <el-button
            type="danger"
            icon="el-icon-delete"
            @click="deletes(scope.row.id)"
            size="small"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        class="text-right"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[5, 10, 20]"
        :page-size="pagesize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      >
    </el-pagination>
    <about-dialog ref="aboutDialog"/>
    <item-dialog ref="itemDialog"/>
  </div>
</template>

<script>
import { getMessage, getMessagebycode, deleteMessage } from "@/server/api.js";
export default {
  components: {
    DownLoad: () => import("@/components/Excel/index.vue"),
    aboutDialog: () => import("./components/aboutDialog.vue"),
    itemDialog: () => import("./components/itemDialog.vue")
  },
  data() {
    return {
      tableData: [],
      excelHeaders: ["序号", "种类", "论文", "学科", "作者", "时间"],
      total: 0,
      currentPage: 1,
      pagesize: 5,
      excelTitle: "导出csv",
      loading: false
    };
  },
  computed: {
    MaxHeight() {
    var height = document.documentElement.clientHeight - 150;
    return height +'px';
    }
  },
  methods: {
    init({query = {prop:'all',label:''}} = {}) {
      this.loading = true
      getMessage(query).then((res) => {
        if (res.status === 200) {
          this.tableData = res.data;
          this.total = res.data.length;
          /* 默认设置成从第一页开始显示 */
          this.currentPage = 1
        } else {
          this.$message.wraning("请求参数失败!");
        }
      }).finally(
          setTimeout(()=>{this.loading = false},1000)
      );
    },
    clickTr(row){
     this.$refs.itemDialog.init({id:row.id})
    },
    add(){
     this.$refs.aboutDialog.init({title:'add'})
    },
    search(title){
     this.loading = true
      getMessagebycode(title).then((res) => {
        if (res.status === 200) {
          this.tableData = res.data;
          this.total = res.data.length;
          /* 默认设置成从第一页开始显示 */
          this.currentPage = 1
        } else {
          this.$message.wraning("请求参数失败!");
        }
      }).finally(
          setTimeout(()=>{this.loading = false},1000)
      );
    },
    update(row) {
     this.$refs.aboutDialog.init({title:'update',row:row})
    },
    deletes(id) {
      var obj = { id: id };
      deleteMessage(obj).then((res) => {
        if (res.data === 1) {
          this.$message.success("删除成功!");
          this.init();
        } else if (res.data === 0) {
          this.$message.wraning("当前列不存在!");
        } else {
          this.$message.error("程序删除异常!");
        }
      });
    },
    handleSizeChange (val) {
      this.pagesize = val
    },
    handleCurrentChange (val) {
      this.currentPage = val
    }
  },
};
</script>
