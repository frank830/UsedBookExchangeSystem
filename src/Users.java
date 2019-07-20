import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;


public class Users{

    HashMap<String, String> map = new HashMap<String, String>();

    public Users(){
        map.put("zi","123");
    }
    public boolean varifyUser(String username, String password){
        if(map.containsKey(username)){
            if(map.get(username).equals(password)){
                return true;
            }
        }
        return false;
    }

    public void addUser(String username, String password){
        map.put(username, password);
    }

    public boolean userFound(String username){
        return map.containsKey(username);
    }

    public User signUP() {
        Scanner sc = new Scanner(System.in);
        //get username
        System.out.println("Please enter a username you prefer: ");
        String newUserName = sc.nextLine();
        if(newUserName.isEmpty()){
            do{
                System.out.println("Invalid input. Please enter a username you prefer: ");
                newUserName = sc.nextLine();
            }while(newUserName.isEmpty());
        }

        //check if username already taken
        if(userFound(newUserName)){
            System.out.println("User already registered, please login.");
            return null;
        }

        // get password
        System.out.println("Please enter a password you prefer: ");
        String newPassword = sc.nextLine();
        if (newPassword.isEmpty()) {
            do {
                System.out.println("Invalid input. Please enter a password you prefer: ");
                newPassword = sc.nextLine();
            } while (newPassword.isEmpty());
        }
        addUser(newUserName, newPassword);
        User user = new User(newUserName, newPassword);
        System.out.println("Success!");
        return user;
    }

    public User login() {
        Scanner input = new Scanner(System.in);
        int falsePassword = 0;

        while (falsePassword < 3) {
            System.out.println("Please enter username: ");
            String username = input.nextLine();
            System.out.println("Please enter password: ");
            String password = input.nextLine();
            if (varifyUser(username, password)) {
                // initialize variables
                System.out.println("Login successful");
                User user = new User(username, password);
                return user;
            }else {
                falsePassword++;
                System.out.println("Invalid password...");
            }
            if (falsePassword == 2) {
                System.out.println("Last chance...");
            } else if (falsePassword >= 3) {
                System.out.println("Too many attempts...program existing...");
            }
        }
        return null;

    }

}