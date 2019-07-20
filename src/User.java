import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class User{

    String username;
    String password;

    private ArrayList<Item> boughtList = new ArrayList<Item>();
    private ArrayList<Item> sellingList = new ArrayList<Item>();

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String password() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void addToBoughtList(Item item){
        boughtList.add(item);
    }

    public void addToSellingList(Item item) {
        sellingList.add(item);
    }

    public void modifySellingList(Item item) {
        for (int i = 0; i < boughtList.size(); i++) {
            if(item.getISBN().equals(boughtList.get(i).getISBN())){
                boughtList.set(i, item);
            }
        }
    }

    public void printBoughtList(){
        try{
            for (int i = 0; i < boughtList.size(); i++) {
                System.out.println(
                        i + 1 + ": " + boughtList.get(i).getISBN() + "\t\tPrice: " + boughtList.get(i).getPrice());
            }
        }catch(NullPointerException e){
        }

        
        
    }

    public void printSellingList() {
        try{
            for (int i = 0; i < sellingList.size(); i++) {
                System.out.println(
                        i + 1 + ": " + sellingList.get(i).getISBN() + "\t\tPrice: " + sellingList.get(i).getPrice());
            }
        }catch (NullPointerException e) {
        }
        
    }

    public boolean sellingAlready(Item item){
        return sellingList.contains(item);
    }

    public void modifyPrice(Item item){
        for (int i = 0; i < sellingList.size(); i++) {
            if(sellingList.get(i).getISBN().equals(item.getISBN())){
                this.sellingList.set(i, item);
            }
        }
    }
    

}