/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.exl2db.tools;

import java.util.Comparator;
import java.util.Map;

/**
 *
 * @author lv
 */
public class MyComparator implements Comparator<Map.Entry<Integer, Double>> {

    @Override
    public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
        Double value1 = o1.getValue();
        Double value2 = o2.getValue();
        if (value1 > value2) {
            return 1;
        } else if (value1 < value2) {
            return -1;
        } 
        return 0;
    }    
}
