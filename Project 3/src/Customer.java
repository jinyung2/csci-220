/*  Java Class: Customer.java
    Author: Jin Choi
    Class: CSCI 220
    Date: 11/6/17
    Description: A Customer class that stores information for the CallCenterSimulation.

    I certify that the code below is my own work.

	Exception(s): N/A

*/
public class Customer {
    private int callTime;
    private int serviceTime;
    private String customerID;

    public Customer(int t, String ID){
        callTime = t;
        customerID = ID;
    }
    public void setID(String s){customerID = s;}
    public String getID(){return customerID;}
    public int getServiceTime(){ return serviceTime; }
    public void setServiceTime(int n){serviceTime = n;}
    public void decreServeTime(){this.serviceTime -= 1;}
    public int getCallTime(){return callTime;}
    public int waitTime(){return serviceTime-callTime;}
}
