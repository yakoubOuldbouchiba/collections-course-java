import com.ouldbouchiba.collections.Guest;
import com.ouldbouchiba.collections.Room;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapCollection {
    public static void main(String[] args) {
        Guest john = new Guest("John" , "Doe", false);
        Guest maria = new Guest("Maria" , "Doe", false);
        Guest sonia = new Guest("Sonia" , "Doe", true);
        Guest siri = new Guest("Siri" , "Doe", true);
        Room cambridge = new Room("Cambridge", "Premiere Room", 4, 175.00);
        Room manchester = new Room("Manchester", "Suite", 5, 250.0);
        Map<Room, Guest> assignments = new HashMap<>();
        assignments.put(cambridge , john);
        assignments.put(manchester, siri);
        assignments.putIfAbsent(manchester, maria);

        System.out.println("Cambridge : "+assignments.get(cambridge));
        System.out.println("manchester : "+assignments.get(new Room("Manchester", "Suite", 5, 250.0)));
        
        Set<Map.Entry<Room , Guest>> assignmentsSet = assignments.entrySet();


        System.out.format("%n-- Map Contents --%n");
        for (Map.Entry<Room , Guest> assignment:assignmentsSet) {
            System.out.println(assignment.getKey().getName() +" : "+ assignment.getKey());
        }
    }
}
