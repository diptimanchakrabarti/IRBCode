package com.codejava.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.codejava.domain.Patient;
import com.codejava.domain.ProviderInfo;
import com.codejava.util.DBConUtil;
public class ProcessDataDAOImpl implements ProcessDataDAO {

private JdbcTemplate jdbcTemplate;

public ProcessDataDAOImpl(DataSource dataSource) throws SQLException {
    jdbcTemplate = new JdbcTemplate(dataSource);
}

@Override
public void saveOrUpdate(ProviderInfo provider){
	String sql = "INSERT INTO userinfo (username, password,email, profession)"
            + " VALUES (?, ?, ?, ?)";
jdbcTemplate.update(sql, provider.getUsername(),provider.getPassword(), provider.getEmail(),
		provider.getProfession());
}

@Override
public ProviderInfo get(String username){
	
	String sql = "SELECT * FROM userinfo WHERE username=" + "\"" + username + "\"";
    return jdbcTemplate.query(sql, new ResultSetExtractor<ProviderInfo>() {
 
        @Override
        public ProviderInfo extractData(ResultSet rs) throws SQLException,
                DataAccessException {
            if (rs.next()) {
            	ProviderInfo prov = new ProviderInfo();
                prov.setEmail(rs.getString("email"));
                prov.setPassword(rs.getString("password"));
                prov.setProfession(rs.getString("profession"));
                prov.setUsername(rs.getString("username"));
                return prov;
            }
 
            return null;
        }
 
    });
}

@Override
public Patient getPatient(String patientId){
	String sql = "SELECT * FROM patient_info WHERE PATIENTID=" + "\"" + patientId + "\"";
    return jdbcTemplate.query(sql, new ResultSetExtractor<Patient>() {
 
        @Override
        public Patient extractData(ResultSet rs) throws SQLException,
                DataAccessException {
            if (rs.next()) {
            	Patient patient = new Patient();
            	patient.setPatientid(rs.getString("PATIENTID"));
                patient.setAdmsndate(rs.getString("joiningdate"));
                patient.setCitynm(rs.getString("city"));
                patient.setDiagcode(rs.getString("ICD10CODE"));
                patient.setDiagcodedesc(rs.getString("ICD10DESC"));
                patient.setDOB(rs.getString("PATIENTAGE"));
                patient.setGendercd(rs.getString("GENDER"));
                patient.setIsdiabetic(rs.getString("isdiabetic"));
                patient.setIshyper(rs.getString("ishyper"));
                patient.setIssmoker(rs.getString("issmoker"));
                patient.setPatname(rs.getString("PATIENTNAME"));
                patient.setSalaryrange(rs.getString("salaryrange"));
                patient.setStatenm(rs.getString("PATIENTSTATE"));
                patient.setTemp(rs.getString("temp"));
                return patient;
            }
 
            return null;
        }
 
    });
}

}
