  import java.util.Scanner;
   public class Driver01
   {
      public static final int NUMITEMS =10;
      private static double sum=0,avg=0,min = 0,max=0;
      public static void main(String[] args)
      {
			double[] array = new double[NUMITEMS];
			Scanner keyboard = new Scanner(System.in);
			for(int x = 0; x<NUMITEMS; x++)
			{
				System.out.print("#"+(x+1)+": ");
				array[x] = keyboard.nextDouble();
			}
			min = array[0];
			max = array[0];
			for(int x = 0; x<array.length;x++)
			{
				sum=sum+array[x];
				min=Math.min(min,array [x]);
				max=Math.max(max,array[x]);
         }
			System.out.println("\t Sum: "+sum);
         System.out.println("\t Avg: "+sum/array.length);
         System.out.println("\t Min: "+min);
			System.out.println("\t Max: "+max);
		}
	}