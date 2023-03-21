package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EstudianteDao;
import com.example.entities.Estudiante;

//quick fix
//esta clase depende del DAO, entonces creamos un objeto de estudiante DAO

    
@Service //buca los beans como el repositorio 
public class EstudianteServiceImpl implements EstudianteService{


    @Autowired //esto crea el objeto, inyecta la dependencia. Mi clase depende de este objeto 
    private EstudianteDao estudianteDao;
    
    @Override
    public List<Estudiante> findAll() {
        
        return estudianteDao.findAll();
    }

    @Override
    public Estudiante findById(int idEstudiante) {
        return estudianteDao.findById(idEstudiante).get(); //porque devuelve un opcional, un registro y hay que extraerlo
    }

    @Override
    public void save(Estudiante estudiante) {
       estudianteDao.save(estudiante);
    }

    @Override
    public void deleteById(int idEstudiante) {
        estudianteDao.deleteById(idEstudiante);
        
    }
    
}
