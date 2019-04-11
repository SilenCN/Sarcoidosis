var app = new Vue({
    el: '#app',
    data: {
        isCollapse: false,
        username: "admin",
        iframeSrc: "https://www.baidu.com",
        loading: false,
        loadUrl: "",
        iframeTitle:"肺结节检测",
        urlArray:["overview/index.html","test/add/index.html","test/history/index.html","settings/profile/index.html","settings/password/index.html"]
    },
    mounted() {
        this.loadUrl=this.urlArray[0];
        this.loading=true;
        axios.post('/api/user/getUsername')
            .then(function (response) {
                var data = response.data;
                if (data.code == 100) {
                    app.username = data.result;
                } else {
                    alert(data.result);
                    location.href = "/user/login.html";
                }
            })
            .catch(function (error) {

            });
        document.getElementById('mainIframe').onload = function() {
            app.iframeTitle=document.getElementById('mainIframe').contentWindow.document.title;
            app.loading=false;
        }

    },
    methods: {
        toggleSideBar() {
            this.isCollapse = !this.isCollapse;
        },
        logout: function () {
            this.$confirm('确认退出?', '提示', {})
                .then(() => {
                    sessionStorage.removeItem('user');

                })
                .catch(() => {
                });
        },
        handleSelect(key, keyPath) {
            app.loading=true;
            app.loadUrl=app.urlArray[key];
        }
/*        ,
        loadHtmlForBody: function (newVal) {
            axios.get(newVal)
                .then(function (response) {
                    app.loadHtml=response.data;
                })
                .catch(function (error) {
                    app.loadHtml="<p>加载错误，请刷新！</p>"
                });
        }*/
    }/*,
    watch: {
        loadUrl: {
            deep: true,
            handler: function (newVal, oldVal) {
                app.loading=true;
                app.loadHtmlForBody(newVal);
                app.loading=false;
            }
        }
    }*/
});
