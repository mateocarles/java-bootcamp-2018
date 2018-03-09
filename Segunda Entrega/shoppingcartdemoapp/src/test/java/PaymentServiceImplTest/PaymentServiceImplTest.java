package PaymentServiceImplTest;


import com.globant.shoppingcartdemoapp.dto.PaymentDTO;
import com.globant.shoppingcartdemoapp.entities.Client;
import com.globant.shoppingcartdemoapp.entities.Payment;
import com.globant.shoppingcartdemoapp.entities.ShoppingOrder;
import com.globant.shoppingcartdemoapp.repository.ClientRepository;
import com.globant.shoppingcartdemoapp.repository.OrderRepository;
import com.globant.shoppingcartdemoapp.repository.PaymentRepository;
import com.globant.shoppingcartdemoapp.service.impl.PaymentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceImplTest {

    @Mock
    private PaymentRepository paymentRepositoryMock;
    @Mock
    private ClientRepository clientRepositoryMock;
    @Mock
    private OrderRepository orderRepositoryMock;

    @InjectMocks
    private PaymentServiceImpl paymentService;


    @Test
    public void addPaymentTest(){
        PaymentDTO paymentDTO = PaymentDTO.builder()
                .orderId(1)
                .amount(20.9f)
                .clientId(1)
                .build();
        ShoppingOrder order = ShoppingOrder.builder()
                .items(new ArrayList<>())
                .id(2)
                .build();
        Client client = Client.builder()
                .payments(new ArrayList<>())
                .build();
        Payment payment = new Payment();

        when(orderRepositoryMock.findOne(anyInt())).thenReturn(order);
        when(clientRepositoryMock.findOne(anyInt())).thenReturn(client);
        //when(paymentRepositoryMock.save(payment)).thenReturn(payment);

        paymentService.add(paymentDTO);

        verify(paymentRepositoryMock,times(1)).save(any(Payment.class));
    }

    @Test
    public void getPaymentsTest() {
        when(paymentRepositoryMock.findOne(anyInt())).thenReturn(any(Payment.class));
        paymentService.getPayment(1);
        verify(paymentRepositoryMock,times(1)).findOne(anyInt());
    }

    @Test
    public void getAllPaymentsTest() {
        List<Payment> listOfPayments = new ArrayList<>();

        when(paymentRepositoryMock.findAll()).thenReturn(listOfPayments);
        paymentService.getAllPayments();
        verify(paymentRepositoryMock,times(1)).findAll();
    }

    @Test
    public void getAllPaymentsFromClient() {

        Client client = Client.builder()
                .payments(new ArrayList<>())
                .build();

        when(clientRepositoryMock.findOne(anyInt())).thenReturn(client);
        paymentService.getAllPaymentsFromClient(1);
        verify(clientRepositoryMock,times(1)).findOne(anyInt());


    }

    @Test
    public void updatePaymentTest() {
        PaymentDTO paymentDTO = PaymentDTO.builder()
                .paymentId(1)
                .amount(20.9f)
                .orderId(1)
                .build();
        Payment payment = new Payment();
        ShoppingOrder shoppingOrder = new ShoppingOrder();

        when(paymentRepositoryMock.findOne(anyInt())).thenReturn(payment);
        when(orderRepositoryMock.findOne(anyInt())).thenReturn(shoppingOrder);
        when(paymentRepositoryMock.save(payment)).thenReturn(payment);

        paymentService.updatePayment(paymentDTO);
        verify(paymentRepositoryMock,times(1)).save(payment);

    }

    @Test
    public void deletePaymentTest() {
        paymentService.deletePayment(1);
        verify(paymentRepositoryMock,times(1)).delete(anyInt());
    }








}
