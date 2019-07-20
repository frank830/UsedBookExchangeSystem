import java.util.HashMap;
import java.awt.print.Book;
import java.util.ArrayList;;
public class Inventory {

    private ArrayList<Item> books = new ArrayList<Item>();

    public Inventory(){
        Item newBook = new Item ("9781792070113", "bookname1", 1, "admin1", 100.0);
        this.books.add(newBook);
        newBook = new Item("9781792070114", "bookname2", 1, "admin2", 200.0);
        this.books.add(newBook);
        newBook = new Item("9781792070115", "bookname3", 1, "admin3", 300.0);
        this.books.add(newBook);
        newBook = new Item("1", "bookname4", 1, "admin3", 400.0);
        this.books.add(newBook);
    }

    public void setBooks(ArrayList<Item> books) {
        this.books = books;
    }

    public ArrayList<Item> getBooks(){
        return this.books;
    }

    public void printInventory() {
        System.out.println("################################     Book List     ################################\n");
        for(int i = 0; i < books.size(); i++){
            System.out.println( "Book Name: " + books.get(i).getBookName() + " ISBN: " + books.get(i).getISBN() + " Quantity: " + books.get(i).getQuantity()+ " Prices are the following: ");   
            books.get(i).priceList();
        }
        System.out.println("###################################################################################");
    }

    public Item searchBookByIsbn(String tempBookISBN){
        for(int i = 0; i < this.books.size();i++){
            if(this.books.get(i).getISBN().equals(tempBookISBN)){
                return this.books.get(i);
            }
        }
        return null;
    }
    
    public Item searchBookByBookName(String tempBookName) {
        for (int i = 0; i < this.books.size(); i++) {
            if (this.books.get(i).getBookName().equals(tempBookName)) {
                return this.books.get(i);
            }
        }
        return null;
    }


    public void printMatchingBookList(String tempBookISBN){
        int count = 1;
        for (int i = 0; i < this.books.size(); i++) {
            if (this.books.get(i).getISBN().equals(tempBookISBN)) {
                System.out.println(count + ". " + this.books.get(i).getBookName() + "\t\t$" + this.books.get(i).getPrice());
                count++;
            }
        }
    }


}
