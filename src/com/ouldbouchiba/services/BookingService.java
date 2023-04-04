package com.ouldbouchiba.services;

import com.ouldbouchiba.collections.Guest;
import com.ouldbouchiba.collections.Room;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class BookingService {
    private Map<Room, Guest> bookings = new HashMap<>();


    public boolean book(Room room , Guest guest){
        Guest newGuest = bookings.putIfAbsent(room , guest);
        return newGuest == null ;
    }

    public double totalRevenue(){
        return bookings.keySet().stream().mapToDouble(Room::getRate).sum();
    }
}
