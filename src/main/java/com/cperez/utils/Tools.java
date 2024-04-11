package com.cperez.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class Tools {

    private static Logger LOGGER = Logger.getLogger(Tools.class.getName());
    
    private Tools() {
    	throw new IllegalStateException("Utiliy class"); 
    }
    
    public static Date getDateFormat(String format, String date) {
    	SimpleDateFormat formatter = new SimpleDateFormat(format); 
    	try {
			return formatter.parse(date);
		} catch (ParseException e) {
        	LOGGER.warning(e.getMessage()); 
		}
		return null; 
    }
    
    public static String dateToString(String format, Date date) {
    	SimpleDateFormat formatter = new SimpleDateFormat(format);
    	return formatter.format(date==null?new Date(): date); 
    }

    public static String execCommand(String command){
        StringBuilder sb = new StringBuilder();
        if (command.isEmpty())
            return "";
        String s = "";
        BufferedReader std = null;
        Runtime run = Runtime.getRuntime();
        Process p = null;
        try {
            p = run.exec(command);
            std = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((s=std.readLine()) != null){
                sb.append(s).append("\n");
                LOGGER.info(s.trim());
            }
        } catch (IOException ex) {
            LOGGER.info(ex.getMessage());
        } catch (SecurityException ex){
        	LOGGER.warning(ex.getMessage());
        }
        return sb.toString();
    }
}
