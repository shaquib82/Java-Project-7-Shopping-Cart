package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class ShopppingCartMain {
  static Store2 store = new Store2();
  static Cart cart = new Cart();

    public static void loadItems(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner sc = new Scanner(fis);
        while(sc.hasNextLine()){
            for (int i = 0; i <7 ; i++) {

                String line = sc.nextLine();
                String[] product = line.split(";");
                for (int j = 0; j < 3; j++) {
                    String ProdAndPrice = product[j];
                    String[] both = ProdAndPrice.split("=");
                    String Product = both[0];
                    double price = Double.parseDouble(both[1]);
                    store.setItem(i,j,new Item2(Product,price));

                }
            }

        }
    }
    /**
     * Name: manageItems
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. Creates an infinite loop:
     *   •        The user can choose to a) add or b) remove c) checkout.
     *   •          case a: asks for the aisle and item number. Then, adds item to cart.
     *   •          case b: asks for the name. Then, removes item from cart.
     *   •          case c: prints the receipt and closes Scanner.
     *   •        Prints the updated shopping cart.
     */

    public static void manageItems(){
        Scanner sc =new Scanner(System.in);
        while(true){

            System.out.println("\n\t******************************JAVA GROCERS******************************\n");
            System.out.println(store);
            System.out.println("Type 'a' to choose, 'b' to remove and 'c' to checkout.");
            String input = sc.next();
            sc.nextLine();
            if(!input.equals("a")&&!input.equals("b")&&!input.equals("c")){
                continue;
            }
            else{
                switch(input){
                    case "a":
                        System.out.println("Please provide the aisle and and item number" +
                                "\nChoose an aisle number between: 1 – 7: ");
                        System.out.print("Aisle number: ");
                        if(!sc.hasNextInt()){
                            break;
                        }
                        int aisleNumber = sc.nextInt();
                        System.out.println("Choose an item number between: 1 – 3: ");
                        System.out.print("Item number: ");
                        if(!sc.hasNextInt()){
                            break;
                        }
                        int itemNumber = sc.nextInt();
                        sc.nextLine();
                        if(itemNumber<=3||aisleNumber<=7){
                            cart.add(new Item2(store.getItem(aisleNumber-1,itemNumber-1)));
                            System.out.println(store.getItem(aisleNumber-1,itemNumber-1).getName() + " was added to your shopping cart.");
                            break;
                        }
                        else{
                           continue;
                        }

                    case "b":
                        System.out.println("Please provide the name of the product you wish to remove.");
                        String prodName = sc.nextLine();
                        if(!cart.isEmpty()){
                            cart.remove(prodName);
                            break;
                        }


                    case "c":
                        if(!cart.isEmpty()){
                            System.out.println(cart.checkout());
                            break;
                        }

                }


            }
            System.out.println("\n\nSHOPPING CART\n\n" + cart);
            System.out.print("Enter anything to continue: ");
            String anything = sc.nextLine();

        }
    }



    public static void main(String[] args) {
        try{
            loadItems("products.txt");
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
finally {
            manageItems();
        }
    }
}
