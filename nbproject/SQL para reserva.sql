

--funcao para controlar as reservas. Não deve haver mais de uma reserva para a sala no mesmo dia

create or replace function verifica_reservas() returns "trigger" as

$BODY$


declare 

datas date;
idsala integer;

pega_dados cursor for
SELECT data_reserva, id_sala
  FROM reservas;

begin

open pega_dados;
loop
fetch pega_dados into datas, idsala;
if(new.id_sala = idsala and new.data_reserva = datas) then

raise exception 'A sala já tem reserva';

end if;
exit when not found;
end loop;

return new;
end;

$BODY$

language 'plpgsql';

--drop trigger conferir_existencia on reservas
--drop function verifica_reservas()
create trigger conferir_existencia before insert on reservas
for each row execute procedure verifica_reservas();