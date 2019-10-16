import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ShoppingCartTest {

    private ShoppingCart shoppingCart;
    private Item item;
    private Item item2;
    private Family family;

    @Before
    public void setUp() throws Exception {

        family = new Family("Zabłoccy");
        shoppingCart = new ShoppingCart(family);
        item = new Item("milk");
        item2 = new Item("bread");
    }

    @Test
    public void shouldContainOneItemAfterAdd() {

        shoppingCart.addItem(item);

        Assert.assertEquals(1, shoppingCart.itemsSize());
    }

    @Test
    public void hasAddedItem() {

        shoppingCart.addItem(item);

        Assert.assertEquals(item, shoppingCart.getItem("milk"));
    }

    @Test(expected = ItemNotInShoppingCartException.class)
    public void shouldThrowExceptionWhenDeletingItemDoesNotExist() throws ItemNotInShoppingCartException {

        shoppingCart.deleteItem(item);

    }

    @Test
    public void shouldDeleteItem() throws ItemNotInShoppingCartException {

        shoppingCart.addItem(item);
        shoppingCart.deleteItem(item);

        Assert.assertFalse(shoppingCart.containsItem(item));
    }

    @Test
    public void shouldReturnItemList() {

        shoppingCart.addItem(item2);
        shoppingCart.addItem(item);

        List<Item> itemList = new ArrayList<>();
        itemList.add(item);
        itemList.add(item2);

        Assert.assertTrue(shoppingCart.getItemList().containsAll(itemList));
    }

    @Test
    public void shouldIncrementQuantityWhenAddingSameItem() {

        shoppingCart.addItem(item);
        shoppingCart.addItem(item);
        shoppingCart.addItem(item2);

        Assert.assertEquals(2, shoppingCart.getQuantity(item));
    }

    @Test
    public void shouldReturnShoppingCartSizeEvaluatingQuantity() {

        shoppingCart.addItem(item);
        shoppingCart.addItem(item);
        shoppingCart.addItem(item2);

        Assert.assertEquals(3, shoppingCart.sizeWithQuantity());
    }

    @Test
    public void shouldHaveFamily() {

        Assert.assertEquals(shoppingCart.getFamily(), family);
    }


}
