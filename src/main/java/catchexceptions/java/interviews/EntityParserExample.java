/**
 *  Copyright 2018 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package catchexceptions.java.interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.ValidationEvent;

/**
 * @version 1.0, 24-Nov-2018
 * @author gourav
 */
public class EntityParserExample {

    static long   rows   = 0;
    static long   result = 1;
    static String PREFIX = "<!ENTITY ";
    static String SUFFIX = ">";

    public static void main(String[] args) {
        int l = 5;
        List<String> entities = new ArrayList<>();
        entities.add("<!ENTITY a0 10>");
        entities.add("<!ENTITY a1 a0;a0>");
        //entities.add("<!ENTITY a2 10>");

        Map<String, String> keyValueMap = new HashMap<>();

        for (String entity : entities) {
            buildMap(entity, keyValueMap);
        }

        for (String key : keyValueMap.keySet()) {
            System.out.println("key: " + key + ", value: " + keyValueMap.get(key));
        }

        for (String entity : entities) {
            buildEntity(entity, keyValueMap, l);
        }

        System.out.println("result: " + result + ", rows: " + rows);
    }

    static void buildMap(String entity, Map<String, String> keyValueMap) {
        String[] entityArray = entity.split(" ");
        String key = entityArray[1];
        String value = entityArray[2].substring(0, entityArray[2].length() - 1);
        if (!(keyValueMap.containsKey(key))) {
            keyValueMap.put(key, value);
        }
    }

    static void buildEntity(String entity, Map<String, String> keyValueMap, long l) {
        String[] entityArray = entity.split(" ");
        String key = entityArray[1];
        String value = entityArray[2].substring(0, entityArray[2].length() - 1);

        String[] valueArray = value.split(";");
        if (valueArray.length == 1) {
            if (rows == l) {
                result = 0;
            }
            rows++;
        } else {

            for (String subValue : valueArray) {
                String subEntity = PREFIX + key + " " + keyValueMap.get(subValue) + SUFFIX;
               // System.out.println(subEntity);
                buildEntity(subEntity, keyValueMap, l);
            }

        }
    }

}
