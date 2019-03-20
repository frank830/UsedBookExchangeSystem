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

        this.findBook(inventory, this.bookISBN);
        Item tempItem = inventory.searchBookByIsbn(this.bookISBN);
        this.addBook(inventory,tempItem,this.quantity);
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
    
    public Item findBook(Inventory inventory, String isbn){
        Item tempItem = inventory.searchBookByIsbn(this.bookISBN);
        return tempItem;
    }

    public void addBook(Inventory inventory, Item bookItem, int quantity ){
        if(bookItem==null){
            //if no book already exists in inventroy, create a new book and simply add to book list
            Item newBook = new Item(this.bookISBN, this.bookName, this.quantity);
            inventory.getBooks().add(newBook);
        }else{
            // if there is at least one book in the inventory, add to the existing book
            for(int i = 0; i < inventory.getBooks().size();i++){
                if( inventory.getBooks().get(i).getISBN().equals(bookItem.getISBN()) ){
                    inventory.getBooks().get(i).setQuantity( inventory.getBooks().get(i).getQuantity() + quantity);
                    break;
                }
            }
        }
    }

    public void printSell(){
        System.out.println("Selling");
    }

}