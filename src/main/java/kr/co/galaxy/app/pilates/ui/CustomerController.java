package kr.co.galaxy.app.pilates.ui;

import kr.co.galaxy.app.pilates.application.CustomerService;
import kr.co.galaxy.app.pilates.application.dto.CustomerRequest;
import kr.co.galaxy.app.pilates.application.dto.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("create")
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerRequest request){
        CustomerResponse customer = customerService.createCustomer(request);
        return ResponseEntity.created(URI.create("/customer/"+customer.getId())).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable UUID id){
        CustomerResponse response = customerService.findCustomerById(id);
        return ResponseEntity.ok(response);
    }
}
