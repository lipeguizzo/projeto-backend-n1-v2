package br.com.exercicio10.services;

import br.com.exercicio10.domain.dto.ProductOrderCreateDto;
import br.com.exercicio10.domain.dto.ProductOrderUpdateDto;
import br.com.exercicio10.domain.entities.ProductOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;

@Service
public class ProductOrderService {
    private RestClient client = RestClient.create("http://localhost:3000/productOrders");

    public ResponseEntity<?> findMany() {
        try{
            ArrayList<ProductOrder> data = client
                    .get()
                    .retrieve()
                    .body(ArrayList.class);
            return ResponseEntity.ok().body(data);

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao encontrar produtos pedidos!");
        }
    }

    public ResponseEntity<?> findOne(String id) {
        try{
            ProductOrder productOrder = client.get()
                    .uri("/" + id)
                    .retrieve()
                    .body(ProductOrder.class);
            return ResponseEntity.ok().body(productOrder);

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao encontrar produto pedido!");
        }
    }

    public ResponseEntity<?> create(ProductOrderCreateDto dto) {
        try{
            ProductOrder createdProductOrder = client.post()
                    .body(dto)
                    .retrieve()
                    .body(ProductOrder.class);
            return ResponseEntity.ok().body(createdProductOrder);

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao criar produto pedido!");
        }
    }

    public ResponseEntity<?> update(String id,ProductOrderUpdateDto dto) {
        try{
            ProductOrder updatedProductOrder = client.put()
                    .uri("/" + id)
                    .body(dto)
                    .retrieve()
                    .body(ProductOrder.class);
            return ResponseEntity.ok().body(updatedProductOrder);

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao atualizar produto pedido!");
        }
    }

    public ResponseEntity<?> delete(String id) {
        try{
            client.delete()
                    .uri("/" + id)
                    .retrieve();
            return ResponseEntity.ok().body("Produto pedido deletado!");

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao deletar produto pedido!");
        }
    }
}