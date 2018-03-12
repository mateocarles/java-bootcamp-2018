package com.globant.shoppingcartdemoapp.repository;

import com.globant.shoppingcartdemoapp.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {


}
