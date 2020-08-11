/*  Java Class: AVLTreeDriver.java
    Author: Jin Choi
    Class: CSCI 220
    Date: 12/4/17
    Description: The main driver for the AVL Tree implementation. Runs a buffered file reader to take in inputs from text file p4small.txt and holds the menu

    I certify that the code below is my own work.

	Exception(s): N/A

*/

import java.util.Scanner;
import java.io.*;

public class AVLTreeDriver {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader("/home/john/Documents/CSCI220/p4small.txt"));
            String currLine;
            Integer code;
            Integer population;
            String name;
            while((currLine = reader.readLine()) != null){
                String[] input = currLine.split(",");
                code = Integer.parseInt(input[0]);
                population = Integer.parseInt(input[1]);
                name = input[2]+","+input[3];
                tree.insert(tree.getRoot(),new Record(code,population,name));
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Population Database for California Counties Menu: ");
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("1. Search a record\n2. Insert a record\n3. Delete a record\n4. List all records\n5.Exit");
            System.out.print("Enter a selection: ");
            Integer selection = in.nextInt();
            if(selection == 5){
                System.out.println("Terminating Program. ");
                in.close();
                break;
            }
            System.out.println("Select 1. Root 2. Left Node 3. Right Node: ");
            Integer startingLocation = in.nextInt();
            AVLNode nodeParameter = null;
            switch(startingLocation){
                case 1: nodeParameter = tree.getRoot(); break;
                case 2: nodeParameter = tree.getRoot().getLeft(); break;
                case 3: nodeParameter = tree.getRoot().getRight(); break;
            }

            switch(selection){
                case 1:
                    System.out.println("Enter the county/state code: ");Integer numInput = in.nextInt(); Record record = tree.search(nodeParameter, numInput);
                    if (record != null){
                        System.out.println("\n" + record.toString() + "\n\n" + "Process took " + tree.getTime() + " ms. \n");
                    }break;
                case 2:
                    System.out.println("Input the county/state code, population, and county/state name in this format:\n'Sample: 12345 4321 Nowhere, CA':\n ");
                    String input ="";
                    in.nextLine();
                    input = in.nextLine();
                    String[] inputarr = input.split(" ");
                    Integer code = Integer.parseInt(inputarr[0]);
                    Integer population = Integer.parseInt(inputarr[1]);
                    String countyName = inputarr[2]+","+inputarr[3];
                    Record newRecord = new Record(code, population, countyName);
                    tree.insert(nodeParameter, newRecord);
                    System.out.println("Inserted " + input +" into the records.\n\n" + "Process took " + tree.getTime() + " ms. \n"); break;
                case 3:
                    System.out.println("Enter the county/state code to be deleted from the records: "); Integer deleteCode = in.nextInt(); Record deletedRecord = tree.remove(nodeParameter,deleteCode);
                    if (deletedRecord!= null){
                        System.out.println("Deleted Record: " + deletedRecord.toString() + "\n\n" + "Process took " + tree.getTime() + " ms. \n");
                    }break;
                case 4:
                    System.out.println("Constructing an in-order traversal list: ");
                    tree.debug(nodeParameter);
                    System.out.println("\nProcess took " + tree.count(nodeParameter) + " ms. \n"); break;
                case 5:
                    System.out.println("Terminating Program."); in.close(); break;
            }
        }
    }
}
