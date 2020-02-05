package app;

import javax.persistence.*;
import java.util.*;
/**
 * @author Nnamdi Okwechime
 *
 */
@Entity
public class AddressBook {
    @Id
    @GeneratedValue
    public Long id;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<BuddyInfo> book;


    public AddressBook() {
        book = new ArrayList<BuddyInfo>();
    }

    public AddressBook(String name)
    {
        book = new ArrayList<BuddyInfo>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addBuddy(BuddyInfo contact) {
        book.add(contact);
    }

    public void addBuddy(String name){
        BuddyInfo temp = new BuddyInfo(name);
        book.add(temp);
    }

    public boolean removeBuddy(int index) {
        if(book.isEmpty()==true){return false;}
        else if (index >= 0 && index < book.size()) {
            book.remove(index);
            return true;
        }
        return false;
    }

    public List<BuddyInfo> getBuddyInfos(){
        return book;
    }

    public int size() {
        return book.size();
    }

    public void clear() {
        book.clear();
    }

    public String toString() {
        String info = "";
        if(book.isEmpty()== true){
            info = "Contact book is empty";
        }else {
            for (BuddyInfo b : book) {
                info += b.toString();
            }
        }
        return info;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("Address Book");
        BuddyInfo test = new BuddyInfo("Diddy", "I'll call you");
        BuddyInfo testted = new BuddyInfo("Reaper", "3435409483");

        AddressBook contactlist = new AddressBook();
        contactlist.addBuddy(test);
        contactlist.removeBuddy(0);
        contactlist.addBuddy(test);
        contactlist.addBuddy(testted);
        System.out.println(contactlist.toString());
    }
}







