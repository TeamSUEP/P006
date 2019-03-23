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
    <!--标题旁边的小icon-->
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
            <li class="nav-item active">
                <a class="nav-link" href="#">学生信息查询与修改</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="admin_teacherInfor.jsp">教师信息查询与修改</a>
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
        <h1>学生信息查询与修改</h1>
        <form action="../Admin_InforServlet?opttype=search&user_type=student&by=stuId" class="bg-light" method="post" role="form">
            <br>
            <label for="stuId">使用学生学号查询学生信息</label>
            <input required id="stuId" class="form-control" type="text" name="stuId" placeholder="请输入学生Id号">
            <br>
            <div class="text-center">
                <input type="submit" value="提交" class="btn btn-primary"style=" width: 30vh;
    height: 6vh;
    font-weight: bold;
    font-size: 3vh;"/>
            </div>
            <br>
        </form>
        <form action="../Admin_InforServlet?opttype=search&user_type=student&by=classno" class="bg-light" method="post" role="form">
            <br>
            <label for="classno">使用班级号查询学生信息</label>
            <input required id="classno" class="form-control" type="text" name="classno" placeholder="请输入班级号">
            <br>
            <div class="text-center">
                <input type="submit" value="提交" class="btn btn-primary"style=" width: 30vh;
    height: 6vh;
    font-weight: bold;
    font-size: 3vh;"/>
            </div>
            <br>
        </form>
        <form action="../Admin_InforServlet?opttype=repair&user_type=student" class="bg-light" method="post" role="form">
            <br>
            <label for="stuId2">修改学生信息</label>
            <input required id="stuId2" class="form-control" type="text" name="stuId" placeholder="请输入要修改学生的Id号">
            <br>
            <input required id="classId" class="form-control" type="text" name="classId" placeholder="请输入修改后班级号">
            <br>
            <input required id="stuName" class="form-control" type="text" name="stuName" placeholder="请输入修改后学生姓名">
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
        <c:forEach var="stu" items="${stulist}">

        <c:if test="${showhead == 0}">

        <thead>
        <tr>
            <th>学生ID号</th>
            <th>学生姓名</th>
            <th>学生班级号</th>
        </tr>
        </thead>

        <tbody>
        </c:if>

        <tr>
            <td>${stu.id}</td>
            <td>${stu.name}</td>
            <td>${stu.classno}</td>
        </tr>
        <c:set var="showhead" value="1"/>
        </c:forEach>
        </tbody>

    </table>
</main>
</body>
</html>
