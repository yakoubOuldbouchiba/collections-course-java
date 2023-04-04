import com.ouldbouchiba.collections.Guest;

import java.util.*;

public class QueueCollection {
    public static void main(String[] args) {

        Guest siri = new Guest("Siri" , "Doe", true);
        Guest john = new Guest("John" , "Doe", false);
        Guest maria = new Guest("Maria" , "Doe", false);
        Guest sonia = new Guest("Sonia" , "Doe", true);


        Comparator<Guest> programComp =  Comparator.comparing(Guest::isLoyaltyProgramMember).reversed();
        Queue<Guest> checkinQueue = new PriorityQueue<>(programComp);
        checkinQueue.add(siri);
        checkinQueue.add(john);
        checkinQueue.add(maria);
        checkinQueue.add(sonia);
        print(checkinQueue);
        //Guest guest1 = checkinQueue.remove();
        Guest guest = checkinQueue.peek();
        System.out.println(guest);
        print(checkinQueue);
    }

    public static void print(Queue<Guest> queue){
        System.out.format("%n--List Contents--%n");
        int x = 0;
        for (Guest guest : queue){
            System.out.format("%x : %s %n" , x++ , guest.toString());
        }
    }
}
