package controller;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pontos")
public class Pessoa {

	private String email;
	private String 	nome_razsocial;
	private String  pais;
	private String  estado;
	private String  cidade;
	private String  bairro;
	private String  cep;
	private String 	rua;
	private int 	num;
	private double  latitude;
	private double 	longitude;
	private String  senha;
	private String  foto;
	private int Cod_tipo;
	private int ID_categoria;
	
	public int getID_categoria() {
		return ID_categoria;
	}
	public void setID_categoria(int iD_categoria) {
		ID_categoria = iD_categoria;
	}
	public int getCod_tipo() {
		return Cod_tipo;
	}
	public void setCod_tipo(int cod_tipo) {
		Cod_tipo = cod_tipo;
	}
	private String categoria;

	private String tel_cel;



	@XmlElement(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@XmlElement(name="nome")
	public String getNome_razsocial() {
		return nome_razsocial;
	}
	public void setNome_razsocial(String nome_razsocial) {
		this.nome_razsocial = nome_razsocial;
	}


	@XmlElement(name="telefone")
	public String  getTel_cel() {
		return tel_cel;
	}

	public void setTel_cel(String tel_cel) {
		this.tel_cel = tel_cel;
	}
	@XmlElement(name="pais")
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	@XmlElement(name="estado")
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@XmlElement(name="cidade")
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	@XmlElement(name="bairro")
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	@XmlElement(name="cep")
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	@XmlElement(name="rua")
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	@XmlElement(name="num")
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@XmlElement(name="latitude")
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double d) {
		this.latitude = d;
	}
	@XmlElement(name="Longitude")
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double d) {
		this.longitude = d;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@XmlElement(name="foto")
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}


	@XmlElement(name="profissao")
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoriapro) {
		categoria = categoriapro;
	}


}
