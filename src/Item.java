import java.util.HashMap;
import java.util.ArrayList;;

public class Item{

    private String isbn, bookName;
    private int quantity;

    public Item(String isbn, String bookName, int quantity){
        this.setISBN(isbn);
        this.setBookName(bookName);
        this.setQuantity(quantity);
    }

    public void setISBN(String isbn){
        this.isbn = isbn;
    }

    public void setBookName(String bookName){
        this.bookName = bookName;
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
    
    public int getQuantity() {
        return this.quantity;
    }

}
