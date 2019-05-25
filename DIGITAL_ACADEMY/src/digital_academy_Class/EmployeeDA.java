/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digital_academy_Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KNOWLETELO
 */
public class EmployeeDA {

    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement ps;
    private static ArrayList<Employee> arEmployee = new ArrayList<>();
    private static ArrayList<Integer> arEmployeeNumber = new ArrayList<>();


 public static void initConnection() throws DataStorageException {
        final String URL = "jdbc:mysql://localhost/EmployeeDB";
        final String USERNAME = "root";
        final String PASSWORD = "";
        final String Driver = "com.mysql.jdbc.Driver";

        try {
            //registering the class
            Class.forName(Driver);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException ex) {
            throw new DataStorageException("Driver missing" + ex.getMessage());
        } catch (SQLException ex) {
            throw new DataStorageException("connection failed" + ex.getMessage());
        }
    }
    public static void CreateCustomer(Employee objCustomer) throws NotFoundException {

        try {
            ps = con.prepareStatement("insert into tblEmployee (Name,ContactNumber,JobTitle,Gender,StreetName,City,PostalCode ) \n"
                    + "values (?,?,?,?,?,?,?) ");
            ps.setString(1, objCustomer.getName());
            ps.setString(2,objCustomer.getContactNum());
            ps.setString(3, objCustomer.getJobTitle());
            ps.setString(4, String.valueOf(objCustomer.getGender()));
            ps.setString(5, objCustomer.getAddress().getStreetName());
            ps.setString(6, objCustomer.getAddress().getCity());
            ps.setString(7, objCustomer.getAddress().getPostalCode());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new NotFoundException("Employee Creation failed, plz try again");

        }
    }

    public static void EditCustomer(int CustomerNumber, String jobTitle) throws NotFoundException {
        try {
            ps = con.prepareStatement("update tblEmployee set JobTitle=? where EmployeeNumber=?");
            ps.setString(1, jobTitle);
            ps.setInt(2, CustomerNumber);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new NotFoundException(" failed to edit Employee details, plz try again");
        }

    }

    public static void DeleteCustomer(int customerNumber) throws NotFoundException {
        try {
            ps = con.prepareStatement("Delete from tblEmployee where EmployeeNumber=? ");
            ps.setInt(1, customerNumber);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new NotFoundException(" failed to delete Employee details, plz try again");
        }
    }

    public static ArrayList<Employee> ViewEmployees() throws NotFoundException {
        arEmployee.clear();
        try {
            ps = con.prepareStatement("select * from tblEmployee");
            rs = ps.executeQuery();
            while (rs.next()) {
                arEmployee.add(new Employee(rs.getString("name"), rs.getString("ContactNumber"), rs.getString("JobTitle"), Employee.Gender.valueOf(rs.getString("Gender")),
                        (new Address(rs.getString("StreetName"), rs.getString("City"), rs.getString("PostalCode")))));

            }
        } catch (SQLException ex) {
            throw new NotFoundException(" failed to delete Employee details, enter correct and plz try again");
        }

        return arEmployee;

    }

    public static ArrayList<Integer> EmployeeNumber() throws NotFoundException {
 arEmployeeNumber.clear();
        try {
            ps = con.prepareStatement("select EmployeeNumber from tblEmployee");
            rs = ps.executeQuery();
            while (rs.next()) {
                arEmployeeNumber.add(rs.getInt("EmployeeNumber"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDA.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arEmployeeNumber;

    }

    public static void terminate() throws DataStorageException {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                throw new DataStorageException("failed to close the con");
            }
        }
    }
}
