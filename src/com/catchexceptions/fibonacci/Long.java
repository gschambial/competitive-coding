/**
 *  Copyright 2018 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */  
package com.catchexceptions.fibonacci;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *  
 *  @version     1.0, 07-Sep-2018
 *  @author gourav
 */
public class Long {

    public static void main(String[] args) {
        double actual = 29.45;
        double roundValue = BigDecimal.valueOf(actual).setScale(0, RoundingMode.HALF_UP).doubleValue();
        double roundDouble = roundValue * 1000000; 
        System.out.println("actual double: "+ roundValue);
        System.out.println("actual long: "+ (long) roundDouble);
        System.out.println("actual double: "+ ((long) roundDouble)/1000000);

    }

}
