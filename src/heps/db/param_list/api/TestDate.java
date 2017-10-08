/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.api;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Administrator
 */
public class TestDate {
    public  static void main(String[] args) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy",Locale.CHINESE);
        Date date = sdf.parse("");
        System.out.println("时间："+date);
    }
}
