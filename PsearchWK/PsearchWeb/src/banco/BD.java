package banco;

import java.sql.*;

public class BD {
	//Classes para manipula��o do banco de dados

	public Connection con =null;//Utiliza o Driver para se conectar ao MySQL
	public PreparedStatement st;//Executa instru��es no banco
	public ResultSet rs = null;//Recebe o resultado

	private final String  DRIVER="com.mysql.jdbc.Driver";// caminho do Driver jdbc=Java Data Base Conector
	private final String DATABASENAME ="psearch";
	private final String URL = "jdbc:mysql://localhost:3306/"+DATABASENAME;//endere�o do banco de dados
	private String LOGIN ="root";// usu�rio padr�o mysql
	private final String SENHA="1234";

	/*
	 * Realiza a conex�o ao banco de dados
	 * return true em caso de sucesso ou false em caso contr�rio
	 */
	public  boolean getConnection(){
		try{
			Class.forName(DRIVER);// carrega o driver/carrega calasse no tempo de execu��o 
			//System.out.println("Driver carregado!");
			con=DriverManager.getConnection(URL,LOGIN,SENHA);//Efetua login
			System.out.println("Conectou...");
			return true;
		}
		catch(ClassNotFoundException erro){ //Classe n�o localizada
			System.out.println("Driver n�o localizado");
			return false;
		}
		catch(SQLException erro){// Erro na conex�o
			System.out.println("Falha na conex�o ao banco!"+erro);
			erro.toString();
			return false;
		}
	}
	public void close(){//Encerra a conex�o ao banco de dados
				try{
					if(rs!=null)rs.close();
				}catch(SQLException erro){}
				try{
					if(st!=null)st.close();
				}catch(SQLException erro){}
				try{
					if( con!=null)con.close();
					System.out.println("Desconectou");
				}catch(SQLException erro){}
	}
	
	

	public static void main(String[] args) {//lembre-se o endere�o deve est�r correto

		BD bd = new BD();
		bd.getConnection();
		bd.close();
	


	}





}
