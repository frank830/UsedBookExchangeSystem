import java.util.Scanner;

public class Buy{

    String bookISBN, bookName;
    int quantity;
    
    public Buy(){
    }
    
    public void buy(Inventory inventory) {

        //initialize variable
        int searchType = -1;

        //keep asking until user gives the correct answer
        while(searchType!=1 && searchType!=2){
            searchType = searchByIsbnOrName();
        }

        //Ask for isbn or book name depends on what user has chose
        if(searchType == 1){
            this.bookISBN = getISBN();
        }
        else if(searchType == 2){
            this.bookName = getBookName();
        }

        this.findBook(inventory, searchType);
        //this.deleteBook(inventory);
        printBuy();
    }

    public int searchByIsbnOrName(){
        System.out.println("Would you like to search by ISBN or book name? Enter 1 for ISBN or 2 for book name: ");
        Scanner input = new Scanner(System.in);

        //make sure there is an input, if no input, throw error
        if (!input.hasNextLine()) {
            System.out.println("ERROR! No input received!!!");
        }

        int searchTypeSelected = input.nextInt();

        return searchTypeSelected;
    }

    public String getISBN() {
        String tempISBN = "";
        Scanner input = new Scanner(System.in);
        System.out.println("bookISBN: ");
        if (input.hasNextLine()) {
            tempISBN = input.nextLine();
        } else {
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

    public int getQuantity() {
        int numOfBooks = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("numOfBooks: ");
        if (input.hasNextLine()) {
            numOfBooks = input.nextInt();
        } else {
            System.out.println("ERROR! No input received!!!");
        }
        return numOfBooks;
    }

    public void findBook(Inventory inventory, int searchType){

        if(searchType==1){
            Item tempItem = inventory.searchBookByIsbn(this.bookISBN);
            if (tempItem == null) {
                System.out.println("Sorry, no book is found, try search by name for more results");
            } else {
                System.out.println("Book " + tempItem.getBookName() + " found!!! ");
            }
        }else if(searchType == 2){
            Item tempItem = inventory.searchBookByBookName(this.bookName);
            if (tempItem == null) {
                System.out.println("Sorry, no book is found, please try again");
            } else {
                System.out.println("Book " + tempItem.getBookName() + " found!!! ");
            }
        }else{
            System.out.println("Error! No mode is selected for find book!");
        }
    }

    public void deleteBook(Inventory inventory) {
        // int inventorySize = inventory.getBooks().size();
        //inventory.deleteBook(this.bookISBN, this.bookName, this.quantity);
    }

    public void printBuy(){
        System.out.println("Buying");
    }

}
