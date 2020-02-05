package app;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Nnamdi Okwechime
 *
 */
@Entity
public class BuddyInfo {

    @Id
    private  String name;
    private String phoneNumber;

    public BuddyInfo(){
    }


    public BuddyInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public BuddyInfo(String name){
        this.name = name;
        this.phoneNumber = "NO NUMBER";
    }

    public String greeting() {
        return "Hello " + name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public  void setName(String name) {
        this.name = name;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return "\n Name: " + name + ". Phone Number: " + phoneNumber + "\n";
    }
}
