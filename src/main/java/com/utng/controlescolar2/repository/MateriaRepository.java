package com.utng.controlescolar2.repository;

import java.util.List;
import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utng.controlescolar2.model.Materia;


public interface MateriaRepository extends JpaRepository<Materia, Integer>{

	@Query("select a from Materia a where a.nombre = ?1")
	Optional<Materia> consultarPorNombre(@Param("nombre") String nombre);
	/*
	@Query("SELECT mtp.TXT_NOMBRE or mtm.DES_MATERIA "
			+ "FROM Master_tbl_profesor mtp Inner Join Rel_tbl_profesor_materia rtpm "
			+ "On mtp.PK_PROFESOR =?1 = rtpm.FK_PROFESOR=?1"
			+ "Inner Join Master_tbl_materia as mtm "
			+ "On rtpm.FK_MATERIA =?1 = mtm.PK_MATERIA =?1")
	Response<Materia>consultarProfesorMateria(@Param("materia") String materia);
	*/
	// Busqueda dinamica
	@Query("select a from Materia a where a.nombre = ?1 or a.clave = ?1 or a.id=?1 "
			+ "or a.estatus=?1")
	List<Materia> consultaDinamica(@Param("dato") String dato);
	
	
	/*
	 * 
	 * 
	*/
/*	SELECT mtp.TXT_NOMBRE , mtm.DES_MATERIA 
	FROM MASTER_TBL_PROFESOR as mtp Inner Join REL_TBL_PROFESOR_MATERIA as rtpm
	On mtp.PK_PROFESOR = rtpm.FK_PROFESOR 
	Inner Join MASTER_TBL_MATERIA as mtm
	On rtpm.FK_MATERIA = mtm.PK_MATERIA 


	@Query("select u.userName from User u inner join u.area ar where ar.idArea = :idArea")

	
	*SELECT
	 u.user_name 
	 FROM
	  user as u 
	  INNER JOIN area as a ON a.iduser = u.iduser
	  WHERE
	  a.idarea = 4
	*
	*/
	
	
	/*@Query("SELECT mtp.TXT_NOMBRE , rtpm.FK_MATERIA, mtm.DES_MATERIA"
			+ "FROM MASTER_TBL_PROFESOR as mtp Inner Join REL_TBL_PROFESOR_MATERIA as rtpm"
			+ "On mtp.PK_PROFESOR = rtpm.FK_PROFESOR"
			+ "Inner Join MASTER_TBL_MATERIA as mtm"
			+ "On rtpm.FK_MATERIA = mtm.PK_MATERIA ")
	Response<Materia> consultarProfesorMateria(@Param("materia") String materia);*/
	
	/*@Query("select mtp.nombre from MASTER_TBL_PROFESOR mtp inner join"
			+ " mtp.profesor rtmp where rtmp.id =: id" )
			//+"mtp.FK_PROFESOR rtmp where rtmp.FK_PROFESOR = :PK_PROFESOR Inner Join "
			//+ "MASTER_TBL_MATERIA mtm Inner Join  rtmp.FK_MATERIA =:PK_MATERIA")
	Response<ProfesorMateria> consultarProfesorMateria();
}*/


}
			
