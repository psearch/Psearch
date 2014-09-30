<%@page import="banco.BD"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="pt-br">
<head>
	<meta HTTP-EQUIV="Pragma" CONTENT="no-cache" />  
<meta HTTP-EQUIV="Cache-control" CONTENT="no-cache" />  
<meta HTTP-EQUIV="Expires" CONTENT="0" />  

	<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<link rel="stylesheet" type="text/css" href="_css/inicioCss.css" />
		<link rel="stylesheet" type="text/css" href="_css/component.css" />
		<link rel="stylesheet" type="text/css" href="_css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="_css/btlogin.css" />

	<title>PSearch</title>
</head>
<body>
	<div id="tudo">	

		<div id="imagem">
		</div>
		<form action="xmlcreate.jsp" method="get">
		<div id="conteudo">

				<input type="text"   id="style" class="textbox" name="Mlocalizacao" size="30" maxlength="50" >
					<select name="profissao" id="style2" class="selectbox">
			
						<%
					BD bd = new BD();
					bd.getConnection();
					String sql = "select descricao from categoria_prof";
					bd.st = bd.con.prepareStatement(sql);
					bd.rs = bd.st.executeQuery();
					while (bd.rs.next()) {

						out.println("<option value=" + bd.rs.getString("descricao")
								+ ">" + bd.rs.getString("descricao") + "</option>");
					}
				%>
						
					</select>	
		</div>	
		
				<button upddate="pontos.xml" class="btn btn-6 btn-6b" action="map.jsp" >Localizar Profissional</button>
	</form>
	
	</div>
</body>
</html>