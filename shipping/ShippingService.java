package shipping;

import java.util.List;

public class ShippingService {
    public static void shipItems(List<IshipableItem> items) {
        if (items == null || items.isEmpty()) return;
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (IshipableItem item : items) {
            System.out.println(item.getName());
            System.out.println(" " + item.getWeight() + "g");
            totalWeight += item.getWeight();
        }
        System.out.printf("Total package weight %.1fkg\n", totalWeight / 1000.0);
    }
}
