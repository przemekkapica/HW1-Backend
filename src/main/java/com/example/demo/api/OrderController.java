package com.example.demo.api;

import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.request.AddOrderDTOCmd;
import com.example.demo.dto.request.UpdateOrderDTOCmd;
import com.example.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:4200")
//@GetMapping("/yourPath")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @PostMapping
    public ResponseEntity<OrderDTO> newOrder(@RequestBody AddOrderDTOCmd addOrderDTOCmd) {
        return ResponseEntity.ok(orderService.addNewOrder(addOrderDTOCmd));
    }

    @PutMapping
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody UpdateOrderDTOCmd updateOrderDTOCmd) {
        return ResponseEntity.ok(orderService.updateOrder(updateOrderDTOCmd));
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<OrderDTO> deleteOrder(@PathVariable("orderId") Integer orderId) {
        return ResponseEntity.ok(orderService.deleteOrder(orderId));
    }
}