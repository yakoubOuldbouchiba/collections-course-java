package com.ouldbouchiba.services;

import com.ouldbouchiba.collections.Guest;
import com.ouldbouchiba.collections.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuestService {

    List<Guest> checkinList = new ArrayList<>(100);

    public static List<Guest> filterByFavoriteRoom(List<Guest> guests, Room room) {
        return guests
                .stream()
                .filter(guest -> guest.getPreferredRooms().size() > 0 && guest.getPreferredRooms().get(0) == room)
                .collect(Collectors.toList());
    }

    public void checkIn(Guest guest) {
        if (guest.isLoyaltyProgramMember()) {
            int index = (int) checkinList.stream().filter(Guest::isLoyaltyProgramMember).count();
            checkinList.add(index, guest);
        }else {
            checkinList.add(guest);
        }
    }

    public void swapPosition(Guest guest1, Guest guest2) {
        int indexGuest1 = checkinList.indexOf(guest1);
        int indexGuest2 = checkinList.indexOf(guest2);
        if(indexGuest1 !=-1 && indexGuest2 !=-1){
            checkinList.set(indexGuest1, guest2);
            checkinList.set(indexGuest2, guest1);
        }
    }

    public List<Guest> getCheckinList(){
        return List.copyOf(this.checkinList);
    }
}
