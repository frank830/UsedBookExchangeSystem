import java.util.Scanner;
/*
1. Inventory
2. Buy/Borrow
3. Sell
*/

public class UsedBookSystem{
    public static void main(String[] args){

        //ask whether user wants to buy or sell
        String modeSelected = mode();
       
        //initialize Books list
        Inventory inventory = new Inventory();

        //do all the buying and selling
        switch(modeSelected){
            case "buy":
            case "b":
                Buy newBuy = new Buy(inventory);
                newBuy.printBuy();
                break;
            case "sell":
            case "s":
                Sell newSell = new Sell();
                newSell.sell(inventory);
                break;
            default:
                System.out.println("Please select buy or sell");
                break;
        }

        //add, edit, or delete book in the inventory.
        inventory.printInventory();
    }

    public static String mode(){
        //ask user if they want to sell or buy
        System.out.println("Thank you for choosing us! Would you like to buy or sell your book? Enter \"buy\" or \"b\" for buy, or \"sell\" or \"s\" for sell.");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        //make all string in lowercase for switch statement in main method
        //close scanner
        //input.close();
        userInput = userInput.toLowerCase();
        return userInput;
    }
    
}