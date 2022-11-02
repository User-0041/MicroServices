package org.id.customerservice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    
}
