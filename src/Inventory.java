import java.util.HashMap;
import java.awt.print.Book;
import java.util.ArrayList;;
public class Inventory {

    private ArrayList<Item> books = new ArrayList<Item>();

    public Inventory(){
        Item newBook = new Item ("9781792070113", "name1", 2);
        this.books.add(newBook);
        newBook = new Item("9781792070114", "name2", 1);
        this.books.add(newBook);
        newBook = new Item("9781792070115", "name3", 3);
        this.books.add(newBook);
    }

    public void setBooks(ArrayList<Item> books) {
        this.books = books;
    }

    public ArrayList<Item> getBooks(){
        return this.books;
    }

    public void printInventory() {
        System.out.println("################################     Book List     ################################");
        for(int i = 0; i < books.size(); i++){
            System.out.println( "Book Name: " + books.get(i).getBookName() + " ISBN: " + books.get(i).getISBN() + " Quantity: " + books.get(i).getQuantity());
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

    public void addBook(Item bookItem) {
        for (int i = 0; i < this.books.size(); i++) {
            if (this.books.get(i).getISBN().equals(bookItem.getISBN())) {
                if (this.books.get(i).getQuantity() > 1) {
                    // if there is more than 1 book in the inventory, add one to quantity
                    this.books.get(i).setQuantity(this.books.get(i).getQuantity() + bookItem.getQuantity());
                } else {
                    // if no book exists, simply add the book to the inventory
                    this.books.add(bookItem);
                }
            }
        }
    }


}
