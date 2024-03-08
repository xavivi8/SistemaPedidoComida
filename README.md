# Repositorio Maven para Gestión de Comidas

Este repositorio contiene dos proyectos Maven diseñados para gestionar la información relacionada con comidas. El primero es un **Servidor Java** destinado a proporcionar servicios para realizar operaciones como añadir, eliminar y actualizar información sobre comidas, así como también para realizar pedidos. El segundo proyecto es un **Cliente Java** que interactúa con el servidor remoto para enviar mensajes y recibir respuestas.

## Proyecto Servidor Java

El proyecto de Servidor Java está diseñado para gestionar una base de datos de comidas. Utiliza Hibernate como framework de mapeo objeto-relacional para interactuar con una base de datos MySQL. Al iniciar, el servidor espera conexiones entrantes de los clientes y procesa las solicitudes según la lógica de negocio implementada.

### Funcionalidades Destacadas:

- Gestión de comidas: Añadir, eliminar y actualizar información sobre comidas.
- Gestión de pedidos: Realizar pedidos y gestionarlos en la base de datos.

### Estructura del Proyecto:

El proyecto se organiza en varios paquetes y clases:

- **Paquete `servidor`**: Contiene las clases principales para iniciar y gestionar el servidor, así como la comunicación con los clientes.
- **Paquete `bdControler`**: Proporciona servicios para interactuar con la base de datos de comidas.
- **Paquete `seguridad`**: Contiene configuraciones de seguridad, incluyendo la creación de un contexto SSL y la configuración de certificados.
- **Paquete `logger`**: Gestiona la escritura de registros en el archivo `log.txt`.

### Dependencias:

El proyecto utiliza las siguientes dependencias gestionadas mediante Maven:

- Hibernate: Framework de mapeo objeto-relacional.
- MySQL Connector: Conector JDBC para la base de datos MySQL.
- log4j: Biblioteca para la generación de registros.

## Proyecto Cliente Java

El proyecto Cliente Java proporciona funcionalidades para establecer una conexión con el servidor remoto, enviar mensajes y recibir respuestas. Está diseñado para interactuar con el servidor de gestión de comidas.

### Funcionalidades Destacadas:

- Establecer conexión con el servidor.
- Enviar y recibir mensajes para interactuar con el servidor de gestión de comidas.

### Estructura del Proyecto:

El proyecto se organiza en varios paquetes y clases:

- **Paquete `cliente`**: Contiene la clase principal que ejecuta la aplicación del cliente y gestiona la conexión con el servidor.
- **Paquete `Seguridad`**: Contiene funciones para la seguridad, como la encriptación de contraseñas utilizando el algoritmo de hash MD5.

### Dependencias:

El proyecto utiliza la siguiente dependencia gestionada mediante Maven:

- `mysql-connector-java`: Versión 8.0.23, para la conexión con bases de datos MySQL.

## Base de Datos

El repositorio incluye un archivo `comidas.db.sql` que contiene el esquema de la base de datos utilizado por el servidor y la definición de las tablas relacionadas con las comidas, usuarios y pedidos.

Este repositorio proporciona una solución completa para la gestión de información relacionada con comidas, desde el servidor que ofrece servicios para interactuar con la base de datos hasta el cliente que permite la interacción con el servidor remoto.
