package edu.ubt.testimi.controller;

import edu.ubt.testimi.data.ShportaProductDTO;
import edu.ubt.testimi.data.ShportaProductViewDTO;
import edu.ubt.testimi.service.ShportaProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/shporta-product")
public class ShportaProductController {

    @Autowired
    private ShportaProductService shportaProductService;

    @PostMapping("")
    public ResponseEntity create(@RequestBody @Valid ShportaProductDTO shportaProductDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors());
        }

        if (shportaProductService.create(shportaProductDTO)){
            return ResponseEntity.ok(true);
        }

        if (shportaProductService.create(shportaProductDTO) == false){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(false);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
    }

    @GetMapping("")
    public ResponseEntity getAll(){
        List<ShportaProductViewDTO> result = shportaProductService.getAll();
        if (result == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/shto-sasi")
    public ResponseEntity shtoSasi(@RequestParam("id") Long id, @RequestParam("sasia") Integer sasia){
        Boolean result = shportaProductService.shtoSasi(id,sasia);
        if (result == false){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(false);
        }
        return ResponseEntity.ok(true);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(@RequestParam("id") Long id){
        Boolean result = shportaProductService.delete(id);
        if (result == false){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(false);
        }
        return ResponseEntity.ok(true);
    }
}
