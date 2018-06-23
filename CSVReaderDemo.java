package files;

//import com.opencsv.CSVReader;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CSVReaderDemo {

    public static void main(String[] args){

        System.out.println(args[0]);
        int numOfArgs = args.length;
        System.out.println(numOfArgs);
        assert numOfArgs>0 : "Please Provide input file path";
        String csvInputFile = args[0];
        String separator = ",";
        String line = null;

        try(BufferedReader br = new BufferedReader(new FileReader(csvInputFile)))
        {
            while((line = br.readLine()) !=null ){
                String[] country;
                country = line.split(separator);
                System.out.println(country[4]+" "+country[5]);
               /* for(String s:country) {
                    System.out.println(s);
                }*/
            }
        }catch(IOException e){
            System.out.println();
        }

        try{
            Scanner inputScanner = new Scanner(System.in);
            System.out.println("Provide CSV File to be read");
            String csvfile = inputScanner.nextLine();
            CSVReader reader = new CSVReader(new FileReader(csvfile));
            String[] row = null;
            while ((row=reader.readNext())!=null){
                System.out.println(row[2]);
            }
        }catch(IOException excep){
            System.out.println(excep.getMessage());
        }

    }
}
