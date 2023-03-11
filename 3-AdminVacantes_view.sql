/*==============================================================*/
/* DB name: AdminVacantes                                       */
/* DBMS:	SQL	Server	                                        */
/* producto: view                                               */
/*==============================================================*/
USE AdminVacantes;  
GO

/*==============================================================*/
/* Table: PROSPECTOS                                              */
/*==============================================================*/
CREATE VIEW VW_PROSPECTOS
AS 

SELECT p.id_prospecto as id_prospecto, 
	p.nombre as nombre_prospecto,
	a.nombre_area as nombre_area,	
	v.nombre as nombre_vacante,  
	e.descripcion as estatus_vacante
FROM prospestos p, vacantes v, areas a, estatus e
WHERE p.id_vacante = v.id_vacante
and v.id_area = a.id_area
and v.estatus_vacante = e.id_estatus
ORDER BY p.id_prospecto asc;

GO