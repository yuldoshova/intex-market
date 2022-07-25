package com.example.index_market.controller.order;

import com.example.index_market.controller.AbstractController;
import com.example.index_market.dto.order.OrderCreateDto;
import com.example.index_market.dto.order.OrderUpdateDto;
import com.example.index_market.response.ApiResponse;
import com.example.index_market.service.order.OrderServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController extends AbstractController<OrderServiceImpl> {

    public OrderController(OrderServiceImpl service) {
        super(service);
    }

    /**
     * Barcha orderlar ro'yxatini ko'rish Admin uchun
     *
     * @return
     */
    @Operation(summary = "all orders",description = "hamma orderlarni ko'rish")
    @GetMapping("/get-all-orders")
    public HttpEntity<?> getAll() {
        ApiResponse all = service.getAll();
        return ResponseEntity.ok(all);
    }

    /**
     * Buyurtmani o'chirb tashlash
     *
     * @param id
     * @return
     */
    @Operation(summary = "delete method",description = "orderni delete qilish")
    @DeleteMapping("/delete-order/{id}")
    public HttpEntity<?> delete(@PathVariable String id) {
        ApiResponse delete = service.delete(id);
        return ResponseEntity.status(delete.isSuccess() ? 204 : 409).body(delete);
    }




    /**
     * maxsulot buyurtma qilish
     *
     * @param dto
     * @return
     */
    @Operation(summary = "create method",description = "buyurtma berish")
    @PostMapping("/add-order")
    public HttpEntity<?>add(@RequestBody OrderCreateDto dto){
        ApiResponse response = service.create(dto);
        return ResponseEntity.status(response.isSuccess() ? 201 : 409).body(response);
    }
}
