package com.bridgelabz;

public class CensusAnalyzerException extends Exception{
    public enum ExceptionType {
        CENSUS_FILE_PROBLEM, CENSUS_INCORRECT_FILE_FORMAT, CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER
    }

    public ExceptionType type;

    public CensusAnalyzerException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public CensusAnalyzerException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
