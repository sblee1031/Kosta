BEGIN TRANSACTION;
DROP TABLE IF EXISTS "Charge";
CREATE TABLE IF NOT EXISTS "Charge" (
	"car_Size"	TEXT,
	"ten_Min"	INTEGER,
	"one_Hour"	INTEGER,
	"three_Hour"	INTEGER,
	"six_Hour"	INTEGER,
	"one_Day"	INTEGER,
	"three_Day"	INTEGER
);

INSERT INTO "charge" VALUES ('small',370,2100,5800,11200,28500,81200);
INSERT INTO "charge" VALUES ('medium',650,3900,11700,23400,93600,280800);
INSERT INTO "charge" VALUES ('large',1000,6000,18000,36000,144000,432000);
INSERT INTO "charge" VALUES ('suv',1050,6300,18900,37800,151200,453600);
COMMIT;