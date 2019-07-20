import java.util.Scanner;

public class Sell{

    String bookISBN, bookName;
    int quantity;
    double price;
    String userName;
    private Item bookListed;

    public Sell(){

    }

    public void sell(Inventory inventory,User user){
        this.userName = user.getUsername();
        this.bookISBN = getISBN();
        this.price = getPrice();
        Item tempItem = this.findBook(inventory, this.bookISBN);

        if(tempItem == null){
            this.bookName = getBookName();
            this.addBook(inventory, tempItem);
        }else{
            this.addBook(inventory, tempItem);
        }
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

    public double getPrice(){
        double userPrice = 0.0;
        Scanner input = new Scanner(System.in);
        System.out.println("How much you would like to sell the book: ");

        while (!input.hasNextDouble()) {
            System.out.println("Invalid Input. Please enter how much you would like to sell the book: ");
            input.nextLine();
        }
        userPrice = input.nextDouble();
        return userPrice;
    }
    
    public Item findBook(Inventory inventory, String isbn){
        Item tempItem = inventory.searchBookByIsbn(this.bookISBN);
        return tempItem;
    }

    public boolean userListedBookAlready(Item bookItem, String userName) {
        return bookItem.getUsersPricesList().containsKey(this.userName);
    }

    public void addBook(Inventory inventory, Item bookItem){
        Scanner sc = new Scanner(System.in);
        if(bookItem==null){
            //if no book already exists in inventroy, create a new book and simply add to book list
            Item newBook = new Item(this.bookISBN, this.bookName, 1, this.userName, this.price);
            inventory.getBooks().add(newBook);
            this.bookListed = newBook;
            System.out.println("Item listed sucessfully!");
        }else{
            //alread exists
            if(bookItem.getUsersPricesList().containsKey(this.userName)){
                System.out.println("You have already listed the item, would you like to change your selling price?");
                String input = sc.nextLine();
                input = input.toLowerCase();
                boolean repeat = true;
                if(input.equals("yes")||input.equals("y")){
                    for (int i = 0; i < inventory.getBooks().size(); i++) {
                        if (inventory.getBooks().get(i).getISBN().equals(bookItem.getISBN())) {
                            // set the price of the item
                            inventory.getBooks().get(i).modifyUsersPricesList(this.userName, this.price);
                            inventory.getBooks().get(i).setPrice(this.price);
                            // inventory.getBooks().get(i).setPrice(newPrices);
                            this.bookListed = inventory.getBooks().get(i);
                            break;
                        }
                    }
                    System.out.println("Price changed ");
                    repeat = false;
                }else if(input.equals("no") || input.equals("n")){
                    repeat=false;
                }else{
                    System.out.println("Invalid!");
                }
            }else{
                //book exists, but not user
                for(int i = 0; i < inventory.getBooks().size();i++){
                    if(inventory.getBooks().get(i).getISBN().equals(bookItem.getISBN())){
                        // add to inventory
                        inventory.getBooks().get(i).addUsersPricesList(this.userName, this.price);
                        //add to item list
                        inventory.getBooks().get(i).setQuantity(inventory.getBooks().get(i).getQuantity()+1);
                        inventory.getBooks().get(i).setPrice(this.price);
                        this.bookListed = inventory.getBooks().get(i);
                        break;
                    }
                }
                System.out.println("Item listed sucessfully!");
            }
        }
    }

    public Item getBookSelling() {
        return this.bookListed;
    }

    public void printSell(){
        System.out.println("Selling");
    }

}