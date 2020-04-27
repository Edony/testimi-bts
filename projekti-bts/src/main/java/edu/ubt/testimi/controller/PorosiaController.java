package edu.ubt.testimi.controller;

import edu.ubt.testimi.data.PorosiaDTO;
import edu.ubt.testimi.data.PorosiaDetajetViewDTO;
import edu.ubt.testimi.data.PorosiaListViewDTO;
import edu.ubt.testimi.data.ProductViewDTO;
import edu.ubt.testimi.service.PorosiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/porosia")
public class PorosiaController {

    @Autowired
    private PorosiaService porosiaService;

    @PostMapping("")
    public ResponseEntity create(@RequestBody @Valid PorosiaDTO porosiaDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldErrors());
        }

        if (porosiaService.create(porosiaDTO)){
            return ResponseEntity.ok(true);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
    }

    @GetMapping("")
    public ResponseEntity getAll(){
        List<PorosiaListViewDTO> result = porosiaService.getAll();
        if (result == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get-one")
    public ResponseEntity getOne(@RequestParam("id") Long id){
        PorosiaDetajetViewDTO result = porosiaService.getOne(id);
        if (result == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/dergo")
    public ResponseEntity dergoPorosine(@RequestParam("id") Long id){
        Boolean result = porosiaService.dergoPorosine(id);
        if (result == false){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(false);
        }
        return ResponseEntity.ok(true);
    }

    @GetMapping("/anulo")
    public ResponseEntity anuloPorosine(@RequestParam("id") Long id){
        Boolean result = porosiaService.anuloPorosine(id);
        if (result == false){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(false);
        }
        return ResponseEntity.ok(true);
    }

}
