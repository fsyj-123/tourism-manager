<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="导游姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入导游姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电话号码" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入电话号码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份证号" prop="identityId">
        <el-input
          v-model="queryParams.identityId"
          placeholder="请输入身份证号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="旅行社ID" prop="agencyId">
        <el-input
          v-model="queryParams.agencyId"
          placeholder="请输入旅行社ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="导游证号" prop="licenseNumber">
        <el-input
          v-model="queryParams.licenseNumber"
          placeholder="请输入导游证号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="导游证截止日期" prop="licenseEndTime">
        <el-date-picker clearable
          v-model="queryParams.licenseEndTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择导游证截止日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="导游证开始日期" prop="licenseStartTime">
        <el-date-picker clearable
          v-model="queryParams.licenseStartTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择导游证开始日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['guide:info:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['guide:info:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['guide:info:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['guide:info:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="infoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="导游ID" align="center" prop="id" />
      <el-table-column label="导游姓名" align="center" prop="name" />
      <el-table-column label="电话号码" align="center" prop="phone" />
      <el-table-column label="身份证号" align="center" prop="identityId" />
      <el-table-column label="旅行社ID" align="center" prop="agencyId" />
      <el-table-column label="导游资质" align="center" prop="qualify" />
      <el-table-column label="导游证号" align="center" prop="licenseNumber" />
      <el-table-column label="导游证截止日期" align="center" prop="licenseEndTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.licenseEndTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="导游证开始日期" align="center" prop="licenseStartTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.licenseStartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['guide:info:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['guide:info:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改登记注册对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="导游姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入导游姓名" />
        </el-form-item>
        <el-form-item label="电话号码" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入电话号码" />
        </el-form-item>
        <el-form-item label="身份证号" prop="identityId">
          <el-input v-model="form.identityId" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="旅行社ID" prop="agencyId">
          <el-input v-model="form.agencyId" placeholder="请输入旅行社ID" />
        </el-form-item>
        <el-form-item label="导游资质" prop="qualify">
          <el-input v-model="form.qualify" placeholder="请输入导游资质" />
        </el-form-item>
        <el-form-item label="导游证号" prop="licenseNumber">
          <el-input v-model="form.licenseNumber" placeholder="请输入导游证号" />
        </el-form-item>
        <el-form-item label="导游证截止日期" prop="licenseEndTime">
          <el-date-picker clearable
            v-model="form.licenseEndTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择导游证截止日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="导游证开始日期" prop="licenseStartTime">
          <el-date-picker clearable
            v-model="form.licenseStartTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择导游证开始日期">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listInfo, getInfo, delInfo, addInfo, updateInfo } from "@/api/guide/info";

export default {
  name: "Info",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 登记注册表格数据
      infoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        phone: null,
        identityId: null,
        agencyId: null,
        licenseNumber: null,
        licenseEndTime: null,
        licenseStartTime: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询登记注册列表 */
    getList() {
      this.loading = true;
      listInfo(this.queryParams).then(response => {
        this.infoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        name: null,
        phone: null,
        identityId: null,
        agencyId: null,
        qualify: null,
        licenseNumber: null,
        licenseEndTime: null,
        licenseStartTime: null,
        createTime: null,
        createUser: null,
        modifyTime: null,
        modifyUser: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加登记注册";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改登记注册";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateInfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addInfo(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除登记注册编号为"' + ids + '"的数据项？').then(function() {
        return delInfo(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('guide/info/export', {
        ...this.queryParams
      }, `info_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
