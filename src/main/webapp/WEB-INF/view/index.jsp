<%--
  Created by IntelliJ IDEA.
  User: zzy
  Date: 2021/11/27
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>房屋管理系统 - 登录页面</title>
    <link rel="icon" href="/static/image/favicon.ico">
    <link rel="stylesheet" type="text/css" href="static/css/index.css"/>
    <script src="../../static/js/jquery-3.6.0.js"></script>
    <%--    <script rel="stylesheet" src="/static/js/jquery-3.6.0.js" crossorigin="anonymous"></script>--%>
    <%--    <link rel="stylesheet" href="/static/bootstrap3.4.1/css/bootstrap.min.css" crossorigin="anonymous">--%>
    <%--    <link href="/static/bootstrap3.4.1/css/bootstrap-theme.min.css">--%>
    <%--    <script src="/static/bootstrap3.4.1/js/bootstrap.min.js"></script>--%>

    <style>
        *{
            font-family: "微软雅黑";
            font-size: 16px;
            border: 0;
            padding: 0;
            margin: 0;
            color: #666;
            box-sizing:border-box;
            -moz-box-sizing:border-box;
            -webkit-box-sizing:border-box;
        }
        .bgone{
            width: 100%;
            height: 100%;
            position: absolute;
            top:0;right: 0;left: 0;bottom: 0;margin: auto;
        }
        .pic{
            width: 492px;
            height: auto;
            position: absolute;
            top:173px;right: 453px;left: 0;bottom: 0;margin: auto;
            z-index: 99999;
        }
        .table{
            background-color: #FFFFFF;
            width: 960px;
            height: 465px;
            position: absolute;
            top:20%;right: 0;left: 0;bottom: 0;margin: auto;
        }
        .password{
            position: absolute;
            top: 12.8rem;
            right: 4rem;
            display: flex;
        }
        .btn{
            position: absolute;
            top: 18.5rem;
            right: 3.9rem;
            border: none;
            color: #fff;
            width: 373px;
            text-align: center;
            background-color: #1592ef;
            text-indent: 0rem;
            border-radius: 10px;
            text-shadow:2px 2px 1px rgba(0, 0, 0, 0.2);
            box-shadow:2px 2px 1px rgba(0, 0, 0, 0.2);
            font-size:20px ;
            height: 50px;
        }

        .wel{
            width: 960px;
            height: 35px;
            color: #fff;
            font-size: 30px;
            position: absolute;
            top: -7rem;
            text-align: center;


        }.wel1{
             width: 960px;
             height: 35px;
             color: #fff;
             font-size: 12.38px;
             position: absolute;
             top: -4rem;
             text-align: center;

         }
        input{
            height: 55px;
            width: 373px;
            text-indent: 55px;
            outline:none;
            background: #eef6fd;
            border-bottom:2px #d6e7fa solid ;
        }
        .password input{
            border: 0;
        }
        .user{
            position: absolute;
            top: 7.8rem;
            right:4rem;
            display: flex;
        }

        .yonghu img{
            height: 30px;
            position: absolute;
            left: 10px;
            top: 13px;
        }

    </style>
</head>
<body>

<img class="bgone" src="../../static/image/1.jpg"/>
<img class="pic" src="../../static/image/a.png"/>

<div class="table">
    <%--    <img src="static/image/welcome.png">--%>
    <div class="wel">尚客公寓后台登录</div>
    <div class="wel1">Backstage login of Shangke Apartment</div>
    <div>
        <form>
            <div class="user">
                <div class="yonghu" style="">
                    <img src="../../static/image/yhm.png">
                </div>
                <input type="text" name="uname" placeholder="username" value="sam"/>
            </div>
            <div class="password">
                <div class="yonghu">
                    <img src="../../static/image/mm.png">
                </div>
                <input type="password" name="upassword" placeholder="password" value="1"/>
            </div>
            <button type="button" class="btn">登录</button>
        </form>
    </div>
</div>
</body>
    <script>
        $(function (){
            $(".btn").click(function (){
                var uname = $("input[name='uname']").val();
                var upassword = $("input[name='upassword']").val();
                $.ajax({
                    url:"/login/"+uname+"/"+upassword,
                    type:"post",
                    success:function (result){
                        if (result.code==100){
                            window.location.href="/admin?uname="+uname;
                        }
                        if (result.code==200){
                            alert("登录失败，账号密码错误");
                        }
                    }
                });
            });
        });
    </script>
</html>