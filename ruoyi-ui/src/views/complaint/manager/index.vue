<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="是否处理" prop="handlingStatus">
        <el-select v-model="queryParams.handlingStatus" placeholder="请选择是否处理" clearable>
          <el-option
            v-for="dict in dict.type.complaint_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="投诉人姓名" prop="username">
        <el-input
          v-model="queryParams.username"
          placeholder="请输入投诉人姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="投诉人电话" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入投诉人电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['complaint:manager:add']"
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
          v-hasPermi="['complaint:manager:edit']"
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
          v-hasPermi="['complaint:manager:remove']"
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
          v-hasPermi="['complaint:manager:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="managerList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="序号" align="center" prop="complaintId"/>
      <el-table-column label="投诉内容" align="center" prop="complaintContent"/>
      <el-table-column label="是否处理" align="center" prop="handlingStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.complaint_status" :value="scope.row.handlingStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="处理结果" align="center" prop="handlingMsg"/>
      <el-table-column label="主体类型" align="center" prop="entityType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.person_department" :value="scope.row.entityType"/>
        </template>
      </el-table-column>
      <el-table-column label="投诉主体" align="center" prop="entityId"/>
      <el-table-column label="投诉人姓名" align="center" prop="username"/>
      <el-table-column label="投诉人电话" align="center" prop="phone"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['complaint:manager:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['complaint:manager:remove']"
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

    <!-- 添加或修改游客投诉管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="投诉内容">
          <editor v-model="form.complaintContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="主体类型" prop="entityType">
          <el-select v-model="form.entityType" placeholder="请选择主体类型" @change="handleChange">
            <el-option
              v-for="dict in dict.type.person_department"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="投诉主体" prop="entityId">
          <!--          <el-input v-model="form.entityId" placeholder="请输入投诉主体"/>-->
          <el-select v-model="form.entityId" placeholder="请选择投诉主体">
            <el-option
              v-for="option in selectOptions"
              :key="option.id"
              :label="option.name"
              :value="parseInt(option.id)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="投诉人姓名" prop="username">
          <el-input v-model="form.username" placeholder="请输入投诉人姓名"/>
        </el-form-item>
        <el-form-item label="投诉人电话" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入投诉人电话"/>
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
import {listManager, getManager, delManager, addManager, updateManager} from "@/api/complaint/manager";
import {getInstitution} from "@/api/person/manager";

export default {
  name: "Manager",
  dicts: ['complaint_status', 'person_department'],
  data() {
    return {
      types: [[],[],[]],
      // 待投诉的主体
      selectOptions: [],
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
      // 游客投诉管理表格数据
      managerList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        complaintContent: null,
        handlingStatus: null,
        handlingMsg: null,
        entityType: null,
        entityId: null,
        username: null,
        phone: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {}
    };
  },
  created() {
    this.getList();
    getInstitution(0).then(resp => {
      this.types[0] = []
      resp.data.forEach(item => {
        this.types[0].push(item)
      })
    })
    getInstitution(1).then(resp => {
      this.types[1] = []
      resp.data.forEach(item => {
        this.types[1].push(item)
      })
    })
    getInstitution(2).then(resp => {
      this.types[2] = []
      resp.data.forEach(item => {
        this.types[2].push(item)
      })
    })
  },
  methods: {
    handleChange(value) {
      getInstitution(value).then(resp => {
        this.selectOptions = resp.data
        console.log("options", this.selectOptions)
      })
    },
    /** 查询游客投诉管理列表 */
    getList() {
      this.loading = true;
      listManager(this.queryParams).then(response => {
        response.rows.forEach(item => {
          // item.entityId = this.getInstitutionWithParam(item.entityType, item.entityId)
          getInstitution(item.entityType).then(resp => {
            for (let ele of resp.data) {
              if (ele.id == item.entityId) {
                item.entityId = ele.name
              }
            }
          })
        })
        console.log(response.rows)
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
        complaintId: null,
        complaintContent: null,
        handlingStatus: null,
        handlingMsg: null,
        entityType: null,
        entityId: null,
        username: null,
        phone: null
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
      this.ids = selection.map(item => item.complaintId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加游客投诉管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const complaintId = row.complaintId || this.ids
      getManager(complaintId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改游客投诉管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.complaintId != null) {
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
      const complaintIds = row.complaintId || this.ids;
      this.$modal.confirm('是否确认删除游客投诉管理编号为"' + complaintIds + '"的数据项？').then(function () {
        return delManager(complaintIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('complaint/manager/export', {
        ...this.queryParams
      }, `manager_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
