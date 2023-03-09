package com.mycompany.avia.database;

import com.mycompany.avia.database.abstracts.AbstractObjectDB;
import com.mycompany.avia.spr.objects.Aircraft;
import com.mycompany.avia.spr.objects.Company;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AircraftDB extends AbstractObjectDB<Aircraft> {
    public final static String TABLE_SPR_AIRCRAFT = "spr_aircraft";

    private AircraftDB() {
        super(TABLE_SPR_AIRCRAFT);
    }
    private static AircraftDB instance;

    public static AircraftDB getInstance() {
        if (instance == null) {
            instance = new AircraftDB();
        }
        return instance;
    }

    @Override
    public Aircraft fillObject(ResultSet rs) throws SQLException {
        Aircraft aircraft = new Aircraft();
        aircraft.setId(rs.getLong("id"));
        aircraft.setDesc(rs.getString("desc"));
        aircraft.setName(rs.getString("name"));

        Company comp = CompanyDB.getInstance().executeObject(CompanyDB.getInstance().getObjectByID(rs.getInt("company_id")));

        aircraft.setCompany(comp);
        return aircraft;
    }
}
