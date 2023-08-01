<template>
  <div>
    <!-- 展示信息 -->
    <el-form :model="tourGuideInfo" v-if="!editMode" label-width="100px">
      <el-form-item label="姓名">
        <el-input v-model="tourGuideInfo.name" disabled></el-input>
      </el-form-item>
      <el-form-item label="电话号码">
        <el-input v-model="tourGuideInfo.phone" disabled></el-input>
      </el-form-item>
      <el-form-item label="身份证">
        <el-input v-model="tourGuideInfo.identityId" disabled></el-input>
      </el-form-item>
      <el-form-item label="导游号">
        <el-input v-model="tourGuideInfo.licenseNumber" disabled></el-input>
      </el-form-item>
      <el-form-item label="有效日期">
        <span>{{ tourGuideInfo.licenseStartTime }} 至 {{ tourGuideInfo.licenseEndTime }}</span>
      </el-form-item>
      <el-form-item label="导游证">
        <img :src="base64Image" v-if="base64Image" style="max-width: 200px; max-height: 200px;"/>
        <span v-else>无导游证图片</span>
      </el-form-item>
      <el-button type="primary" @click="editMode = true">编辑</el-button>
    </el-form>

    <!-- 编辑模态窗口 -->
    <el-dialog title="编辑信息" :visible.sync="editMode" width="50%">
      <el-form :model="tourGuideInfo" ref="editForm" label-width="100px">
        <el-form-item label="姓名">
          <el-input v-model="tourGuideInfo.name"></el-input>
        </el-form-item>
        <el-form-item label="电话号码">
          <el-input v-model="tourGuideInfo.phone"></el-input>
        </el-form-item>
        <el-form-item label="身份证">
          <el-input v-model="tourGuideInfo.identityId"></el-input>
        </el-form-item>
        <el-form-item label="导游号">
          <el-input v-model="tourGuideInfo.licenseNumber"></el-input>
        </el-form-item>
        <el-form-item label="有效日期">
          <el-date-picker
            v-model="tourGuideInfo.licenseStartTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="开始日期"
          ></el-date-picker>
          <span> 至 </span>
          <el-date-picker
            v-model="tourGuideInfo.licenseEndTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="截止日期"
          ></el-date-picker>
        </el-form-item>
        <el-form-item label="导游证">
          <el-upload
            class="avatar-uploader"
            action="#"
            :show-file-list="false"
            :on-change="handleAvatarChange"
            :before-upload="beforeAvatarUpload"
          >
            <img :src="base64Image" v-if="base64Image" style="max-width: 200px; max-height: 200px;"/>
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="cancelEdit">取消</el-button>
        <el-button type="primary" @click="submitEdit">提交</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import {getGuideInfo, updateInfo} from "@/api/guide/info";
import {getInstitution} from "@/api/person/manager";

export default {
  data() {
    return {
      editMode: false, // 控制编辑模态窗口的显示与隐藏
      tourGuideInfo: {
        // 从后端获取的信息
        name: 'John Doe',
        phone: '1234567890',
        identityId: '123456789012345678',
        licenseNumber: 'Guide123',
        licenseStartTime: '2023-07-01',
        agencyId: '',
        licenseEndTime: '2023-12-31',
        qualify: '',
      },
      agencyName: '',
      agencyOptions: [{
        label: '无',
        value: ''
      }], // 存储旅行社的下拉选项
      base64Image: '', // 存储Base64编码图片
    };
  },
  mounted() {
    // 模拟从后端获取的旅行社列表数据，此处假设后端返回了JSON数组，每个对象包含value和label
    getInstitution(2).then(resp => {
      let data = resp.data.map(item => ({
        label: item.name,
        value: item.id
      }))
      this.agencyOptions = this.agencyOptions.concat(data)
    })
    getGuideInfo().then(resp => {
      this.tourGuideInfo = {...resp.data}
      this.agencyName = this.getAgencyNameById(this.tourGuideInfo.agencyId)
      this.base64Image = this.tourGuideInfo.qualify
    })

  },
  methods: {
    cancelEdit() {
      // 取消编辑
      this.editMode = false;
    },
    submitEdit() {
      // 编辑模态窗口关闭
      this.editMode = false;
      this.tourGuideInfo.qualify = this.base64Image;
      updateInfo(this.tourGuideInfo)
    },
    // 图片上传前处理
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isPNG = file.type === 'image/png';
      const isGIF = file.type === 'image/gif';
      if (!(isJPG || isPNG || isGIF)) {
        this.$message.error('图片格式只能是 JPG/PNG/GIF 格式!');
        return false;
      }
      const isLt2M = file.size / 1024 / 1024 < 2;
      if (!isLt2M) {
        this.$message.error('上传图片大小不能超过 2MB!');
        return false;
      }
      return true;
    },
    // 图片上传成功处理
    handleAvatarChange(file) {
      const reader = new FileReader();
      reader.readAsDataURL(file.raw);
      reader.onload = () => {
        this.base64Image = reader.result;
      };
    },
// 根据旅行社ID获取旅行社名字
    getAgencyNameById(agencyId) {
      const selectedAgency = this.agencyOptions.find((agency) => agency.value === agencyId);
      return selectedAgency ? selectedAgency.label : '';
    },
  },
};
</script>

<style>
/* 样式可以根据实际情况进行调整 */
</style>
