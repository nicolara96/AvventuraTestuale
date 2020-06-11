package avventura.type;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AdventureObject {

	private final int id;
	
	private String name;
	
	private String description;
	
	private Set<String> alias;
	
	private boolean openable = false;
	
	private boolean pickupable = false;
	
	private boolean pushable = false;
	
	private boolean open = false;
	
	private boolean push = false;

	public AdventureObject(int id) {
		this.id = id;
	}

	public AdventureObject(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public AdventureObject(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public AdventureObject(int id, String name, String description, Set<String> alias) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.alias = alias;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<String> getAlias() {
		return alias;
	}

	public void setAlias(Set<String> alias) {
		this.alias = alias;
	}

	public boolean isOpenable() {
		return openable;
	}

	public void setOpenable(boolean obenable) {
		this.openable = obenable;
	}

	public boolean isPickupable() {
		return pickupable;
	}

	public void setPickupable(boolean pickupable) {
		this.pickupable = pickupable;
	}

	public boolean isPushable() {
		return pushable;
	}

	public void setPushable(boolean pushable) {
		this.pushable = pushable;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isPush() {
		return push;
	}

	public void setPush(boolean push) {
		this.push = push;
	}
	
	public void setAlias(String[] alias) {
        this.alias = new HashSet<>(Arrays.asList(alias));
    }

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AdventureObject other = (AdventureObject) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}
	
	
}
