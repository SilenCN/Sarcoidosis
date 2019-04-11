var app = new Vue({
    el: '#vue-login',
    data: {
        username:"",
        password:"",
        message:"登录",
        errorMessage:""
    },
    methods: {
        loginClick: function () {
            axios.post('/user/login?username='+this.username+"&password="+this.password)
                .then(function (response) {
                    if(response.data=='ok'){
                        location.href="/home.html";
                    }else{
                        app.errorMessage="账号或密码错误！";
                    }
                })
                .catch(function (error) {
                    this.errorMessage=error.toString();
                });
        }
    }
});
var register = new Vue({
    el: '#vue-register',
    data: {
        nickname:"",
        username:"",
        password:"",
        message:"注册",
        rePassword:"",
        errorMessage:"",
        successMessage:""
    },
    methods: {
        registerClick: function () {
            register.errorMessage="";
            register.successMessage="";
            if (this.nickname==null||this.nickname.length<=0){
                register.errorMessage="请输入名称！";
                return;
            }
            if (this.username==null||this.username.length<=0){
                register.errorMessage="请输入邮箱！";
                return;
            }
            if (this.password==null||this.password.length<=0){
                register.errorMessage="请输入密码！";
                return;
            }
            if (this.rePassword==null||this.rePassword.length<=0){
                register.errorMessage="请再次输入密码！";
                return;
            }
            if(this.rePassword!=this.password){
                register.errorMessage="两次密码不一致！";
                return;
            }
            //register.successMessage="注册成功,请登陆！";

            axios.post('/user/register',{nickname: this.nickname,password:this.password,username:this.username})
                .then(function (response) {
                    let data=response.data;
                    if(data.code==100){
                        register.successMessage=data.result;
                    }else{
                        register.errorMessage=data.result;
                    }
                })
                .catch(function (error) {
                    this.errorMessage=error.toString();
                });
        }
    }
});
