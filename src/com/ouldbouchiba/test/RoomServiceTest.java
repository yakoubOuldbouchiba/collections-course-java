package com.ouldbouchiba.test;



import com.ouldbouchiba.collections.Room;
import com.ouldbouchiba.services.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;




import static org.junit.jupiter.api.Assertions.*;

public class RoomServiceTest {

    RoomService roomService;

    Room manchester = new Room("Manchester", "Suite", 5, 250.00);

    Room oxford = new Room("Oxford", "Suite", 5, 225.0);
    Room victoria = new Room("Victoria", "Suite", 5, 225.00);
    Room westminister = new Room("Westminister", "Premiere Room", 4, 200.00);


    @BeforeEach
    public void setUp(TestInfo info){

        this.roomService = new RoomService();
        this.roomService.createRoom("Piccadilly", "Guest Room", 3, 125.00);
        this.roomService.createRoom("Cambridge", "Premiere Room", 3, 175.00);
        this.roomService.createRoom("Victoria", "Suite", 5, 225.00);
    }

    @Test
    public void createRoom(){
        this.roomService.createRoom("Westminister", "Premiere Room", 4 ,200.0);
        assertEquals(4, this.roomService.getInventory().size());
    }

    @Test
    void testCreateRooms(){
        Room[] rooms = {this.westminister , this.oxford , this.manchester};
        this.roomService.createRooms(rooms);
        assertEquals(6, this.roomService.getInventory().size());
    }

    @Test
    void testRemoveRoom(){
        this.roomService.removeRoom(new Room("Victoria", "Suite", 5, 225.00));
        assertEquals(2 , this.roomService.getInventory().size());
        assertFalse(this.roomService.getInventory().contains(victoria));
    }

    @Test
    public void testGetInvertory(){
        assertNotNull(this.roomService.getInventory());
    }

    @Test
    public void testHasRoom(){
        assertTrue(this.roomService.hasRoom(victoria));
        assertFalse(this.roomService.hasRoom(new Room("Victoria2", "Suite", 5, 225.00)));
    }

    @Test
    public void testAsArray(){
        Room[] rooms = {this.westminister , this.oxford , this.manchester};
        assertEquals(3 , this.roomService.asArray().length);
    }

    @Test
    public void testGetByType(){
        assertEquals(1,this.roomService.getByType("Suite").size());
    }

    @Test
    public void testApplyDiscount(){
        roomService.applyDiscount(100.0);
        Room[] rooms =  roomService.asArray();
        System.out.println(roomService.getInventory());
        assertEquals(125.00 , rooms[0].getRate() );
        assertEquals(25.00 , rooms[1].getRate() );
        assertEquals(75.00 , rooms[2].getRate() );
    }

    @Test
    public void testGetRoomsByCapacity(){
       assertEquals(roomService.getRoomsByCapacity(3).size() , 2);
       assertEquals(roomService.getRoomsByCapacity(50).size() , 0);
    }

    @Test
    public void testGetRoomsByRateAndType(){
        assertEquals(roomService.getRoomsByRateAndType(225.0 , "Suite").size() , 1);
        assertEquals(roomService.getRoomsByRateAndType(150.0 , "Suite").size() , 0);
        assertEquals(roomService.getRoomsByRateAndType(250.0 , "Guest Room").size() , 0);
    }

}
