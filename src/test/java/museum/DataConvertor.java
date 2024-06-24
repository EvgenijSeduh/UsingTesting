package museum;

import java.util.HashMap;
import java.util.Map;

public class DataConvertor {
    private static final Map<String, Integer> nameAndNumberMonth= new HashMap<>();

    static{
        nameAndNumberMonth.put("января", 1);
        nameAndNumberMonth.put("февраля", 2);
        nameAndNumberMonth.put("мара", 3);
        nameAndNumberMonth.put("апреля", 4);
        nameAndNumberMonth.put("мая", 5);
        nameAndNumberMonth.put("июня", 6);
        nameAndNumberMonth.put("июля", 7);
        nameAndNumberMonth.put("августа", 8);
        nameAndNumberMonth.put("сентября", 9);
        nameAndNumberMonth.put("октября", 10);
        nameAndNumberMonth.put("ноября", 11);
        nameAndNumberMonth.put("декабря", 12);
    }
    public static Integer getNumberMonth(String nameMonth){
        if(nameAndNumberMonth.containsKey(nameMonth)){
            return nameAndNumberMonth.get(nameMonth);
        }else return -1;
    }
}
