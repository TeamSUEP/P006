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
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="alert alert-warning">
                            <h4>上传&nbsp;<strong style="color:blue">&lt;&lt;JAVA EE&gt;&gt;&nbsp;&nbsp;${exp_name}&nbsp;</strong>报告</h4>
                            <h5><strong>(报告大小限制1M以内，可以压缩并将压缩后的文件上传)</strong></h5>
                        </div>
                    </div>
                    <div class="panel-body">
                        <Form action="../UploadServlet?opptype=upload" method="post" ENCTYPE="multipart/form-data">
                            <div class="form-group">
                                <input class="form-control" type="file" name="file1" />
                                <br />
                                <input class="btn btn-primary" type="submit" value="上&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;传" />
                                &nbsp;&nbsp;&nbsp;<a class="btn btn-primary"  href="Stu_Experiment.jsp" >返&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;回</a>
                            </div>
                        </Form>
                    </div>
                </div>
            </div>
        </div>

    </div>
</main>
</body>
</html>
