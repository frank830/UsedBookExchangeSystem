import java.util.HashMap;
import java.util.ArrayList;;
public class Inventory {

    static HashMap<String, Integer> books = new HashMap<String, Integer>();
    //static ArrayList<Integer> amounts = new ArrayList<Integer>();
    //static ArrayList<Integer> prices = new ArrayList<Integer>();

    public static void initInventory(){
        books.put("9781792070112", 1);
        books.put("9781792070113", 2);
        books.put("9781792070114", 3);
    }

    public static void addBook(String bookISBN, int numOfBook){
        //books.put("9781792070112", 1);
        books.put(bookISBN, numOfBook);
    }

    public void printInventory() {
        System.out.println("Inventory");
    }

}
