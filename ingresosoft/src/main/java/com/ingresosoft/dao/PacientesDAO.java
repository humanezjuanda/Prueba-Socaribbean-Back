package com.ingresosoft.dao;


import com.ingresosoft.dto.Pacientes;

import java.util.List;

public interface PacientesDAO {

    List<Pacientes> getAll();

    Pacientes getById(int nmid);

    Pacientes insert(Pacientes entity);

    Pacientes update(Pacientes entity);

    Boolean delete(int nmid);
}

