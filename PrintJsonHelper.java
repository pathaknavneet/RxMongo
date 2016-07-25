package com.navneet.utilities;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

public class PrintJsonHelper {



	    public static String printJson(Object obj) throws IOException{
	        ObjectMapper mapper=new ObjectMapper();
	        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

	    }
	}

