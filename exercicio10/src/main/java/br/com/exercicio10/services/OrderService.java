package br.com.exercicio10.services;

import br.com.exercicio10.domain.dto.OrderCreateDto;
import br.com.exercicio10.domain.dto.OrderUpdateDto;
import br.com.exercicio10.domain.entities.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;

@Service
public class OrderService {
    private RestClient client = RestClient.create("http://localhost:3000/orders");

    public ResponseEntity<?> findMany() {
        try{
            ArrayList<Order> data = client
                    .get()
                    .retrieve()
                    .body(ArrayList.class);
            return ResponseEntity.ok().body(data);

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao encontrar pedidos!");
        }
    }

    public ResponseEntity<?> findOne(String id) {
        try{
            Order order = client.get()
                    .uri("/" + id)
                    .retrieve()
                    .body(Order.class);
            return ResponseEntity.ok().body(order);

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao encontrar pedido!");
        }
    }

    public ResponseEntity<?> create(OrderCreateDto dto) {
        try{
            Order createdOrder = client.post()
                    .body(dto)
                    .retrieve()
                    .body(Order.class);
            return ResponseEntity.ok().body(createdOrder);

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao criar pedido!");
        }
    }

    public ResponseEntity<?> update(String id,OrderUpdateDto dto) {
        try{
            Order updatedOrder = client.put()
                    .uri("/" + id)
                    .body(dto)
                    .retrieve()
                    .body(Order.class);
            return ResponseEntity.ok().body(updatedOrder);

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao atualizar pedido!");
        }
    }

    public ResponseEntity<?> delete(String id) {
        try{
            client.delete()
                    .uri("/" + id)
                    .retrieve();
            return ResponseEntity.ok().body("Pedido deletado!");

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao deletar pedido!");
        }
    }
}