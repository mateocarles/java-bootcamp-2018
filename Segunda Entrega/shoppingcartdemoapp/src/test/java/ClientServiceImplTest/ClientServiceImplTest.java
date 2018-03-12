package ClientServiceImplTest;


import com.globant.shoppingcartdemoapp.dto.ClientDTO;
import com.globant.shoppingcartdemoapp.entities.Client;
import com.globant.shoppingcartdemoapp.entities.Payment;
import com.globant.shoppingcartdemoapp.repository.ClientRepository;
import com.globant.shoppingcartdemoapp.service.impl.ClientServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepositoryMock;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    public void createClientTest() {
        List<Payment> list = new ArrayList<>();
        Client c = new Client(1,"Mateo","Carles","A desciption",list);
        ClientDTO cc = new ClientDTO("Mateo","Carles","A description");
        when(clientRepositoryMock.save(any(Client.class))).thenReturn(c);
        clientService.addClient(cc);
        verify(clientRepositoryMock,times(1)).save(any(Client.class));
    }

    @Test
    public void getAllClientsTest() {
        List<Payment> listOfPayments = new ArrayList<>();
        List<Client> listOfClients = new ArrayList<>();
        Client c = new Client(1,"Mateo","Carles","A desciption",listOfPayments);
        Client c1 = new Client(2,"Lucas","Rodriguez","A desciption2",listOfPayments);
        Client c2 = new Client(3,"Juan","Gonzalez","A desciption1",listOfPayments);
        listOfClients.add(c);
        listOfClients.add(c1);
        listOfClients.add(c2);
        when(clientRepositoryMock.findAll()).thenReturn(listOfClients);
        clientService.getAllClients();
        verify(clientRepositoryMock,times(1)).findAll();
    }

    @Test
    public void getClientTest() {

        List<Payment> list = new ArrayList<>();
        Client c = new Client(1,"Mateo","Carles","A desciption",list);
        when(clientRepositoryMock.findOne(1)).thenReturn(c);
        clientService.getClient(1);
        verify(clientRepositoryMock,times(1)).findOne(1);
    }

    @Test
    public void updateClientTest() {
        List<Payment> list = new ArrayList<>();
        Client c = new Client(1,"Mateo","Carles","A desciption",list);
        when(clientRepositoryMock.save(any(Client.class))).thenReturn(c);
        clientService.updateClient(c);
        verify(clientRepositoryMock,times(1)).save(any(Client.class));
    }

    @Test
    public void deleteClientTest() {
        clientService.deleteClient(1);
        verify(clientRepositoryMock,times(1)).delete(anyInt());
    }
}
