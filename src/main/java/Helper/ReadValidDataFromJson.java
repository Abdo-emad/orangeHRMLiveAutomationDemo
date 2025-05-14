package Helper;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadValidDataFromJson {
    public String userName ,password;
    public  void ReadValidCredentialsOnly() throws IOException, ParseException {
        String path = System.getProperty("user.dir")+"//src//main//java//Utilities//userData.json";
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray=(JSONArray) jsonParser.parse(new FileReader(path));
        for (Object object:jsonArray) {
             JSONObject jsonObject=(JSONObject) object;
              userName = (String) jsonObject.get("userName");
              password= (String) jsonObject.get("password");



        }
    }
}
