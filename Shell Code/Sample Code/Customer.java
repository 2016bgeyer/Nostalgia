   public class Customer
   {
      private Yard myYard;
      private double Cost;
      private int Size;
      private String firstName;
      private String lastName;
      public Customer(Yard y)
      {
         myYard = y;
         Cost = y.getCost();
         Size = y.getSize();
         firstName = y.getFirstName();
         lastName = y.getLastName();
      }
      public double getCost()
      {
         return this.Cost;
      }
      public int getSize()
      {
         return this.Size;
      }
      public String getFirstName()
      {
         return this.firstName;
      }
      public String getLastName()
      {
         return this.lastName;
      }
   }