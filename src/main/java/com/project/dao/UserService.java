package com.project.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.project.SpringAppProjectApplication;

@Service
public class UserService {
	

	public String getFinalData(String data) {
		data = data.replaceAll("\\s", "");
String output=removeDuplicate(data);
		return output;

	
}

	static String removeDuplicate(String data) {
	    char[] chars = data.toCharArray();
	    char previous = chars[0];
	    int k = 0;
	    int i = 1;
	 int Count=0;
	    while (i < chars.length)
	    {
	    	if (previous != chars[i])
	        {
	        	
	            chars[++k] = chars[i++];    
	            previous = chars[k];            
	        }
	        else {
	            while (i < chars.length && previous == chars[i]) {
	                i++;  
	            }
	            Count++;
	            if(k>1)
	                previous = chars[--k];  
	                else
	                	k=-1;
	                         
	        }
	    }
	String output=new String(chars).substring(0, k + 1);
	    return output+"-"+Count;
}
	}