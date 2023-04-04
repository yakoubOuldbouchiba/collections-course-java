import com.ouldbouchiba.collections.Room;
import com.ouldbouchiba.implentations.Implementation;
import com.ouldbouchiba.interfaces.Contrat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        Room cambridge = new Room("Cambridge", "Premiere Room", 4, 175.00);
//        Room manchester = new Room("Manchester", "Suite", 5, 250.0);
//        Room piccadilly = new Room("Piccadilly", "Guest Room", 4, 125.00);
//        Room oxford = new Room("Oxford", "Suite", 5, 250.0);
//
//        //Room[] rooms={cambridge, manchester,piccadilly, oxford};
//        Collection<Room> rooms = new ArrayList<>(List.of(cambridge, manchester));
//        rooms.add(piccadilly);
//        rooms.add(oxford);
//        double total = getPotentialRevenue(rooms);
//        System.out.println("total = " + total);
        Contrat contrat = new Implementation();
        printTerms(contrat);

    }

//    private static double getPotentialRevenue(Room[] rooms) {
//        return Arrays.stream(rooms).mapToDouble(Room::getRate).sum();
//    }
//
//    private static double getPotentialRevenue(Collection<Room>  rooms) {
//        return rooms.stream().mapToDouble(Room::getRate).sum();
//    }
    private static void printTerms(Contrat contrat){
        contrat.term1();
        contrat.term2();
        contrat.extendedTerm();
    }

}