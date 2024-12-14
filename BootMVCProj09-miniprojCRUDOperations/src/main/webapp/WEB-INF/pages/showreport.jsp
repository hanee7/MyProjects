<%@ page language="java"  isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="frm" %>

<head>
<style>
body{
     background: url('images/repHom.jpg') no-repeat center center/cover;
}

</style>
</head>
<body>
<div>

<frm:choose>
  <frm:when test="${!empty empList}">
      <h1 style="color:white;text-align: center">EMPLOYEE REPORT PAGE</h1>

     <table border="1" align="left" style="color:white; width: 600px; height: 900px">
       
       <tr>
         <th>EMPNO</th><th>ENAME</th><th>JOB</th><th>SAL</th><th>DEPTNO</th>
       </tr>
       
       <frm:forEach var="emp" items="${empList}">
         
         <tr>
           <td>${emp.empno}</td> <td>${emp.ename}</td>
           <td>${emp.job}</td> <td>${emp.sal}</td> <td>${emp.deptno}</td>
           
           <td><a href="edit?empno=${emp.empno}" onclick="return confirm('Do You Want To Delete This Record')"><img src="images/edit.jpg" width="30px" height="30px"></a>
               <a href="delete?empno=${emp.empno}" onclick="return confirm('Do You Want To Update This Record')"><img src="images/delete.jpg" width="30px" height="30px"></a></td>
           </tr> 
      </frm:forEach>
      </table> <br><br><br>   <h2 style="color: red;text-align: center">${resultMsg}</h2>
         
  </frm:when>

   <frm:otherwise>
    <h1>DATA NOT FOUND</h1>
   </frm:otherwise>
</frm:choose>
   </div>
 <div>
<center style="text-align: center;">
<br><br><br><br><br><br>
<a href="add"><img src="images/add.jpg" width="100px" height="100px">ADD</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="./"><img src="images/hom.jpg" width="150px" height="110px">HOME</a>
</center>
</div>
</body>