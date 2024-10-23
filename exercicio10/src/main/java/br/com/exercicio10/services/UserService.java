package br.com.exercicio10.services;

import br.com.exercicio10.domain.dto.UserCreateDto;
import br.com.exercicio10.domain.dto.UserUpdateDto;
import br.com.exercicio10.domain.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;

@Service
public class UserService {
    private RestClient client = RestClient.create("http://localhost:3000/users");

    public ResponseEntity<?> findMany() {
        try{
            ArrayList<User> data = client
                    .get()
                    .retrieve()
                    .body(ArrayList.class);
            return ResponseEntity.ok().body(data);

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao encontrar usuários!");
        }
    }

    public ResponseEntity<?> findOne(String id) {
        try{
            User user = client.get()
                    .uri("/" + id)
                    .retrieve()
                    .body(User.class);
            return ResponseEntity.ok().body(user);

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao encontrar usuário!");
        }
    }

    public ResponseEntity<?> create(UserCreateDto dto) {
        try{
            User createdUser = client.post()
                    .body(dto)
                    .retrieve()
                    .body(User.class);
            return ResponseEntity.ok().body(createdUser);

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao criar usuário!");
        }
    }

    public ResponseEntity<?> update(String id,UserUpdateDto dto) {
        try{
            User updatedUser = client.put()
                    .uri("/" + id)
                    .body(dto)
                    .retrieve()
                    .body(User.class);
            return ResponseEntity.ok().body(updatedUser);

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao atualizar usuário!");
        }
    }

    public ResponseEntity<?> delete(String id) {
        try{
            client.delete()
                    .uri("/" + id)
                    .retrieve();
            return ResponseEntity.ok().body("Usuário deletado!");

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro ao deletar usuário!");
        }
    }
}