package kr.co.galaxy.app.pilates.application;

import kr.co.galaxy.app.pilates.application.dto.CustomerRequest;
import kr.co.galaxy.app.pilates.application.dto.CustomerResponse;
import kr.co.galaxy.app.pilates.domain.Customer;
import kr.co.galaxy.app.pilates.domain.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerResponse createCustomer(CustomerRequest request){
        Customer customer =  repository.save(request.toCustomer());
        return CustomerResponse.of(customer);
    }

}
