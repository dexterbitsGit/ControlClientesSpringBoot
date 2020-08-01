package com.dexterbits.dao;

import com.dexterbits.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author guillermo
 */


public interface PersonaDAO extends JpaRepository<Persona, Long> {
    
}
