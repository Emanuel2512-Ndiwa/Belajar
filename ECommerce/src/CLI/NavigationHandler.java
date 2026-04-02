package CLI;

import java.util.ArrayList;
import java.util.Scanner;
import ECommerce.DataManager;
import ECommerce.User;

public class NavigationHandler {
    private Scanner scanner ;
    private DataManager dataManager;

    public NavigationHandler(DataManager dataManager){
        this.scanner=new Scanner(System.in);
        this.dataManager=dataManager;

    }

     public void welome(){
        System.out.println("welcome to Our E-Commerce System");
    }


    public void init() {
        System.out.println("Welcome to Our E-Commerce system");
        System.out.println("1.Login");
        System.out.println("2.SignUp");
        System.out.println("3.Exit");
        System.out.println("Input:");

        int choice = scanner.nextInt();

        switch(choice){
            case 1 :
                new Login(scanner,dataManager,this);
                break;
            case 2:
                new SignUp(scanner,dataManager,this);
                break;
            case 3:
                exit();
                break;

                default:
                    System.out.println("invalid choice");
                    init();

        }
        
    }
    public static void showMenu(User user){

    }
    private static void exit(){
        System.out.println("Thanks For Using Our System ");
        System.out.println("Have a nice day");
        

    }

}
