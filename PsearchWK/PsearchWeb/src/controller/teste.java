package controller;

import java.sql.SQLException;

import banco.BD;

public class teste {

	public static void main(String[] args) throws SQLException  {
	
		
		XmlCreate c = new XmlCreate();
		c.gerarXmlUser("J:/PsearchWK/PsearchWeb/WebContent", "Rua silvio candello nº2259");
		
		
}
}