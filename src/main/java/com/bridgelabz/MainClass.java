package com.bridgelabz;

public class MainClass {
    public static void main(String[] args) {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        try {
            censusAnalyser.loadIndiaCensusData("IndiaStateCensusData.csv");
        } catch (CensusAnalyzerException e) {
            e.printStackTrace();
        }
    }
}
