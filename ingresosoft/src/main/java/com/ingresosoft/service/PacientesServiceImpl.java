package com.ingresosoft.service;


import com.ingresosoft.dao.PacientesDAO;
import com.ingresosoft.dto.Pacientes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PacientesServiceImpl implements PacientesService{
    private  final Logger log = LoggerFactory.getLogger(PacientesServiceImpl.class);

    private final PacientesDAO pacientesDAO;

    public PacientesServiceImpl(PacientesDAO pacientesDAO) {
        this.pacientesDAO = pacientesDAO;
    }

    @Override
    public Pacientes save(Pacientes pacientes) {
        log.debug("Request to insert Pacientes: {}", pacientes);
        return pacientesDAO.insert(pacientes);
    }

    @Override
    public Pacientes update(Pacientes pacientes) {
        log.debug("Request to get all Pacientes : {}", pacientes);
        return pacientesDAO.update(pacientes);
    }



    @Override
    @Transactional(readOnly = true)
    public List<Pacientes> getAll() {
        log.debug("Request to get all Pacientess");
        return pacientesDAO.getAll();
    }

    @Override
    public Pacientes findOne(int nmid) {
        return null;
    }

    @Override
    public void delete(int nmid) {
        log.debug("Request to delete }", nmid);
        pacientesDAO.delete(nmid);
        }
    }




