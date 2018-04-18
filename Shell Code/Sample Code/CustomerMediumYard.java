   public class CustomerMediumYard implements Yard, Comparable<Yard>
   {
      private double Cost;
      private int size;
      private String First_Name;
      private String Last_Name;
      public CustomerMediumYard( int s,String f, String l)
      {
         Cost = s*.004;
         size = s;
         First_Name = f;
        Last_Name = l;
      }
      public double getCost() 
      {
         return Cost;
      }
      public String getFirstName()
      {
         return First_Name; 
      }
      public String getLastName() 
      {
         return Last_Name;
      }
      public int compareTo(Yard y)
      {
         return First_Name.compareTo(y.getFirstName());	
      }
      public int getSize()
      {
         return size;
      }
   }