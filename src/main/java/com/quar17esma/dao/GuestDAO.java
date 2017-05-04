package com.quar17esma.dao;


import com.quar17esma.model.Guest;
import java.util.List;

public interface GuestDAO {

    void addGuest(Guest guest);

    void deleteGuest(int guestId);

    void updateGuest(Guest guest);

    List<Guest> getAllGuests();

    Guest getGuestById(int guestId);

}
