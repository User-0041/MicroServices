package org.id.billingservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="customer-service")
interface CustomerServiceClient{
@GetMapping("/customers/{id}?projection=fullCustomer")
Customer findCustomerById(@PathVariable("id") Long id);
}