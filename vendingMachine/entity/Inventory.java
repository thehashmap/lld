package vendingMachine.entity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private Map<String, Item> itemsMap = new ConcurrentHashMap<>();
    private Map<String, Integer> stockMap = new ConcurrentHashMap<>();

    public void addItem(String code, Item item, int quantity) {
        itemsMap.put(code, item);
        stockMap.put(code, quantity);
    }

    public void removeItem(String code) {
        stockMap.remove(code);
        itemsMap.remove(code);
    }

    public void reduceStock(String code) {
        stockMap.put(code, stockMap.get(code) - 1);
    }

    public boolean isAvailable(String code) {
        return (stockMap.getOrDefault(code, 0) > 0);
    }

    public Item getItem(String code) {
        return itemsMap.get(code);
    }

}
