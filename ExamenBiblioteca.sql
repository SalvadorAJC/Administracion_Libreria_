create database Biblioteca

use Biblioteca

create table usuariosacceso
(
Id varchar (30),
Nombre varchar(30),
Contraseña varchar(30),
)

insert into usuariosacceso values ('1','root','1234')

create table libro
(
nombre varchar(30),
autor varchar(30),
tipo varchar(10),
añop int,
fechar varchar (30),
reparaciones int,
numprestado int,
tema varchar(30)
)

create table tiposlibro(
tipo varchar (10)
)

create table usuario(
Nombre varchar(30),
id varchar(30),
estado varchar(30)
)

create table prestamos(
id int identity (1,1),
nomdrep varchar(30),
fecha varchar(30),
libro varchar(30),
tipo varchar (10),
estado varchar(30)
)

create table idU(
id varchar(30) 
)

create proc ingresarLi(
@nombre varchar(30),
@autor varchar(30),
@tipo varchar(10),
@añop int,
@fechar varchar (30),
@reparaciones int,
@numprestado int,
@tema varchar(30)
)

as begin
insert into libro values (@nombre,@autor,@tipo,@añop,@fechar,@reparaciones,@numprestado,@tema)
end

create proc modificarLi(
@nombre varchar(30),
@autor varchar(30),
@tipo varchar(10),
@añop int,
@fechar varchar (30),
@reparaciones int,
@numprestado int,
@tema varchar(30)
)
as begin
Update libro set numprestado=@numprestado where @nombre=@nombre 
end

-------------------------------------------------------------------------------------------------------------------
create proc ingresarUs(
@nomdre varchar(30),
@id varchar(30),
@estado varchar(30)
)
as begin
insert into usuario values (@nomdre,@id,@estado)
end

create proc modificarUs(
@nombre varchar(30),
@id varchar(30),
@estado varchar(30)
)
as begin
Update usuario set estado=@estado where nombre=@nombre
end

create trigger id
on usuario
After insert
as
begin
declare @id varchar(30)
select @id =[id]
from inserted
insert into idU values (@id)
end
drop table libro
------------------------------------------------------------------------------
create proc ingresarP(
@nomdrep varchar(30),
@fecha varchar(30),
@libro varchar(30),
@tipo varchar (10),
@estado varchar(30)
)
as begin
insert into prestamos values (@nomdrep,@fecha,@libro,@tipo,@estado)
end

create proc eliminarP(
@nomdrep varchar(30),
@estado varchar(30)
)
as begin
delete from prestamos where nomdrep=@nomdrep and estado=@estado
end

