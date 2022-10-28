package com.ingresosoft.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ingresosoft.util.UtilDate;
import lombok.Data;


import java.io.Serializable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Data
public class Pacientes implements Serializable {


    private static final long serialVersionUID = 1L;
    private int nmid;
    private String nomespecie;
    private String especie;
    private String raza;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fechanaci;
    private String tipoid;
    private int iddue;
    private String nomdue;
    private String ciudad;
    private String direccion;
    private int telefono;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fecharegis;


    public static List<Pacientes> getAll() {
        return null;
    }

    @JsonIgnore
    public void setPacientesFromRs(ResultSet rs) throws SQLException {
        nmid = rs.getInt("nmid");
        nomespecie = rs.getString("nomespecie");
        especie = rs.getString("especie");
        raza = rs.getString("raza");
        fechanaci = UtilDate.getLocalDate(rs.getDate("fechanaci"));
        tipoid = rs.getString("tipoid");
        iddue = rs.getInt("iddue");
        nomdue = rs.getString("nomdue");
        ciudad = rs.getString("ciudad");
        direccion = rs.getString("direccion");
        telefono = rs.getInt("telefono");
        fecharegis = UtilDate.getLocalDate(rs.getDate("fecharegis"));




}
}