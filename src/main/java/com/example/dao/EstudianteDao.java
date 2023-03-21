package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.entities.Estudiante;
/**
 * Comentario en formato Javadoc, ordena por clases 
 */
 //aquí busca los beans, tiene los métodos, no hace falta ninguna clase que implemente 

public interface EstudianteDao extends JpaRepository<Estudiante,Integer> {

//integer porque el id de estudiante es int
//con esto puedo pedir lo que sea al estudiante siempre que en la clase tenga los constructores 

    


}
