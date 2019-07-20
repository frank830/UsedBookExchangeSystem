import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class Buy {

    String bookISBN, bookName;
    private Item bookBought;

    public Buy() {
    }

    public void buy(Inventory inventory, User user) {
        // String username = user.getUsername();
        // prompt user for book name
        String buyUsername;
        this.bookISBN = getISBN();
        // check if we can find the book in the inventory
        Item bookFound = this.findBook(inventory);
        Scanner input = new Scanner(System.in);
        if (bookFound == null) {
            // if no book is found, print no book found
            System.out.println("Sorry, no book is found...");
        } else {
            // ask users which one in the list they want to buy
            ArrayList<String> itemList = new ArrayList<String>();
            int tempInventoryIndex = 0;
            for (int i = 0; i < inventory.getBooks().size(); i++) {
                if (inventory.getBooks().get(i).getISBN().equals(bookISBN)) {
                    itemList = inventory.getBooks().get(i).printNReturnMatchingBookList();
                    tempInventoryIndex = i;
                    break;
                }
            }
            if(itemList.contains(user.getUsername())){
                System.out.println("Sorry, you cannot buy your own book");
            }else{
                boolean cont = true;
                while (cont) {
                    System.out.println("Enter the index of the item you would like to purchase: ");

                    int index = 0;
                    while(!input.hasNextInt()){
                        System.out.println("Invalid input. Please enter the index of the item you would like to purchase: ");
                        input.nextLine();
                    }
                    index = input.nextInt()-1;
                    if (index >= itemList.size() || index < 0) {
                        System.out.println("Invalid input");
                    } else {
                        this.bookBought = inventory.getBooks().get(tempInventoryIndex);
                        buyUsername = itemList.get(index);
                        // delete from item list
                        inventory.getBooks().get(tempInventoryIndex).deleteAnItemBasedOnUser(buyUsername);
                        // delete from inventory
                        deleteBookFromItemList(inventory, inventory.getBooks().get(tempInventoryIndex), buyUsername);
                        System.out.println("Success!");
                        cont = false;
                    }
                }
            }


        }
    }

    public Item getBookbought() {
        return this.bookBought;
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

    public Item findBook(Inventory inventory) {
        // return the Item found, if no item is found, return null
        return inventory.searchBookByIsbn(this.bookISBN);
    }

    public void deleteBookFromItemList(Inventory inventory, Item bookItem, String username) {
        String targetISBN = bookItem.getISBN();
        for (int i = 0; i < inventory.getBooks().size(); i++) {
            String tempISBN = inventory.getBooks().get(i).getISBN();
            if (tempISBN.equals(targetISBN)) {
                inventory.getBooks().get(i).deleteAnItemBasedOnUser(username);
                int quan = inventory.getBooks().get(i).getQuantity();
                if (quan > 1) {
                    inventory.getBooks().get(i).setQuantity(quan - 1);
                }
                else if (quan == 1) {
                    inventory.getBooks().remove(bookItem);
                } else {
                    System.out.println("Not enough books in stock...");
                }
            }
        }
    }

    public void printBuy() {
        System.out.println("Buying");
    }

}