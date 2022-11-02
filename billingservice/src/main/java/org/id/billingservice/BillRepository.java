package org.id.billingservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface BillRepository extends JpaRepository<Bill,Long>{}
