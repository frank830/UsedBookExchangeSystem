import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        // initialize Books list
        Inventory inventory = new Inventory();

        //prompt user for username and password
        
        // initialize users
        Users users = new Users();
        // initialize variables
        boolean firstAttempt = true;
        boolean quitFlag = false;
        boolean cont = true;

        Scanner input = new Scanner(System.in);
        User user = null;
        while(cont){
            System.out.println("Would you like to sign up(1), login(2), or quit(3): ");
            String tempStr = input.nextLine();
            int userInput;
            //check invalid input
            try{
                userInput = Integer.parseInt(tempStr);
            }catch(Exception e){
                userInput = -1;
            }
            if(userInput==1){
                user = users.signUP();
                if(!(user==null)){
                    break;
                }
            }else if(userInput==2){
                user = users.login();
                //if login is unsussesful
                if(user==null){
                    cont=false;
                    quitFlag = true;
                }else{
                    cont = false;
                }
            }else if(userInput == 3){
                quitFlag = true;
                break;
            }
            else{
                System.out.println("Invalid input");
            }
        }

        while (quitFlag == false) {
            String modeSelected = mode(firstAttempt);
            // do all the buying and selling
            switch (modeSelected) {
            case "b":
                firstAttempt = false;
                Buy newBuy = new Buy();
                newBuy.buy(inventory, user);
                user.addToBoughtList(newBuy.getBookbought());
                break;
            case "s":
                firstAttempt = false;
                Sell newSell = new Sell();
                newSell.sell(inventory, user);
                if(user.sellingAlready(newSell.getBookSelling())){
                    user.modifyPrice(newSell.getBookSelling());
                }else{
                    user.addToSellingList(newSell.getBookSelling());
                }
                break;
            case "q":
                firstAttempt = false;
                quitFlag = true;
                System.out.println("*******************");
                System.out.println("Books you bought: ");
                user.printBoughtList();
                System.out.println("*******************");
                System.out.println("Books you are selling: ");
                user.printSellingList();
                System.out.println("*******************");
                break;
            case "sa":
                inventory.printInventory();
                break;
            case "bl":
                user.printBoughtList();
                break;
            case "sl":
                user.printSellingList();
                break;
            default:
                System.out.println("Invalid input");
                break;
            }
        }
        input.close();
    }

    public static String mode(boolean firstAttempt){
        //ask user if they want to sell or buy
        String userInput = "";
        Scanner input = new Scanner(System.in);
        do{
            if(firstAttempt){
                //Welcome the user when they enter the program first time
                System.out.println("************************************");
                System.out.println("Welcome to the used book exchanged system!!!");
                System.out.println(
                        "Would you like to buy or sell your book? \nPlease enter \"buy\" or \"b\" for buy, \"sell\" or \"s\" for sell, \"sa\" or \"show all\" to see the entire book list, \"bl\" or \"bought list\" to see the books you bought, \"sl\" or \"selling list\" to see the books you are selling,  or \"quit\" or \"q\" to exit the program");
                System.out.println("************************************");
            }else{
                System.out.println("******************");
                System.out.println(
                        "Would you like to buy or sell your book? \nPlease enter \"buy\" or \"b\" for buy, \"sell\" or \"s\" for sell, \"sa\" or \"show all\" to see the entire book list, \"bl\" or \"bought list\" to see the books you bought, \"sl\" or \"selling list\" to see the books you are selling,  or \"quit\" or \"q\" to exit the program");
                System.out.println("******************");
            }

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
                case "sa":
                case "show all books":
                    userInput = "sa";
                    break;
                case "bl":
                case "bought list":
                    userInput = "bl";
                    break;
                case "sl":
                case "sold list":
                    userInput = "sl";
                    break;
                default:
                    break;
            }
        }while(userInput!="b" && userInput != "s" && userInput != "q" && userInput != "sa" && userInput != "bl" && userInput != "sl");

        return userInput;
    }
    
}