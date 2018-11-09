CREATE SEQUENCE SEQ_FizetesMod INCREMENT BY 1 START WITH 1000 NOCACHE NOCYCLE;

CREATE OR REPLACE PROCEDURE FizetesModLetrehozasa (p_mod IN nvarchar2, p_hatarido IN int, CurrentId OUT NUMBER) AS
BEGIN
insert into FizetesMod(id, mod, hatarido) values(SEQ_FizetesMod.nextval, p_mod, p_hatarido);
select SEQ_FizetesMod.currval INTO CurrentId FROM DUAL;
COMMIT;
END;