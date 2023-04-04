package com.ouldbouchiba.test;

import com.ouldbouchiba.collections.Guest;
import com.ouldbouchiba.collections.Room;
import com.ouldbouchiba.services.GuestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuestServiceTest {
    private GuestService guestService;
    Guest john, maria, sonia, siri, yakoub;
    Room manchester = new Room("Manchester", "Suite", 5, 250.00);

    Room oxford = new Room("Oxford", "Suite", 5, 225.0);
    Room victoria = new Room("Victoria", "Suite", 5, 225.00);
    Room westminister = new Room("Westminister", "Premiere Room", 4, 200.00);

    @BeforeEach
    public void setUp() {
        guestService = new GuestService();
        john = new Guest("John", "Doe", false);
        maria = new Guest("Maria", "Doe", false);
        sonia = new Guest("Sonia", "Doe", true);
        siri = new Guest("Siri", "Doe", true);
        yakoub = new Guest("Yakoub", "Doe", true);
        guestService.checkIn(john);
        guestService.checkIn(maria);
        guestService.checkIn(sonia);
        guestService.checkIn(siri);
        sonia.getPreferredRooms().add(victoria);
        sonia.getPreferredRooms().add(manchester);
        sonia.getPreferredRooms().add(oxford);
        siri.getPreferredRooms().add(manchester);
        siri.getPreferredRooms().add(oxford);
    }

    @Test
    public void testCheckIn() {
        assertEquals(4, guestService.getCheckinList().size());
        assertEquals(0, guestService.getCheckinList().indexOf(sonia));
        assertEquals(1, guestService.getCheckinList().indexOf(siri));
        assertEquals(2, guestService.getCheckinList().indexOf(john));
        assertEquals(3, guestService.getCheckinList().indexOf(maria));
    }

    @Test
    public void testSwapPosition(){
        guestService.swapPosition(siri , maria);
        assertEquals(3, guestService.getCheckinList().indexOf(siri));
        assertEquals(1, guestService.getCheckinList().indexOf(maria));
        guestService.swapPosition(maria , maria);
        assertEquals(1, guestService.getCheckinList().indexOf(maria));
        guestService.swapPosition(maria, siri);
        assertEquals(1, guestService.getCheckinList().indexOf(siri));
        assertEquals(3, guestService.getCheckinList().indexOf(maria));
        guestService.swapPosition(yakoub, siri);
        assertEquals(1, guestService.getCheckinList().indexOf(siri));
        assertEquals(-1, guestService.getCheckinList().indexOf(yakoub));
    }

    @Test
    public void testFilterByFavoriteRoom(){
        assertEquals(1 , GuestService.filterByFavoriteRoom(guestService.getCheckinList(), manchester ).size());
        assertEquals(1 , GuestService.filterByFavoriteRoom(guestService.getCheckinList(), victoria ).size());
        assertEquals(0 , GuestService.filterByFavoriteRoom(guestService.getCheckinList(), oxford ).size());
    }

}
