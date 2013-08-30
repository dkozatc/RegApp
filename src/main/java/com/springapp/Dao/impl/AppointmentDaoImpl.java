package com.springapp.dao.impl;

import com.springapp.dao.AppointmentDao;
import com.springapp.models.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/29/13
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class AppointmentDaoImpl implements AppointmentDao {


    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private ResourceBundle myResources = ResourceBundle.getBundle("com.springapp.properties.AppointmentDao");
    private final String INSERT_APPOINTMENT = myResources.getString("insertAppointment");
    private final String UPDATE_APPOINTMENT = this.myResources.getString("updateAppointment");
    private final String GET_APPOINTMENT_LIST = this.myResources.getString("getAppointmentList");
    private final String DELETE_APPOINTMENT = this.myResources.getString("deleteAppointment");


    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        System.out.print("set");
    }

    @Override
    public int insertAppointment(Appointment appointment) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(appointment);
        this.namedParameterJdbcTemplate.update(this.INSERT_APPOINTMENT, namedParameters, keyHolder);
        int id = keyHolder.getKey().intValue();
        return id;
    }

    @Override
    public String updateAppointment(Appointment appointment) {
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(appointment);
        this.namedParameterJdbcTemplate.update(this.UPDATE_APPOINTMENT, namedParameters);
        return "Update dane";
    }

    @Override
    public List<Appointment> getAppointments(int query) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource("EncounterId", query);
        List<Appointment> appointments = this.namedParameterJdbcTemplate.query(this.GET_APPOINTMENT_LIST, paramSource, new RowMapper() {
            @Override
            public Appointment mapRow(ResultSet resultSet, int i) throws SQLException {
                Appointment appointment = new Appointment();
                appointment.setId(resultSet.getInt("id"));
                appointment.setStartDateTime(resultSet.getTimestamp("StartDateTime"));
                appointment.setEndDateTime(resultSet.getTimestamp("EndDateTime"));
                appointment.setEncounterId(resultSet.getInt("EncounterId"));
                appointment.setResourcesId(resultSet.getInt("ResourcesId"));
                appointment.setCommentsText(resultSet.getString("CommentsText"));
                return appointment;
            }
        });
        return appointments;
    }

    @Override
    public String removeAppointments(int id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        this.namedParameterJdbcTemplate.update(this.DELETE_APPOINTMENT, parameterSource);
        return "delete dane";
    }
}
