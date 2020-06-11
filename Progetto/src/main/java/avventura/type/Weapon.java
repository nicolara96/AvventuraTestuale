package avventura.type;

import java.util.Set;

public class Weapon extends AdventureObject {

	private int danni;
	
	public Weapon(int id) {
		super(id);
	}

	public Weapon(int id, String name, String description, Set<String> alias) {
		super(id, name, description, alias);
	}

	public Weapon(int id, String name, String description) {
		super(id, name, description);
	}

	public Weapon(int id, String name) {
		super(id, name);
	}
	
	public Weapon(int id, String name, String description, Set<String> alias, int danni) {
		super(id, name, description, alias);
		this.danni = danni;
	}

	public int getDanni() {
		return danni;
	}

	public void setDanni(int danni) {
		this.danni = danni;
	}
	
}
