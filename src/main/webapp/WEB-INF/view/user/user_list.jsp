<%--
  Created by IntelliJ IDEA.
  User: Sam
  Date: 2022/4/28
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
        <link rel="icon" href="/static/image/favicon.ico">
        <link rel="stylesheet" href="/static/css/user.css">
        <link rel="stylesheet" href="/static/css/font-awesome/css/font-awesome.css">
        <script rel="stylesheet" src="/static/js/jquery-3.6.0.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="/static/bootstrap3.4.1/css/bootstrap.min.css" crossorigin="anonymous">
        <link href="/static/bootstrap3.4.1/css/bootstrap-theme.min.css">
        <script src="/static/bootstrap3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="box">
    <h3>用户管理</h3>
    <div class="actions">
        <div>
            <a class="btn btn-primary" href="<c:url value="/view/rent/rent_add.jsp" />">添加用户信息</a>
        </div>
    </div>
    <table class="list">
        <tr>
            <th>序号</th>
            <th>用户名</th>
            <th>用户密码</th>
            <th>用户真实姓名</th>
            <th>系统角色</th>
            <th>添加时间</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${user.uname}</td>
                <td>${user.upassword}</td>
                <td>${user.urealname}</td>
                    <%--                <td>${user.role.roname}</td>--%>
                <td>
                    <c:forEach items="${user.roles}" var="role">
                        |&nbsp;${role.roname}
                    </c:forEach>
                </td>
                <td>${user.uaddTime}</td>
                <td>
                        <%--          <a class="fa fa-info" title="详情"--%>
                        <%--             href="<c:url value="/user/RentDetail?rid=${rent.rid}" />"></a>--%>
                    &nbsp;&nbsp;
                        <%--  <a class="fa fa-pencil" title="编辑"
                             href="<c:url value="/user/RentEdit?rid=${rent.rid}" />"></a>--%>
                    &nbsp;&nbsp;
                    <a class="fa fa-remove" title="删除" onclick="confirmDelete(${user.uid})"></a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div class="pager-info">
        <div>
            共有${total}条记录，第${pageNo}/${pageCount}页
        </div>
        <div>
            <ul class="pagination">
                <li class="paginate_button previous ${pageNo == 1 ? 'disabled' : ''}">
                    <a href="<c:url value="/user/UserList?pageNo=${pageNo-1}" />">上一页</a>
                </li>
                <c:forEach begin="1" end="${pageCount}" step="1" var="i">
                    <li class="${pageNo == i ? "paginate_button active" : ""}">
                        <a href="<c:url value="/user/UserList?pageNo=${i}" />">${i}</a>
                    </li>
                </c:forEach>
                <li class="paginate_button next ${pageNo == pageCount ? 'disabled' : ''}">
                    <a href="<c:url value="/user/UserList?pageNo=${pageNo+1}" />">下一页</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<script src="<c:url value="/lib/jquery/jquery.js" />"></script>
<script>
    function confirmDelete(id) {
        if (confirm("确定要删除吗？")) {
            window.location.href = "/user/UserDelete?uid=" + id;
        }
        return false;
    }
</script>
</body>
</html>
