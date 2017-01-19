package com.quar17esma.dao;


import com.quar17esma.model.Guest;
import com.quar17esma.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestDAOImpl implements GuestDAO {
    private Connection conn;

    public GuestDAOImpl() {
        conn = DBUtil.getConnection();
    }

    @Override
    public void addGuest(Guest guest) {
        try {
            String query = "insert into guest_book (name, surname, birthday_date, phone_number, email, country, city)" +
                    " values (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, guest.getFirstName());
            preparedStatement.setString(2, guest.getLastName());
            preparedStatement.setString(3, guest.getBirthday());
            preparedStatement.setString(4, guest.getPhoneNumber());
            preparedStatement.setString(5, guest.getEmail());
            preparedStatement.setString(6, guest.getCountry());
            preparedStatement.setString(7, guest.getCity());

            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGuest(int guestId) {
        try {
            String query = "delete from guest_book where guest_id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, guestId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateGuest(Guest guest) {
        try {
            String query = "update guest_book " +
                           "set name=?, surname=?, birthday_date=?, phone_number=?, email=?, country=?, city=? " +
                           "where studentId=?";

            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, guest.getFirstName());
            preparedStatement.setString(2, guest.getLastName());
            preparedStatement.setString(3, guest.getBirthday());
            preparedStatement.setString(4, guest.getPhoneNumber());
            preparedStatement.setString(5, guest.getEmail());
            preparedStatement.setString(6, guest.getCountry());
            preparedStatement.setString(7, guest.getCity());

            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Guest> getAllGuests() {
        List<Guest> guests = new ArrayList<Guest>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from guest_book");
            while (resultSet.next()) {
                Guest guest = new Guest();

                guest.setGuestId(resultSet.getInt("guest_id"));
                guest.setFirstName(resultSet.getString("name"));
                guest.setLastName(resultSet.getString("surname"));
                guest.setBirthday(resultSet.getString("birthday_date"));
                guest.setPhoneNumber(resultSet.getString("phone_number"));
                guest.setEmail(resultSet.getString("email"));
                guest.setCountry(resultSet.getString("country"));
                guest.setCity(resultSet.getString("city"));

                guests.add(guest);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guests;
    }

    @Override
    public Guest getGuestById(int guestId) {
        Guest guest = new Guest();
        try {
            String query = "select * from guest_book " +
                           "where guest_id=?";

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, guestId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                guest.setGuestId(resultSet.getInt("guest_id"));
                guest.setFirstName(resultSet.getString("name"));
                guest.setLastName(resultSet.getString("surname"));
                guest.setBirthday(resultSet.getString("birthday_date"));
                guest.setPhoneNumber(resultSet.getString("phone_number"));
                guest.setEmail(resultSet.getString("email"));
                guest.setCountry(resultSet.getString("country"));
                guest.setCity(resultSet.getString("city"));
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guest;
    }

}

