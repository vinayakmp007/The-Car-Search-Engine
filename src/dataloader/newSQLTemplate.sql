/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  vinayak
 * Created: 5 Jan, 2017
 */
CREATE TABLE CAR_DATA(
CAR_ID INTEGER PRIMARY KEY,
NAME VARCHAR2(100),
BMEP VARCHAR2(50),
CYCLINDERS VARCHAR2(100),
DESIGNERS VARCHAR2(100),
DRIVE_WHEELS VARCHAR2(100),
ENGINE_COOLANT VARCHAR2(100),
ENGINE_LAYOUT VARCHAR2(100),
ENGINE_MAIN VARCHAR2(100),
ENGINE_POS VARCHAR2(100),
ENGINE_TYPE VARCHAR2(100),
FRONT_BRAKE_DIA NUMBER(20,5),
FUEL_SYSTEM VARCHAR2(100),
FUEL_TANK_CAP NUMBER(20,5),
GEARBOX VARCHAR2(100),
GROUND_CLR_IN_MM NUMBER(20,5),
HEAD VARCHAR2(100),
HEIGHT_IN_MM NUMBER(20,5),
IMAGE_ID INTEGER,
IMAGE_Y_N VARCHAR2(10),
LENGHT_IN_MM NUMBER(10,5),
MAN_NAME VARCHAR2(100),
MAX_SPEED NUMBER(20,5),
MILEAGE NUMBER(20,5),
MILEAGES VARCHAR2(100),
MODEL_NAME VARCHAR2(100),
NOD INTEGER,
REAR_BRAKE_DIA NUMBER(20,5),
STEERING VARCHAR2(100),
TYRES_FRONT VARCHAR2(100),
TYRES_REAR VARCHAR2(100),
WEIGHT_IN_KG NUMBER(20,5).
WHEELBASE_IN_MM NUMBER(20,5),
WIDTH_IN_MM NUMBER(20,5),
YEAR INTEGER);


CREATE SEQUENCE CAR_ID_GEN_SEQ 
  START WITH 10000 
  INCREMENT BY 1;

CREATE OR REPLACE TRIGGER CAR_GEN_TRIG
BEFORE INSERT ON CAR_DATA
FOR EACH ROW
DECLARE
BEGIN
IF (:NEW.CAR_ID IS NULL)
THEN :NEW.CAR_ID =CAR_ID_GEN_SEQ.NEXTVAL;
END IF;
END;