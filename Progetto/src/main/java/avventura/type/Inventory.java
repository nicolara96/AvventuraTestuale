package avventura.type;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

	private List<AdventureObject> list = new ArrayList<>();

	public List<AdventureObject> getList() {
		return list;
	}

	public void setList(List<AdventureObject> list) {
		this.list = list;
	}
	
	public void add(AdventureObject o) {
		list.add(o);
	}
	
	public void remove(AdventureObject o) {
		list.remove(o);
	}
}
