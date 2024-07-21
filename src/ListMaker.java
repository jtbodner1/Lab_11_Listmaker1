import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    private static ArrayList<String> myArrList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        do {
            displayList();
            char choice = SafeInput.getRegExString(scanner, "Choose an option: [AaDdIiPpQq]", "[AaDdIiPpQq]").charAt(0);
            switch (Character.toUpperCase(choice)) {
                case 'A':
                    addItem();
                    break;
                case 'D':
                    deleteItem();
                    break;
                case 'I':
                    insertItem();
                    break;
                case 'P':
                    printList();
                    break;
                case 'Q':
                    quit = SafeInput.getYNConfirm(scanner, "Are you sure you want to quit?");
                    break;
            }
        } while (!quit);
    }

    private static void displayList() {
        System.out.println("\nCurrent List:");
        for (int i = 0; i < myArrList.size(); i++) {
            System.out.println((i + 1) + ": " + myArrList.get(i));
        }
        System.out.println();
        System.out.println("A – Add an item");
        System.out.println("D – Delete an item");
        System.out.println("I – Insert an item");
        System.out.println("P – Print the list");
        System.out.println("Q – Quit");
    }

    private static void addItem() {
        String item = SafeInput.getString(scanner, "Enter item to add:");
        myArrList.add(item);
    }

    private static void deleteItem() {
        if (myArrList.isEmpty()) {
            System.out.println("The list is empty, nothing to delete.");
            return;
        }
        int itemNumber = SafeInput.getRangedInt(scanner, "Enter item number to delete:", 1, myArrList.size());
        myArrList.remove(itemNumber - 1);
    }

    private static void insertItem() {
        if (myArrList.isEmpty()) {
            System.out.println("The list is empty, adding the item as the first element.");
            addItem();
            return;
        }
        int position = SafeInput.getRangedInt(scanner, "Enter position to insert item:", 1, myArrList.size() + 1);
        String item = SafeInput.getString(scanner, "Enter item to insert:");
        myArrList.add(position - 1, item);
    }

    private static void printList() {
        System.out.println("\nList Contents:");
        for (String item : myArrList) {
            System.out.println(item);
        }
    }
}
