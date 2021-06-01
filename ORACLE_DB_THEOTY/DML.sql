
CREATE TABLE t1(
 a varchar2(5),
 b number(3,1),
 c DATE
);

CREATE TABLE dept_temp
AS SELECT * FROM dept WHERE 0<>1;

--p268
INSERT INTO dept_temp(deptno)
	VALUES ('50'); --문자 '50'가 숫자형으로 자동형변환됨
INSERT INTO dept_temp(deptno)
	VALUES ('ABC');--오류 발생

UPDATE employees
SET employee_id = 1 --PK값을 변경하는 권장하지 않으므로 가능한 지양한다.
WHERE employee_id = 100;

---------------------------------------
트랜잭션.sql
트랜잭션이란 일처리작업단위이다
ex)계좌이체(A계좌에서 금액이 출금된, B계좌로 금액이 입금)
l<- 트랜잭션 시작
	A계좌에서 금액이 출금
		B계좌로 금액이 입금
			트랜잭션 종료-->
			(작업성공 : 완료-commit,
			(작업실패 : 원상태로 복구-rollback)

DDL (CREATE, ALTER, DROP) : 자동완료(트랜잭션시작, DDL구문처리, commit)
DML (INSERT, UPDATE, DELETE) : 자동완료안됨(트랜젝션시작,DML구문 처리);

CREATE TABLE account(no varchar2(3) primary key, balance number(5));
--트랜잭션 시작
INSERT INTO account(no, balance) values ('100',1000);
INSERT INTO account(no, balance) values ('200',1000);
SELECT * FROM account;
--트랜잭션 완료
commit;
-----------------------------------------------------
--트랜잭션 시작(100번 계좌에서 200번계쫘로 10원 이체)
UPDATE account SET balance = balance-10 where no='100';
UPDATE account SET balance = balance+10 where no='200';
--트랜잭션 완료
commit;
------------------------------------------------------
SELECT * FROM account;
--트랜잭션 시작(100번 계좌에서 900번계좌로 10원 이체)
UPDATE account SET balance = balance-10 where no='100';
UPDATE account SET balance = balance+10 where no='900';
--트랜잭션 복부
rollback;

---------
UPDATE-1
INSERT-2
INSERT-3
DELETE-4
UPDATE-5
commit(1,2,3,4,5모두 처리됨)

--세션1                     세션2
UPDATE-1
INSERT-2
rollback(1,2취소)
INSERT-3
delete-4
commit(3,4처리)
UPDATE-5
DELETE from account-6
where no = '101';
                            DELETE FROM account 
                            WHERE no = '100'; --DEAD LOCK(지연)됨
                            rollback;
                            

