/*
 * Passport.java 2014/03/29
 *
 * Copyright (C) 2014 Florin.
 *
 */
package com.carrental.entities;

import java.io.Serializable;
import java.sql.Date;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * A bean for "passports" table
 *
 * @author Florin
 */
public class Licence implements Serializable {

    private int licenceID;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String phoneNmber;
    private Date birthday;
    private String lSeries;
    private String lNumber;
    private String whoIssued;
    private String address;
    private Date whenIssued;

    public Licence() {
    }

    public Licence(int passportID, String lastName, String firstName,
            String patronymic, String phoneNmber, Date birthday, String pSeries,
            String pNumber, String whoIssued,String address, Date whenIssued) {
        this.licenceID = passportID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.phoneNmber = phoneNmber;
        this.birthday = birthday;
        this.lSeries = pSeries;
        this.lNumber = pNumber;
        this.whoIssued = whoIssued;
        this.address = address;
        this.whenIssued = whenIssued;
    }

    public int getLicenceID() {
        return licenceID;
    }

    public void setLicenceID(int passportID) {
        this.licenceID = passportID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    
    

    public String getPhoneNmber() {
		return phoneNmber;
	}

	public void setPhoneNmber(String phoneNmber) {
		this.phoneNmber = phoneNmber;
	}

	public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getlSeries() {
        return lSeries;
    }

    public void setlSeries(String pSeries) {
        this.lSeries = pSeries;
    }

    public String getlNumber() {
        return lNumber;
    }

    public void setlNumber(String pNumber) {
        this.lNumber = pNumber;
    }

    public String getWhoIssued() {
        return whoIssued;
    }

    public void setWhoIssued(String whoIssued) {
        this.whoIssued = whoIssued;
    }

    public Date getWhenIssued() {
        return whenIssued;
    }
    

    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setWhenIssued(Date whenIssued) {
        this.whenIssued = whenIssued;
    }

    /**
     * Methods that generates the string representation of passport object to be
     * shown on the web page
     *
     * @return specially built string for representing passport on web page
     */
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(lastName).append(" ").append(firstName).append("\n");
        if (patronymic != null) {
            sb.append(patronymic).append("\n");
        }
        sb.append(phoneNmber).append("\n");
        sb.append(birthday).append("\n");
        sb.append(lSeries).append(lNumber).append("\n");
        sb.append(whoIssued).append(" ").append(address).append(" ").append(whenIssued);
        return sb.toString();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("LicenceID", licenceID)
                .append("lastName", lastName)
                .append("firstName", firstName)
                .append("patronymic", patronymic)
                .append("phoneNmber",phoneNmber)
                .append("birthday", birthday)
                .append("lSeries", lSeries)
                .append("lNumber", lNumber)
                .append("whoIssued", whoIssued)
                .append("address", address)
                .append("whenIssued", whenIssued)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(licenceID)
                .append(lastName)
                .append(firstName)
                .append(patronymic)
                .append(phoneNmber)
                .append(birthday)
                .append(lSeries)
                .append(lNumber)
                .append(whoIssued)
                .append(address)
                .append(whenIssued)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Licence other = (Licence) obj;
        return new EqualsBuilder()
                .append(licenceID, other.licenceID)
                .append(lastName, other.lastName)
                .append(firstName, other.firstName)
                .append(patronymic, other.patronymic)
                .append(phoneNmber,other.phoneNmber)
                .append(birthday, other.birthday)
                .append(lSeries, other.lSeries)
                .append(lNumber, other.lNumber)
                .append(whoIssued, other.whoIssued)
                .append(address,other.address)
                .append(whenIssued, other.whenIssued)
                .isEquals();
    }

}
