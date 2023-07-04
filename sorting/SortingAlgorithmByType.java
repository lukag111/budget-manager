package budget.sorting;

import budget.Category;
import budget.Purchase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingAlgorithmByType implements SortingAlgorithm{

    Map<Category, List<Purchase>> map;

    public SortingAlgorithmByType(
            Map<Category, List<Purchase>> map) {
        this.map = map;
    }


    @Override
    public void sort() {
        Map<Category, Double> categoryTotalMap = new HashMap<>();
        for (Category category : Category.values()){
            categoryTotalMap.put(category, 0.0);
        }

        for (List<Purchase> purchaseList : map.values()){
            for (Purchase p : purchaseList){
                Category category = p.getCategory();
                double total = categoryTotalMap.getOrDefault(category, 0.0);
                total+=p.getUnitPrice();
                categoryTotalMap.put(category, total);
            }
        }

        List<Map.Entry<Category, Double>> categoryTotalList = new ArrayList<>(categoryTotalMap.entrySet());
        categoryTotalList.sort((a, b) ->Double.compare(b.getValue(), a.getValue()));

        for (Map.Entry<Category, Double> entry : categoryTotalList){
            System.out.printf("%s - $%.2f%n", entry.getKey().toString(), entry.getValue());
        }
    }
}
