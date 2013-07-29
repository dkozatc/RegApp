package com.springapp.dao.impl;

import com.springapp.dao.AppointmentDao;
import com.springapp.models.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
        System.out.print("set");
    }
    @Override
    public int insertAppointment(Appointment appointment) {

        String query = "INSERT INTO appointments (id, StartDateTime, EndDateTime, Resourceid, CommentsText)" +
                "VALUES (null,?, ?, ?, ?)";
       this.jdbcTemplate.update(query, new Object[]{
                appointment.getStartDateTime(),
                appointment.getEndDateTime(),
                appointment.getResourceId(),
                appointment.getCommentsText()
        });
        return 0;
    }
    @Override
    public String updateAppointment(Appointment appointment) {

        String query = "UPDATE appointments SET StartDateTime=?, EndDateTime=?, Resourceid=?, CommentsText=? WHERE" +
                "id="+appointment.getId();
        this.jdbcTemplate.update(query, new Object[]{
                appointment.getStartDateTime(),
                appointment.getEndDateTime(),
                appointment.getResourceId(),
                appointment.getCommentsText()
        });


        return null;
    }
    @Override
    public List<Appointment> getAppointments(String query) {

        String sqlQuery = "SELECT * FROM appointments WHERE id ="+query;
        List<Appointment> appointments = this.jdbcTemplate.query(sqlQuery, new RowMapper() {
            @Override
            public Appointment mapRow(ResultSet resultSet, int i) throws SQLException {
                Appointment appointment = new Appointment();
                appointment.setId(resultSet.getInt("id"));
                appointment.setStartDateTime(resultSet.getString("StartDateTime"));
                appointment.setEndDateTime(resultSet.getString("EndDateTime"));
                appointment.setResourceId(resultSet.getInt("Resourceid"));
                appointment.setCommentsText(resultSet.getString("CommentsText"));
                return appointment;
            }
        });

        return appointments;
    }
}
