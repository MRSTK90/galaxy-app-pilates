package kr.co.galaxy.app.pilates.domain;


import io.hypersistence.utils.spring.repository.HibernateRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID>, HibernateRepository<Customer> {
}
