package br.com.exercicio10.controllers;

import br.com.exercicio10.domain.dto.ProductOrderCreateDto;
import br.com.exercicio10.domain.dto.ProductOrderUpdateDto;
import br.com.exercicio10.services.ProductOrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/product-orders")
public class ProductOrderController {

    @Autowired
    ProductOrderService productOrderService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<?> findMany() {
        return productOrderService.findMany();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<?> findOne(@PathVariable String id) {
        return productOrderService.findOne(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody @Valid ProductOrderCreateDto dto) {
        return productOrderService.create(dto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody @Valid  ProductOrderUpdateDto dto) {
        return productOrderService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable String id) {
        return productOrderService.delete(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Map<String, String> validationErrors(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();

        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        return errors;
    }

}
