<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/4/27
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<link rel="icon" href="/static/image/favicon.ico">
<!-- 告诉浏览器该页面是自适应布局 -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="stylesheet" href="/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="/bower_components/Ionicons/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="/dist/css/AdminLTE.min.css">
<!-- AdminLTE 皮肤。默认使用蓝色皮肤。
    您可以选择其他皮肤。皮肤样式写在 body 标签中，
    以便使之生效。 -->
<link rel="stylesheet" href="/dist/css/skins/_all-skins.min.css">
<link rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<body class="hold-transition skin-purple sidebar-mini">
<div class="wrapper">

    <!--------------------------------------------- 头部 ------------------------------------------>
    <header class="main-header">

        <!------------------ 左上角的LOGO ----------------->
        <a href="#" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>后台</b>管理</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>数据</b>后台管理</span>
        </a>

        <!----------------- 头部导航栏 ------------------>
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- 导航栏收缩按钮-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">切换导航</span>
            </a>
            <!-- 导航栏右侧菜单 -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- User Account Menu -->
                    <li class="dropdown user user-menu">
                        <!-- Menu Toggle Button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <!-- The user image in the navbar-->
                            <img src="/dist/img/user2-160x160.jpg" class="user-image" alt="用户图像">
                            <!-- hidden-xs 在小型设备上隐藏用户名，只显示图像。 -->
                            <span class="hidden-xs">${param.uname}</span>
                        </a>
                        <!-- 点击头像的菜单 -->
                        <ul class="dropdown-menu">
                            <!-- The user image in the menu -->
                            <li class="user-header">
                                <img src="/dist/img/user2-160x160.jpg" class="img-circle" alt="用户图像">

                                <p id="head_info">
                                    <span style="font-size: 20px"></span>
                                    <small style="font-size: 15px"></small>
                                </p>
                            </li>

                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-default btn-flat">资料</a>
                                </div>
                                <div class="pull-right">
                                    <a href="#" class="btn btn-default btn-flat" id="log_out">退出</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <!-- 最右侧的设置按钮 -->
                    <li>
                        <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <!-------------------------------------------- 左部侧边栏 ---------------------------------------------->
    <aside class="main-sidebar">
        <section class="sidebar">

            <!--------- 用户状态面板 ----------->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="/dist/img/user2-160x160.jpg" class="img-circle" alt="用户图像">
                </div>
                <div class="pull-left info">
                    <p id="uname">${param.uname}</p>
                    <!-- 状态 -->
                    <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
                </div>
            </div>

            <!---------- 侧边栏搜索框 --------->
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="搜索...">
                    <span class="input-group-btn">
                            <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i
                                    class="fa fa-search"></i>
                            </button>
                        </span>
                </div>
            </form>

            <!------------- 侧边栏菜单 ------------->
            <ul class="sidebar-menu" data-widget="tree">
                <li class="header">主导航</li>
                <!--------- 导航链接 ----------->
                <li class="active"><a href="#"><i class="fa fa-link"></i> <span>链接</span></a></li>
                <li><a href="#"><i class="fa fa-link"></i> <span>另一个链接</span></a></li>
                <li class="treeview">
                    <a href="#"><i class="fa fa-link"></i> <span>多级菜单</span>
                        <span class="pull-right-container">
                                <i class="fa fa-angle-left pull-right"></i>
                            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/WEB-INF/view/index.jsp">2级链接</a></li>
                        <li><a href="#">2级链接</a></li>
                    </ul>
                </li>
            </ul>
        </section>
    </aside>

    <!------------------------------------- 页面主体内容 -------------------------------------->
    <div class="content-wrapper">
        <!------- 头部 (页眉) ------->
        <section class="content-header">
            <h1>
                首页
                <small>欢迎您</small>
            </h1>
            <!-- 面包屑 -->
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> home</a></li>
                <li class="active">样例</li>
            </ol>
        </section>

        <!------ 主体内容 ------>
        <section class="content container-fluid">
            <!-- 面板样例 -->
            <div class="box box-primary">
                <!-- 面板头部 -->
                <div class="box-header with-border">
                    <i class="fa fa-cube"></i>
                    <h3 class="box-title">面板样例</h3>
                </div>
                <!-- 面板内容 -->
                <div class="box-body">
                    <h1>这是一个AdminLTE模板！</h1>
                    <h3>任何你想要的</h3>

                </div>


            </div>
            <!-- /.box-body -->

        </section>
    </div>

    <!------- 尾部Footer ------>
    <footer class="main-footer">
        <!-- 右测内容 -->
        <div class="pull-right hidden-xs">
            任何你想要的
        </div>
        <!-- 默认左侧内容 -->
        <strong>Copyright &copy; 2016 <a href="#">Company</a>.</strong> All rights reserved.
    </footer>

    <!------------------------------------右侧设置按钮的侧边栏 ------------------------------------>
    <aside class="control-sidebar control-sidebar-dark" style="display: none;">
        <!-- Create the tabs -->
        <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
            <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
            <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
            <!-- Home tab content -->
            <div class="tab-pane" id="control-sidebar-home-tab">
                <h3 class="control-sidebar-heading">个人中心</h3>

            </div>
            <!-- /.tab-pane -->
            <!-- Settings tab content -->
            <div class="tab-pane" id="control-sidebar-settings-tab">
                <h3 class="control-sidebar-heading">常规设置</h3>
            </div>
            <!-- /.tab-pane -->
        </div>
    </aside>
    <!-- /.control-sidebar -->
    <!-- 添加侧边栏的背景。这个 div必须放在 control-sidebar 之后 -->
    <div class="control-sidebar-bg"></div>
</div>



<!--------------------------- 导入的 JS SCRIPTS ------------------------>
<!-- jQuery 3 -->
<script src="/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/dist/js/demo.js"></script>
<script src="/static/js/admin.js"></script>

</body>
</html>
