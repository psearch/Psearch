<%@page import="controller.AvaliacaoDao"%>
<%@page import="java.sql.SQLException"%>
<%@page import="banco.BD"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Avalia��o</title>
</head>
<body>
<% 
String email = request.getParameter("mailOculto");
int tamanho = email.length();
String e = email.substring(0, tamanho-1);
System.out.println(request.getParameter(e));
AvaliacaoDao a = new AvaliacaoDao();
float valor = Float.parseFloat(request.getParameter("stars"));
a.setEmail_pessoa(e);
a.setValor_avaliacao(valor);
a.avaliar();
response.sendRedirect("avaliacao.jsp");
%>
</body>
</html>