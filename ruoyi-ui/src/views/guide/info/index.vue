<template>
    <div class="app-container">
        <el-form ref="myForm" :model="myForm" size="medium" label-width="100px">
            <el-form-item label="姓名" prop="name">
                {{myForm.name}}
            </el-form-item>
            <el-form-item label="电话号码" prop="phone">
                {{myForm.phone}}
            </el-form-item>
            <el-form-item label="身份证号" prop="identity_id">
                {{myForm.identity_id}}
            </el-form-item>
            <el-form-item label="所属旅行社" prop="agency">
                <el-select v-model="myForm.agency" placeholder="请选择所属旅行社" clearable :style="{width: '100%'}">
                    {{myForm.agency}}
                </el-select>
            </el-form-item>
            <el-form-item label="导游证号" prop="license_number">
                {{myForm.license_number}}
            </el-form-item>
            <el-form-item label="日期范围" prop="license_effect_time">
                <el-date-picker type="daterange" v-model="myForm.license_effect_time" format="yyyy-MM-dd"
                    value-format="yyyy-MM-dd" :style="{width: '100%'}" start-placeholder="开始日期" end-placeholder="结束日期"
                    range-separator="至" clearable></el-date-picker>
            </el-form-item>
            <el-form-item label="导游证上传" prop="field110" required>
                <img src="">
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="open">编辑</el-button>
            </el-form-item>
        </el-form>

        <!-- 表单 -->
        <el-dialog :visible.sync="diavisible" title="编辑信息" @close="onClose">
            <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
                <el-form-item label="姓名" prop="name">
                    <el-input v-model="formData.name" placeholder="请输入姓名" style="width: '100%'"></el-input>
                </el-form-item>
                <el-form-item label="电话号码" prop="phone">
                    <el-input v-model="formData.phone" placeholder="请输入电话号码" style="width: '100%'">
                    </el-input>
                </el-form-item>
                <el-form-item label="身份证号" prop="identity_id">
                    <el-input v-model="formData.identity_id" placeholder="请输入身份证号" style="width: '100%'">
                    </el-input>
                </el-form-item>
                <el-form-item label="所属旅行社" prop="agency">
                    <el-select v-model="formData.agency" placeholder="请选择所属旅行社" style="width: '100%'">
                        <el-option v-for="(item, index) in agencyOptions" :key="index" :label="item.label"
                            :value="item.value" :disabled="item.disabled"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="导游证号" prop="license_number">
                    <el-input v-model="formData.license_number" placeholder="请输入导游证号" style="width: '100%'"></el-input>
                </el-form-item>
                <el-form-item label="日期范围" prop="license_effect_time">
                    <el-date-picker type="daterange" v-model="formData.license_effect_time" format="yyyy-MM-dd"
                        value-format="yyyy-MM-dd" style="width: '100%'" start-placeholder="开始日期" end-placeholder="结束日期"
                        range-separator="至"></el-date-picker>
                </el-form-item>
                <el-form-item label="导游证上传" prop="field110">
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
    import { listInfo, getInfo, delInfo, addInfo, updateInfo, listInfoAll } from "@/api/guide/info";
    import Cookies from "js-cookie";
    export default {
        inheritAttrs: false,
        components: {},
        props: [],
        data() {
            return {
                diavisible: false,
                myForm: {
                    name: "吴所谓",
                    phone: "19827275084",
                    identity_id: "533104199908082111",
                    agency: "",
                    license_number: "123XXXXXX",
                    license_effect_time: "",
                    field110: "url",
                },
                formData: {
                    name: undefined,
                    phone: undefined,
                    identity_id: undefined,
                    agency: undefined,
                    license_number: undefined,
                    license_effect_time: null,
                    field110: null,
                },
                // rules: {
                //     name: [{
                //         required: true,
                //         message: '请输入姓名',
                //         trigger: 'blur'
                //     }],
                //     phone: [{
                //         required: true,
                //         message: '请输入电话号码',
                //         trigger: 'blur'
                //     }],
                //     identity_id: [{
                //         required: true,
                //         message: '请输入身份证号',
                //         trigger: 'blur'
                //     }],
                //     agency: [],
                //     license_number: [{
                //         required: true,
                //         message: '请输入导游证号',
                //         trigger: 'blur'
                //     }],
                //     license_effect_time: [{
                //         required: true,
                //         message: '日期范围不能为空',
                //         trigger: 'change'
                //     }],
                // },
                field110Action: 'https://jsonplaceholder.typicode.com/posts/',
                field110fileList: [],
                agencyOptions: [
                    {
                        "label": "无",
                        "value": ""
                    },
                    {
                        "label": "飞猪旅行社",
                        "value": "飞猪旅行社"
                    }, {
                        "label": "去哪儿旅行社",
                        "value": "去哪儿旅行社"
                    }],
                // 查询参数
                queryParams: {
                    pageNum: 1,
                    pageSize: 10,
                    name: null,
                    phone: null,
                    identityId: null,
                    agencyId: null,
                    qualify: null,
                    licenseNumber: null,
                    licenseStartTime: null,
                    lecenseEndTime: null,
                },
            }
        },
        computed: {},
        watch: {},
        mounted() {
            console.log("mouted");
            this.getList()
        },
        // mounted() { },
        methods: {
            onOpen() {
                this.$refs['elForm'].resetFields()
            },
            open() {
                this.reset()
                this.diavisible = true
            },
            onClose() {
                this.$refs['elForm'].resetFields()
            },
            close() {
                this.diavisible = false
            },
            // 获取导游信息
            getList() {
                this.loading = true;
                const username = Cookies.get("username");//用户名=电话
                this.queryParams.phone = username;
                // 从存储中拿取账号（电话），作为参数传入listInfo
                listInfo(this.queryParams).then(response => {
                    // 查看返回的data值，设置myForm
                    console.log("data", response);
                    // this.infoList = response.rows;
                    // this.total = response.total;
                    this.loading = false;
                });
            },
            // 提交表单
            handleConfirm() {
                this.$refs['elForm'].validate(valid => {
                    if (valid) {
                        console.log(this.formData);
                        if (this.myForm.identityId != null) {
                            console.log("编辑");
                            updateInfo(this.formData).then(response => {
                                this.$modal.msgSuccess("编辑成功");
                                this.close()
                                // this.diavisible = false;
                                this.getList();
                            })
                        }
                        else {
                            console.log("新增");
                            addInfo(this.formData).then(response => {
                                this.$modal.msgSuccess("新增成功");
                                this.diavisible = false;
                                this.getList();
                            });
                        }
                    }
                })
            },
            // 上传文件
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
            // 表单重置
            reset() {
                this.formData = {
                    name: null,
                    phone: null,
                    identityId: null,
                    agencyId: null,
                    qualify: null,
                    licenseNumber: null,
                    licenseStartTime: null,
                    lecenseEndTime: null,
                };
                this.resetForm("formData");
            },
        }
    }

</script>

<style>
    .el-upload__tip {
        line-height: 1.2;
    }
</style>