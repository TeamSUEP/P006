<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!--width=device-width 表示宽度是设备屏幕的宽度。-->
    <!--initial-scale=1 表示初始的缩放比例。-->
    <!--shrink-to-fit=no 自动适应手机屏幕的宽度。-->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../img/bitbug_favicon.ico">
    <!--标题旁边的小icon-->
    <title>课程实验管理</title>
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/navbar-top-fixed.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="../js/bootstrap.js"></script>
</head>

<body>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">Hi,${name}</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
            aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
                <a class="nav-link" href="Stu_infor.jsp">通知公告</a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="../courseServlet">我的实验</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="#">密码修改<span class="sr-only">(current)</span></a>
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
        <h1>个人密码修改</h1>
        <form action="../PasswdRepairServlet" class="bg-light" method="post" role="form">
            <input type=hidden name="opttype" value="repair"/>
            <br>
            <label for="pwd2">新密码</label>
            <input required id="pwd2" class="form-control" type="password" name="newPassword" placeholder="输入新密码">
            <br>
            <label for="pwd3">确认新密码</label>
            <input required id="pwd3" class="form-control" type="password" name="newPassword2" placeholder="确认新密码">
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
</main>
</body>
</html>
