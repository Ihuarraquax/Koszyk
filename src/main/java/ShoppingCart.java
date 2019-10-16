import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    private Map<Item, Integer> content;
    Family family;

    public ShoppingCart(Family family) {
        this.content = new HashMap<>();
        this.family = family;
    }

    public void addItem(Item item) {

        if (content.containsKey(item)) {
            int quantity = content.get(item);
            content.put(item, quantity + 1);
        } else {
            content.put(item, 1);
        }
    }

    public int size() {

        return content.size();
    }

    public Item getItem(String name) {

        for (Item item : content.keySet()) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public void deleteItem(Item item) throws ItemNotInShoppingCartException {

        if (!containsItem(item)) {
            throw new ItemNotInShoppingCartException();
        }

        content.put(item, getQuantity(item) - 1);
        if (getQuantity(item) == 0) {
            content.remove(item);
        }

    }

    public boolean containsItem(Item item) {

        return content.containsKey(item);
    }

    public List<Item> getItemList() {

        return new ArrayList<>(content.keySet());
    }

    public int getQuantity(Item item) {

        return content.get(item);
    }

    public int itemsSize() {

        return content.keySet().size();
    }

    public int sizeWithQuantity() {

        int quantity = 0;
        for (Map.Entry<Item, Integer> entry : content.entrySet()) {
            quantity += entry.getValue();
        }
        return quantity;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
}
