package com.ingresosoft.mapper;


import com.ingresosoft.dto.Pacientes;
import com.ingresosoft.util.UtilDate;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.*;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
public class PacientesMapper implements RowMapper<Pacientes> {
    @Override
    public Pacientes mapRow(ResultSet rs, int rowNum) throws SQLException {

        Pacientes entity = new Pacientes();

        UIManager resultSet = null;
        entity.setNmid( resultSet.getInt("nmid"));
        entity.setNomespecie( resultSet.getString("nomespecie"));
        entity.setEspecie(resultSet.getString("especie"));
        entity.setRaza(resultSet.getString("raza"));
        entity.setFechanaci(UtilDate.getLocalDate(rs.getDate("fechanaci")));
        entity.setTipoid(resultSet.getString("tipoid"));
        entity.setIddue( resultSet.getInt("iddue"));
        entity.setNomdue( resultSet.getString("nomdue"));
        entity.setCiudad(resultSet.getString("ciudad"));
        entity.setDireccion(resultSet.getString("direccion"));
        entity.setTelefono( resultSet.getInt("telefono"));
        entity.setFecharegis(UtilDate.getLocalDate(rs.getDate("fecharegis")));

        entity.setPacientesFromRs(rs);
        return entity;
    }
}




