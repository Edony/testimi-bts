package edu.ubt.testimi.controller;

import edu.ubt.testimi.data.ProductDTO;
import edu.ubt.testimi.data.ProductViewDTO;
import edu.ubt.testimi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("")
    public ResponseEntity create(@RequestBody @Valid ProductDTO productDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors());
        }

        if (productService.create(productDTO) != null){
            return ResponseEntity.ok(true);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
    }

    @PutMapping("")
    public ResponseEntity update(@RequestBody @Valid ProductViewDTO productViewDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors());
        }

        if (productService.update(productViewDTO) != null){
            return ResponseEntity.ok(true);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
    }

    @GetMapping("")
    public ResponseEntity getAll(){
        List<ProductViewDTO> result = productService.getAll();
        if (result == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get-one")
    public ResponseEntity getOne(@RequestParam("id") Long id){
        ProductViewDTO result = productService.getOne(id);
        if (result == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
        }
        return ResponseEntity.ok(result);
    }

}
