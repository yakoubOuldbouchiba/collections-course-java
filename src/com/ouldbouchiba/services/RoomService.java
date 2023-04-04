package com.ouldbouchiba.services;

import com.ouldbouchiba.collections.Room;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

public class RoomService {

    private Collection<Room> inventory;

    public RoomService() {
        this.inventory = new HashSet<>();
    }

    public Collection<Room> getInventory() {
        return new HashSet<>(inventory);
    }

    public void createRoom(String name , String type , int capacity , double rate){
        this.inventory.add(new Room(name, type, capacity, rate));
    }

    public void createRooms(Room[] rooms){
        this.inventory.addAll(Arrays.asList(rooms));
    }

    public void removeRoom(Room room){
        this.inventory.remove(room);
    }

    public boolean hasRoom(Room room){
        return inventory.contains(room);
    }

    public Room[] asArray(){
        return inventory.toArray(new Room[0]);
    }

    public Collection<Room> getByType(String type){
        Collection<Room> copy = new HashSet<>(inventory);
        return inventory.stream().filter(room -> room.getType() == type).collect(Collectors.toList());
    }

    public void applyDiscount(final double discout){
         inventory.stream().forEach(room -> room.setRate(room.getRate()-discout));
    }

    public Collection<Room> getRoomsByCapacity(final int requiredCapacity){
        return inventory.stream().filter(room -> room.getCapacity() == requiredCapacity).collect(Collectors.toList());
    }

    public Collection<Room> getRoomsByRateAndType(final double rate , final String type){
        return inventory.stream().filter(room -> room.getRate() == rate && room.getType() == type).collect(Collectors.toList());
    }
}
