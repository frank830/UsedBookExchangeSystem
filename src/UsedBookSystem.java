import java.util.Scanner;
/*
1. Inventory
2. Buy/Borrow
3. Sell
*/

public class UsedBookSystem{
    public static void main(String[] args){

        // initialize Books list
        Inventory inventory = new Inventory();
        boolean quitFlag = false;
        boolean firstAttempt = true;

        /*
         * Need to make a loop here, so the program will keep asking user if they want
         * to buy until they say they want to quit the program.
         */
        
        while(quitFlag == false){

            String modeSelected = mode(firstAttempt);
    
            //do all the buying and selling  
            switch(modeSelected){
                case "b":
                    firstAttempt = false;
                    Buy newBuy = new Buy(inventory);
                    newBuy.printBuy();
                    break;
                case "s":
                    firstAttempt = false;
                    Sell newSell = new Sell();
                    newSell.sell(inventory);
                    break;
                case "q":
                    firstAttempt = false;
                    quitFlag = true;
                    break;
                default:
                    System.out.println("Please select buy or sell");
                    break;
            }
        }

        //add, edit, or delete book in the inventory.
        inventory.printInventory();
    }

    public static String mode(boolean firstAttempt){
        //ask user if they want to sell or buy
        String userInput = "";
        do{
            if(firstAttempt){
                //Welcome the user when they enter the program first time
                System.out.println("******************");
                System.out.println("Welcome to the used book exchanged system!!!");
                System.out.println(
                        "Would you like to buy or sell your book? \nPlease enter \"buy\" or \"b\" for buy, \"sell\" or \"s\" for sell, or \"quit\" or \"q\" to exit the program");
                System.out.println("******************");
            }else{
                System.out.println("******************");
                System.out.println(
                        "Would you like to buy or sell another book? \nPlease enter \"buy\" or \"b\" for buy, \"sell\" or \"s\" for sell, or \"quit\" or \"q\" to exit the program");
                System.out.println("******************");
            }

            Scanner input = new Scanner(System.in);
            userInput = input.nextLine();
            //make all string in lowercase for switch statement in main method
            userInput = userInput.toLowerCase();

            //turn the user input into 1 letter, easy to process for later.
            switch (userInput) {
                case "b":
                case "buy":
                    userInput = "b";
                    break;
                case "s":
                case "sell":
                    userInput = "s";
                    break;
                case "q":
                case "quit":
                    userInput = "q";
                    break;
                default:
                    break;
            }
        }while(userInput!="b" && userInput != "s" && userInput != "q");

        return userInput;
    }
    
}