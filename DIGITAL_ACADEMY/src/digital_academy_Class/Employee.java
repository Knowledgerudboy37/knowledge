/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digital_academy_Class;

import java.util.ArrayList;

/**
 *
 * @author Ngobeni Knowledge
 */
public class Employee {

    private String name;
    private String contactNum;
    private String jobTitle;

    public enum Gender {

        F, M
    };
    private Gender gender;
    private Address address;

    public Employee() {
        this("", "", "", null, null);
    }
//address is an aggregated class of employee,i sent it as a paramater

    public Employee(String name, String contactNum, String jobTitle, Gender gender, Address address) {

        this.name = name;
        this.contactNum = contactNum;
        this.jobTitle = jobTitle;
        this.gender = gender;
        setAddress(address);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    //validating length of name 
    public void setName(String name) {
        if (name.length() > 2) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("length name must be grater than 2");

        }

    }

    public String getContactNum() {

        return contactNum;
    }

    //validating the contact number to have ten digits and ensures it starts with 0
    public void setContactNum(String contactNum) {
        if (contactNum.matches("\\d{10}")) {
            if (contactNum.startsWith("0")) {
                this.contactNum = contactNum;
            }
        } else {
            throw new IllegalArgumentException("contact must be 10 and start with zero");
        }

    }

    public String getJobTitle() {
        return jobTitle;
    }

    //validating jo title to have more than 1 character
    public void setJobTitle(String jobTitle) {
        if (jobTitle.length() >= 2) {
            this.jobTitle = jobTitle;
        } else {
            throw new IllegalArgumentException("job title must have at least 2 character");

        }

    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return name + "\t" + contactNum + "\t" + jobTitle + "\t" + gender + "\t" + address;
    }

    public void initConnection() throws DataStorageException {
        EmployeeDA.initConnection();
    }

    public void CreateCustomer(Employee objCustomer) throws NotFoundException {
        EmployeeDA.CreateCustomer(objCustomer);
    }

    public void EditCustomer(int CustomerNumber, String jobTitle) throws NotFoundException {
        EmployeeDA.EditCustomer(CustomerNumber, jobTitle);
    }

    public void DeleteCustomer(int customerNumber) throws NotFoundException {
        EmployeeDA.DeleteCustomer(customerNumber);
    }

    public ArrayList<Employee> ViewEmployees() throws NotFoundException {
        return EmployeeDA.ViewEmployees();

    }

    public ArrayList<Integer> EmployeeNumber() throws NotFoundException {
        return EmployeeDA.EmployeeNumber();

    }

    public void terminate() throws DataStorageException {
        EmployeeDA.terminate();
    }
}
