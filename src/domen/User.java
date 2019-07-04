package domen;

public class User {
	String ime,prezime,password,username;
	private int status,id;
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User(String ime, String prezime, String password, String username, int status, int id) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.password = password;
		this.username = username;
		this.status = status;
		this.id = id;
	}
	public User() {
		super();
	}
	
}
