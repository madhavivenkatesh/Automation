package files;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class SimpleJSONReaderDemo {

    public static void readJson(String inputJSON) throws IOException, ParseException {

        File inputFile = new File(inputJSON);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Input file does not exist");
        }
        JSONParser jsonparser = new JSONParser();
        FileReader filereader = new FileReader(inputFile);
        Object obj = jsonparser.parse(filereader);
        JSONObject jsonObj = (JSONObject)obj;
        System.out.println(jsonObj.get("Id"));
        System.out.println(jsonObj.get("Name"));
        JSONArray courseList = (JSONArray) jsonObj.get("CourseRegistered");
        Iterator<String> courseiter = courseList.iterator();
        while(courseiter.hasNext()){
            System.out.println(courseiter.next().toString());
        }
    }
    public static void main(String[] args) throws ParseException,IOException{
        System.out.println("Enter the JSON File path to be Parsed");
        Scanner inputReader = new Scanner(System.in);
        String inputJSON = inputReader.nextLine();
        assert inputJSON!=null : "Input Provided is null , Please provide valid input";
        readJson(inputJSON);
    }
}
