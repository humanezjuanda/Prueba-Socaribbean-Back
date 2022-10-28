package com.ingresosoft.dao;


import com.ingresosoft.dto.Pacientes;
import com.ingresosoft.mapper.PacientesMapper;
import com.ingresosoft.util.DaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;
@Repository
public class PacientesDAOImpl implements PacientesDAO{

    private static final String INSERT ="INSERT INTO pacientes (nomespecie,especie,raza,fechanaci,tipoid,iddue,nomdue,ciudad,direccion,telefono,fecharegis)" +
            " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE ="UPDATE pacientes set nomespecie = ? ,especie = ? ,raza = ? ,fechanaci = ? ,tipoid = ? ,iddue = ? ,nomdue = ? ," +
            "ciudad = ? ,direccion = ? ,telefono = ? ,fecharegis = ? WHERE nmid = ?";
    private static final String SELECT ="SELECT * FROM pacientes";
    private static final String SELECTBYID = SELECT + " WHERE nmid = ?";
    private static final String DELETE = "DELETE FROM pacientes WHERE nmid = ?";
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void PacientesMapper(DataSource dataSource){jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override
    public List<Pacientes> getAll() {
        return jdbcTemplate.query(SELECT, new PacientesMapper());
    }

    @Override
    public Pacientes getById(int nmid) {
        return jdbcTemplate.queryForObject(SELECTBYID, new PacientesMapper(), nmid);
    }

    @Override
    public Pacientes insert(Pacientes entity) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT, new String[]{ "nmpaciente" });
            DaoUtil.setPrepareStatement(ps, new Object[]{entity.getNomespecie(),entity.getEspecie(), entity.getRaza(), entity.getFechanaci(), entity.getTipoid(), entity.getIddue(),entity.getNomdue(),entity.getCiudad(), entity.getDireccion(),entity.getTelefono(),entity.getFecharegis()});
            return ps;
        }, keyHolder);
        entity.setNmid(keyHolder.getKey().intValue());
        return entity;
    }

    @Override
    public Pacientes update(Pacientes entity){
        jdbcTemplate.update(UPDATE, entity.getNomespecie(),entity.getEspecie(),
                entity.getRaza(), entity.getFechanaci(), entity.getTipoid(), entity.getIddue(),entity.getNomdue(),
                entity.getCiudad(), entity.getDireccion(),entity.getTelefono(),entity.getFecharegis(),entity.getNmid());
        return entity;
    }
    @Override
    public Boolean delete(int nmid) {
        return jdbcTemplate.update(DELETE,
                nmid
        )>0;
    }
}
