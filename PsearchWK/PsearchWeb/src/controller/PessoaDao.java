package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import banco.BD;

public class PessoaDao extends Pessoa{

	private BD bd;
	String sql;
	String msg;
	public PessoaDao() {
		bd = new BD();
	}




	public String inserir(){

		sql ="insert into pessoa  ("
				/*1*/	+ "email "
				/*2*/	+ ",nome_razsocial"
				/*3*/	+ " ,tel_cel "
				/*4*/	+ ",pais "
				/*5*/	+ ",estado"
				/*6*/	+ " ,cidade"
				/*7*/	+ " ,bairro"
				/*8*/	+ " ,cep "
				/*9*/	+ ",rua "
				/*10*/	+ ",num"
				/*11*/	+ " ,latitude"
				/*12*/	+ " ,longitude "
				/*13*/	+ ",senha"
				/*14*/	+ " ,foto"
				/*15*/	+ " ,Cod_tipo"
				/*16*/	+ " ,ID_categoria)"
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try{
			bd.getConnection();
			bd.st=bd.con.prepareStatement(sql);
			
			bd.st.setString(1,getEmail());
			bd.st.setString(2,getNome_razsocial());
			bd.st.setString(3,getTel_cel());
			bd.st.setString(4,getPais());
			bd.st.setString(5,getEstado());
			bd.st.setString(6,getCidade());
			bd.st.setString(7,getBairro());
			bd.st.setString(8, getCep());
			bd.st.setString(9, getRua());
			bd.st.setInt(10,getNum());
			bd.st.setDouble(11,getLatitude());
			bd.st.setDouble(12,getLongitude());
			bd.st.setString(13,getSenha());
			bd.st.setString(14, getFoto());
			bd.st.setInt(15,getCod_tipo());
			bd.st.setInt(16, getID_categoria());
			bd.st.executeUpdate();
			/*Insersão de dados nos respectivos campos*/
			
	
			msg="Parabéns agora você está cadastrado no Psearch";



		}catch(SQLException erro){
			
			msg="Verifique se os campos foram preenchidos corretamente"+erro.toString()+bd.st;
		}


		finally{
		bd.close();
		}
		
		/*Retorna mensagem status de êxito ou erro*/
		return msg;
	}
	
	public static ResultSet getPro(){
	
	String sql ="select descricao from categoria_prof";
		BD bd = new BD();
		bd.getConnection();
		try{
			bd.st=bd.con.prepareStatement(sql);
			bd.st.executeQuery();
			
			
			
			}
		catch(SQLException erro){
			System.out.println(erro.toString());
		}
	
		return bd.rs;
	}
	
	
	
	public boolean localizar(String email) {
		sql = "select * from pessoa where email = ?";
		bd.getConnection();

		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, email);
			bd.rs = bd.st.executeQuery();
			if(bd.rs.next()){
			return true;
			}
		} catch (SQLException erro) {
			System.out.println(erro.toString());
		}
		return false;

	}
	
	
	
}
