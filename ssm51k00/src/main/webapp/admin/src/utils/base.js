const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm51k00/",
            name: "ssm51k00",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm51k00/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "宠物综合服务平台"
        } 
    }
}
export default base
