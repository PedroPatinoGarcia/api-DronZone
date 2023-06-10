package restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.Dron;
import services.DronService;


@RestController
@RequestMapping("/api/listDron")
public class DronRestController {

    @Autowired
    public DronService dronService;

    @GetMapping("")
    public List<Dron> getList() {
        List<Dron> listaDrones = dronService.findAll();
        return listaDrones;
    }


    @GetMapping("/{id}")
    public Dron getOneElement(@PathVariable Long id) {
            return dronService.findById(id);
    }
   
   

    @PostMapping("")
    public ResponseEntity<?> newElement(@Valid @RequestBody Dron nuevoDron) {
        Dron dron = DronService.add(nuevoDron);
        return ResponseEntity.status(HttpStatus.CREATED).body(dron); // cod 201
    }


    @PutMapping("/{id}")
    public Dron  editElement(@Valid @RequestBody Dron editDron,
            @PathVariable Long id) {
                dronService.findById(id); // ejecutamos esto para ver si se produce excepción
        return dronService.edit(editDron);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteElement(@PathVariable Long id) {
            dronServices.delete(id);
        return ResponseEntity.noContent().build(); // cod 204
    }

}
