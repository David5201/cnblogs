package com.cnblogs.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cnblogs.json.pojo.Person;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	String str="{\"family[0].FamilyName\": \"第一个\",\"family[0].Sex\": \"1\",\"family[1].FamilyName\": \"第二个\",\"family[1].Sex\": \"1\"}";
    	JsonParser parse =new JsonParser();  //创建json解析器
    	JsonObject json=(JsonObject)parse.parse(str); //创建jsonObject对象

    	Iterator<String> it = json.keySet().iterator();
    	List<JsonObject> lst = new ArrayList<JsonObject>();
    	JsonObject jo= new JsonObject(); 
    	while(it.hasNext()){
    		String key = it.next();
    		String value = json.get(key).getAsString();
    		if(key.contains("FamilyName")){
    			jo.addProperty("FamilyName", value);
    		}else{
    			jo.addProperty("sex", value);
    			lst.add(jo);
    			jo = new JsonObject();
    		}
    	}
    	
    	System.out.println(lst.toString());
    	
//    	for(int i=0;i<lst.size();i++){
//    		Person ps1=(Person)lst.get(i);
//    		System.out.println("FamilyName: " + ps1.getFamilyName() + "   Sex:"+ps1.getSex());
//    	}
    }
}
