/**
 * Author: Ali Ahad Mukhida
 */

package stockAnalysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author ali_ahad
 */
public class SMA 
{
    public double[] simple_moving_average (int m, double[] close_rate)
    {
        double sum;
        double average;
        ArrayList<Double> closing_rate = new ArrayList<Double>();
        for (int i = 0; i < close_rate.length; i++)
            closing_rate.add(close_rate[i]);
        
        //System.out.print(closing_rate.size());
        //System.out.print(closing_rate);
        
        ArrayList<Double> sma = new ArrayList<Double>();
        
        while(closing_rate.size() >= m)
        {
           sum = 0;
           average = 0;
           
           for (int i = 0; i < m; i++)
           {
               //System.out.println(closing_rate.get(i));
               sum += closing_rate.get(i);
               
           }
           
           //System.out.println(sum);
           average = sum / m;
           sma.add(average);
           closing_rate.remove(0);
        }
        
        double[] simple_moving_average;
        simple_moving_average = new double[sma.size()];
        
        for (int i = 0; i < sma.size(); i++)
            simple_moving_average[i] = sma.get(i);
        
        //System.out.print(sma);
        //for (int i = 0; i < sma.size(); i++)
            //System.out.printf("%.5f\n", simple_moving_average[i]);
        
        return simple_moving_average;
    }
}
