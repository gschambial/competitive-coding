/**
 *  Copyright 2018 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */  
package com.catchexceptions.cocepts;

/**
 *  
 *  @version     1.0, 07-Oct-2018
 *  @author gourav
 */
public class TestingConcepts {
    
   public static void main(String[] args) {
       
       System.out.println("----------Testing Integer Pool-----------");
       
       Integer one = 1;
       Integer againOne = 1;
       System.out.println(one == againOne);
       
       System.out.println("----------Testing Float Pool-----------");
       Float floatOne = 1f;
       Float againFloatOne = 1f;
       System.out.println(floatOne == againFloatOne);
       
   } 

}
