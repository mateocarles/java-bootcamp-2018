package com.globant.shoppingcartdemoapp.repository;
import com.globant.shoppingcartdemoapp.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.*;


public interface ClientRepository extends JpaRepository<Client,Integer> {



}
