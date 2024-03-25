/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author Cesar
 */
public class UtilDate {

    private static Date date;
    private static Calendar calendar;
    private static DateFormat df;
    
    public static Date calendarToDate(Calendar calendar){
        return date = calendar.getTime();
        
    }
    public static Calendar dateToCalendar(Date date){                  
        calendar.setTime(date);
        return calendar;
    }
    
    public static String formatDMY(Date data){
        try {
            DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
            return d.format(data);
        } catch (Exception ex) {
            ex.toString();
        }
        return null;
    }
    
     public static String formatDMY(Calendar calendar){
        try {
            Date data = calendar.getTime();
            DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
            return d.format(data);
        } catch (Exception ex) {
            MsgsErros.getErro("Erro ao converter data\n"+ ex.toString());
                    }
        return null;
    }
    
   public static Calendar somaDiasCalendar(int dias){
        calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, dias);
        return calendar;
   }
   
   public static Date somaDiasDate(int dias)    {
       try{
          calendar.add(Calendar.DATE, dias);          
          return date = calendar.getTime();
       }catch(Exception ex){
           MsgsErros.getErro("Erro ao somar data\n"+ ex.toString());
       }
       return null;
   }
}
