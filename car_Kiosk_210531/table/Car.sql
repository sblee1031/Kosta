BEGIN TRANSACTION;
DROP TABLE IF EXISTS "Car";
CREATE TABLE IF NOT EXISTS "Car" (
	"car_Name"	TEXT,
	"car_Num"	TEXT,
	"isKey"	boolean,
	"car_Url"	varchar(50),
	"size"	varchar(50)
);
INSERT INTO "Car" VALUES ('엑센트','123허 1001',0,'./img/car_Img/hd_Accent.png','small');
INSERT INTO "Car" VALUES ('엑센트','123허 1002',0,'./img/car_Img/hd_Accent.png','small');
INSERT INTO "Car" VALUES ('엑센트','123허 1003',1,'./img/car_Img/hd_Accent.png','small');
INSERT INTO "Car" VALUES ('아반떼','123허 1004',1,'./img/car_Img/hd_Abante.png','medium');
INSERT INTO "Car" VALUES ('소나타','123허 1005',0,'./img/car_Img/hd_Sonata.png','medium');
INSERT INTO "Car" VALUES ('소나타','123허 1006',0,'./img/car_Img/hd_Sonata.png','medium');
INSERT INTO "Car" VALUES ('소나타','123허 1007',1,'./img/car_Img/hd_Sonata.png','medium');
INSERT INTO "Car" VALUES ('소나타','123허 1008',1,'./img/car_Img/hd_Sonata.png','medium');
INSERT INTO "Car" VALUES ('그랜저','123허 1009',1,'./img/car_Img/hd_Grandeur.png','large');
INSERT INTO "Car" VALUES ('투싼','123허 1010',1,'./img/car_Img/hd_Tucson.png','suv');
INSERT INTO "Car" VALUES ('투싼','123허 1011',1,'./img/car_Img/hd_Tucson.png','suv');
INSERT INTO "Car" VALUES ('펠리세이드','123허 1012',0,'./img/car_Img/hd_Palisade.png','suv');
INSERT INTO "Car" VALUES ('펠리세이드','123허 1013',1,'./img/car_Img/hd_Palisade.png','suv');
INSERT INTO "Car" VALUES ('펠리세이드','123허 1014',1,'./img/car_Img/hd_Palisade.png','suv');
INSERT INTO "Car" VALUES ('모닝','234하 2001',0,'./img/car_Img/kia_Morning.png','small');
INSERT INTO "Car" VALUES ('모닝','234하 2002',1,'./img/car_Img/kia_Morning.png','small');
INSERT INTO "Car" VALUES ('모닝','234하 2003',1,'./img/car_Img/kia_Morning.png','small');
INSERT INTO "Car" VALUES ('모닝','234하 2004',1,'./img/car_Img/kia_Morning.png','small');
INSERT INTO "Car" VALUES ('모닝','234하 2005',1,'./img/car_Img/kia_Morning.png','small');
INSERT INTO "Car" VALUES ('K3','234하 2006',0,'./img/car_Img/kia_K3.png','medium');
INSERT INTO "Car" VALUES ('K3','234하 2007',1,'./img/car_Img/kia_K3.png','medium');
INSERT INTO "Car" VALUES ('K3','234하 2008',1,'./img/car_Img/kia_K3.png','medium');
INSERT INTO "Car" VALUES ('K3','234하 2009',1,'./img/car_Img/kia_K3.png','medium');
INSERT INTO "Car" VALUES ('K5','234하 2010',0,'./img/car_Img/kia_K5.png','medium');
INSERT INTO "Car" VALUES ('K7','234하 2011',0,'./img/car_Img/kia_K7.png','large');
INSERT INTO "Car" VALUES ('K9','234하 2012',1,'./img/car_Img/kia_K9.png','large');
INSERT INTO "Car" VALUES ('K9','234하 2013',1,'./img/car_Img/kia_K9.png','large');
INSERT INTO "Car" VALUES ('쏘렌토','234하 2014',0,'./img/car_Img/kia_Sorento.png','suv');
INSERT INTO "Car" VALUES ('쏘렌토','234하 2015',1,'./img/car_Img/kia_Sorento.png','suv');
INSERT INTO "Car" VALUES ('쏘렌토','234하 2016',1,'./img/car_Img/kia_Sorento.png','suv');
COMMIT;
