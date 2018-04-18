   import java.awt.event.*;
   import javax.swing.*;
   import java.io.*;
   import java.util.*;
   import java.awt.*;
   public class Panel extends JPanel
   {
      private Customer[] customers;
      private Scanner findLength;
      private Scanner infile;
      private double[] cost;
      private String[] firstName, lastName;
      private JLabel[] data;
   	
      public Panel()
      {
         prepare();
       
         setLayout(new BorderLayout());
         
         JLabel title = new JLabel("Green and Grow Mowing Company");
         title.setHorizontalAlignment(SwingConstants.CENTER);
         add(title, BorderLayout.NORTH);
      	
         JPanel information = new JPanel();
      	
      }
      public JPanel fillInfoNames(JPanel arg)
      {
         arg.setLayout(new GridLayout(5,1));
         arg.add(new JLabel("Last Name:"));
         arg.add(new JLabel("First Name:"));
         arg.add(new JLabel("Lawn Size:"));
         arg.add(new JLabel("Total Cost:"));
         arg.add(new JLabel("Running Total: " ));
         return arg;
      }
      public void prepare()
      {
         Scanner scanner = new Scanner(System.in); 
         int length = getCustomerAmount(scanner.next());
         scanner.close();
         customers = new Customer[length];
         cost = new double[length];
         firstName = new String[length];
         lastName = new String[length];
         customers = input_Customer(customers);
         cost = input_Cost(customers, cost);
         firstName = input_firstName(customers, firstName);
         lastName = input_lastName(customers, lastName);
      }
      public String[] input_lastName(Customer[] arg1, String[] arg2)
      {
         if(arg2.length != arg1.length)
         {
            System.out.println("Mismatched array length");
            System.exit(0);
         }
         for( int i = 0; i < cost.length; i++)
            arg2[i] = arg1[i].getLastName();
         return arg2;
      
      }
      public String[] input_firstName(Customer[] arg1, String[] arg2)
      {
         if(arg2.length != arg1.length)
         {
            System.out.println("Mismatched array length");
            System.exit(0);
         }
         for( int i = 0; i < cost.length; i++)
            arg2[i] = arg1[i].getFirstName();
         return arg2;
      
      }
      public double[] input_Cost(Customer[] arg1, double[] arg2)
      {
         if(arg2.length != arg1.length)
         {
            System.out.println("Mismatched array length");
            System.exit(0);
         }
         for( int i = 0; i < cost.length; i++)
            arg2[i] = arg1[i].getCost();
         return arg2;
      }
      public Customer[] input_Customer(Customer[] c)
      {
         try{
            infile = new Scanner(new File("greenGrow.txt"));
         }
            catch(FileNotFoundException e)
            {
               System.out.println("No such file");
            }
         infile.next();
         for(int i = 0; i < c.length; i++)
         {
            int size = infile.nextInt();
            if(size <= 10000)
               c[i] = new Customer(new CustomerSmallYard(size, infile.next(), infile.next()));
            else if(size <= 20000)
               c[i] = new Customer(new CustomerMediumYard(size, infile.next(), infile.next()));
            else
               c[i] = new Customer(new CustomerLargeYard(size, infile.next(), infile.next()));
         }
         infile.close();
         return c;
      }
      public int getCustomerAmount(String s)
      {
         try{
            findLength = new Scanner(new File(s));
         }
            catch(FileNotFoundException e)
            {
               System.out.println("No such file");
            }
         int length = findLength.nextInt();
         findLength.close();
         return length;
      }
   }