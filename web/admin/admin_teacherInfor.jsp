<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../img/bitbug_favicon.ico">
    <title>课程实验管理</title>
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/navbar-top-fixed.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="../js/bootstrap.js"></script>
</head>

<body>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">Hi,${name}</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
                <a class="nav-link" href="admin_infor.jsp">通知公告<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="admin_studentInfor.jsp">学生信息查询与修改</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="#">教师信息查询与修改</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="adimin_adduser.jsp">添加用户</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="admin_passRepair.jsp">重置密码</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="../login.jsp">退出系统</a>
            </li>
        </ul>
    </div>
</nav>

<main role="main" class="container">
    <div class="jumbotron">
        <!--大屏幕-->
        <h1>教师信息查询与修改</h1>
        <form action="../Admin_InforServlet?opttype=search&user_type=teacher" class="bg-light" method="post" role="form">
            <br>
            <label for="teaId">查询教师信息</label>
            <input required id="teaId" class="form-control" type="text" name="teaId" placeholder="请输入教师Id号">
            <br>
            <div class="text-center">
                <input type="submit" value="提交" class="btn btn-primary"style=" width: 30vh;
    height: 6vh;
    font-weight: bold;
    font-size: 3vh;"/>
            </div>
            <br>
        </form>
        <form action="../Admin_InforServlet?opttype=repair&user_type=teacher" class="bg-light" method="post" role="form">
            <br>
            <label for="teaId2">修改教师信息</label>
            <input required id="teaId2" class="form-control" type="text" name="teaId" placeholder="请输入要修改教师Id号">
            <br>
            <input required id="teaName" class="form-control" type="text" name="teaName" placeholder="请修改后的教师姓名">
            <br>
            <div class="text-center">
                <input type="submit" value="提交" class="btn btn-primary"style=" width: 30vh;
    height: 6vh;
    font-weight: bold;
    font-size: 3vh;"/>
            </div>
            <br>
        </form>
    </div>
    <table class="table table-light table-hover table-bordered">
        <c:set var="showhead" value="0"/>
        <c:forEach var="tea" items="${tealist}">
        <c:if test="${showhead == 0}">
        <thead>
        <tr>
            <th>教师ID号</th>
            <th>教师姓名</th>
        </tr>
        </thead>
        <tbody>
        </c:if>
        <tr>
            <td>${tea.id}</td>
            <td>${tea.name}</td>
        </tr>
        <c:set var="showhead" value="1"/>
        </c:forEach>
        </tbody>
    </table>
</main>
</body>
</html>