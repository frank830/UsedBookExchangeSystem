import java.util.Scanner;

public class Sell{

    String bookISBN, bookName;
    int quantity;

    public Sell(){

    }

    public void sell(Inventory inventory){
        this.bookISBN = getISBN();
        this.bookName = getBookName();
        this.quantity = getQuantity();
        this.addBook(inventory);
        //printSell();
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

    public String getBookName() {
        String tempBookName = "";
        Scanner input = new Scanner(System.in);
        System.out.println("Book Name: ");
        if (input.hasNextLine()) {
            tempBookName = input.nextLine();
        } else {
            System.out.println("ERROR! No input received!!!");
        }
        // need to check user input format!!!!!! (special character...)
        return tempBookName;
    }

    public int getQuantity(){
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

    public void addBook(Inventory inventory){
        //int inventorySize = inventory.getBooks().size();
        inventory.addBook(this.bookISBN, this.bookName, this.quantity);
    }

    public void printSell(){
        System.out.println("Selling");
    }

}