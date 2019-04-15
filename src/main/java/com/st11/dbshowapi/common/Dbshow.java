package com.st11.dbshowapi.common;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class Dbshow {

    public static String getCurrentTime() {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(new Date());

        return formattedDate;
    }

    public static Map getParameterMap(HttpServletRequest request){

        Map parameterMap = new HashMap();
        Enumeration enums = request.getParameterNames();

        while(enums.hasMoreElements()){
            String paramName = (String)enums.nextElement();
            String[] parameters = request.getParameterValues(paramName);

            if(parameters.length > 1){
                parameterMap.put(paramName, parameters);
            }else{
                parameterMap.put(paramName, parameters[0]);
            }
        }
        return parameterMap;
    }

    public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.trim().isEmpty())
            return false;
        return true;
    }
}
