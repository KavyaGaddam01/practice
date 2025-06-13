package data_driven_testing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonFile {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		//Parse JSON physical file into java object using JSONParser class
		JSONParser parser = new JSONParser();
		Object javaObj = parser.parse(new FileReader("C:\\Users\\QSP\\Documents\\Commondata.json"));
		
		//Convert the java Object into JSON Object(Down-casting)
		JSONObject obj = (JSONObject) javaObj;
		//Read the data using get() by passing key
		String value = obj.get("Browser").toString();
		System.out.println(value);
	}

}
