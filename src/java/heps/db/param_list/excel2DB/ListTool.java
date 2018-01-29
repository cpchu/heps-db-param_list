/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.excel2DB;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Lvhuihui
 */
public class ListTool {

    public ListTool(ArrayList arrayList) {
        this.arrayList = arrayList;
    }
    public ListTool() {
        this.arrayList = null;
    }
    private ArrayList arrayList;

    public ArrayList getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList arrayList) {
        this.arrayList = arrayList;
    }
    
    public int getColNum(String name){ 
        int col=0;
        if(this.arrayList!=null&&!"".equals(this.arrayList)){
           Iterator it=this.arrayList.iterator();
           while(it.hasNext()){
              col=0;
              ArrayList rowList=(ArrayList)it.next();
              Iterator it1=rowList.iterator();
              while(it1.hasNext()){
                 String s=(String) it1.next();
                 if(s.toLowerCase().contains(name.toLowerCase())||s.equals(name)){
                     return col;
                 }
                 col++;
              }
           }
        }
        return col;
    }
}
