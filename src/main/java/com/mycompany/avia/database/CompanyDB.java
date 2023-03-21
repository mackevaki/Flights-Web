package com.mycompany.avia.database;

import com.mycompany.avia.database.abstracts.AbstractObjectDB;
import com.mycompany.avia.spr.objects.Company;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyDB extends AbstractObjectDB<Company> {
    public final static String TABLE_SPR_COMPANY = "spr_company";

    private CompanyDB() {
        super(TABLE_SPR_COMPANY);
    }
    private static CompanyDB instance;

    public static CompanyDB getInstance() {
        if (instance == null) {
            instance = new CompanyDB();
        }
        return instance;
    }

    @Override
    public Company fillObject(ResultSet rs) throws SQLException {
        Company company = new Company();
        company.setId(rs.getLong("id"));
        company.setName(rs.getString("name"));
        company.setDesc(rs.getString("desc"));
        company.setIcon(rs.getBytes("icon"));
        return company;
    }
}
