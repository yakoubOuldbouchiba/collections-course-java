import com.ouldbouchiba.collections.Room;

import java.util.*;

public class CreationCollection {
    public static void main(String[] args) {
        Collection<String> c = new ArrayDeque<>();
        c.add("snowboard");
        c.add("linux");
        c.add("books");
        c.add("snowboard");
        Collection<String> favoriteThings = new HashSet<>(c);
        System.out.println(favoriteThings);


        Collection<Room> generic = new ArrayList<>();
        //generic.add("Cambridge");
        //generic.add(1L);
        generic.add(new Room("Oxford", "Suite", 5, 250.0));
        generic.stream().forEach(e-> {
            System.out.println(e.getName());
        });
    }
}
