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
            <li class="nav-item">
                <a class="nav-link" href="teacher_infor.jsp">通知公告<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="#">查看实验<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="teacher_assignment.jsp">布置实验</a>
            </li>
            <li class="nav-item ">
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
        <h1>查询实验情况</h1>
        <form action="../ExperimentServlet" class="bg-light" method="post" role="form">
            <br>
            <label for="class_search">按班级号查询实验情况</label>
            <input type=hidden name="opttype" value="class"/>
            <input required id="class_search" class="form-control" type="text" name="classno" placeholder="请输入班级号">
            <br>
            <input required class="form-control" type="text" name="courseId" placeholder="请输入课程号">
            <br>
            <div class="text-center">
                <input type="submit" value="提交" class="btn btn-primary" style=" width: 30vh;
    height: 6vh;
    font-weight: bold;
    font-size: 3vh;"/>
            </div>
        </form>
        <form action="../ExperimentServlet" class="bg-light" method="post" role="form">
            <label for="sno_search">按学生学号查询实验情况</label>
            <input type=hidden name="opttype" value="sno"/>
            <input required id="sno_search" class="form-control" type="text" name="sno" placeholder="请输入学生学号">
            <br>
            <input required class="form-control" type="text" name="courseId" placeholder="请输入课程号">
            <br>
            <div class="text-center">
                <input type="submit" value="提交" class="btn btn-primary" style=" width: 30vh;
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
