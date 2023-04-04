import com.ouldbouchiba.collections.Room;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetCollection {
    public static void main(String[] args) {
        Room cambridge = new Room("Cambridge", "Premiere Room", 4, 175.00);
        Room manchester = new Room("Manchester", "Suite", 5, 250.0);
        Room piccadilly = new Room("Piccadilly", "Guest Room", 4, 125.00);
        Room piccadillyDuplicate = new Room("Piccadilly", "Guest Room", 4, 125.00);
        Room oxford = new Room("Oxford", "Suite", 5, 250.0);

        Set<Room> othRooms = Set.of(piccadilly , oxford);
        //othRooms.add(manchester);

        Set<Room> rooms = new LinkedHashSet<>();
        rooms.add(cambridge);
        rooms.add(manchester);
        rooms.add(piccadilly);
        rooms.add(piccadillyDuplicate);
        rooms.add(oxford);

        Set<Room> moreRoom = Set.copyOf(rooms);


        moreRoom.stream().map(r->r.getName()).forEach(System.out::println);
    }
}
