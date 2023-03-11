/*==============================================================*/
/* DB name: AdminVacantes                                       */
/* DBMS:	SQL	Server	                                        */
/* producto: stored procedure                                   */
/*==============================================================*/
USE AdminVacantes;  
GO

/*==============================================================*/
/* Table: VACANTES                                              */
/*==============================================================*/
CREATE PROCEDURE SP_INSERTA_VACANTE  
    @id_area    int,
	@nombre      varchar(70),
	@cubierta    varchar(1)
AS     
    INSERT INTO vacantes (id_area, nombre, cubierta) 
	VALUES  (@id_area, @nombre, @cubierta)
	
GO  

CREATE PROCEDURE SP_ACTUALIZA_VACANTE  
    @id_vacante  int,
	@id_area     int,
	@nombre      varchar(70),
	@cubierta    varchar(1)
AS     
	
	UPDATE vacantes
    SET id_area = @id_area,
		nombre = @nombre, 
		cubierta = @cubierta
	WHERE  id_vacante = @id_vacante
	
GO

