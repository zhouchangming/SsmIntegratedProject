<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	

  </head>
  
  <body>
             <form action="${pageContext.request.contextPath}/login.handler" method="post"> 
               
                  <table>
                   
                    <tr>
                      <td >用户名</td>
                      <td><input  type="text" name="username" /></td>
                    </tr>
                    
                    <tr>
                      <td>密　码</td>
                      <td><input  type="password" name="password"  /></td>
                    </tr>
                    <tr>
                    	<td></td>
                    	<td><input type="submit" value="提交" ></td>
                    </tr>
                    
                 </table>
              </form>
           
		
  </body>
</html>
	