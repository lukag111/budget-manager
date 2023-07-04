package budget.sorting;

import budget.Category;
import budget.Purchase;

import java.util.*;

public class SortingAlgorithmCertainType implements SortingAlgorithm{

    private final Map<Category, List<Purchase>> map;
    private final Scanner scanner;

    public SortingAlgorithmCertainType(Map<Category, List<Purchase>> map, Scanner scanner) {
        this.map = map;
        this.scanner = scanner;
    }

    private void menuSort(String input){
        switch (Integer.parseInt(input)){
            case 1:
                sortiraj(Category.FOOD);
                break;
            case 2:
                sortiraj(Category.CLOTHES);
                break;
            case 3:
                sortiraj(Category.ENTERTAINMENT);
                break;
            case 4:
                sortiraj(Category.ALL);
                break;
        }
        System.out.println();
    }

    private void sortiraj(Category category){
        List<Purchase> list = map.getOrDefault(category, Collections.emptyList());
        list.sort(Comparator.reverseOrder());

        if (list.isEmpty()){
            System.out.println("The purchase list is empty!");
            return;
        }

        double sum = 0;
        System.out.println("Categoty: "+category);
        for (Purchase p : list){
            sum+=p.getUnitPrice();
            System.out.println(p);
        }
        System.out.println(String.format("Total sum: $%.2f", sum));
    }

    private void printMenu (){
        System.out.println("1) Food\n" +
                "2) Clothes\n" +
                "3) Entertainment\n" +
                "4) Other");
    }

    @Override
    public void sort() {
        boolean flag = true;

        while (flag){
            printMenu();
            String input = scanner.nextLine();
            System.out.println();
            menuSort(input);
            flag = false;
        }
    }
}
