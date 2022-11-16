package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.bridgelabz.CensusAnalyzerException.ExceptionType.*;

class CensusAnalyserTest {
    private String INDIAN_CENSUS_CSV_FILE_PATH = "C:\\Users\\ULLASKUMAR K\\Desktop\\CensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String INCORRECT_FILE_FORMAT = "C:\\Users\\ULLASKUMAR K\\Desktop\\Prophecy.txt";
    private static final String CSV_WITH_WRONG_DELIMITER = "C:\\Users\\ULLASKUMAR K\\Desktop\\Data.csv";

    private static final String CSV_WITH_INCORRECT_HEADER = "C:\\Users\\ULLASKUMAR K\\Desktop\\Data.csv";

    private static final String INDIA_STATE_CODE_CSV = "C:\\Users\\ULLASKUMAR K\\Desktop\\Statecodee.csv";
    private static final String WRONG_STATE_CODE_CSV_PATH = "./src/main/resources/IndiaStateCode.csv";
    private static final String STATE_CODE_INCORRECT_FILE_FORMAT = "C:\\Users\\ULLASKUMAR K\\Desktop\\Prophecy.txt";
    private static final String STATE_CODES_WITH_WRONG_DELIMITER = "C:\\Users\\ULLASKUMAR K\\Desktop\\IncorrectStatecodee.csv";
    private static final String STATE_CODES_WITH_INCORRECT_HEADER = "./src/test/resources/IndiaStateCodeIncorrectHeader.csv";

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

    @Test
    public void givenIndianCensusCSVFile_WhenCustomDelimiter_ShouldThrowExceptionSadTest(){
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        CensusAnalyzerException exceptionRule = Assertions.assertThrows(CensusAnalyzerException.class,()->{
            censusAnalyser.loadIndiaCensusData(CSV_WITH_WRONG_DELIMITER);
        });
        Assertions.assertEquals(CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER, exceptionRule.type);
    }

    @Test
    public void givenIndianCensusCSVFile_WhenIncorrectHeader_ShouldThrowExceptionSadTest() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        CensusAnalyzerException exceptionRule = Assertions.assertThrows(CensusAnalyzerException.class,()->{
            censusAnalyser.loadIndiaCensusData(CSV_WITH_INCORRECT_HEADER);
        });
        Assertions.assertEquals(CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER, exceptionRule.type);
    }

    @Test
    public void givenIndiaStateCodeCSVFile_WhenCorrectPath_ShouldReturnsCorrectRecordsHappyTest() throws CensusAnalyzerException {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndianStateCode(INDIA_STATE_CODE_CSV);
            Assertions.assertEquals(9,numOfRecords);
    }

    @Test
    public void givenIndianStateCodeCSVFile_WhenWithWrongFilePath_ShouldThrowExceptionSadTest() {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        CensusAnalyzerException exceptionRule = Assertions.assertThrows(CensusAnalyzerException.class,()->{
            censusAnalyser.loadIndianStateCode(WRONG_STATE_CODE_CSV_PATH);
        });
        Assertions.assertEquals(CENSUS_FILE_PROBLEM, exceptionRule.type);
    }
}
