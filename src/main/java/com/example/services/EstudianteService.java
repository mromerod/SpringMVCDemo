package com.example.services;

import java.util.List;

import com.example.entities.Estudiante;

//Service se conecta con el Dao, por eso hay que crear antes el Dao


public interface EstudianteService {

    public List<Estudiante> findAll();
    public Estudiante findById(int idEstudiante);
    public void save(Estudiante estudiante);
    public void deleteById(int idEstudiante);
    /**
     * No es necesario el update porque el save detecta si hay un estudiante con el mismo id.
     * Si existe lo reemplaza y si no lo crea
     */
    
}
