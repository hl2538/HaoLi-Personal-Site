package com.haoli.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.haoli.dao.AuthDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Service

public class AuthService {

	private static String PRIVATE_TOKEN = "THWo3vygEnjcZJsxDCep";
	private static String BASE_URL_PRIVATE = "http://10.80.28.85/api/v3/";
	
	@Autowired
	AuthDao authDao;
	
	
	public String addProject() {
		String privateUrl = BASE_URL_PRIVATE+"projects?private_token="+PRIVATE_TOKEN;
		StringBuilder result = new StringBuilder(); 
		try {  
          URL url = new URL(privateUrl);
          HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
          connection.connect(); 
          BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));  
          String line;
          while ((line = br.readLine()) != null) {
              result.append(line);  
          }  
          br.close();
          connection.disconnect();
  		
      } catch (Exception e) {  
          e.printStackTrace();  
          System.out.println("失败!");  
      } 
		
		
		JSONArray jsonArray=JSONArray.fromObject(result.toString());
		for(Object param : jsonArray) {
			JSONObject jsonObj = JSONObject.fromObject(param);
			String name = jsonObj.getString("name");
	        String description = jsonObj.getString("description");
	        String createTime = jsonObj.getString("created_at");
	        
	        Map project = new HashMap();
	        project.put("name",name);
	        project.put("description",description);
	        project.put("createTime",createTime);
	        System.out.println(project);
	        System.out.println(authDao);
	        authDao.addProject(project);
		}
		return "success";
		
	}
	
	public static void main(String[] args) {
		AuthService auth = new AuthService();
		auth.addProject();
		
	}

}