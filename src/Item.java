import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class Item{

    private String isbn, username;
    private String bookName = "";
    private int quantity;
    private double price;
    private HashMap<String,Double> usersPricesList = new HashMap<String,Double>();


    public Item(String isbn, String bookname, int quantity, String username, double price){
        this.setISBN(isbn);
        this.setBookName(bookname);
        this.setPrice(price);
        this.setQuantity(quantity);
        this.setUsername(username);
        this.usersPricesList.put(username, price);
    }

    public void addUsersPricesList(String username, double price){
        this.usersPricesList.put(username, price);
    }
    public void modifyUsersPricesList(String username, double price){
        this.usersPricesList.replace(username, price);
    }

    public void setISBN(String isbn){
        this.isbn = isbn;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setBookName(String bookName){
        this.bookName = bookName;
    }

    public void setPrice(double newPrices) {
        this.price = newPrices;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getISBN() {
        return this.isbn;
    }
    
    public String getBookName() {
        return this.bookName;
    }

    public String getUsername() {
        return this.username;
    }
 
    public HashMap<String,Double> getUsersPricesList(){
        return this.usersPricesList;
    }
    
    public int getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public ArrayList<String> printNReturnMatchingBookList(){
        ArrayList<String> list = new ArrayList<String>();
        int count = 0;
        for (Map.Entry<String, Double> entry : usersPricesList.entrySet()) {
            count++;
            System.out.println(count + ". " + entry.getKey() + "\t\t$" + entry.getValue());
            list.add(entry.getKey());
        }
        return list;
    }

    public void priceList() {
        int count = 0;
        for (Map.Entry<String, Double> entry : usersPricesList.entrySet()) {
            count++;
            System.out.println(count + ".\t\t$ " + entry.getValue() + "\t\tSell by: " + entry.getKey() + "\n");
        }
    }

    public void deleteAnItemBasedOnUser(String username){
        this.usersPricesList.remove(username);
    }

}
