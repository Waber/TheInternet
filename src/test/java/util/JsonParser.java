package util;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class JsonParser {
    String selectorMapUrl = "C:\\Users\\Standard\\IdeaProjects\\TheInternet\\src\\test\\resources\\selectorMap.json";
    BufferedReader reader;
    Gson gson = new Gson();
    Map map;


    public JsonParser(String setName){
        {
            try {
                reader = new BufferedReader(new FileReader(selectorMapUrl));
                map = (Map) gson.fromJson(reader,Map.class).get(setName);//w celu zmapowania tego konkretnego zbioru
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public Map getMap() {
        return map;
    }
}
