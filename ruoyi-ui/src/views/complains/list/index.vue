<template>
  <div>
    <!-- 搜索栏 -->
    <el-form :inline="true">
      <el-form-item label="姓名">
        <el-input v-model="searchName" placeholder="请输入姓名"></el-input>
      </el-form-item>
      <el-form-item label="得分">
        <el-input v-model.number="searchScore" placeholder="请输入得分"></el-input>
      </el-form-item>
      <el-form-item label="类型">
        <el-select v-model="searchType" placeholder="请选择类型">
          <el-option label="旅行社" value="旅行社"></el-option>
          <el-option label="旅游景区" value="旅游景区"></el-option>
          <el-option label="星级酒店" value="星级酒店"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="handleSearch">搜索</el-button>
        <el-button @click="handleReset">重置搜索条件</el-button>
      </el-form-item>
    </el-form>

    <!-- 表格 -->
    <el-table :data="filteredData" style="width: 100%">
      <el-table-column label="姓名" prop="name"></el-table-column>
      <el-table-column label="类型" prop="type"></el-table-column>
      <el-table-column label="得分" prop="score"></el-table-column>
    </el-table>

    <!-- 分页组件 -->
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="pageSize"
      layout="sizes, prev, pager, next, jumper"
      :total="filteredData.length"
    />
  </div>
</template>

<script>
import {getInstitutionComplains} from "@/api/person/manager";

export default {
  data() {
    return {
      dataList: [], // 从后台接口获取的数据列表
      filteredData: [], // 经过搜索和过滤后的数据列表
      searchName: '', // 姓名搜索关键字
      searchScore: '', // 得分搜索关键字
      searchType: '', // 类型过滤关键字
      currentPage: 1, // 当前页码
      pageSize: 10, // 每页展示的条数
    };
  },
  mounted() {
    // 假设从后台接口获取的数据列表为dataList
    getInstitutionComplains().then(resp => {
      this.dataList = resp.data
      this.filteredData = resp.data
      console.log(this.dataList)
      this.handleCurrentChange(1);
    })

    // 初始化展示第一页数据
  },
  computed: {
    // 计算当前页的数据
    currentPageData() {
      const startIndex = (this.currentPage - 1) * this.pageSize;
      const endIndex = startIndex + this.pageSize;
      return this.filteredData.slice(startIndex, endIndex);
    },
  },
  methods: {
    // 处理搜索
    handleSearch() {
      this.filterData();
      this.currentPage = 1; // 搜索后回到第一页
    },

    handleReset() {
      this.searchName = '';
      this.searchScore = '';
      this.searchType = '';
      this.filteredData = this.dataList
    },

    // 处理过滤
    handleFilter() {
      this.filterData();
      this.currentPage = 1; // 过滤后回到第一页
    },

    // 处理分页
    handleSizeChange(newSize) {
      this.pageSize = newSize;
      this.handleCurrentChange(1); // 修改每页条数后回到第一页
    },
    handleCurrentChange(newPage) {
      this.currentPage = newPage;
    },

    // 过滤数据
    filterData() {
      this.filteredData = this.dataList.filter((item) => {
        const isNameMatch = item.name.toLowerCase().includes(this.searchName.toLowerCase());
        const isScoreMatch = this.searchScore === '' || item.score === this.searchScore;
        const isTypeMatch = this.searchType === '' || item.type === this.searchType;
        return isNameMatch && isScoreMatch && isTypeMatch;
      });
    },
  },
};
</script>

<style>
/* 样式可以根据实际情况进行调整 */
</style>
