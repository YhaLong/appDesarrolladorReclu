/*==============================================================*/
/* DB name: AdminVacantes                                       */
/* DBMS:	SQL	Server	                                        */
/*==============================================================*/
--CREATE DATABASE AdminVacantes;

--USE AdminVacantes;


/*==============================================================*/
/* Table: AREAS                                                 */
/*==============================================================*/
CREATE TABLE areas ( 
	id_area            int NOT NULL IDENTITY	,
	cve_area           varchar(6) NOT NULL	,
	nombre_area        varchar(50) NOT NULL	,
	CONSTRAINT PK_areas_id_area PRIMARY KEY  ( id_area )
 );


/*==============================================================*/
/* Table: ESTATUS                                               */
/*==============================================================*/
CREATE TABLE estatus ( 
	id_estatus           int NOT NULL IDENTITY	,
	cve_estatus          varchar(1) NOT NULL	,
	descripcion          varchar(30) NOT NULL	,
	CONSTRAINT PK_estatus_id_estatus PRIMARY KEY  ( id_estatus )
 );


/*==============================================================*/
/* Table: VACANTES                                              */
/*==============================================================*/
CREATE TABLE vacantes ( 
	id_vacante           int NOT NULL IDENTITY	,
	id_area              int NOT NULL 	,
	nombre               varchar(70) NOT NULL   ,
	cubierta             varchar(1) NOT NULL   ,
	CONSTRAINT PK_vacantes_id_vacante PRIMARY KEY  ( id_vacante ),
	CONSTRAINT FK_vacantes_areas FOREIGN KEY ( id_area ) REFERENCES areas( id_area )
 );

/*==============================================================*/
/* Table: PROSPECTOS                                            */
/*==============================================================*/
CREATE TABLE prospectos ( 
	id_prospecto        int NOT NULL IDENTITY  ,
	id_vacante          int NOT NULL  ,
	nombre              varchar(70) NOT NULL   ,
	edad                int NOT NULL  ,
	estatus_vacante     int ,
	CONSTRAINT PK_prospectos_id_prospecto PRIMARY KEY  ( id_prospecto ),
	CONSTRAINT U_nombre UNIQUE (nombre)
	CONSTRAINT U_prospecto_vacante UNIQUE (id_prospecto, id_vacante)
	CONSTRAINT FK_vacantes_prospectos FOREIGN KEY ( id_vacante ) REFERENCES vacantes( id_vacante )
	CONSTRAINT FK_estatus_prospectos FOREIGN KEY ( estatus_vacante ) REFERENCES estatus( id_estatus )
 );
 
 
/*==============================================================*/
/* Table: HISTORICO_VACANTES                                            */
/*==============================================================*/
CREATE TABLE historico_vacantes ( 
	id_historico_vacante        int NOT NULL IDENTITY  ,
	id_vacante                  int NOT NULL  ,
	id_prospecto                int NOT NULL   ,
	observaciones               varchar(70) NOT NULL   ,
	CONSTRAINT PK_historico_vacantes_id_historico_vacante PRIMARY KEY  ( id_historico_vacante )
 );

/*==============================================================*/
/* Table: ROLES                                                 */
/*==============================================================*/
CREATE TABLE roles ( 
	id_rol           int NOT NULL IDENTITY ,
	cve_rol          varchar(1) NOT NULL   ,
	descripcion      varchar(30) NOT NULL   ,
	CONSTRAINT PK_roles_id_rol PRIMARY KEY  ( id_rol )
 );


/*==============================================================*/
/* Table: USUARIOS                                              */
/*==============================================================*/
CREATE TABLE usuarios ( 
	id_usuario            int NOT NULL IDENTITY  ,
	id_rol                int NOT NULL ,
	cve_usuario           varchar(6) NOT NULL   ,
	nombre                varchar(70) NOT NULL   ,
	contrasenia           varchar(1) NOT NULL   ,
	CONSTRAINT PK_usuarios_id_usuario PRIMARY KEY  ( id_usuario ),
	CONSTRAINT FK_usuarios_roles FOREIGN KEY ( id_rol ) REFERENCES areas( id_rol )
 );