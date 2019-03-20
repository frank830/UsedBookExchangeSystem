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

        //check if we can find the book in the inventory
        Item bookFound = this.findBook(inventory, searchType);
        if(bookFound==null){
            //if book is found, print no book found
            if(searchType == 1){
                System.out.println("Sorry, no book is found, try search by name for more results");
            }
            else if (searchType == 2){
                System.out.println("Sorry, no book is found, try search by ISBN for more results");
            }
            
        }else{
            // if book is found, delete book or subtract the number of the same book in inventory
            int quan = askUserForQuantity();
            //if quan = -1, then invalid input
            if(quan!=-1){
                this.deleteBook(inventory, bookFound, quan);
            }else{
                System.out.println("Invalid buying input for the number of books buying...");
            }
        }
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

    public Item findBook(Inventory inventory, int searchType){
        //return the Item found, if no item is found, return null
        Item tempItem = null;
        if(searchType==1){
            tempItem = inventory.searchBookByIsbn(this.bookISBN);
        }else if(searchType == 2){
            tempItem = inventory.searchBookByBookName(this.bookName);
        }else{
            System.out.println("Error! No mode is selected for find book!");
        }
        return tempItem;
    }

    public void deleteBook(Inventory inventory, Item bookItem, int quantity) {
        if(bookItem==null){
            System.out.println("No book found...");
        }else if(quantity>bookItem.getQuantity()){
            System.out.println("Sorry, we do no have enough of books in stock...");
        }else if(quantity == bookItem.getQuantity()){
            inventory.getBooks().remove(bookItem);
        }
        else{
            for(int i = 0 ; i < inventory.getBooks().size(); i++){
                if(inventory.getBooks().get(i).getISBN().equals(bookItem.getISBN())){
                    //set new quantity to the book
                    inventory.getBooks().get(i).setQuantity(inventory.getBooks().get(i).getQuantity()-quantity);
                    break;
                }
            }
        }

    }

    public void printBuy(){
        System.out.println("Buying");
    }

    public int askUserForQuantity(){
        Scanner input = new Scanner(System.in);
        int numOfBooks = -1;
        System.out.println("How many would you like to buy: ");
        if (input.hasNextLine()) {
            numOfBooks = input.nextInt();
        } else {
            System.out.println("ERROR! No input received!!!");
        }
        return numOfBooks;
    }

}
