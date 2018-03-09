package OrderServiceImplTest;

import com.globant.shoppingcartdemoapp.dto.OrderDTO;
import com.globant.shoppingcartdemoapp.entities.Item;
import com.globant.shoppingcartdemoapp.entities.ShoppingOrder;
import com.globant.shoppingcartdemoapp.repository.ItemRepository;
import com.globant.shoppingcartdemoapp.repository.OrderRepository;
import com.globant.shoppingcartdemoapp.service.impl.OrderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {

    @Mock
    private ItemRepository itemRepositoryMock;
    @Mock
    private OrderRepository orderRepositoryMock;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    public void addShoppingOrderTest() {

        OrderDTO orderDTO = OrderDTO.builder()
                .itemIds(new ArrayList<>())
                .id(1)
                .build();

        List<Item> items = new ArrayList<>();

        when(itemRepositoryMock.findAll(anyCollection())).thenReturn(items);
        orderService.addOrder(orderDTO);
        verify(orderRepositoryMock,times(1)).save(any(ShoppingOrder.class));


    }

    @Test
    public void getOrderTest() {
        when(orderRepositoryMock.findOne(anyInt())).thenReturn(any(ShoppingOrder.class));
        orderService.getOrder(1);
        verify(orderRepositoryMock,times(1)).findOne(anyInt());
    }

    @Test
    public void updateOrderTest() {

        OrderDTO orderDTO = OrderDTO.builder()
                .itemIds(new ArrayList<>())
                .id(1)
                .build();
        ShoppingOrder shoppingOrder = ShoppingOrder.builder()
                .items(new ArrayList<>())
                .build();

        when(orderRepositoryMock.findOne(anyInt())).thenReturn(shoppingOrder);
        when(orderRepositoryMock.save(any(ShoppingOrder.class))).thenReturn(any(ShoppingOrder.class));
        orderService.updateOrder(orderDTO,2);
        verify(orderRepositoryMock,times(1)).save(any(ShoppingOrder.class));
        verify(orderRepositoryMock,times(1)).findOne(anyInt());

    }

    @Test
    public void deleteOrderTest() {
        orderService.deleteOrder(1);
        verify(orderRepositoryMock,times(1)).delete(anyInt());

    }


}
