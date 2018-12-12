/**
 *  Copyright 2018 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */  
package com.catchexceptions.inheritance;

import java.io.IOException;

/**
 *  
 *  @version     1.0, 01-Sep-2018
 *  @author gourav
 */
public class PdfReader extends Reader{
    
    public void process() {
        byte[] bArr = null;
        try {
            fis.read(bArr);
            //do something with bArr
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
