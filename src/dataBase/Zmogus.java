package dataBase;

public class Zmogus {
	
	private int id;
	private String vardas, pavarde;
	
	public Zmogus(){
	}
	
	/*public Zmogus(String vardas, String pavarde) {
		this.vardas = vardas;
		this.pavarde = pavarde;
	}*/
	
	public Zmogus(int id, String vardas, String pavarde) {
		this.id = id;
		this.vardas = vardas;
		this.pavarde = pavarde;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVardas() {
		return vardas;
	}

	public void setVardas(String vardas) {
		this.vardas = vardas;
	}

	public String getPavarde() {
		return pavarde;
	}

	public void setPavarde(String pavarde) {
		this.pavarde = pavarde;
	}
	
	
	

}
