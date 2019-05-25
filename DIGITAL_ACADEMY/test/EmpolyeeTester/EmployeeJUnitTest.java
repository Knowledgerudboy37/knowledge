/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmpolyeeTester;

import org.junit.Test;
import static org.junit.Assert.*;
import digital_academy_Class.Employee;
import digital_academy_Class.Address;
/**
 *
 * @author KNOWLETELO
 */
public class EmployeeJUnitTest {
    
    Employee objEmployee;
    Address objaddress;
    
    //testing name
    @Test
    public void  testName() {
        objEmployee=new Employee("knowledge", "0785553910","admin", Employee.Gender.F, null);
        assertEquals("knowledge", objEmployee.getName());
        
    }
    //catching IllegalArgumentException 
    @Test(expected =IllegalArgumentException.class)
    public void  testNameException() {
        objEmployee=new Employee("knowledge", "0785553910","admin", Employee.Gender.F, null);
        objEmployee.setName("k");
        assertEquals("k", objEmployee.getName());
        
    } 
    //testing contact number
    @Test
      public void  testContactNum() {
        objEmployee=new Employee("knowledge", "0785553910","admin", Employee.Gender.F, null);
        objEmployee.setContactNum("0606895656");
        assertEquals("0606895656", objEmployee.getContactNum());
        
    } 
       //catching IllegalArgumentException
      @Test(expected =IllegalArgumentException.class)
      public void  testContactNumEx() {
        objEmployee=new Employee("knowledge", "0605553910","admin", Employee.Gender.F, null);
        objEmployee.setContactNum("7785553");
        assertEquals("7785553", objEmployee.getContactNum());
        
    } 
      //testing job title
         @Test
      public void  testJobTitle() {
        objEmployee=new Employee("knowledge", "0785553910","admin", Employee.Gender.F, null);
        objEmployee.setJobTitle("Finance");
        assertEquals("Finance", objEmployee.getJobTitle());
        
    } 
      //testing Streetname
      @Test
      public void  testStreetName() {
          objaddress=new Address("CE55","tzaneen","0861");
          objaddress.setStreetName("baju");
          assertEquals("baju", objaddress.getStreetName());
      }
      
      
       //catching IllegalArgumentException
       @Test(expected =IllegalArgumentException.class)
      public void  testStreetNameException() {
          objaddress=new Address("CE55","tzaneen","0861");
          objaddress.setStreetName("b");
          assertEquals("b", objaddress.getStreetName());
      }
      
         //testing City
      @Test
      public void  testCity() {
          objaddress=new Address("CE55","tzaneen","0861");
          objaddress.setCity("vereeniging");
          assertEquals("vereeniging", objaddress.getCity());
      }
      
      
       //catching IllegalArgumentException
       @Test(expected =IllegalArgumentException.class)
      public void  testCityException() {
          objaddress=new Address("CE55","tzaneen","0861");
          objaddress.setCity("ve");
          assertEquals("ve", objaddress.getStreetName());
      }
    //testing postal code
        @Test
      public void  testPostalCode() {
          objaddress=new Address("CE55","tzaneen","0861");
          objaddress.setPostalCode("1900");
          assertEquals("1900", objaddress.getPostalCode());
      }
      
      
       //catching IllegalArgumentException
       @Test(expected =IllegalArgumentException.class)
      public void testPostalCodeException() {
          objaddress=new Address("CE55","tzaneen","0861");
         objaddress.setPostalCode("190");
          assertEquals("190", objaddress.getPostalCode());
      }
    
}
