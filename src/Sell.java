import java.util.Scanner;

public class Sell{

    public void sell(){
        String bookISBN = getISBN();
        int amount = getAmount();

        //add book 
        addBook(bookISBN);

        //for debugging
        printSell();
    }

    public String getISBN(){
        String tempISBN = "";
        Scanner input = new Scanner(System.in);
        System.out.println("bookISBN: ");
        if(input.hasNextLine()){
        	 tempISBN = input.nextLine();
        }else{
            System.out.println("ERROR! No input received!!!");
        }
        // need to check user input format!!!!!! (special character...)
        return tempISBN;
    }

    public int getAmount(){
        int numOfBooks = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("numOfBooks: ");
        if (input.hasNextLine()) {
            numOfBooks = input.nextInt();
        }else {
            System.out.println("ERROR! No input received!!!");
        }
        return numOfBooks;
    }

    public void addBook(String isbn){
        int inventorySize = Inventory.books.size();
        Inventory.addBook(isbn, inventorySize - 1);
    }

    public void printSell(){
        System.out.println("Selling");
        System.out.println(Inventory.books);
    }

}