/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digital_academy_Class;

/**
 *
 * @author Ngobeni knowledge
 */
public class Address {

    //delaring valiables

    private String streetName;
    private String City;
    private String postalCode;

    public Address() {
       
    }

    public Address(String streetName, String City, String postalCode) {
        this.streetName = streetName;
        this.City = City;
        this.postalCode = postalCode;
    }

    public String getStreetName() {
        return streetName;
    }

    //validating the Streetname to have atleast 4 character and above

    public void setStreetName(String streetName) {
        if (streetName.length() >= 3) {
            this.streetName = streetName;
        } else {
            throw new IllegalArgumentException("the Street name must be at least 3 characters");
        }

    }

    public String getCity() {
        return City;
    }
//validating the city,more than2 character
    public void setCity(String City) {
        if(City.length()>2){
         this.City = City;   
        }else{
          throw new IllegalArgumentException("the city must have at least 3 character");  
        }
        
    }

    public String getPostalCode() {

        return postalCode;
    }
//validating lenth to have morethan 3 didgits

    public void setPostalCode(String postalCode) {
        if (postalCode.length() == 4) {
            this.postalCode = postalCode;
        } else {
            throw new IllegalArgumentException("the postal code name must be 4 characters");
        }

    }

    @Override
    public String toString() {
        return "\t"+ streetName + "\t" + City +  "\t"+ postalCode ;
    }

}
