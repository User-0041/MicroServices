package org.id.billingservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
interface ProductItemRepository extends
JpaRepository<ProductItem,Long>{
List<ProductItem> findByBillId(Long billID);
}