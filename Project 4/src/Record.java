/*  Java Class: Record.java
    Author: Jin Choi
    Class: CSCI 220
    Date: 12/4/17
    Description: Stores the code, population and county name of each entry into the tree.

    I certify that the code below is my own work.

	Exception(s): N/A

*/

public class Record {
    private Integer code;
    private Integer population;
    private String countyName;

    public Record(Integer code, Integer population, String countyName){
        this.code = code;
        this.population = population;
        this.countyName = countyName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }
    public String toString(){
        return "0" + code + ", " + population + ", " + countyName;
    }
}
