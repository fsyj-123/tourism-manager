<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="关联的旅行社信息表的旅行社" prop="agencyId">
        <el-input
          v-model="queryParams.agencyId"
          placeholder="请输入关联的旅行社信息表的旅行社"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="团队名称" prop="teamName">
        <el-input
          v-model="queryParams.teamName"
          placeholder="请输入团队名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="目的地" prop="destination">
        <el-input
          v-model="queryParams.destination"
          placeholder="请输入目的地"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="行程开始日期" prop="tripStartTime">
        <el-date-picker clearable
          v-model="queryParams.tripStartTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择行程开始日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="行程结束日期" prop="tripEndTime">
        <el-date-picker clearable
          v-model="queryParams.tripEndTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择行程结束日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="关联的导游" prop="tourGuideId">
        <el-input
          v-model="queryParams.tourGuideId"
          placeholder="请输入关联的导游"
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
          v-hasPermi="['itinerary:manager:add']"
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
          v-hasPermi="['itinerary:manager:edit']"
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
          v-hasPermi="['itinerary:manager:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['itinerary:manager:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="managerList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="itineraryId" />
      <el-table-column label="关联的旅行社信息表的旅行社" align="center" prop="agencyId" />
      <el-table-column label="团队名称" align="center" prop="teamName" />
      <el-table-column label="目的地" align="center" prop="destination" />
      <el-table-column label="行程开始日期" align="center" prop="tripStartTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.tripStartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="行程结束日期" align="center" prop="tripEndTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.tripEndTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="电子行程单的详细内容" align="center" prop="comment" />
      <el-table-column label="关联的导游" align="center" prop="tourGuideId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['itinerary:manager:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['itinerary:manager:remove']"
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

    <!-- 添加或修改行程单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="关联的旅行社信息表的旅行社" prop="agencyId">
          <el-input v-model="form.agencyId" placeholder="请输入关联的旅行社信息表的旅行社" />
        </el-form-item>
        <el-form-item label="团队名称" prop="teamName">
          <el-input v-model="form.teamName" placeholder="请输入团队名称" />
        </el-form-item>
        <el-form-item label="目的地" prop="destination">
          <el-input v-model="form.destination" placeholder="请输入目的地" />
        </el-form-item>
        <el-form-item label="行程开始日期" prop="tripStartTime">
          <el-date-picker clearable
            v-model="form.tripStartTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择行程开始日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="行程结束日期" prop="tripEndTime">
          <el-date-picker clearable
            v-model="form.tripEndTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择行程结束日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="电子行程单的详细内容" prop="comment">
          <el-input v-model="form.comment" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="关联的导游" prop="tourGuideId">
          <el-input v-model="form.tourGuideId" placeholder="请输入关联的导游" />
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
import { listManager, getManager, delManager, addManager, updateManager } from "@/api/itinerary/manager";

export default {
  name: "Manager",
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
      // 行程单表格数据
      managerList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        agencyId: null,
        teamName: null,
        destination: null,
        tripStartTime: null,
        tripEndTime: null,
        comment: null,
        tourGuideId: null
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
    /** 查询行程单列表 */
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
        itineraryId: null,
        agencyId: null,
        teamName: null,
        destination: null,
        tripStartTime: null,
        tripEndTime: null,
        comment: null,
        tourGuideId: null
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
      this.ids = selection.map(item => item.itineraryId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加行程单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const itineraryId = row.itineraryId || this.ids
      getManager(itineraryId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改行程单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.itineraryId != null) {
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
      const itineraryIds = row.itineraryId || this.ids;
      this.$modal.confirm('是否确认删除行程单编号为"' + itineraryIds + '"的数据项？').then(function() {
        return delManager(itineraryIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('itinerary/manager/export', {
        ...this.queryParams
      }, `manager_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
