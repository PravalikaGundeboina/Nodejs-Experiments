package sample;

import java.util.Scanner;

class Item {

 String name;

 double price;

 Item(String name, double price) {

     this.name = name;

     this.price = price;

 }

}

class Order {

 int orderId;

 Item[] items;



 Order(int orderId, Item[] items) {

     this.orderId = orderId;

     this.items = items;

 }

}

interface Restaurant {

 void printRestaurantName();

 void addItem(Item item);

 Item[] getMenu();

 Order placeOrder(Item[] items);

 double generateBill(int orderId);

}

class KFC implements Restaurant {

 String name = "KFC";

 Item[] menu = new Item[100]; 

 int menuCount = 0;

 Order[] orders = new Order[100]; 

 int orderCount = 0;

 public void printRestaurantName() {

     System.out.println("Restaurant: " + name);

 }

 public void addItem(Item item) {

     menu[menuCount++] = item;

     System.out.println("Item added: " + item.name + " - $" + item.price);

 }

 public Item[] getMenu() {

     Item[] currentMenu = new Item[menuCount];

     for (int i = 0; i < menuCount; i++) {

         currentMenu[i] = menu[i];

     }

     return currentMenu;

 }

 public Order placeOrder(Item[] items) {

     Order order = new Order(orderCount + 1, items);

     orders[orderCount++] = order;

     System.out.println("Order placed! Order ID: " + order.orderId);

     return order;

 }

 public double generateBill(int orderId) {

     for (int i = 0; i < orderCount; i++) {

         if (orders[i].orderId == orderId) {

             double total = 0;

             for (Item item : orders[i].items) {

                 total += item.price;

             }

             total += total * 0.06; // 6% tax

             return total;

         }

     }

     System.out.println("Order ID not found!");

     return 0;

 }

}

public class RestaurantDemo {

 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);

     KFC kfc = new KFC();

     kfc.printRestaurantName();

     System.out.print("How many items to add to menu? ");

     int n = sc.nextInt();

     sc.nextLine(); 

     for (int i = 0; i < n; i++) {

         System.out.print("Enter item name: ");

         String name = sc.nextLine();

         System.out.print("Enter item price: ");

         double price = sc.nextDouble();

         sc.nextLine(); 

         kfc.addItem(new Item(name, price));

     }

     System.out.println("\nMenu:");

     Item[] menu = kfc.getMenu();

     for (int i = 0; i < menu.length; i++) {

         System.out.println((i + 1) + ". " + menu[i].name + " - $" + menu[i].price);

     }

     System.out.print("\nHow many items to order? ");

     int orderSize = sc.nextInt();

     sc.nextLine(); 

     Item[] orderItems = new Item[orderSize];

     for (int i = 0; i < orderSize; i++) {

         System.out.print("Enter menu item number to order: ");

         int choice = sc.nextInt() - 1;

         orderItems[i] = menu[choice];

     }

     Order order = kfc.placeOrder(orderItems);

     double bill = kfc.generateBill(order.orderId);

     System.out.println("Total Bill with 6% tax: $" + bill);



     sc.close();

 }

}




