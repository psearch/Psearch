/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.54
 * Generated at: 2014-09-29 16:42:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controller.PessoaDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import banco.BD;

public final class cadastro_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"pt-br\">\r\n");
      out.write("<head>\r\n");
      out.write("<style>\r\n");
      out.write("html, body, #map-canvas {\r\n");
      out.write("\theight: 30%;\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("\tpadding: 0px\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#map-canvas {\r\n");
      out.write("\tmargin-top: -13%;\r\n");
      out.write("\tmargin-left: 60%;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<meta charset=\"UTF-8\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"_css/estilo.css\" />\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"http://maps.googleapis.com/maps/api/js?key=AIzaSyDfmXMCQ3dfJKd_wAKe4Gh0_JmgJNKD_EY&sensor=SET_FALSE\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\tvar geocoder;\r\n");
      out.write("\tvar map;\r\n");
      out.write("\tfunction initialize() {\r\n");
      out.write("\t\tgeocoder = new google.maps.Geocoder();\r\n");
      out.write("\t\tvar latlng = new google.maps.LatLng(-34.397, 150.644);\r\n");
      out.write("\r\n");
      out.write("\t\tvar mapOptions = {\r\n");
      out.write("\t\t\tzoom : 100,\r\n");
      out.write("\r\n");
      out.write("\t\t\tcenter : new google.maps.LatLng(-23.5505199, -46.63330939999997),\r\n");
      out.write("\r\n");
      out.write("\t\t};\r\n");
      out.write("\r\n");
      out.write("\t\tmap = new google.maps.Map(document.getElementById('map-canvas'),\r\n");
      out.write("\t\t\t\tmapOptions);\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction AparecerDiv() {\r\n");
      out.write("\t\tdocument.getElementById(\"\").style.display = \"block\";\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction codeAddress() {\r\n");
      out.write("\r\n");
      out.write("\t\tdocument.getElementById(\"address\").value = document\r\n");
      out.write("\t\t\t\t.getElementById('rua').value\r\n");
      out.write("\t\t\t\t+ \" \"\r\n");
      out.write("\t\t\t\t+ document.getElementById('numero').value\r\n");
      out.write("\t\t\t\t+ \" \"\r\n");
      out.write("\t\t\t\t+ document.getElementById('cidade').value\r\n");
      out.write("\t\t\t\t+ \" \"\r\n");
      out.write("\t\t\t\t+ document.getElementById('estado').value;\r\n");
      out.write("\r\n");
      out.write("\t\tvar address = document.getElementById('address').value;\r\n");
      out.write("\t\tgeocoder.geocode({\r\n");
      out.write("\t\t\t'address' : address\r\n");
      out.write("\t\t}, function(results, status) {\r\n");
      out.write("\t\t\tif (status == google.maps.GeocoderStatus.OK) {\r\n");
      out.write("\t\t\t\tmap.setCenter(results[0].geometry.location);\r\n");
      out.write("\t\t\t\tmarker = new google.maps.Marker({\r\n");
      out.write("\t\t\t\t\tmap : map,\r\n");
      out.write("\t\t\t\t\tposition : results[0].geometry.location\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"teste\").value = map.getCenter();\r\n");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t    document.getElementById(\"map-canvas\").style.visibility = \"visible\";\r\n");
      out.write("\t\t\t\t    \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\telse {\r\n");
      out.write("\t\t\t\talert('Erro ao obter coordenadas ' + status + geocoder);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction armazenarDescpro() {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tgoogle.maps.event.addDomListener(window, 'load', initialize);\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<title>PSearch</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"tudo\">\r\n");
      out.write("\r\n");
      out.write("\t\t<header id=\"topo\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t </header>\r\n");
      out.write("<header id=\"menu\">\r\n");
      out.write("<a  class=\"buttons\" href=\"inicio.html\">Início</a> <a  class=\"buttons\" href=\"ranking.html\">Ranking</a> <a\r\n");
      out.write("\t\t\t\thref=\"sobreNos.html\"  class=\"buttons\" >Sobre Nós</a> <a class=\"buttons\"  href=\"faleConosco.html\">Fale\r\n");
      out.write("\t\t\t\tConosco</a>\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<article id=\"conteudo\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<form action=\"actionCadastrojsp.jsp\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tNome/Razão Social: <input class=\"textbox\" name=\"nome\" type=\"text\" value=\"\"\r\n");
      out.write("\t\t\t\t\tsize=\"30 maxlength=\" 50\"/><br /> E-mail: <input  class=\"textbox\" type=\"email\"\r\n");
      out.write("\t\t\t\t\tname=\"email\" size=\"30\" maxlength=\"50\" /><br /> Telefone: <input class=\"textbox\"\r\n");
      out.write("\t\t\t\t\ttype=\"text\" id=\"tel\" name=\"tel\" size=\"30\" maxlength=\"50\" />\r\n");
      out.write("\t\t\t\t\tEstado: <select  class=\"textbox\" id='estado' name='estado'>\r\n");
      out.write("\t\t\t\t\t");

					BD bd = new BD();
						bd.getConnection();
						String sqluf = "select ds_uf_sigla from uf";
						bd.st = bd.con.prepareStatement(sqluf);
						bd.rs = bd.st.executeQuery();
						while (bd.rs.next()) {
							out.println("<option value =" + bd.rs.getString("ds_uf_sigla")
									+ ">" + bd.rs.getString("ds_uf_sigla") + "</option>");
						}
					
      out.write("\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write(" País: <input class=\"textbox\" type=\"text\" id=\"pais\" name=\"pais\"\r\n");
      out.write("\t\t\t\t\tsize=\"30\" maxlength=\"50\" /><br /> Cidade: <input type=\"text\" class=\"textbox\"\r\n");
      out.write("\t\t\t\t\tid=\"cidade\" name=\"cidade\" size=\"30\" maxlength=\"50\" /> Bairro: <input class=\"textbox\"\r\n");
      out.write("\t\t\t\t\ttype=\"text\" id=\"bairro\" name=\"bairro\" size=\"30\" maxlength=\"50\" /><br />\r\n");
      out.write("\t\t\t\tCEP: <input class=\"textbox\"  type=\"text\" id=\"cep\" name=\"cep\" size=\"30\" maxlength=\"50\" /><br />\r\n");
      out.write("\t\t\t\tRua: <input class=\"textbox\" type=\"text\" id=\"rua\" name=\"rua\" size=\"30\" maxlength=\"50\" /><br />\r\n");
      out.write("\t\t\t\tNumero: <input class=\"textbox\" type=\"text\" id=\"numero\" name=\"num\" size=\"30\"\r\n");
      out.write("\t\t\t\t\tmaxlength=\"50\" /><br /> Senha: <input class=\"textbox\"  type=\"password\" name=\"senha\"\r\n");
      out.write("\t\t\t\t\tsize=\"30\" maxlength=\"50\" /><br /> <select class=\"textbox\"  action=\"cadastro.jsp\"\r\n");
      out.write("\t\t\t\t\tname=\"profissao\">\r\n");
      out.write("\t\t\t\t\t<option>Selecione uma profissão</option>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t");

				
					
			
						String sql = "select descricao from categoria_prof";
						bd.st = bd.con.prepareStatement(sql);
						bd.rs = bd.st.executeQuery();
						while (bd.rs.next()) {

							out.println("<option value=" + bd.rs.getString("descricao")
									+ ">" + bd.rs.getString("descricao") + "</option>");
						}
						
					
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</select> Confirmar Senha: <input  class=\"textbox\" type=\"password\" name=\"Csenha\" size=\"30\"\r\n");
      out.write("\t\t\t\t\tmaxlength=\"50\" /><br /> <input class=\"textbox\" id=\"address\"\r\n");
      out.write("\t\t\t\t\t type=\"textbox\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- Campo escondido que junta os dados do endereco -->\r\n");
      out.write("\t\t\t\t<input class=\"textbox\" type=\"text\" id=\"teste\" style=\"visibility: hidden\"\r\n");
      out.write("\t\t\t\t\tname=\"teste\">\r\n");
      out.write("\t\t\t\t<!-- campo escondido que armazena latitude e longitude -->\r\n");
      out.write("\t\t\t\t <input class=\"textbox\" type=\"submit\" value=\"cadastrar\" /> <input type=\"reset\"\r\n");
      out.write("\t\t\t\t\tvalue=\"limpar\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div style=\"visibility: hidden\"id=\"map-canvas\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<button onclick=\"codeAddress()\">Verificar endereço</button>\r\n");
      out.write("\r\n");
      out.write("\t\t</article>\r\n");
      out.write("\r\n");
      out.write("\t\t<footer id=\"rodape\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t</footer>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}