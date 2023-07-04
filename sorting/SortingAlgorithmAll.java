package budget.sorting;

import budget.Category;
import budget.Purchase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class SortingAlgorithmAll implements SortingAlgorithm{

    List<Purchase> list;
    public SortingAlgorithmAll(Map<Category, List<Purchase>> map){
        this.list = new ArrayList<>();
        for(var m : map.entrySet()){
            list.addAll(m.getValue());
        }
        list.sort(Comparator.reverseOrder());
    }
    @Override
    public void sort() {
        double total = 0;
        System.out.println("All:");
        for(Purchase p : list){
            total+=p.getUnitPrice();
            System.out.println(p);
        }
        System.out.println(String.format("Total: $%.2f", total));
    }
}
