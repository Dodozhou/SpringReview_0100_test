<%@ page contentType="text/html; charset=utf-8" import="java.sql.*" %>
<%@ page import="com.star.model.User" %>
<%@ page import="com.star.service.UserManager" %>
<html>

<body>
<%
    String name=request.getParameter("name");
    String password=request.getParameter("password");
    String password2=request.getParameter("password2");

    if (password.equals(password2))
    {
        Connection conn=null;
        PreparedStatement pstmt=null;
        User u=new User();
        UserManager um = new UserManager();

        u.setName(name);
        u.setPassword(password);
        if(um.exists(u)){
            response.sendRedirect("fail.jsp");
            return;
        }

        um.add(u);

    response.sendRedirect("success.jsp");
    }
    else    response.sendRedirect("fail.jsp");

%>

</body>

</html>