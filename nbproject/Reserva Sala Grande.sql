--Quando a sala 1(que é a sala unida com as demais salas) é reservada, automaticamente as outras salas serão reservadas para o mesmo id
create or replace function reserva_sala_grande() returns "trigger" as

$BODY$
begin
if(new.id_sala = 23)then

INSERT INTO reservas (data_reserva, id_sala, funcionario, descricao)
VALUES(new.data_reserva, 25, new.funcionario, new.descricao);

end if;

return new;

end;

$BODY$

language 'plpgsql';

--drop function reserva_sala_grande()
--drop trigger reserva_todas_salagrande on reservas

create trigger reserva_todas_salagrande BEFORE INSERT on reservas
   for each row execute procedure reserva_sala_grande();