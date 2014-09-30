<%@page import="banco.BD"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=800, user-scalable=no">
        
        <title>PSearch</title>

        <link rel="stylesheet" type="text/css" href="css/demo.css">
        <link rel="stylesheet" type="text/css" href="css/style1.css">
        <link rel="stylesheet" type="text/css" href="css/inicioCss.css" />
        <link rel="stylesheet" type="text/css" href="css/component.css" />
        <link rel="stylesheet" type="text/css" href="css/component2.css" />
        <link rel="stylesheet" type="text/css" href="css/component3.css" />
      
		<script type="text/javascript" src="js/modernizr.custom.86080.js"></script>
		
        <script type="text/javascript">
    

function AparecerDiv(){ // fun��o aparecer
    document.getElementById('Modalbusca').style.display = "block";
    // usamos o style.display para manupular o css da div e mostrar ela
}
 
function OcultarDiv(){  // fun��o ocultar
    document.getElementById("Modalbusca").style.display = "none";

    // usamos o style.display para manupular o css da div e ocultar ela
}

</script>


    </head>
    <body id="page">


        <ul class="cb-slideshow">
            <li><span>Image 01</span></li>
            <li><span>Image 02</span></li>
            <li><span>Image 03</span></li>
            <li><span>Image 04</span></li>
            <li><span>Image 05</span></li>
            <li><span>Image 06</span></li>
        </ul>

        <div id="cabecalho">

        	<img class="logo" src="images/LogoBranco.png">
        	
            <button id="btni" class="Btn Btn-2 Btn-2a">Entrar</button>

        		<span id="saibamais"><a class="saiba"href="#" >Saiba Mais</a></span>
    	</div>

    	<div id="linha">
    		
    	</div>

            <div class="conteudo">

                <button onclick="AparecerDiv()" class="btn btn-6 btn-6b" >Localizar Profissional</button>

            </div>

    	<div id="Modalbusca">
        <div id="ModalCab">
        	<img class="modalImage"src="images/ModalIcon.png">
        </div>

    		<form action="xmlcreate_map.jsp" method="post">

    			<input type="text" class="textbox" id="style" name="address" ><br/>
    			
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
    			
    	   <button onclick="OcultarDiv()" id="btnM"class="Bttn Bttn-3 Bttn-3a" action="xmlcreate_map.jsp">Localizar</button>
    		</form>
       
    	</div>
            
    
    
</body>
</html>