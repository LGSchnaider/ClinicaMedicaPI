package model;

public class MPatient extends MPerson {

	private long telefone;
	private MTyperGender sex;
	private String email;
	private int idPac;

	public int getIdPac() {
		return idPac;
	}

	public void setIdPac(int idPac) {
		this.idPac = idPac;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public MTyperGender getSexo() {
		return sex;
	}

	public void setSexo(MTyperGender sexo) {
		this.sex = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String toString() {
		// TODO Auto-generated method stub
		return nome;
	}
}
