<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系方式" prop="contactInfo">
        <el-input
          v-model="queryParams.contactInfo"
          placeholder="请输入联系方式"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="机构类型" prop="menuId">
        <el-input
          v-model="queryParams.menuId"
          placeholder="请输入机构类型"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="人员类型" prop="personType">
        <el-select v-model="queryParams.personType" placeholder="请选择人员类型" clearable>
          <el-option
            v-for="dict in dict.type.person_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
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
          v-hasPermi="['person:manager:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['person:manager:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['person:manager:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['person:manager:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="managerList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="编号" align="center" prop="personId"/>
      <el-table-column label="姓名" align="center" prop="name"/>
      <el-table-column label="联系方式" align="center" prop="contactInfo"/>
      <el-table-column label="机构类型" align="center" prop="menuId">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.person_department" :value="scope.row.menuId"/>
        </template>
      </el-table-column>
      <el-table-column label="所属机构" align="center" prop="relatedId"/>
      <el-table-column label="类型" align="center" prop="personType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.person_type" :value="scope.row.personType"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['person:manager:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['person:manager:remove']"
          >删除
          </el-button>
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

    <!-- 添加或修改人员管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名"/>
        </el-form-item>
        <el-form-item label="联系方式" prop="contactInfo">
          <el-input v-model="form.contactInfo" placeholder="请输入联系方式"/>
        </el-form-item>
        <el-form-item label="机构类型" prop="menuId">
          <el-select v-model="form.menuId" placeholder="请选择机构类型" @change="changeDepart">
            <el-option
              v-for="dict in dict.type.person_department"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="类型" prop="personType">
          <el-select v-model="form.personType" placeholder="请选择类型">
            <el-option
              v-for="dict in dict.type.person_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="所属机构" prop="relatedId">
          <el-select v-model="form.relatedId" placeholder="请选择机构">
            <el-option
              v-for="pair in pendingInstitutions"
              :key="pair.id"
              :label="pair.name"
              :value="pair.id"
            ></el-option>
          </el-select>
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
import {listManager, getManager, delManager, addManager, updateManager, getInstitution} from "@/api/person/manager";

export default {
  name: "Manager",
  dicts: ['person_type', 'person_department'],
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
      // 人员管理表格数据
      managerList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        contactInfo: null,
        menuId: null,
        relatedId: null,
        personType: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {},
      pendingInstitutions: []
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /**
     * 改变机构类型，查询出所有的对应的机构
     */
    changeDepart(value) {
      getInstitution(value).then(resp => {
        this.pendingInstitutions = resp.data
        console.log(this.pendingInstitutions)
      })
    },
    /** 查询人员管理列表 */
    getList() {
      this.loading = true;
      listManager(this.queryParams).then(response => {
        this.managerList = response.rows;
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
        personId: null,
        name: null,
        contactInfo: null,
        menuId: null,
        relatedId: null,
        personType: null,
        createTime: null,
        createUser: null,
        modifyTime: null,
        modifyUser: null,
        deleted: null
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
      this.ids = selection.map(item => item.personId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加人员管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const personId = row.personId || this.ids
      getManager(personId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改人员管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.personId != null) {
            updateManager(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addManager(this.form).then(response => {
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
      const personIds = row.personId || this.ids;
      this.$modal.confirm('是否确认删除人员管理编号为"' + personIds + '"的数据项？').then(function () {
        return delManager(personIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('person/manager/export', {
        ...this.queryParams
      }, `manager_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
