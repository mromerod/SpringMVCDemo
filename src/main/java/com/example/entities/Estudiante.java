package com.example.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "estudiantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    //@NotNull(message = "El nombre no puede ser null") el de validation
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private LocalDate fechaAlta;
    private LocalDate fechaNacimiento;
    private Genero genero;
    private double beca;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST) //muchos estudiantes a una facultad
    //Lazy cuando el proyecto sea más grande y tengas que pedirle sólo lo que necesites, pero ahora es pequeño pido todo
    @JoinColumn(name = "idFacultad")//esto es para llamarlo como yo quiero pero por defecto te lo hace
    
    private Facultad facultad; //relacion estudiante con facultad
    
   

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "estudiante")
    private List<Telefono> telefonos;//relacion estudiante y telefonos

    public enum Genero{

        HOMBRE, MUJER, OTRO
    }
    
}
