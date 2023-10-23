package kr.co.galaxy.app.pilates.ui;

import kr.co.galaxy.app.pilates.application.CustomerService;
import kr.co.galaxy.app.pilates.application.dto.CustomerRequest;
import kr.co.galaxy.app.pilates.application.dto.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping()
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerRequest request){
        CustomerResponse customer = customerService.createCustomer(request);
        return ResponseEntity.created(URI.create("/customer/"+customer.getId())).build();
    }
}
