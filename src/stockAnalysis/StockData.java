/**
 * Author: Ali Ahad Mukhida
 */

package stockAnalysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StockData 
{
    private String input_file;
    
    private double split_string(String line)
    {
        int count = 0;
        double result = 0;
        String[] array = line.split(",");           
        for (String str : array)
        {           
                    //System.out.println(str);
            if (count == 4)
            {
                //System.out.println(str);
                result = Double.parseDouble(str);
                //System.out.println(result);
            }
            count++;
         } 
        
        return result;
    }
    
    public double[] Openfile(String s)
    {   
        input_file = s;
        try 
        {
            Scanner read_data = new Scanner(new File(input_file + ".csv"));
            read_data.nextLine();
            //double result;
            ArrayList<Double> closing_prices = new ArrayList<>();
            
            while(read_data.hasNextLine())
            {
                //int count;
                String line = read_data.nextLine();
                closing_prices.add(split_string(line));

            }
            
            double close_rate[];
            close_rate = new double[closing_prices.size()];
            
            for (int i = 0; i < closing_prices.size(); i++)
                close_rate[i] = closing_prices.get(i);
            
            //for (int i = 0; i < closing_prices.size(); i++)
                //System.out.println(close_rate[i]);
            
            return close_rate;
        }
        
        catch(FileNotFoundException e)
        {
            System.out.println("File Reading Errors\n");
            System.out.println(e);
        }
        return null;
        
    }
    
    
    
}
