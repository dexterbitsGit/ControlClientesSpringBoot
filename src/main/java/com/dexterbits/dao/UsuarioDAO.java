package com.dexterbits.dao;

import com.dexterbits.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author guillermo
 */


public interface UsuarioDAO extends JpaRepository<Usuario, Long> {
    
    Usuario findByUsername(String username);
}
