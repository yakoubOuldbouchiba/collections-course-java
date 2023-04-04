package com.ouldbouchiba.test;

import com.ouldbouchiba.collections.Guest;
import com.ouldbouchiba.collections.Room;
import com.ouldbouchiba.services.BookingService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookingServiceTest {
    BookingService service = new BookingService();
    Guest maria = new Guest("Maria", "Doe", false);
    Guest sonia = new Guest("Sonia", "Doe", true);
    Guest siri = new Guest("Siri", "Doe", true);
    Guest yakoub = new Guest("Yakoub", "Doe", true);
    Room manchester = new Room("Manchester", "Suite", 5, 250.00);
    Room oxford = new Room("Oxford", "Suite", 5, 225.0);
    Room victoria = new Room("Victoria", "Suite", 5, 225.00);
    Room westminister = new Room("Westminister", "Premiere Room", 4, 200.00);

    @Test
    public void testBook(){
        assertTrue (service.book(manchester, maria));
        assertTrue (service.book(oxford, maria));
        assertTrue (service.book(victoria, maria));
        assertFalse (service.book(manchester,yakoub));
        assertFalse (service.book(oxford, yakoub));
        assertFalse (service.book(victoria, yakoub));

    }

    @Test
    public void testTotalRevenue(){
        assertTrue (service.book(manchester, maria));
        assertTrue (service.book(oxford, maria));
        assertTrue (service.book(victoria, maria));
        assertEquals(700.0 , service.totalRevenue());
    }
}
