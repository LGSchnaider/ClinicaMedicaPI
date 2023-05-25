package modelo;

public class MPatient extends MPerson {

	private long telefone;
	private MTyperGender sexo;
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
		return sexo;
	}

	public void setSexo(MTyperGender sexo) {
		this.sexo = sexo;
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
