/**
 *  Copyright 2018 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */  
package catchexceptions.java.cocepts;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 *  
 *  @version     1.0, 12-Nov-2018
 *  @author gourav
 */
public class DateComparatorTest {
    
    public static void main(String[] args) {
        
        Calendar c1 = Calendar.getInstance();
        c1.set(2018, 11, 10);
        
        Calendar c2 = Calendar.getInstance();
        c2.set(2018, 11, 11);
        
        Date d1 = c1.getTime();
        Date d2 = c2.getTime();
        
        List<Date> dates = new ArrayList<>();
        dates.add(d1);
        dates.add(d2);
        
        for (Date date : dates) {
            System.out.println(date);
        }
        
        Collections.sort(dates, new Comparator<Date>() {
            @Override
            public int compare(Date a, Date b) {
                return b.compareTo(a);
            }
        });
        
        for (Date date : dates) {
            System.out.println(date);
        }
        
        
    }

}
