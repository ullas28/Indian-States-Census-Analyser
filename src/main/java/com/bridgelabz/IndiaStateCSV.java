package com.bridgelabz;

import com.opencsv.bean.CsvBindByName;

public class IndiaStateCSV {

    @CsvBindByName(column = "State")
    public String state;

    @CsvBindByName(column = "TIN")
    public String TIN;

    @CsvBindByName(column = "stateCode")
    public String stateCode;

    /**
     * @return all values by printing all.
     */
    @Override
    public String toString() {
        return "IndiaStateCSV{" +
                ", state='" + state + '\'' +
                ", TIN=" + TIN +
                ", stateCode='" + stateCode + '\'' +
                '}';
    }
}
