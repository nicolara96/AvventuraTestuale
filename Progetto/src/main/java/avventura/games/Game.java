package avventura.games;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;

import avventura.GameDescription;
import avventura.parser.ParserOutput;
import avventura.type.AdventureObject;
import avventura.type.AdventureObjectContainer;
import avventura.type.CharacterAdventure;
import avventura.type.Command;
import avventura.type.CommandType;
import avventura.type.Monster;
import avventura.type.Room;
import avventura.type.Weapon;


public class Game extends GameDescription {

	public void init() throws Exception {
		// comandi
		Command nord = new Command(CommandType.NORD, "nord");
		nord.setAlias(new String[] { "n", "N", "Nord", "NORD" });
		getCommands().add(nord);
		Command sud = new Command(CommandType.SOUTH, "sud");
		sud.setAlias(new String[] { "s", "S", "Sud", "SUD" });
		getCommands().add(sud);
		Command est = new Command(CommandType.EAST, "est");
		est.setAlias(new String[] { "e", "E", "Est", "EST" });
		getCommands().add(est);
		Command ovest = new Command(CommandType.WEST, "ovest");
		ovest.setAlias(new String[] { "o", "O", "Ovest", "OVEST" });
		getCommands().add(ovest);
		Command iventory = new Command(CommandType.INVENTORY, "inventario");
		iventory.setAlias(new String[] { "inv", "i", "I" });
		getCommands().add(iventory);
		Command end = new Command(CommandType.END, "end");
		end.setAlias(new String[] { "end", "fine", "esci", "muori", "ammazzati", "ucciditi", "suicidati", "exit" });
		getCommands().add(end);
		Command look = new Command(CommandType.LOOK_AT, "osserva");
		look.setAlias(new String[] { "guarda", "vedi", "trova", "cerca", "descrivi" });
		getCommands().add(look);
		Command pickup = new Command(CommandType.PICK_UP, "raccogli");
		pickup.setAlias(new String[] { "prendi" });
		getCommands().add(pickup);
		Command open = new Command(CommandType.OPEN, "apri");
		open.setAlias(new String[] {});
		getCommands().add(open);
		Command push = new Command(CommandType.PUSH, "premi");
		push.setAlias(new String[] { "spingi", "attiva" });
		getCommands().add(push);
		Command enter = new Command(CommandType.ENTER, "entra");
		enter.setAlias(new String[] { "vai" });
		getCommands().add(enter);
		Command attack = new Command(CommandType.ATTACK, "attacca");
		attack.setAlias(new String[] { "attacca", "colpisci", "uccidi" });
		getCommands().add(attack);
		Command escape = new Command(CommandType.ESCAPE, "scappa");
		escape.setAlias(new String[] { "fuggi" });
		getCommands().add(escape);
		Command weapon = new Command(CommandType.WEAPON, "arma");
		getCommands().add(weapon);
		// Rooms
		Room yourRoom = new Room(0, "Camera tua", "Ti sei appena svegliato.");
		yourRoom.setLook("Sei nella tua camera e puoi solo andare nel dormitorio. Si trova ad est.");
		Room dormitory1 = new Room(1, "Dormitorio", "Ci sono solo sedie e tavoli.");
		dormitory1.setLook(
				"Ci sono due porte una ti porta sul corridoio a est, l'altra nell'altra stanza del dormitorio a sud.");
		Room dormitory2 = new Room(2, "Dormtorio", "Stanza dei giochi.");
		dormitory2.setLook("Niente di interessante.");
		Room hall1 = new Room(3, "Corridoio", "Il corridoio: è molto lungo.");
		hall1.setLook("C'è una spada. Il corridoio prosegue verso sud.");
		Room hall2 = new Room(4, "Corridoio", "Prosegue ancora.");
		hall2.setLook("Niente d'interessante.");
		Room monsterRoom = new Room(5, "Corridoio", "C'è un enorme mostro.");
		monsterRoom.setLook("Devi uccidere il mostro per proseguire.");
		Room hall3 = new Room(6, "Corridoio", "Nulla.");
		hall3.setLook("Puoi solo o tornare indietro o andare a ovest.");
		Room keyRoom = new Room(7, "Stanza della chiave", "Una stanza con dentro una chiave.");
		keyRoom.setLook("Una stanza vuota con solo una chiave a terra.");
		Room closeRoom = new Room(8, "Stanza.", "Non c'è niente di interessante.");
		closeRoom.setLook("A est c'è una porta chiusa a chiave.");
		Room mysteriousRoom = new Room(9, "Stanza misteriosa", "C'è uno strano portale luminoso.");
		mysteriousRoom.setLook("Non si può andare in nessuna da nessuna parta, solo entrare nel portale.");
		// maps
		yourRoom.setEast(dormitory1);
		dormitory1.setSouth(dormitory2);
		dormitory1.setWest(yourRoom);
		dormitory1.setEast(hall1);
		dormitory2.setNorth(dormitory1);
		hall1.setWest(dormitory1);
		hall1.setSouth(hall2);
		hall2.setSouth(monsterRoom);
		hall2.setNorth(hall1);
		monsterRoom.setNorth(hall2);
		monsterRoom.setWest(hall3);
		monsterRoom.setSouth(closeRoom);
		hall3.setEast(monsterRoom);
		hall3.setWest(keyRoom);
		keyRoom.setEast(hall3);
		closeRoom.setNorth(monsterRoom);
		closeRoom.setEast(mysteriousRoom);
		mysteriousRoom.setWest(closeRoom);
		getRooms().add(yourRoom);
		getRooms().add(dormitory1);
		getRooms().add(dormitory2);
		getRooms().add(hall1);
		getRooms().add(hall2);
		getRooms().add(hall3);
		getRooms().add(keyRoom);
		getRooms().add(monsterRoom);
		getRooms().add(mysteriousRoom);
		getRooms().add(closeRoom);
		// objects
		AdventureObject keyDoor = new AdventureObject(1, "chiave", "Chiave per aprire qualcosa.");
		keyDoor.setAlias(new String[] { "chiavi" });
		keyDoor.setPickupable(true);
		keyRoom.getObject().add(keyDoor);
		AdventureObject sword = new Weapon(2, "spada", "Una spada, poterebbe servire.");
		sword.setPickupable(true);
		((Weapon) sword).setDanni(15);
		hall1.getObject().add(sword);
		AdventureObject portal = new AdventureObject(3, "portale");
		mysteriousRoom.getObject().add(portal);
		// character
		Monster monster = new Monster(100, 5);
		monsterRoom.getMonster().add(monster);
		CharacterAdventure player = new CharacterAdventure(100);
		getPlayer().add(player);
		// starting room
		setCurrentRoom(yourRoom);
	}

	public void nextMove(ParserOutput p, PrintStream out) {
		if (p.getCommand() == null) {
			out.println("Non ho capito cosa devo fare! Prova con un altro comando.");
		} else {
			// move
			boolean noroom = false;
			boolean move = false;
			if (p.getCommand().getType() == CommandType.NORD) {
				if (getCurrentRoom().getNorth() != null) {
					setCurrentRoom(getCurrentRoom().getNorth());
					move = true;
				} else {
					noroom = true;
				}
			} else if (p.getCommand().getType() == CommandType.SOUTH) {
				if (getCurrentRoom().getSouth() != null) {
					if (getCurrentRoom().getId() == 5) {
						if (getCurrentRoom().getMonster().get(0).getVita() > 0) {
							out.println("Devi prima uccidere il mostro per passare.");
						} else {
							setCurrentRoom(getCurrentRoom().getSouth());
							move = true;
						}
					} else {
						setCurrentRoom(getCurrentRoom().getSouth());
						move = true;
					}
				} else {
					noroom = true;
				}
			} else if (p.getCommand().getType() == CommandType.EAST) {
				if (getCurrentRoom().getEast() != null) {
					if (getCurrentRoom().getEast().getId() == 9) {
						if (!getInventory().isEmpty()) {
							for (AdventureObject o : getInventory()) {
								if (o.getId() == 1) {
									out.println("Hai aperto la porta.");
									setCurrentRoom(getCurrentRoom().getEast());
									move = true;
									break;
								} else {
									out.println("Non hai la chiave per entrare.");
									break;
								}
							}
						} else {
							out.println("Non hai la chiave.");
						}
					} else {
						setCurrentRoom(getCurrentRoom().getEast());
						move = true;
					}
				} else {
					noroom = true;
				}
			} else if (p.getCommand().getType() == CommandType.WEST) {
				if (getCurrentRoom().getWest() != null) {
					if (getCurrentRoom().getId() == 5) {
						if (getCurrentRoom().getMonster().get(0).getVita() > 0) {
							out.println("Devi prima uccidere il mostro per passare.");
						} else {
							setCurrentRoom(getCurrentRoom().getWest());
							move = true;
						}
					} else {
						setCurrentRoom(getCurrentRoom().getWest());
						move = true;
					}
				} else {
					noroom = true;
				}
			} else if (p.getCommand().getType() == CommandType.INVENTORY) {
				out.println("Nel tuo inventario ci sono:");
				for (AdventureObject o : getInventory()) {
					out.println(o.getName() + ": " + o.getDescription());
				}
			} else if (p.getCommand().getType() == CommandType.LOOK_AT) {
				if (getCurrentRoom().getLook() != null) {
					out.println(getCurrentRoom().getLook());
				} else {
					out.println("Non c'è niente di interessante qui.");
				}
			} else if (p.getCommand().getType() == CommandType.PICK_UP) {
				if (p.getObject() != null) {
					if (p.getObject().isPickupable()) {
						if (p.getObject().getId() == 2) {
							getPlayer().get(0).setArmaEquiqaggiata((Weapon) p.getObject());
							getCurrentRoom().getObject().remove(p.getObject());
							out.println("Hai raccolto: " + p.getObject().getDescription());
						} else {
							getInventory().add(p.getObject());
							getCurrentRoom().getObject().remove(p.getObject());
							out.println("Hai raccolto: " + p.getObject().getDescription());
						}
					} else {
						out.println("Non puoi raccogliere questo oggetto.");
					}
				} else {
					out.println("Non c'è niente da raccogliere qui.");
				}
			} else if (p.getCommand().getType() == CommandType.OPEN) {
				if (p.getObject() == null && p.getInvObject() == null) {
                    out.println("Non c'è niente da aprire qui.");
                } else {
                    if (p.getObject() != null) {
                        if (p.getObject().isOpenable() && p.getObject().isOpen() == false) {
                            if (p.getObject() instanceof AdventureObjectContainer) {
                                out.println("Hai aperto: " + p.getObject().getName());
                                AdventureObjectContainer c = (AdventureObjectContainer) p.getObject();
                                Scanner tastiera = new Scanner(System.in);
                                String opzione = new String("");
                                if (!c.getList().isEmpty()) {
                                    out.print(c.getName() + " contiene:");
                                    Iterator<AdventureObject> it = c.getList().iterator();
                                    while (it.hasNext()) {
                                        AdventureObject next = it.next();
                                        out.print(" " + next.getName());
                                        out.println("Vuoi raccogliere l'oggetto?");
                                        opzione = tastiera.nextLine();
                                        if(opzione.equalsIgnoreCase("si")) {
                                        	getInventory().add(p.getObject());
                                        	it.remove();
                                        }
                                    }
                                    out.println();
                                    tastiera.close();
                                }
                            } else {
                                out.println("Hai aperto: " + p.getObject().getName());
                                p.getObject().setOpen(true);
                            }
                        } else {
                            out.println("Non puoi aprire questo oggetto.");
                        }
                    }
                    if (p.getInvObject() != null) {
                        if (p.getInvObject().isOpenable() && p.getInvObject().isOpen() == false) {
                            if (p.getInvObject() instanceof AdventureObjectContainer) {
                                AdventureObjectContainer c = (AdventureObjectContainer) p.getInvObject();
                                if (!c.getList().isEmpty()) {
                                    out.print(c.getName() + " contiene:");
                                    Iterator<AdventureObject> it = c.getList().iterator();
                                    while (it.hasNext()) {
                                        AdventureObject next = it.next();
                                        getInventory().add(next);
                                        out.print(" " + next.getName());
                                        it.remove();
                                    }
                                    out.println();
                                }
                            } else {
                                p.getInvObject().setOpen(true);
                            }
                            out.println("Hai aperto nel tuo inventario: " + p.getInvObject().getName());
                        } else {
                            out.println("Non puoi aprire questo oggetto.");
                        }
                    }
                }
			} else if (p.getCommand().getType() == CommandType.PUSH) {
				if (p.getObject() != null && p.getObject().isPushable()) {
					out.println("Hai premuto: " + p.getObject().getName());
				} else if (p.getInvObject() != null && p.getInvObject().isPushable()) {
					out.println("Hai premuto: " + p.getInvObject().getName());
				} else {
					out.println("Non ci sono oggetti che puoi premere qui.");
				}
			} else if (p.getCommand().getType() == CommandType.ENTER) {
				if (p.getObject() == null) {
					out.println("Non puoi entrare.");
				} else if (p.getObject().getId() == 3) {
					end(out);
				}
			} else if (p.getCommand().getType() == CommandType.ATTACK) {
				int vita = getCurrentRoom().getMonster().get(0).getVita();
				vita = vita - getPlayer().get(0).getArmaEquiqaggiata().getDanni();
				getCurrentRoom().getMonster().get(0).setVita(vita);
				out.println("Il mostro ha " + getCurrentRoom().getMonster().get(0).getVita() + " vita.");
			} else if (p.getCommand().getType() == CommandType.WEAPON) {
				if (getPlayer().get(0).getArmaEquiqaggiata() != null) {
					out.println("Arma equipaggiata: " + getPlayer().get(0).getArmaEquiqaggiata().getDescription());
				} else {
					out.println("Arma equipaggiata: nessun'arma");
				}
			}
			if (noroom) {
				out.println("Da quella parte non si può andare c'è un muro!");
			} else if (move) {
				out.println(getCurrentRoom().getName());
				out.println("================================================");
				out.println(getCurrentRoom().getDescription());
			}
		}
	}

	private void end(PrintStream out) {
		out.println("Sei entrato nel portale e ti ritrovi in un altro mondo.");
		System.exit(0);
	}

}
