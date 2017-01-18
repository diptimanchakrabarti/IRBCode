package com.codejava.dao;

import com.codejava.domain.Patient;
import com.codejava.domain.ProviderInfo;
public interface ProcessDataDAO {

	public void saveOrUpdate(ProviderInfo provider);
    
   // public void delete(String username);
     
   public ProviderInfo get(String username);
   
   public Patient getPatient(String patientId);
}
