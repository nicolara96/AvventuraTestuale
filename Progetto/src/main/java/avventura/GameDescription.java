package avventura;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import avventura.parser.ParserOutput;
import avventura.type.AdventureObject;
import avventura.type.CharacterAdventure;
import avventura.type.Command;
import avventura.type.Room;

public abstract class GameDescription {

	private final List<Room> rooms = new ArrayList<Room>();

    private final List<Command> commands = new ArrayList<Command>();

    private final List<AdventureObject> inventory = new ArrayList<AdventureObject>();

    private Room currentRoom;
    
    private final List<CharacterAdventure> player = new ArrayList<CharacterAdventure>();

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public List<AdventureObject> getInventory() {
        return inventory;
    }

    public abstract void init() throws Exception;

    public abstract void nextMove(ParserOutput p, PrintStream out);

	public List<CharacterAdventure> getPlayer() {
		return player;
	}
}
