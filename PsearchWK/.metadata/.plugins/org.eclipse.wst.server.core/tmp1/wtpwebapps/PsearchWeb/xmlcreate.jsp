<%@page import="java.util.Timer"%>
<%@page import="java.io.File"%>
<%@page import="controller.XmlCreate"%>
<%@page import="java.sql.SQLException"%>
<%@page import="banco.BD"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

String sql ="select  ID_categoria from categoria_prof where descricao = ? ";
int categoria = 0;
BD bd = new BD();
try{
bd.getConnection();
bd.st=bd.con.prepareStatement(sql);
bd.st.setString(1, request.getParameter("profissao"));
bd.rs=bd.st.executeQuery();
bd.rs.next();
categoria= bd.rs.getInt("ID_categoria");
XmlCreate c = new XmlCreate();
c.gerarXML(categoria,"E:/PsearchWK/PsearchWeb/WebContent");
Thread.sleep( 7 * 1000 );
}catch(SQLException erro){
	System.out.println(erro.toString());
}

	String redirectURL = "map.jsp";
    response.sendRedirect(redirectURL);
     
%>

</body>
</html>