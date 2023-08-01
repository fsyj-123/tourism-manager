<template>
  <div>
    <el-table :data="showList" style="width: 100%">
      <el-table-column label="团队名" prop="teamName"></el-table-column>
      <el-table-column label="行程开始时间" prop="tripStartTime"></el-table-column>
      <el-table-column label="行程结束时间" prop="tripEndTime"></el-table-column>
      <el-table-column label="导游姓名" prop="name"></el-table-column>
      <el-table-column label="导游手机号" prop="phone"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="text" @click="showDetails(scope.row)">详情</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[10, 20, 50, 100]"
    :page-size="pageSize"
    layout="sizes, prev, pager, next, jumper"
    :total="itineraryList.length"
    />

    <!-- 详情弹窗 -->
    <el-dialog :visible.sync="showDetailsDialog" title="详情" width="60%">
      <el-row>
        <el-col :span="12">
          <h3>地点信息列表</h3>
          <el-table :data="parsedCommentList" style="width: 100%" v-if="parsedCommentList.length">
            <el-table-column label="地点" prop="location"></el-table-column>
            <el-table-column label="开始时间" prop="startTime"></el-table-column>
            <el-table-column label="结束时间" prop="endTime"></el-table-column>
            <el-table-column label="备注" prop="remark"></el-table-column>
          </el-table>
          <span v-else>暂无地点信息</span>
        </el-col>
        <el-col :span="12">
          <h3>队伍成员列表</h3>
          <el-table :data="teamMemberList" style="width: 100%" v-if="teamMemberList.length">
            <el-table-column label="成员名" prop="name"></el-table-column>
            <el-table-column label="手机号" prop="identityId"></el-table-column>
          </el-table>
          <span v-else>暂无队伍成员</span>
        </el-col>
      </el-row>
    </el-dialog>
  </div>
</template>

<script>
import {getList} from "@/api/trip/manage";

export default {
  data() {
    return {
      itineraryList: [], // 后台返回的列表数据，格式如下
      /**
       * itineraryId 行程单ID
       * teamName 团队名
       * tripStartTime 行程开始时间
       * tripEndTime 行程结束时间
       * name 导游名
       * phone 导游手机号
       * comment 转为字符串后的JSON数组，格式如下[{"location":"地点A","startTime":"2023-07-30 08:00:00","endTime":"2023-07-30 12:00:00","remark":"备注1"}]
       * teamMember 队伍成员，JSON数组，格式为[{name: "成员名", identityId: "手机号"}]
       */
      showList: [],
      parsedCommentList: [],
      teamMemberList: [],
      showDetailsDialog: false, // 控制详情弹窗的显示与隐藏
      selectedItinerary: null, // 当前选中的行程单数据
      currentPage: 1, // 当前页码
      pageSize: 10, // 每页展示的条数
    };
  },
  created() {
    getList().then(resp => {
      this.itineraryList = resp.data
      this.showList = this.itineraryList.slice(0, this.pageSize)
    })
  },
  computed: {
    // 计算当前页的数据
    currentPageData() {
      const startIndex = (this.currentPage - 1) * this.pageSize;
      const endIndex = startIndex + this.pageSize;
      return this.itineraryList.slice(startIndex, endIndex);
    },
  },
  methods: {
    showDetails(itinerary) {
      // 点击详情按钮时触发，打开详情弹窗，并将选中的行程单数据保存在selectedItinerary中
      this.selectedItinerary = itinerary;

      // 解析comment字段，并保存到parsedCommentList中
      this.parsedCommentList = JSON.parse(this.selectedItinerary.comment || '[]');

      // 解析teamMember字段，并保存到teamMemberList中
      this.teamMemberList = this.selectedItinerary.teamMembers || [];

      this.showDetailsDialog = true;
    },
    // 每页展示条数发生变化时的回调
    handleSizeChange(newSize) {
      this.pageSize = newSize;
      let start = (this.currentPage - 1) * this.pageSize
      this.showList = this.itineraryList.slice(start, start + this.pageSize)
    },

    // 页码发生变化时的回调
    handleCurrentChange(newPage) {
      this.currentPage = newPage;
      let start = (this.currentPage - 1) * this.pageSize
      this.showList = this.itineraryList.slice(start, start + this.pageSize)
    },
  },
};
</script>

<style>
/* 样式可以根据实际情况进行调整 */
</style>
