<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh">
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
                <a class="nav-link" href="Stu_infor.jsp">通知公告</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="#">我的实验<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Stu_passwdRepair.jsp">密码修改</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="../login.jsp">退出系统</a>
            </li>
        </ul>
    </div>
</nav>

<main role="main" class="container">
    <div>
    <table class="table table-light table-hover table-bordered">
        <thead>
        <tr>
            <th>序</th>
            <th>实验名称</th>
            <th>实验要求</th>
            <th>实验内容</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="e" items="${eList}">
            <tr>
                <td>${e.id}</td>
                <td>${e.exp_name}</td>
                <td>${e.demand}</td>
                <c:if test="${e.content == null}">
                    <td>${e.content}</td>
                </c:if>
                <c:if test="${e.content != null}">
                <td><a href="../DownloadServlet?fileName=${e.content}">查看内容</a></td>
                </c:if>
                <c:if test="${e.upload == true }">
                    <td>已上传</td>
                    <td>
                        <a href="../DownloadServlet?fileName=${e.location}" methods="post">查看报告</a>
                        <a href="../jumpServlet?opttype=upload&exp_id=${e.id}&courseId=${e.courseId}" methods="post">再传报告</a>
                    </td>
                </c:if>
                <c:if test="${e.upload == false }">
                    <td>报告未上传</td>
                    <td>
                        <a href="../jumpServlet?opttype=upload&exp_id=${e.id}&courseId=${e.courseId}" methods="post">上传实验报告</a>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
</main>
</body>
</html>