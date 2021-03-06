CREATE TABLE "TEST04"."PEDROMONCADA_ROL" 
   (	"ID" NUMBER(19,0) NOT NULL ENABLE, 
	"DESCRIPCION" VARCHAR2(255 CHAR), 
	"ELIMINADO" NUMBER(10,0), 
	"NOMBRE" VARCHAR2(255 CHAR), 
	"ACTIVO" NUMBER(10,0), 
	 PRIMARY KEY ("ID")
	 );
	 
CREATE TABLE "TEST04"."PEDROMONCADA_USUARIO" 
   (	"ID" NUMBER(19,0) NOT NULL ENABLE, 
	"ACTIVO" NUMBER(10,0), 
	"APELLIDOS" VARCHAR2(255 CHAR), 
	"CLAVE" VARCHAR2(255 CHAR), 
	"CORREO" VARCHAR2(255 CHAR), 
	"ELIMINADO" NUMBER(10,0), 
	"IDENTIFICACION" VARCHAR2(255 CHAR), 
	"INTENTOS_EXITOSOS" NUMBER(10,0), 
	"INTENTOS_FALLIDOS" NUMBER(10,0), 
	"NOMBRES" VARCHAR2(255 CHAR), 
	"ORIGEN_ID" NUMBER(19,0), 
	"USUARIO" VARCHAR2(255 CHAR),
	PRIMARY KEY ("ID")
	 );

CREATE TABLE "TEST04"."PEDROMONCADA_ROL_USUARIO" (	
	"ROL_ID" NUMBER(19,0) NOT NULL ENABLE, 
	"USUARIO_ID" NUMBER(19,0) NOT NULL ENABLE,
	constraint permission_role_ibfk_1 foreign key ("ROL_ID") references "TEST04"."PEDROMONCADA_ROL" ("ID"),
  	constraint permission_role_ibfk_2 foreign key ("USUARIO_ID") references "TEST04"."PEDROMONCADA_USUARIO" ("ID")
);
	 
CREATE TABLE "TEST04"."PEDROMONCADA_MENSAJE" 
   (	"ID" NUMBER(19,0) NOT NULL ENABLE, 
	"ACTIVO" NUMBER(10,0), 
	"DESTINATARIO_ID" NUMBER(10,0), 
	"ELIMINADO" NUMBER(10,0), 
	"FECHA_REGISTRO" TIMESTAMP (6), 
	"LEIDO" NUMBER(10,0), 
	"MENSAJE" VARCHAR2(255 CHAR), 
	"ORIGEN" VARCHAR2(255 CHAR), 
	 PRIMARY KEY ("ID"),
	 constraint MENSAJE_USUARIO_IBFK_1 foreign key ("DESTINATARIO_ID") references "TEST04"."PEDROMONCADA_USUARIO" ("ID")
	 );