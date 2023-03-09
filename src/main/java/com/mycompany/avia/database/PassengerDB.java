package com.mycompany.avia.database;

import com.mycompany.avia.database.abstracts.AbstractObjectDB;
import com.mycompany.avia.objects.Passenger;

import java.sql.*;

public class PassengerDB extends AbstractObjectDB<Passenger> {
    public final static String TABLE_PASSENGER = "passenger";

    private PassengerDB() {
        super(TABLE_PASSENGER);
    }
    private static PassengerDB instance;

    public static PassengerDB getInstance() {
        if (instance == null) {
            instance = new PassengerDB();
        }
        return instance;
    }

    @Override
    public Passenger fillObject(ResultSet rs) throws SQLException {
        Passenger passenger = new Passenger();
        passenger.setId(rs.getLong("id"));
        passenger.setDocumentNumber(rs.getString("document_number"));
        passenger.setEmail(rs.getString("email"));
        passenger.setFamilyName(rs.getString("family_name"));
        passenger.setGivenName(rs.getString("given_name"));
        passenger.setMiddleName(rs.getString("middle_name"));
        passenger.setPhone(rs.getString("phone"));
        return passenger;
    }
    public PreparedStatement getInsertStmt(Passenger passenger) throws SQLException {
        Connection conn = AviaDB.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement("insert into " + TABLE_PASSENGER + "(given_name, middle_name, family_name, document_number, email, phone) values (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, passenger.getGivenName());
        stmt.setString(2, passenger.getMiddleName());
        stmt.setString(3, passenger.getFamilyName());
        stmt.setString(4, passenger.getDocumentNumber());
        stmt.setString(5, passenger.getEmail());
        stmt.setString(6, passenger.getPhone());
        return stmt;
    }
}
