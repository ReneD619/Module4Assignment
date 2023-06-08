package module4assignment;

import java.sql.*;
import java.util.Scanner;

public class Module4Assignment {

    public static void main(String[] args) {
        //SELECT ProductName FROM Products WHERE ProductLine = 'classic cars';
                   
        try { 
        //Step 1:  Create a connection to the database 
        Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/northwind", "root", "admin");
            
        //Step 2 Create a new SQL statement using the connection
        Statement stmt = con.createStatement();
                        
        //Step 3 Execute the SQL statement to retrieve a result set of records from the database.
        ResultSet rs = stmt.executeQuery("select * from categories");
        
        //Step 4
         while (rs.next()){
            System.out.println(rs.getString("ProductName"));

        } //end while loop
        
        //Step 5 close the connection to the database
         con.close();
         
        //Ask the user if they would like to see the inventory of cats, ships, or motocycles
        System.out.println("Enter 1 to see classic cars, enter 2 to see ships, or enter 3 to see motocycles");
        
        //Use a scanner object to get the input from the user
        Scanner scanner = new Scanner(System.in);
        
        //Get the input from the user
        String userInput = scanner.next();
        
        //Variable to hold the SQL statement
        String sql = "";
        
        //Test the user input and display the correct type of products that the user wants to see
        switch(userInput){
            case "1":
                sql = "SELECT * FROM Products WHERE ProductLine = 'classic cars'";
                break;
            case "2":
                sql = "SELECT * FROM Products WHERE ProductLine = 'ships'";
                break;
            case "3":
                sql = "SELECT * FROM Products WHERE ProductLine = 'motocycles'";
                break;                   
        }//end switch
        
        //Execute a query against the Classic Models database to retrieve a list of products for the product line chosen by the user
        rs = stmt.executeQuery(sql);
        
        //Iterate through the resultset from the database
         while (rs.next()){
            System.out.println(rs.getString("ProductName") + " " + rs.getString("ProductLine"));

        } //end while loop
        
        //Insert a new record into the database
        //stmt.executeUpdate("INSERT INTO PRODUCTS(productCode, productName, productLine, productScale, productVendor, productDescription, quantity, buyPrice, MSRP) VALUES (\"S72_3213\",\"USS Monitor\", \"Ships\", \"1:72\", \"Second Gear Diecast\", \"Ironclad warship with her steam engine and revolving turret\", 780, 35.00, 55.00);\n");
        
        //Retrieve the record from the USS monitor and display it
        rs = stmt.executeQuery("SELECT * FROM Products WHERE productCode = 'S72_3213'");

        //Iterate through the resultset from the database
         while (rs.next()){
            System.out.println(rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(1));

        } //end while loop
         
        //Update the record for the USS Monitor. Change the model's scale to 1:10.
        
        //Step 5 close the connection to the database
         con.close();
         
         }catch(Exception e){
        System.out.println(e);
        
         }//end try catch
    }//end try catch

} //end main