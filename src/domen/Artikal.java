package domen;

public class Artikal {
	
	private int idArtikla;
	private String naziv;
	private double cena;
	private int idKategorije;
	private String nazivSlike;
	public int getIdArtikla() {
		return idArtikla;
	}
	public void setIdArtikla(int idArtikla) {
		this.idArtikla = idArtikla;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public int getIdKategorije() {
		return idKategorije;
	}
	public void setIdKategorije(int idKategorije) {
		this.idKategorije = idKategorije;
	}
	public String getNazivSlike() {
		return nazivSlike;
	}
	public void setNazivSlike(String nazivSlike) {
		this.nazivSlike = nazivSlike;
	}
	public Artikal() {
		super();
	} 
	
}
