import java.util.HashMap;
import java.awt.print.Book;
import java.util.ArrayList;;
public class Inventory {

    private ArrayList<Item> books = new ArrayList<Item>();

    public Inventory(){
        addBook("9781792070113", "name1", 2);
        addBook("9781792070114", "name2", 1);
        addBook("9781792070115", "name3", 3);
    }

    public void addBook(String bookISBN, String bookName, int numOfBook){
        //books.put("9781792070112", 1);
        Item tempBook = new Item(bookISBN, bookName, numOfBook);
        books.add(tempBook);
    }

    public void setBooks(ArrayList<Item> books) {
        this.books = books;
    }

    public ArrayList<Item> getBooks(){
        return this.books;
    }

    public void printInventory() {
        for(int i = 0; i < books.size(); i++){
            System.out.println( books.get(i).getISBN() );
        }
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

}
