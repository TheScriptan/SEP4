package com.example.legalizeco2.business.model;

import java.sql.Date;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "Humidity_table")
public class Humidity {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "humidity")

    private int id;

    private final double higheAcceptableValue = 5.5;

    private final double lowAcceptableValue = 0.1;

    private String businessKey;

    private String value;

    private Date timestamp;

    public Humidity() {

    }

    public Humidity(String businessKey, String value, Date timestamp) {

        this.businessKey = businessKey;
        this.value = value;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getHigheAcceptableValue() {
        return higheAcceptableValue;
    }

    public double getLowAcceptableValue() {
        return lowAcceptableValue;
    }

    @Override
    public String toString() {
        return "Humidity [id=" + id + ", higheAcceptableValue=" + higheAcceptableValue + ", lowAcceptableValue="
                + lowAcceptableValue + ", businessKey=" + businessKey + ", value=" + value + ", timestamp=" + timestamp
                + "]";
    }
}