package avventura.type;

public class CharacterAdventure {

	private int vita;
	
	private Weapon armaEquipaggiata = null;

	public CharacterAdventure(int vita) {
		this.vita = vita;
	}

	public CharacterAdventure(int vita, Weapon armaEquipaggiata) {
		this.vita = vita;
		this.armaEquipaggiata = armaEquipaggiata;
	}

	public int getVita() {
		return vita;
	}

	public void setVita(int vita) {
		this.vita = vita;
	}

	public Weapon getArmaEquiqaggiata() {
		return armaEquipaggiata;
	}

	public void setArmaEquiqaggiata(Weapon armaEquipaggiata) {
		this.armaEquipaggiata = armaEquipaggiata;
	}
	
	public void danneggiato(int danni) {
		this.vita -= danni;
	}
}
