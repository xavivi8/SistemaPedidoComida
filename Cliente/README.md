# Cliente Java para Interacción con Servidor

Este proyecto consiste en un cliente Java diseñado para interactuar con un servidor remoto. Proporciona funcionalidades para establecer una conexión con el servidor, enviar mensajes y recibir respuestas.

## Estructura del Proyecto

El proyecto se organiza en los siguientes paquetes y clases:

- **Paquete `cliente`**:
  - `MainCliente.java`: Clase principal que contiene el método `main()` para ejecutar la aplicación del cliente.
  - `Conexion.java`: Clase que gestiona la conexión del cliente con el servidor.
  - `Funciones.java`: Clase que proporciona funciones comunes para manipular cadenas.

- **Paquete `Seguridad`**:
  - `Seguridad.java`: Clase que contiene funciones para la seguridad, como la encriptación de contraseñas utilizando el algoritmo de hash MD5.

## Dependencias

El proyecto utiliza Maven para la gestión de dependencias. Actualmente, tiene la siguiente dependencia:

- `mysql-connector-java`: Versión 8.0.23, para la conexión con bases de datos MySQL.

