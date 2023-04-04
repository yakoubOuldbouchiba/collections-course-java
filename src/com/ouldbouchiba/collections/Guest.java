package com.ouldbouchiba.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Guest {
    private String firstName;

    private String lastName;

    private boolean loyaltyProgramMember;

    private List<Room> preferredRooms = new ArrayList<>();

    public Guest(String firstName, String lastName, boolean loyaltyProgramMember) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.loyaltyProgramMember = loyaltyProgramMember;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isLoyaltyProgramMember() {
        return loyaltyProgramMember;
    }

    public void setLoyaltyProgramMember(boolean loyaltyProgramMember) {
        this.loyaltyProgramMember = loyaltyProgramMember;
    }

    public List<Room> getPreferredRooms() {
        return preferredRooms;
    }

    public void setPreferredRooms(List<Room> preferredRooms) {
        this.preferredRooms = preferredRooms;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", loyaltyProgramMember=" + loyaltyProgramMember +
                ", preferredRooms=" + preferredRooms +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return Objects.equals(firstName, guest.firstName) && Objects.equals(lastName, guest.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
