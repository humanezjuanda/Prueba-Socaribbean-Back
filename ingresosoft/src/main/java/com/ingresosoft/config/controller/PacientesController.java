package com.ingresosoft.config.controller;
import com.ingresosoft.dto.Pacientes;
import com.ingresosoft.service.PacientesService;
import com.ingresosoft.util.MessagesConstants;
import com.ingresosoft.util.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;


@RestController
@RequestMapping("/api")
public class PacientesController {

    private Logger log = LoggerFactory.getLogger(PacientesController.class);

    private static final String ENITY_NAME = "pacientes";
    private final com.ingresosoft.service.PacientesService PacientesService;

    public PacientesController(PacientesService PacientesService){
        this.PacientesService = PacientesService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/pacientes")
    public ResponseEntity<ResponseMessage<List<Pacientes>>> getAllPacientes(){
        log.debug("REST request to get all Pacientes");
        return ResponseEntity.ok( new ResponseMessage<>(0,null, PacientesService.getAll()));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/pacientes")
    public ResponseEntity<ResponseMessage<Pacientes>> create(@Valid @RequestBody Pacientes pacientes) throws ApplicationCustomException {
        log.debug("REST request to save Pacientes : {}",PacientesService);
        Pacientes Pacientes = PacientesService.findOne(pacientes.getNmid());
        if(Pacientes != null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENITY_NAME));
        }

        Pacientes result =PacientesService.save(pacientes);
        return ResponseEntity.ok( new ResponseMessage<>(0,null, result));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/pacientes")
    public ResponseEntity<ResponseMessage<Pacientes>> update(@Valid @RequestBody Pacientes pacientes) throws ApplicationCustomException {
        log.debug("REST request to update Pacientes : {} ", pacientes);
        if(pacientes.getNmid() == 0){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE,String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENITY_NAME));
        }
        Pacientes result = PacientesService.update(pacientes);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/pacientes/{nmid}")
    public ResponseEntity<ResponseMessage<Pacientes>> delete(@PathVariable int nmid) {
        log.debug("REST request to delete : {}", nmid);
        PacientesService.delete(nmid);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, null) );
    }


}
