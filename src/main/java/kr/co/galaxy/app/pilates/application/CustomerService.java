package kr.co.galaxy.app.pilates.application;

import kr.co.galaxy.app.pilates.application.dto.CustomerRequest;
import kr.co.galaxy.app.pilates.application.dto.CustomerResponse;
import kr.co.galaxy.app.pilates.domain.Customer;
import kr.co.galaxy.app.pilates.domain.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    @Transactional(readOnly = false)
    public CustomerResponse createCustomer(CustomerRequest request){
        Customer customer =  repository.save(request.toCustomer());
        return CustomerResponse.of(customer);
    }
    public CustomerResponse findCustomerById(UUID id){
        return CustomerResponse.of(findById(id));
    }
    public Customer findById(UUID id){
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Transactional(readOnly = false)
    public void updateCustomer(UUID id, CustomerRequest request){
        Customer customer = findById(id);
        customer.update(request);
    }

}
