package br.com.exercicio10.services;

import br.com.exercicio10.domain.dto.ProductCreateDto;
import br.com.exercicio10.domain.dto.ProductUpdateDto;
import br.com.exercicio10.domain.dto.UserCreateDto;
import br.com.exercicio10.domain.dto.UserUpdateDto;
import br.com.exercicio10.domain.entities.Product;
import br.com.exercicio10.domain.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;

@Service
public class ProductService {
    private RestClient client = RestClient.create("http://localhost:3000/products");

    public ResponseEntity<?> findMany() {
        try{
            ArrayList<Product> data = client
                    .get()
                    .retrieve()
                    .body(ArrayList.class);
            return ResponseEntity.ok().body(data);

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao encontrar produtos!");
        }
    }

    public ResponseEntity<?> findOne(String id) {
        try{
            Product product = client.get()
                    .uri("/" + id)
                    .retrieve()
                    .body(Product.class);
            return ResponseEntity.ok().body(product);

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao encontrar produto!");
        }
    }

    public ResponseEntity<?> create(ProductCreateDto dto) {
        try{
            Product createdProduct = client.post()
                    .body(dto)
                    .retrieve()
                    .body(Product.class);
            return ResponseEntity.ok().body(createdProduct);

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao criar produto!");
        }
    }

    public ResponseEntity<?> update(String id, ProductUpdateDto dto) {
        try{
            Product updatedProduct = client.put()
                    .uri("/" + id)
                    .body(dto)
                    .retrieve()
                    .body(Product.class);
            return ResponseEntity.ok().body(updatedProduct);

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao atualizar produto!");
        }
    }

    public ResponseEntity<?> delete(String id) {
        try{
            client.delete()
                    .uri("/" + id)
                    .retrieve();
            return ResponseEntity.ok().body("Produto deletado!");

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao deletar produto!");
        }
    }
}