<%@page import="java.sql.SQLException"%>
<%@page import="java.io.IOException"%>
<%@page import="banco.BD"%>
<%@page import="controller.PessoaDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>


<%
	System.out.println(request.getParameter("image"));
	String latlong = request.getParameter("teste");
	String lx = latlong.replace("(", "");
	String lat = null;
	String log = null;
	String ltlong = lx.replace(")", "");
	int tamanho = ltlong.length();
	for (int i = 0; i < tamanho; i++) {
		char v = ltlong.charAt(i);
		if (v == ',') {
			System.out.println(i);
			lat = ltlong.substring(0, i);
			log = ltlong.substring(i + 1, tamanho);
		}
	}

	double latitude = Double.parseDouble(lat);
	double longitude = Double.parseDouble(log);

	PessoaDao p = new PessoaDao();

	String nome = request.getParameter("nome");

	String email = request.getParameter("email");

	String telefone = request.getParameter("tel");

	String estado = request.getParameter("estado");

	String pais = request.getParameter("pais");

	String cidade = request.getParameter("cidade");


	String bairro = request.getParameter("bairro");

	String rua = request.getParameter("rua");

	String numero = (request.getParameter("num"));
	
	String senha = request.getParameter("senha");

	String confSenha = request.getParameter("Csenha");

	String cep = request.getParameter("cep");


	int t = 0;
	String tipo = null;
	BD bd = new BD();
	bd.getConnection();

	String pro = request.getParameter("profissao");
	System.out.println(pro);
	String sql = "select ID_categoria from categoria_prof where descricao = ?";
	try {
		bd.st = bd.con.prepareStatement(sql);

		bd.st.setString(1, pro);
		bd.rs = bd.st.executeQuery();
		bd.rs.next();
		tipo = bd.rs.getString("ID_categoria");
		t = Integer.parseInt(tipo);

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.toString());
	}

	System.out.println("tipo" + tipo);

	p.setNome_razsocial(nome);
	p.setEmail(email);
	p.setTel_cel(telefone);
	p.setEstado(estado);
	p.setPais(pais);
	p.setCidade(cidade);
	p.setBairro(bairro);
	p.setRua(rua);
	p.setCep(cep);
	p.setNum(Integer.parseInt(numero));
	p.setSenha(senha);
	p.setLatitude(latitude);
	p.setLongitude(longitude);
	p.setID_categoria(t);
	p.setCod_tipo(2);
	
if(p.localizar(p.getEmail())){
	out.println("Email já cadastrado!");
	
}else{
	out.println(p.inserir());
}
	
	
%>