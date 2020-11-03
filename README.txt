###### INSTRUCCIONES PARA ARRANCAR EL PROYECTO

#Prerequisitos

#- Instalar la base de datos MariaDB, yo utilice la versión: mariadb-10.0.10-winx64.
#- Para el gestor de la base utilicé HeidiSQL. (Si desea ver la data desde un gestor, aunque en la app se ve en las tablas)
#- Para el IDE usted puede usar Eclipse o STS, yo utilice STS.

#Cuando instale el MariaDB asigne al usuario root el password (sin comillas) "jdml1989", es el que yo tengo configurado en la app.

#username: root
#password: jdml1989

#Desde el gestor de DB o desde donde usted considere, cree una base de datos llamada "todo1" (sin comillas). 
#Le dejo esta cadena de conexion como referencia.
#No es necesario crear las tablas. La app las levanta al arrancar.

#url: jdbc:mariadb://localhost:3306/todo1?useSSL=false

#El flujo para usar la app seria el siguiente:

#1. Arrancar como Springboot App.
#2. ingresar al enlace: "localhost:8080/ o localhost:8080/login

#En esta pagina puedes encontrar las siguientes funcionalidades:

#- Registro de administrador, registro de cliente, restablecer contraseña y el login.

#Primero debe crear el administrador, es quien gestiona las categorias y los productos, estas opciones las encuentras en el menú principal 
#a la izquierda de la pantalla.

#En la parte superior derecha, donde aparece el nombre de usuario puedes encontrar las opciones de cambio de contraseña y cierre de sesión.

#- Luego de registrar el administrador, y antes o después de gestionar las categorias y los productos, puedes crear el cliente.

#Al iniciar sesion encontraras una pantalla con el saldo del cliente y las categorias creadas. 

#Para ingresar a una categoria para comprar un producto, das click sobre el enlace dentro del recuadro. Se listaran los productos, también con su información, al igual que en las categorias.

#En el Menú puedes encontrar los movimientos que son las compras que se realizaron.

#Comparto el siguiente enlace donde hay un video corto usando la app.

#https://drive.google.com/file/d/13clHJxTlxEbB63vMlbHRqzsd6ebH9ing/view?usp=sharing
