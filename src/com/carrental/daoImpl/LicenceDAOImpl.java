/*
 * PassportDAOImpl.java 2018/03/19
 *
 *
 */
package com.carrental.daoImpl;

import com.carrental.util.Lgr;
import com.carrental.entities.Licence;
import com.carrental.dao.LicenceDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO for "passports" table
 *
 * @author Florin
 */
public class LicenceDAOImpl implements LicenceDAO {

    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    private final String TABLE_NAME = "LICENCE";
    private final String COL_1 = "LICENCE_ID";
    private final String COL_2 = "LAST_NAME";
    private final String COL_3 = "FIRST_NAME";
    private final String COL_4 = "PATRONYMIC";
    private final String COL_5 = "PHONE_NUMBER";
    private final String COL_6 = "BIRTHDAY";
    private final String COL_7 = "L_SERIES";
    private final String COL_8 = "L_NUMBER";
    private final String COL_9 = "WHO_ISSUED";
    private final String COL_10 = "ADDRESS";
    private final String COL_11 = "WHEN_ISSUED";
    ;

    private final String INSERT_QUERY;
    private final String UPDATE_QUERY;
    private final String DELETE_QUERY;
    private final String SELECT_QUERY;

    {
        INSERT_QUERY = new StringBuffer()
                .append("INSERT INTO ")
                .append(TABLE_NAME)
                .append(" (")
                .append(COL_2).append(",")
                .append(COL_3).append(",")
                .append(COL_4).append(",")
                .append(COL_5).append(",")
                .append(COL_6).append(",")
                .append(COL_7).append(",")
                .append(COL_8).append(",")
                .append(COL_9).append(",")
                .append(COL_10).append(",")
                .append(COL_11)
                .append(") VALUES ")
                .append("(?,?,?,?,?,?,?,?,?)")
                .toString();

        UPDATE_QUERY = new StringBuffer()
                .append("UPDATE ")
                .append(TABLE_NAME)
                .append(" SET ")
                .append(COL_2).append("=?").append(",")
                .append(COL_3).append("=?").append(",")
                .append(COL_4).append("=?").append(",")
                .append(COL_5).append("=?").append(",")
                .append(COL_6).append("=?").append(",")
                .append(COL_7).append("=?").append(",")
                .append(COL_8).append("=?").append(",")
                .append(COL_9).append("=?").append(",")
                .append(COL_10).append("=?").append(",")
                .append(COL_11).append("=?")
                .append(" WHERE ")
                .append(COL_1).append("=?")
                .toString();

        DELETE_QUERY = new StringBuffer()
                .append("DELETE FROM ")
                .append(TABLE_NAME)
                .append(" WHERE ")
                .append(COL_1).append("=?")
                .toString();

        SELECT_QUERY = new StringBuffer()
                .append("SELECT * FROM ")
                .append(TABLE_NAME)
                .toString();
    }

    @Override
    public int insert(Licence licence) {
        int autoIncID = DAOHelper.EXECUTE_UPDATE_ERROR_CODE;
        try {
            cn = DAOHelper.getConnection();
            ps = cn.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, licence.getLastName());
            ps.setString(2, licence.getFirstName());
            ps.setString(3, licence.getPatronymic());
            ps.setString(4, licence.getPhoneNmber());
            ps.setDate(5, licence.getBirthday());
            ps.setString(6, licence.getlSeries());
            ps.setString(7, licence.getlNumber());
            ps.setString(8, licence.getWhoIssued());
            ps.setString(9, licence.getAddress());
            ps.setDate(10, licence.getWhenIssued());
            ps.executeUpdate();
            ResultSet keysSet = ps.getGeneratedKeys();
            keysSet.next();
            autoIncID = keysSet.getInt(1);
            Lgr.LOGGER.info("Data inserted successfully");
        } catch (SQLException e) {
            Lgr.LOGGER.error(e);
        } finally {
            DAOHelper.closeResources(cn, ps, rs);
        }
        return autoIncID;
    }

    @Override
    public int update(Licence licence) {
        int result = DAOHelper.EXECUTE_UPDATE_ERROR_CODE;
        try {
            cn = DAOHelper.getConnection();
            ps = cn.prepareStatement(UPDATE_QUERY);
            ps.setString(1, licence.getLastName());
            ps.setString(2, licence.getFirstName());
            ps.setString(3, licence.getPatronymic());
            ps.setString(4, licence.getPhoneNmber());
            ps.setDate(5, licence.getBirthday());
            ps.setString(6, licence.getlSeries());
            ps.setString(7, licence.getlNumber());
            ps.setString(8, licence.getWhoIssued());
            ps.setDate(9, licence.getWhenIssued());
            ps.setString(10, licence.getAddress());
            ps.setInt(10, licence.getLicenceID());
            result = ps.executeUpdate();
            Lgr.LOGGER.info("Data updated successfully");
        } catch (SQLException e) {
            Lgr.LOGGER.error(e);
        } finally {
            DAOHelper.closeResources(cn, ps, rs);
        }
        return result;
    }

    @Override
    public int delete(Licence licence) {
        int result = DAOHelper.EXECUTE_UPDATE_ERROR_CODE;
        try {
            cn = DAOHelper.getConnection();
            ps = cn.prepareStatement(DELETE_QUERY);
            ps.setInt(1, licence.getLicenceID());
            result = ps.executeUpdate();
            Lgr.LOGGER.info("Data deleted successfully");
        } catch (SQLException e) {
            Lgr.LOGGER.error(e);
        } finally {
            DAOHelper.closeResources(cn, ps, rs);
        }
        return result;
    }

    @Override
    public List<Licence> findAll() {
        List<Licence> list = new ArrayList<>();
        try {
            cn = DAOHelper.getConnection();
            ps = cn.prepareStatement(SELECT_QUERY);
            rs = ps.executeQuery();
            while (rs.next()) {
                int licenceID = rs.getInt(1);
                String lastName = rs.getString(2);
                String firstName = rs.getString(3);
                String patronymic = rs.getString(4);
                String phoneNumber = rs.getString(5);
                Date birthday = rs.getDate(6);
                String lSeries = rs.getString(7);
                String lNumber = rs.getString(8);
                String whoIssued = rs.getString(9);
                String address = rs.getString(10);
                Date whenIssued = rs.getDate(11);
                Licence licenceObj = new Licence(licenceID, lastName,
                        firstName, patronymic, phoneNumber, birthday, lSeries, lNumber,
                        whoIssued, address, whenIssued);
                list.add(licenceObj);
            }
            Lgr.LOGGER.info("Data selected successfully");
        } catch (SQLException e) {
            Lgr.LOGGER.error(e);
        } finally {
            DAOHelper.closeResources(cn, ps, rs);
        }
        return list;
    }

    @Override
    public Licence findByID(int licenceIDParam) {
        Licence licenceObj = null;
        try {
            cn = DAOHelper.getConnection();
            ps = cn.prepareStatement(SELECT_QUERY + " WHERE PASSPORT_ID=?");
            ps.setInt(1, licenceIDParam);
            rs = ps.executeQuery();
            rs.next();
            int licenceID = rs.getInt(1);
            String lastName = rs.getString(2);
            String firstName = rs.getString(3);
            String patronymic = rs.getString(4);
            String phoneNumber = rs.getString(5);
            Date birthday = rs.getDate(6);
            String lSeries = rs.getString(7);
            String lNumber = rs.getString(8);
            String whoIssued = rs.getString(9);
            String address = rs.getString(10);
            Date whenIssued = rs.getDate(11);
            licenceObj = new Licence(licenceID, lastName, firstName,
                    patronymic, phoneNumber, birthday, lSeries, lNumber,
                    whoIssued, address, whenIssued);
            Lgr.LOGGER.info("Data selected successfully");
        } catch (SQLException e) {
            Lgr.LOGGER.error(e);
        } finally {
            DAOHelper.closeResources(cn, ps, rs);
        }
        return licenceObj;
    }

}
