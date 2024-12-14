<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<head>
<style>
body{
     background: url('images/repHom.jpg') no-repeat center center/cover;
}

</style>
</head>
<body>
<h1 style="color:white;text-align: center">EMPLOYEE UPDATE PAGE</h1>
<br><br>
<frm:form modelAttribute="emp">
  <table border="1" align="center" style="color:white;">
    <tr>
     <td>EMPLOYEE NAME</td>
     <td><frm:input path="ename" /></td>
    </tr>
    <tr>
     <td>EMPLOYEE JOB</td>
     <td><frm:input path="job"/></td>
    </tr>
    <tr>
     <td>EMPLOYEE SALARY</td>
     <td><frm:input path="sal"/></td>
    </tr>
    <tr>
     <td>EMPLOYEE DEPTNO</td>
     <td><frm:input path="deptno"/></td>
    </tr>
    <tr>
      <td><input type="submit" value="register"></td>
      <td><input type="reset" value="cancle"></td>
    </tr>
  </table>
  <a href="./"><img src="images/hom.jpg" width="150px" height="110px">HOME</a>
</frm:form>
</body>