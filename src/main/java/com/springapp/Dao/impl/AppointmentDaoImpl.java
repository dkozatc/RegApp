package com.springapp.dao.impl;

import com.springapp.dao.AppointmentDao;
import com.springapp.models.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    @Autowired
    private DataSource dataSource;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private  ResourceBundle myResources = ResourceBundle.getBundle("com.springapp.properties.AppointmentDao");
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.namedParameterJdbcTemplate = new  NamedParameterJdbcTemplate(this.dataSource);
        System.out.print("set");
    }
    @Override
    public int insertAppointment(Appointment appointment) {
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(appointment);
        String query =this.myResources.getString("insertAppointment");
        this.namedParameterJdbcTemplate.update(query, namedParameters);
        String selectQuery = this.myResources.getString("selectAppointmentId");
        int id = this.namedParameterJdbcTemplate.queryForInt(selectQuery, namedParameters);
        return id;
    }
    @Override
    public String updateAppointment(Appointment appointment) {
        String query = "UPDATE appointments SET StartDateTime=?, EndDateTime=?, Resourceid=?, CommentsText=? WHERE" +
                "id="+appointment.getId();
        return null;
    }
    @Override
    public List<Appointment> getAppointments(String query) {

        String sqlQuery = this.myResources.getString("getAppointmentList");
        MapSqlParameterSource paramSource = new MapSqlParameterSource("EncounterId", query);
        List<Appointment> appointments = this.namedParameterJdbcTemplate.query(sqlQuery, paramSource, new RowMapper() {
            @Override
            public Appointment mapRow(ResultSet resultSet, int i) throws SQLException {
                Appointment appointment = new Appointment();
                appointment.setId(resultSet.getInt("id"));
                appointment.setStartDateTime(resultSet.getString("StartDateTime"));
                appointment.setEndDateTime(resultSet.getString("EndDateTime"));
                appointment.setEncounterId(resultSet.getInt("EncounterId"));
                appointment.setResourcesId(resultSet.getInt("ResourcesId"));
                appointment.setCommentsText(resultSet.getString("CommentsText"));
                return appointment;
            }
        });

        return appointments;
    }
}
