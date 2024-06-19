package fileUtility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONFileUtility {
	public String getDataFromJsonFile(String key) throws Exception, FileNotFoundException {
		JSONParser jp=new JSONParser();
		Object obj=jp.parse(new FileReader("./testData/CommonData.json"));
		JSONObject jobj=(JSONObject)obj;
		
		return (String)jobj.get(key);
	}
}
