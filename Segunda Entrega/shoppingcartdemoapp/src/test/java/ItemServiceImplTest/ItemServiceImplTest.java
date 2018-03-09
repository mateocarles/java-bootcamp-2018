package ItemServiceImplTest;


import com.globant.shoppingcartdemoapp.entities.Item;
import com.globant.shoppingcartdemoapp.repository.ItemRepository;
import com.globant.shoppingcartdemoapp.service.ItemService;
import com.globant.shoppingcartdemoapp.service.impl.ItemServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceImplTest {

    @Mock
    private ItemRepository itemRepositoryMock;

    @InjectMocks
    private ItemServiceImpl itemService;

    @Test
    public void addItemTest() {
        Item item = new Item();
        when(itemRepositoryMock.save(any(Item.class))).thenReturn(any(Item.class));
        itemService.addItem(item);
        verify(itemRepositoryMock,times(1)).save(item);
    }

    @Test
    public void getItemTest() {
        when(itemRepositoryMock.findOne(anyInt())).thenReturn(any(Item.class));
        itemService.getItem(2);
        verify(itemRepositoryMock, times(1)).findOne(anyInt());
    }

    @Test
    public void updateItemTest() {
        Item item = new Item();
        when(itemRepositoryMock.save(any(Item.class))).thenReturn(any(Item.class));
        itemService.updateItem(item);
        verify(itemRepositoryMock,times(1)).save(any(Item.class));

    }

    @Test
    public void deleteItemTest() {
        itemService.deleteItem(1);
        verify(itemRepositoryMock,times(1)).delete(anyInt());
    }
}
