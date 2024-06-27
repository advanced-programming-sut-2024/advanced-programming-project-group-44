package com.ap.gwentgame;

public class Utilities {
    public static String getResourcePath(String path){
        return Utilities.class.getResource("/com/ap/gwentgame/" + path).toExternalForm();

    }
}
