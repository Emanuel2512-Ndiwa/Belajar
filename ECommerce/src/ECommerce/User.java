package ECommerce;

import java.util.ArrayList;
import CLI.Actionable;

public class User {


    //atribute
    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    
    protected ArrayList<Actionable>actions;



    //method gett
    public int getID() {
        return ID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }


    //method setter
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
