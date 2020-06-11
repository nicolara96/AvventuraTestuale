package avventura.type;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AdventureObjectContainer extends AdventureObject{

	private List<AdventureObject> list = new ArrayList<>();

	public AdventureObjectContainer(int id, String name, String description, Set<String> alias) {
		super(id, name, description, alias);
	}

	public AdventureObjectContainer(int id, String name, String description) {
		super(id, name, description);
	}

	public AdventureObjectContainer(int id, String name) {
		super(id, name);
	}

	public AdventureObjectContainer(int id) {
		super(id);
	}

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
