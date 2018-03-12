package com.app;
import java.util.*;
import com.controller.Operations;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int menuop = 0;
        do {

            System.out.println("---------- > Welcome to ShoppingCart App !");
            System.out.println("1-Add Client");
            System.out.println("2-Select Client");
            System.out.println("3-Exit");

            menuop = sc.nextInt();
            sc.nextLine();

            switch (menuop) {

                case 1:
                    System.out.println("\n\n****** ADD CLIENT ******");
                    Operations.addClient();
                    break;

                case 2:
                    System.out.println("\n\n****** SELECT CLIENT ******");
                    Operations.selectClient();
                    break;

                case 3:
                    System.exit(0);
                    break;
            }
        } while (menuop != 3);
        System.out.println("Thanks for using ShoppingCart App!");
    }
}
