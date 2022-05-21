<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>用户登录</title>
  <link rel="shortcut icon" href="img/bitbug_favicon.ico">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="style.css">
  <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="js/bootstrap.js"></script>
</head>
<body>
<div class="container demo">
  <div class="row">
    <div class="col-sm-1 col-lg-8">
      <img class="d-block w-100" src="img/loginlogo.jpg" style="object-fit: cover;" alt="">
    </div>
    <div class="col-sm-1 col-lg-4">
      <form action="LoginServlet" method="post" role="form">
        <br>
        <h3 class="text-center">上海电力大学</h3>
        <h3 class="text-center">计算机学院实验管理系统</h3>
        <br>
        <div>
          <input type="text" placeholder="请输入编号" class="form-control" name="id" required>
          <br>
          <input type="password" placeholder="请输入密码" class="form-control" name="password" required />
          <br>
          <select name="user_type" class="form-control" required>
            <option value="students">学生</option>
            <option value="teachers">教师</option>
            <option value="admins">管理员</option>
          </select>
          <br>
          &nbsp;&nbsp;&nbsp;&nbsp;
          <input type="submit" value="登录" class="btn btn-primary "/>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>