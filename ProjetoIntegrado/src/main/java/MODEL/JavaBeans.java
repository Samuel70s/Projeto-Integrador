package MODEL;



public class JavaBeans {
	private String idcon;
	private String email;
	private String senha;
	
	
	
	public JavaBeans(String id, String email , String senha) {
		super();
		this.email = email;
		this.senha = senha;
		this.idcon = id;
	}

	public JavaBeans() {
		super();

	}
	
	public String getIdcon() {
		return idcon;
	}

	public void setIdcon(String idcon) {
		this.idcon = idcon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
