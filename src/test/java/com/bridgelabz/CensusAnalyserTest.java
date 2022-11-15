package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CensusAnalyserTest {
    private String INDIAN_CENSUS_CSV_FILE_PATH = "C:\\Users\\ULLASKUMAR K\\Desktop\\CensusData.csv";

    /**
     * Tc1.1Given the StatesCensus CSV file, Check to ensure the Number of Record matches
     * This is a Happy Test Case where the record are checked
     */
    @Test
    public void givenIndianCensusCSVFile_WhenLoad_ShouldReturnCorrectRecordsHappyTest() throws CensusAnalyzerException {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int count = censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
        Assertions.assertEquals(10, count);
    }

}