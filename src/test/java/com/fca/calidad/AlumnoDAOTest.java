package com.fca.calidad;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AlumnoDAOTest {
	
	private AlumnoDAO alumnoDAO;

	 @Before

	public void setup(){

	alumnoDAO = new AlumnoDAOHashMap();
	alumnoDAO.getAllAlumno().clear(); //Limpiar nuestra BD
	}

	 @After
	 public void tearDown(){

	}
	 @Test

	public void insertarDatoNuevoTest() {
	
	Alumno alumno = new Alumno("001","nombre", "apellido", 20, 8.0f);

	//Insertar

	alumnoDAO.addAlumno(alumno);

	//Consulta

	String resultadoEsperado = "nombreapellido";
	String resultadoEjecucion = alumnoDAO.getAlumnoName("001");

	 //Verificar que sean iguales

	 assertThat(resultadoEsperado, equalTo(resultadoEjecucion));

	}
	 @Test

	 public void borrarElementoTest(){
	  //Agregar alumno
	Alumno alumno = new Alumno("001","nombre", "apellido", 20, 8.0f);
	  //Insertar
	alumnoDAO.addAlumno(alumno);

	  //Eliminar dato --> Ejercicio del código
	alumnoDAO.removeAlumno(alumno);

	  //Buscar dato que borramos
	String resultadoEsperado = "";
	String resultadoEjecucion = alumnoDAO.getAlumnoName("001");

	  //Verificar esperado igual a vacio
	assertThat(resultadoEsperado, equalTo(resultadoEjecucion));

	 }
	 @Test
	 public void ActualizarPromedioTest() {
		 Alumno alumno = new Alumno("001","nombre", "apellido", 20, 8.0f);
		 alumnoDAO.addAlumno(alumno);
		 alumnoDAO.updateAlumnoPromedio(alumno, 9.0f);
		 
		 float resultadoEsperado = 9.0f;
		 Alumno resultadoEjecucion = alumnoDAO.getAlumno("001");
		 
		 assertThat(resultadoEsperado, equalTo(resultadoEjecucion.getAverage()));
	 }
	 
	
}
