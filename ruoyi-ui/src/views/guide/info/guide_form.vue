<template>
  <div>
    <el-dialog v-bind="$attrs" v-on="$listeners" @open="onOpen" @close="onClose" title="Dialog Title">
      <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="formData.name" placeholder="请输入姓名" clearable :style="{width: '100%'}"></el-input>
        </el-form-item>
        <el-form-item label="电话号码" prop="phone">
          <el-input v-model="formData.phone" placeholder="请输入电话号码" clearable :style="{width: '100%'}">
          </el-input>
        </el-form-item>
        <el-form-item label="身份证号" prop="identity_id">
          <el-input v-model="formData.identity_id" placeholder="请输入身份证号" clearable :style="{width: '100%'}">
          </el-input>
        </el-form-item>
        <el-form-item label="所属旅行社" prop="agency">
          <el-select v-model="formData.agency" placeholder="请选择所属旅行社" clearable :style="{width: '100%'}">
            <el-option v-for="(item, index) in agencyOptions" :key="index" :label="item.label"
              :value="item.value" :disabled="item.disabled"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="导游证号" prop="license_number">
          <el-input v-model="formData.license_number" placeholder="请输入导游证号" clearable
            :style="{width: '100%'}"></el-input>
        </el-form-item>
        <el-form-item label="日期范围" prop="license_effect_time">
          <el-date-picker type="daterange" v-model="formData.license_effect_time" format="yyyy-MM-dd"
            value-format="yyyy-MM-dd" :style="{width: '100%'}" start-placeholder="开始日期" end-placeholder="结束日期"
            range-separator="至" clearable></el-date-picker>
        </el-form-item>
        <el-form-item label="导游证上传" prop="field110" required>
          <el-upload ref="field110" :file-list="field110fileList" :action="field110Action"
            :before-upload="field110BeforeUpload" list-type="picture" accept="image/*">
            <el-button size="small" type="primary" icon="el-icon-upload">点击上传</el-button>
          </el-upload>
        </el-form-item>
      </el-form>
      <div slot="footer">
        <el-button @click="close">取消</el-button>
        <el-button type="primary" @click="handleConfirm">确定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
export default {
  inheritAttrs: false,
  components: {},
  props: [],
  data() {
    return {
      formData: {
        name: undefined,
        phone: undefined,
        identity_id: undefined,
        agency: undefined,
        license_number: undefined,
        license_effect_time: null,
        field110: null,
      },
      rules: {
        name: [{
          required: true,
          message: '请输入姓名',
          trigger: 'blur'
        }],
        phone: [{
          required: true,
          message: '请输入电话号码',
          trigger: 'blur'
        }],
        identity_id: [{
          required: true,
          message: '请输入身份证号',
          trigger: 'blur'
        }],
        agency: [],
        license_number: [{
          required: true,
          message: '请输入导游证号',
          trigger: 'blur'
        }],
        license_effect_time: [{
          required: true,
          message: '日期范围不能为空',
          trigger: 'change'
        }],
      },
      field110Action: 'https://jsonplaceholder.typicode.com/posts/',
      field110fileList: [],
      agencyOptions: [{
        "label": "选项一",
        "value": "飞猪旅行社"
      }, {
        "label": "选项二",
        "value": "去哪儿旅行社"
      }],
    }
  },
  computed: {},
  watch: {},
  created() {},
  mounted() {},
  methods: {
    onOpen() {},
    onClose() {
      this.$refs['elForm'].resetFields()
    },
    close() {
      this.$emit('update:visible', false)
    },
    handleConfirm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        this.close()
      })
    },
    field110BeforeUpload(file) {
      let isRightSize = file.size / 1024 / 1024 < 2
      if (!isRightSize) {
        this.$message.error('文件大小超过 2MB')
      }
      let isAccept = new RegExp('image/*').test(file.type)
      if (!isAccept) {
        this.$message.error('应该选择image/*类型的文件')
      }
      return isRightSize && isAccept
    },
  }
}

</script>
<style>
.el-upload__tip {
  line-height: 1.2;
}

</style>
