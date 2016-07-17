cc8-lab1
===================

Simple TCP and UDP cli applications.

----------

Questions
-------------

 - **Desde la perspectiva del programador, ¿Qué diferencias existen entre usar Sockets TCP y Sockets UDP?**
 
 La forma de entregar los paquetes principalmente; mientras que uno se preocupa en entregar cada uno de los paquetes enviados por el emisor, el otro (UDP) simplemente cumple con la tarea de enviar un datagrama sin verificar si este fue entregado correctamente.

 - **¿Qué hace el método Accept de un TCP ServerSocket?**

Aceptar el intento de conexión de un cliente hacia la aplicación del servidor. Al aceptarlo se crea un Socket el cuál representa la conexión.

----------
Galileo University
Computer Science 2016

