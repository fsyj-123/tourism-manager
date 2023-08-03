<template>
  <div>
    <el-steps :active="active" finish-status="success" style="margin: 30px;">
      <el-step title="填写行程信息"></el-step>
      <el-step title="添加团队成员"></el-step>
      <el-step title="完成"></el-step>
    </el-steps>

    <div v-if="active===0">
      <!-- 团队名称文本框 -->
      <el-form :model="formData" ref="form" label-width="100px">
        <el-form-item label="团队名称" style="width: 50%;">
          <el-input v-model="formData.teamName" placeholder="请输入团队名称"></el-input>
        </el-form-item>
        <!-- 开始时间选择框 -->
        <el-form-item label="开始时间" style="width: 50%;">
          <el-date-picker v-model="formData.startTime" type="date" value-format="yyyy-MM-dd" placeholder="请选择开始时间">
          </el-date-picker>
        </el-form-item>
        <!-- 结束时间选择框 -->
        <el-form-item label="结束时间" style="width: 50%;">
          <el-date-picker v-model="formData.endTime" type="date" value-format="yyyy-MM-dd" placeholder="请选择结束时间">
          </el-date-picker>
        </el-form-item>
        <!-- 添加行程按钮 -->
        <el-form-item>
          <el-button type="primary" @click="showAddDialog">添加行程</el-button>
        </el-form-item>

      </el-form>

      <!-- 行程表格 -->
      <el-table :data="scheduleData" style="width: 90%;margin: 30px;">
        <el-table-column label="地点" prop="location"></el-table-column>
        <el-table-column label="开始时间" prop="startTime"></el-table-column>
        <el-table-column label="结束时间" prop="endTime"></el-table-column>
        <el-table-column label="备注" prop="remark"></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button type="text" @click="showEditDialog(scope.$index)">修改</el-button>
            <el-button type="text" @click="handleDelete(scope.$index)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>

      <!-- 添加/修改行程的 Dialog -->
      <el-dialog :title="dialogTitle" :visible.sync="dialogVisible" width="50%">
        <el-form :model="currentSchedule" ref="scheduleForm" label-width="100px">
          <el-form-item label="地点">
            <el-input v-model="currentSchedule.location" placeholder="请输入地点"></el-input>
          </el-form-item>
          <el-form-item label="开始时间">
            <el-date-picker v-model="currentSchedule.startTime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss"
              placeholder="请选择开始时间"></el-date-picker>
          </el-form-item>
          <el-form-item label="结束时间">
            <el-date-picker v-model="currentSchedule.endTime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss"
              placeholder="请选择结束时间"></el-date-picker>
          </el-form-item>
          <el-form-item label="备注">
            <el-input v-model="currentSchedule.remark" placeholder="请输入备注"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="handleSubmit">提交</el-button>
        </span>
      </el-dialog>
    </div>
    <div v-if="active===1">
      <div>
        <!-- 团队成员数量文本框 -->
        <el-form :model="teamData" ref="teamForm" label-width="120px" style="margin-bottom: 20px;">
          <el-form-item label="团队成员数量" style="width: 50%;">
            <el-input v-model="teamData.memberCount" disabled></el-input>
          </el-form-item>
        </el-form>

        <!-- 团队成员表格 -->
        <el-table :data="teamData.members" style="width: 90%;margin: 30px;">
          <el-table-column label="姓名" prop="name"></el-table-column>
          <el-table-column label="手机号" prop="identityId"></el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button type="text" @click="handleMemberEdit(scope.$index)">修改</el-button>
              <el-button type="text" @click="handleMemberDelete(scope.$index)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>

        <el-button type="primary" @click="addMemberDialogVisible=true" style="margin: 30px;">添加成员</el-button>
        <!-- 新增团队成员的 Dialog -->
        <el-dialog title="新增团队成员" :visible.sync="addMemberDialogVisible" width="50%">
          <el-form :model="newMember" ref="newMemberForm" label-width="100px">
            <el-form-item label="姓名">
              <el-input v-model="newMember.name" placeholder="请输入姓名"></el-input>
            </el-form-item>
            <el-form-item label="手机号">
              <el-input v-model="newMember.identityId" placeholder="请输入手机号"></el-input>
            </el-form-item>
          </el-form>
          <span slot="footer" class="dialog-footer">
            <el-button @click="addMemberDialogVisible = false">取消</el-button>
            <el-button type="primary" @click="handleAddMember">添加</el-button>
          </span>
        </el-dialog>
      </div>
    </div>
    <div v-if="active===2">
      <div>
        <img src="@/assets/images/success.png" style="display: block;
        margin: 0 auto;">
        <span style="display:block;font-size: 2vw;display: block;
        text-align: center;">操作成功</span>
      </div>
      <div style="width: 200px;margin: 35px auto;">
        <el-form :model="showData" ref="showDataForm" label-width="100px" align="left">
          <el-form-item label="团队名称">
            {{formData.teamName}}
          </el-form-item>
          <el-form-item label="导游姓名">
            {{showData.name}}
          </el-form-item>
          <el-form-item label="电话号码">
            {{showData.phone}}
          </el-form-item>
        </el-form>
      </div>
    </div>

    <div v-show="active>0">
      <el-button style="margin-top: 12px;margin-left: 30px;" @click="active--">上一步</el-button>
    </div>
    <el-button style="margin-top: 12px;margin-left: 30px;" @click="next">{{nextName}}</el-button>
  </div>
</template>

<script>

  import { insertTrip, insertToursim } from "@/api/trip/manage";
  import { getGuideInfo } from "@/api/guide/info";

  export default {
    data() {
      return {
        formData: {
          teamName: '',
          tripStartTime: '',
          tripEndTime: '',
        },
        nextName: '下一步',
        active: 0,
        scheduleData: [

        ], // 存储行程表格数据
        dialogVisible: false, // 控制 Dialog 的显示与隐藏
        dialogTitle: '', // Dialog 的标题，用于区分添加和修改功能
        currentSchedule: {}, // 当前正在编辑的行程数据
        teamData: {
          memberCount: 0,
          members: [
          ],
        },
        addMemberDialogVisible: false,
        newMember: {
          name: '',
          phone: '',
        },
        travelId: 0,
        showData: {
          name: '',
          phone: '',
        }
      };
    },
    created() {

    },
    methods: {
      next() {
        switch (this.active) {
          case 0: {
            let data = { ...this.formData }
            data.comment = JSON.stringify(this.scheduleData)
            insertTrip(data).then(resp => {
              if (resp.code === 200) {
                this.active++
                this.travelId = resp.data
              } else {
                alert("消息填写错误")
              }
            })
            break;
          }
          case 1: {
            this.teamData.members.forEach(item => {
              item.travelItineraryId = this.travelId
            })
            insertToursim(this.teamData.members).then(resp => {
              if (resp.code !== 200) {
                alert("服务端错误")
              } else {
                this.active++
                this.nextName = "添加完成"
              }
            })
            getGuideInfo().then(resp => {
              this.showData = { ...resp.data }
            })
            break
          }
          case 2: {

          }
        }
      },
      handleDelete(index) {
        // 处理删除操作
        this.scheduleData.splice(index, 1);
      },
      // 显示添加行程的 Dialog
      showAddDialog() {
        this.dialogTitle = '添加行程';
        this.currentSchedule = {
          location: '',
          startTime: '',
          endTime: '',
          remark: '',
        };
        this.dialogVisible = true;
      },

      // 显示修改行程的 Dialog
      showEditDialog(index) {
        this.dialogTitle = '修改行程';
        this.currentSchedule = { ...this.scheduleData[index] };
        this.dialogVisible = true;
      },

      // 提交表单数据
      handleSubmit() {
        this.$refs.scheduleForm.validate((valid) => {
          if (valid) {
            if (this.dialogTitle === '添加行程') {
              this.scheduleData.push(this.currentSchedule);
            } else if (this.dialogTitle === '修改行程') {
              const index = this.scheduleData.findIndex(
                (item) => item === this.currentSchedule
              );
              if (index !== -1) {
                this.scheduleData.splice(index, 1, this.currentSchedule);
              }
            }
            this.dialogVisible = false; // 关闭 Dialog
          }
        });
      },


      handleMemberEdit(index) {
        // 处理修改操作
        this.newMember = { ...this.teamData.members[index] };
        this.addMemberDialogVisible = true;
      },
      handleMemberDelete(index) {
        // 处理删除操作
        this.teamData.members.splice(index, 1);
        this.updateMemberCount();
      },
      handleAddMember() {
        // 处理新增团队成员操作
        this.teamData.members.push({
          name: this.newMember.name,
          identityId: this.newMember.identityId,
        });
        this.addMemberDialogVisible = false;
        this.updateMemberCount();
      },
      updateMemberCount() {
        // 更新团队成员数量
        this.teamData.memberCount = this.teamData.members.length;
      },
    },
  };
</script>

<style>
  /* 样式可以根据实际情况进行调整 */
</style>