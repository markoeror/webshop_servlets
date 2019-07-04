package domen;

public enum constants {
	USER(1),ADNIM(0);
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private constants(int id) {
		this.id = id;
	}
}
