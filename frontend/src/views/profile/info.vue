<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="120px">
      <el-form-item label="头像">
        <el-input v-model="form.icon" />
      </el-form-item>
      <el-form-item label="用户名">
        <el-input v-model="form.username" />
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="form.email" />
      </el-form-item>
      <el-form-item label="昵称">
        <el-input v-model="form.nickName" />
      </el-form-item>
      <el-form-item label="备注">
        <el-input v-model="form.note" />
      </el-form-item>
      <el-form-item label="创建时间">
        <el-input v-model="form.createTime" />
      </el-form-item>
      <el-form-item label="最后登录">
        <el-input v-model="form.loginTime" />
      </el-form-item>
      <el-form-item label="状态">
        <el-input v-model="form.status" />
      </el-form-item>


    </el-form>
  </div>
</template>

<script>

    import { info } from "../../api/profile";

    export default {
        name: "ProfileInfo",
        data() {
            return {
                form: {
                    icon: '',
                    username: '',
                    email: '',
                    nickName: '',
                    note: '',
                    createTime: '',
                    loginTime: '',
                    status: ''
                }
            }
        },
        created() {
            this.fetchData()
        },
        methods: {
            fetchData() {
                info(this.$store.getters.name).then(response => {
                    console.log(response.data);
                  this.form = response.data;
                });
            }
        }
    }
</script>

<style scoped>

</style>
