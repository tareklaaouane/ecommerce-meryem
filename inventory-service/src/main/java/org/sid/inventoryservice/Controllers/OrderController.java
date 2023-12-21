package org.sid.inventoryservice.Controllers;

import org.sid.inventoryservice.Services.OrderService;
import org.sid.inventoryservice.entites.Customer_Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/CustomerOrder")
public class OrderController {

    @Autowired
    private OrderService orderService;



    @GetMapping("/{orderId}")
    public ResponseEntity<Customer_Order> getOrderById(@PathVariable Long orderId) {
        Customer_Order customerOrder = orderService.getOrderById(orderId);
        if (customerOrder != null) {
            return ResponseEntity.ok(customerOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Customer_Order> createOrder(@RequestBody Customer_Order customerOrder) {
        Customer_Order createdCustomerOrder = orderService.createOrder(customerOrder);
        return ResponseEntity.ok(createdCustomerOrder);
    }



    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
