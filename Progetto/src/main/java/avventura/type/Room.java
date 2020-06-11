package avventura.type;

import java.util.ArrayList;
import java.util.List;

public class Room {

	private final int id;
	
	private String name;
	
	private String description;
	
	private String look;
	
	private boolean visible = true;
	
	private Room north = null;
	
	private Room east = null;
	
	private Room west = null; 
	
	private Room south = null;
	
	private final List<AdventureObject> object = new ArrayList<AdventureObject>();
	
	private final List<Monster> monster = new ArrayList<Monster>();

	private final List<CharacterAdventure> player = new ArrayList<CharacterAdventure>();

	public List<Monster> getMonster() {
		return monster;
	}

	public Room(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Room(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
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

	public String getLook() {
		return look;
	}

	public void setLook(String look) {
		this.look = look;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Room getNorth() {
		return north;
	}

	public void setNorth(Room north) {
		this.north = north;
	}

	public Room getEast() {
		return east;
	}

	public void setEast(Room east) {
		this.east = east;
	}

	public Room getWest() {
		return west;
	}

	public void setWest(Room west) {
		this.west = west;
	}

	public Room getSouth() {
		return south;
	}

	public void setSouth(Room south) {
		this.south = south;
	}

	public List<AdventureObject> getObject() {
		return object;
	}

	public List<CharacterAdventure> getPlayer() {
		return player;
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
		Room other = (Room) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	
}
