package com.bridgelabz;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CensusAnalyser {

    public boolean isValidFile (String filePath, String desriedType){
        File fileToCheck = new File(filePath);
        String filename = fileToCheck.getName();
        String extension = "";
        int i = filename.lastIndexOf('.');
        if (i > 0) {
            extension = filename.substring(i + 1);
        }
        return extension.equals(desriedType);
    }
    public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyzerException {
        boolean b = isValidFile(csvFilePath, "csv");
        if (b){
            try {
                Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
                CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
                csvToBeanBuilder.withType(IndiaCensusCSV.class);
                csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
                CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
                Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
                ;
                int namOfEateries = 0;
                while (censusCSVIterator.hasNext()) {
                    namOfEateries++;
                    IndiaCensusCSV censusData = censusCSVIterator.next();
                }
                return namOfEateries;
            }
            catch (IOException e) {
                throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM);
            } catch (RuntimeException e) {
                throw new CensusAnalyzerException("CSV File Must Have Comma As Delimiter Or Has Incorrect Header", CensusAnalyzerException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER);
            } }
            else {
                throw new CensusAnalyzerException("File format not supported", CensusAnalyzerException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT);
            }
    }

    public int loadIndianStateCode(String csvFilePath) throws CensusAnalyzerException {
        try {
            if(csvFilePath.contains(".txt")) {
                throw new CensusAnalyzerException("File must be in CSV Format", CensusAnalyzerException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT);
            }
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<IndiaStateCSV> csvToBeanBuilder = new CsvToBeanBuilder<IndiaStateCSV>(reader);
            csvToBeanBuilder.withType(IndiaStateCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaStateCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaStateCSV> stateCodesCSVIterator = csvToBean.iterator();
            int numberOfEntries = 0;
            while(stateCodesCSVIterator.hasNext()) {
                numberOfEntries++;
                IndiaStateCSV censusData = stateCodesCSVIterator.next();
            }
            return numberOfEntries;
        }
        catch (IOException e) {
            throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
        catch(RuntimeException e) {
            throw new CensusAnalyzerException("CSV File Must Have Comma As Delimiter Or Has Incorrect Header", CensusAnalyzerException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER);
        }
    }
}


