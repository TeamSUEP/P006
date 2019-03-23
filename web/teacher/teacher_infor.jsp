<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <li class="nav-item active">
                <a class="nav-link" href="#">通知公告<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="teachar_exper.jsp">查看实验</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="teacher_assignment.jsp">布置实验</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Teaxher_passRepair.jsp">密码修改</a>
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
        <h1>通知公告</h1>
        <div class="card-columns">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">最新公告</h4>
                    <p class="card-text">本系统目前处于调试阶段,由于程序、服务器、网络等问题都可能导致系统不能正常运行</p>
                </div>
                <div class="card-footer">
                    <p class="card-text">2018-11-12</p>
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">关于实验报告上传的说明</h4>
                    <p class="card-text">请大家于近日将实验报告上传至系统,上传文件名中不能带有如"()"等字符,可能导致上传失败</p>
                </div>
                <div class="card-footer">
                    <p class="card-text">2018-11-12</p>
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    <h4 class="crad-title">最新通知</h4>
                    <p class="card-text"></p>
                </div>
                <div class="card-footer">
                    <p class="card-text">2018-11-20</p>
                </div>
            </div>
        </div>
    </div>
</main>
</body>
</html>
