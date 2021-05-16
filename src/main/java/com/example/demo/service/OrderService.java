package com.example.demo.service;

import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.request.AddOrderDTOCmd;
import com.example.demo.dto.request.UpdateOrderDTOCmd;
import com.example.demo.entity.MovieEntity;
import com.example.demo.entity.OrderEntity;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream()
                .map(OrderDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO addNewOrder(AddOrderDTOCmd addOrderDTOCmd) {
        var order = createNewOrder(addOrderDTOCmd);
        orderRepository.save(order);
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO updateOrder(UpdateOrderDTOCmd updateOrderDTOCmd) {
        var order = orderRepository.findById(updateOrderDTOCmd.getId())
                .orElseThrow(() -> new RuntimeException("Order with given id not found"));
        fillOrder(order, updateOrderDTOCmd);
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO deleteOrder(Integer orderId) {
        var orderToBeDeleted = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order cannot be removed becouse it does not exist"));
        orderRepository.deleteById(orderId);
        return new OrderDTO(orderToBeDeleted);
    }

    private OrderEntity createNewOrder(AddOrderDTOCmd addOrderDTOCmd) {
        var orderEntity = new OrderEntity();
        orderEntity.setDate(addOrderDTOCmd.getDate());
        orderEntity.setDiscount(addOrderDTOCmd.getDiscount());
        orderEntity.setGross(addOrderDTOCmd.getGross());
        orderEntity.setMovie(new MovieEntity(addOrderDTOCmd.getMovieId()));
        orderEntity.setNetAmount(addOrderDTOCmd.getNetAmount());
        return orderEntity;
    }

    private void fillOrder(OrderEntity orderEntity, UpdateOrderDTOCmd updateOrderDTOCmd) {
        orderEntity.setNetAmount(updateOrderDTOCmd.getNetAmount());
        orderEntity.setGross(updateOrderDTOCmd.getGross());
        orderEntity.setDiscount(updateOrderDTOCmd.getDiscount());
        orderEntity.setDate(updateOrderDTOCmd.getDate());
        orderEntity.setMovie(new MovieEntity(updateOrderDTOCmd.getMovieId()));
    }
}
