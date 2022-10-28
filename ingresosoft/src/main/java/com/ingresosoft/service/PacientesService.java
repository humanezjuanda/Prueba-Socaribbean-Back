package com.ingresosoft.service;


import com.ingresosoft.dto.Pacientes;

import java.util.List;

public interface PacientesService {



    Pacientes save(Pacientes application);

    Pacientes update(Pacientes application);

    List<Pacientes> getAll();

    Pacientes findOne(int nmid);

    void delete(int nmid);
}

