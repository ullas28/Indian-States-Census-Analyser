package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.bridgelabz.CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM;
import static com.bridgelabz.CensusAnalyzerException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT;

class CensusAnalyserTest {
    private String INDIAN_CENSUS_CSV_FILE_PATH = "C:\\Users\\ULLASKUMAR K\\Desktop\\CensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String INCORRECT_FILE_FORMAT = "C:\\Users\\ULLASKUMAR K\\Desktop\\Prophecy.txt";
    @Test
    public void givenIndianCensusCSVFile_WhenLoad_ShouldReturnCorrectRecordsHappyTest() throws CensusAnalyzerException {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        int count = censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
        Assertions.assertEquals(10, count);
    }


    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowExceptionSadTest() {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            CensusAnalyzerException exceptionRule = Assertions.assertThrows(CensusAnalyzerException.class,()->{
                censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
            });
            Assertions.assertEquals(CENSUS_FILE_PROBLEM, exceptionRule.type);
    }

    @Test
    public void givenIndianCensusCSVFile_WhenCorrectPathButWrongFileFormat_ShouldThrowExceptionSadTest() {

            CensusAnalyser censusAnalyser = new CensusAnalyser();
            CensusAnalyzerException exceptionRule = Assertions.assertThrows(CensusAnalyzerException.class,()->{
                censusAnalyser.loadIndiaCensusData(INCORRECT_FILE_FORMAT);
            });
            Assertions.assertEquals(CENSUS_INCORRECT_FILE_FORMAT, exceptionRule.type);
        }
    }
