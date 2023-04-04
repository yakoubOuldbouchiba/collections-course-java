import com.ouldbouchiba.collections.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Iterating {

    public static void main(String[] args) {
        Room cambridge = new Room("Cambridge", "Premiere Room", 4 , 175.00);
        Room piccadilly = new Room("Piccadilly", "Guest Room", 3 , 125.00);
        Room westminister = new Room("Westminister", "Premiere Room", 4 , 175.00);
        Room victoria = new Room("Victoria", "Suite", 4 , 175.00);

//        System.out.println("***************************Iteration -1- *******************************************");

        Collection<Room> rooms = new ArrayList<>(Arrays.asList(cambridge, piccadilly, westminister, victoria));
        westminister.setPetFriendly(true);
        victoria.setPetFriendly(true);
//        Iterator<Room> iterator = rooms.iterator();
//        while (iterator.hasNext()){
//            Room room = iterator.next();
//            System.out.println(room);
//        }

//        System.out.println("*****************************Iteration -2- *****************************************");
//        iterator = rooms.iterator();
//        while (iterator.hasNext()){
//            Room room = iterator.next();
//            if(room.getType().equals("Guest Room")){
//                iterator.remove();
//            }else {
//                System.out.println(room);
//            }
//        }
//        System.out.println("length of rooms = "+rooms.size());
//        System.out.println("***************************** forEach / Modifying ***************************************");
//        Collection<Room> removeRooms = new ArrayList<>();
//        for (Room room: rooms) {
//            //System.out.println(room.getName() +" "+ room.getType());
//            if(room.isPetFriendly()){
//                removeRooms.add(room);
//            }
//        }
//        rooms.removeAll(removeRooms);
//        rooms.stream().forEach(room -> System.out.println(room.getName()));
        rooms = rooms.stream().takeWhile(new Predicate<Room>() {
            @Override
            public boolean test(Room room) {
                return !room.isPetFriendly();
            }
        }).collect(Collectors.toList());
        rooms = rooms.stream().takeWhile(room -> !room.isPetFriendly()).collect(Collectors.toList());
        rooms.stream().forEach(System.out::println);

    }
}
