$(function (){
    // 获取登录人信息
    getEnrollerInfo();
    // 退出
    $("#log_out").click(function (){
        logout();
    });
});
//获取登录人信息
function getEnrollerInfo(){
    var uname = $("#uname").text();
    $.ajax({
        url:"/user/"+uname,
        type:"get",
        success:function (result){
            // 获取到注册时间 时间戳
            var loginTime = result.extend.user.uaddtime;
            var date = new Date(loginTime);
            var year = date.getFullYear();
            var month = date.getMonth()+1;
            var roname;
            $.each(result.extend.user.roles,function (index,item){
                roname = item.roname;
                $("#head_info small").text("注册于"+year+" 年"+month+" 月");
                $("#head_info span").text(uname+"   "+roname);
            })
        }
    })
}
function logout(){
    alert("asss");
    $.ajax({
        url: "/logout",
        type: "get",
        success:function (result){
            if (result.code==100){
                window.location.href="/";
            }
        }
    });
}
