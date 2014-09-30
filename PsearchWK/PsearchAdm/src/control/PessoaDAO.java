package control;

import java.sql.SQLException;

import model.BD;

public class PessoaDAO extends Pessoa {

	String sql = "";
	String msg = "";
	private BD bd;

	public PessoaDAO() {

		bd = new BD();

	}

	public String inserir() {
		bd.getConnection();

		try {
			sql = "Insert into pessoa (email," + "nome_razsocial," + "tel_cel,"
					+ "pais," + "estado," + "cidade," + "bairro" + ",cep"
					+ ",rua" + ",num" + ",senha" + ",Cod_tipo) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, getEmail());
			bd.st.setString(2, getNome_razsocial());
			bd.st.setString(3, getTel_cel());
			bd.st.setString(4, getPais());
			bd.st.setString(5, getEstado());
			bd.st.setString(6, getCidade());
			bd.st.setString(7, getBairro());
			bd.st.setString(8, getCep());
			bd.st.setString(9, getRua());
			bd.st.setInt(10, getNum());
			bd.st.setString(11, getSenha());
			bd.st.setInt(12, getCod_tipo());
			bd.st.executeUpdate();

			msg = "Salvo com êxito";
			return msg;

		} catch (SQLException erro) {

			return erro.toString();

		} finally {
			bd.close();
		}

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

	public boolean Autenticarr(String email, String senha) {

		if (bd.getConnection()) {
			try {
				sql = "select * from pessoa where  email=? and senha =?";
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setString(2, email);
				bd.st.setString(1, senha);
				bd.rs = bd.st.executeQuery();
				System.out.println(bd.st);
				if (bd.rs.next()) {
					System.out.println("deu certo");
					return true;
				}
			} catch (SQLException erro) {
				System.out.println(erro.toString());
				return false;
			}

			finally {
				bd.close();
			}

		}

		return false;

	}

	public String deletar() {
		sql = "delete from pessoa where email = ?";
		bd.getConnection();
		try {
			bd.st.setString(1, getEmail());

			bd.st = bd.con.prepareStatement(sql);
			bd.st.executeUpdate();
			msg = "Excluido com exito";
			return msg;
		} catch (SQLException erro) {
			msg = "Falha ao excluir";
			return msg + erro.toString();
		} finally {
			bd.close();
		}

	}

}
