package files;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class NestedJSONReader {

    public static void readNestedJSON(String inputJSON) throws FileNotFoundException,ParseException,IOException
    {
        assert inputJSON!=null:"Input file is null";

        JSONParser nestedParser = new JSONParser();
        FileReader fileReader = new FileReader(inputJSON);
        Object obj = nestedParser.parse(fileReader);
        //JSONObject jsonObj = (JSONObject) obj;
        JSONArray array = (JSONArray)obj;
        Iterator<JSONObject> jsonobjs = array.iterator();
        while(jsonobjs.hasNext()){
            System.out.println(jsonobjs.next());
        }
    }
    public static void main(String[] args){
        try{
            readNestedJSON("src/nested_student.json");
        }catch(FileNotFoundException fileexcp){
            System.out.println(fileexcp.getMessage());
        }catch(IOException ioexcp){
            System.out.println(ioexcp.getMessage());
        }catch(ParseException pexcp){
            System.out.println(pexcp.getMessage());
        }

    }
}
