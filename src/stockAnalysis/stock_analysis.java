/**
 * Author: Ali Ahad Mukhida
 */

package stockAnalysis;

import java.io.*;
import java.util.*;

public class stock_analysis
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("The prices of a stock in CSV format: ");
        String file = scan.next();

        System.out.print("The value of M: ");
        int M = scan.nextInt();

        System.out.print("The value of D: ");
        int D = scan.nextInt();

        try
        {
            // Object to read the stock data
            StockData read = new StockData();
            double[] closing_rate = read.Openfile(file);

            // Object to calculate simple moving average
            SMA sma = new SMA();
            double[] average = sma.simple_moving_average(M, closing_rate);

            // Object to calculate bollinger bands
            BBands bands = new BBands();
            double[] lowerBand = bands.lower_band(D, average, closing_rate, M);
            double[] upperBand = bands.upper_band(D, average, closing_rate, M);

            // Printing the data to a new CSV file
            PrintStream fw = new PrintStream(file + "_ta.csv");
            try
            {
                String header = M + "-day SMA,LowerBand(-" + D + "S.D.),UpperBand(+" + D + "S.D.)\n";
                fw.print(header);

                for (int i = 0; i < average.length; i++) {
                    fw.printf("%.5f,%.5f,%.5f\n", average[i], lowerBand[i], upperBand[i]);
                }
                fw.close();
            }
            catch (Exception e)
            {
                System.out.println("File writing errors");
                System.out.println(e);
            }

        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
        }

    }

}
