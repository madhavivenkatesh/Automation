package files;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

class State{

    public String name;
    public int temperature;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

/*    public State(String name, int temperature){
        this.name = name;
        this.temperature = temperature;
    }*/
}

public class JSONSerializeDemo {

    public static void serializeJSON(File weatherJSON) throws IOException {
        if(!weatherJSON.exists())
            throw new FileNotFoundException("File Cannot be Found");

        ObjectMapper mapper = new ObjectMapper();
        State ca = new State();
        ca.setName("CA");
        ca.setTemperature(87);
        mapper.writeValue(weatherJSON,ca);
        String line = null;

        try(BufferedReader br = new BufferedReader(new FileReader(weatherJSON))){
            while((line = br.readLine())!= null){
                System.out.println(line);
            }
        }

        State readState = mapper.readValue(weatherJSON,State.class);
        System.out.println(readState.getName()+" "+readState.getTemperature());
    }
    public static void main(String[] args) throws IOException {
        File weatherJSON = new File("src/weather.json");
        weatherJSON.createNewFile();
        try{
            serializeJSON(weatherJSON);
        }catch(FileNotFoundException fexcp){
            System.out.println(fexcp.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
