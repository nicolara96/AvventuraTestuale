package avventura.type;

public class Monster {

	private int vita;
	
	private int danni;

	public Monster(int vita) {
		this.vita = vita;
	}

	public Monster(int vita, int danni) {
		this.vita = vita;
		this.danni = danni;
	}

	public int getVita() {
		return vita;
	}

	public void setVita(int vita) {
		this.vita = vita;
	}

	public int getDanni() {
		return danni;
	}

	public void setDanni(int danni) {
		this.danni = danni;
	}
	
	public void danneggiato(int danni) {
		this.vita -= danni;
	}
	
}
