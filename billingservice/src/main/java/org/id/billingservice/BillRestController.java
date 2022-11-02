package org.id.billingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class BillRestController {
    @Autowired private BillRepository billRepository;
@Autowired private ProductItemRepository productItemRepository;
@Autowired private CustomerServiceClient customerServiceClient;
@Autowired private InventoryServiceClient inventoryServiceClient;
@GetMapping("/bills/full/{id }")
Bill getBill(@PathVariable(name="id") Long id){
Bill bill=billRepository.findById(id).get();
bill.setCustomer(customerServiceClient.findCustomerById(bill.getCustomerID()));
bill.setProductItems(productItemRepository.findByBillId(id));
bill.getProductItems().forEach(pi ->{
pi.setProduct(inventoryServiceClient.findProductById(pi.getProductID() ));
});
return bill ;
}}
