package com.dexterbits.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author guillermo
 */
@Entity
@Data
@Table(name="rol")
public class Rol implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name="idrol")
    private Long idRol; 
    
    @NotEmpty
    private String nombre;
}
