package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BD;

public class TipoDao extends CatProfissional {
private BD bd ;
String msg = "";
String sql ="";

public TipoDao() {
bd = new BD();
}

public String inserir(){

	if(bd.getConnection()){
		try{
			sql = "insert into categoria_prof (descricao) values (?)";
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setString(1,(getDescricao()));
				bd.st.executeUpdate();
				 
				return "Salvo com êxito";
			}catch(SQLException erro){
				return"falha na conexão"+erro.toString();
			}finally{
			bd.close();
			}
				
				
			}else{
				msg="falha na conexão com o banco de dados";
			}
	return msg;
	}

public String deletar(){
	
	if(bd.getConnection()){
		try{
			sql = "delete from categoria_prof where ID_categoria=?";
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setInt(1,(getCod_tipo()));
				bd.st.executeUpdate();
				 
				return "Excluído com êxito";
			}catch(SQLException erro){
				return"falha na conexão"+erro.toString();
			}finally{
			bd.close();
			}
				
				
			}else{
				msg="falha na conexão com o banco de dados";
			}
	return msg;
	}

public boolean localizar(int cod) {

	if(bd.getConnection()){
		try{
			sql = "select * from categoria_prof where id_categoria=?";
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, cod);
			bd.rs = bd.st.executeQuery();
			if(bd.rs.next()){
				return true; 
			}
		}
		catch(SQLException erro){
			return false;
		}
		
		
		
		
		finally{
			bd.close();
		}

	}
	else{
		System.out.println("Falha na conexão");
	}
	return false;
}

public String atualizar(){
	try{
		bd.getConnection();
		sql="UPDATE categoria_prof set descricao= ? where ID_categoria =?;";
		bd.st = bd.con.prepareStatement(sql);
		
		bd.st.setString(1, getDescricao());
		bd.st.setInt(2, getCod_tipo());

		bd.st.executeUpdate();
		return "Atualizado com êxito";
	}

	catch(SQLException e){
		return "Erro ao atualizar"+e;
	}

}




}





