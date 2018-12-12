/**
 *  Copyright 2018 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */  
package com.catchexceptions.inheritance;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *  
 *  @version     1.0, 01-Sep-2018
 *  @author gourav
 */
public class Reader {
    
    
    FileInputStream fis;
    
    public void loadFile() {
        try {
            fis = new FileInputStream(new File("/home/gourav/somefile.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    
    public void closeFile() {
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
