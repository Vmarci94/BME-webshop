-- A rendszer lassú működése miatt szükséges a megrendelés táblába felvenni egy új oszlopot,
-- mely a megrendeléstételekből számítható végösszeget tartalmazza. 
-- Készítsd el a szükséges módosításokat végrehajtó SQL szkriptet Oracle szerveren, 
-- valamint a folyamatos karbantartáshoz szükséges triggereket!

-- + kiegészítettem egy procedure-val, amivel újra lehet számítani az összes végösszeget.


alter table Megrendeles
  add vegosszeg float;

create or replace procedure calcAllVegosszegTrigger is
  vegosszeg_ float default 0;
  begin
    for megrendelesID_rec in (select m.ID from MEGRENDELES m)
    loop
      for megrendelesTetel_rec in (select mt.NETTOAR, mt.MENNYISEG
                                   from MEGRENDELESTETEL mt
                                   where mt.megrendelesID = megrendelesID_rec.ID)
      loop
        vegosszeg_ := vegosszeg_ + (megrendelesTetel_rec.MENNYISEG * megrendelesTetel_rec.NETTOAR);
      end loop;
      update MEGRENDELES m set m.vegosszeg = vegosszeg_ where m.id = megrendelesID_rec.ID;
      vegosszeg_ := 0; -- reset az új sorhoz
    end loop;
  end;

begin
  calcAllVegosszegTrigger();
end;

create or replace trigger VegosszegKarbantartTrigger
  after
  insert or update or delete
  on MegrendelesTetel
  for each row
  declare
    -- nem kell tagváltozó
  begin
    update MEGRENDELES
    set MEGRENDELES.vegosszeg = MEGRENDELES.vegosszeg + nvl(:new.NettoAr * :new.Mennyiseg, 0)
                                -- az eddigi összeg + az új termék(ek) ára, delete esetén nullát adsz hozzá
                                  -
                                nvl(:old.NettoAr * :old.Mennyiseg, 0) -- de ha update volt akkor le kell vonni a régi árát. Insert esetén ez nulla. delete esetén is le kell vonni
    where MEGRENDELES.id = nvl(:old.megrendelesid, :new.megrendelesid);
  end VegosszegKarbantartTrigger;

insert into MEGRENDELESTETEL
VALUES (17, 2, 2000, 2, 10, 5);
