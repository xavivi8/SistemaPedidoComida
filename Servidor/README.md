# Servidor Java para Gestión de Comidas

Este servidor Java está diseñado para gestionar una base de datos de comidas, proporcionando servicios para realizar operaciones como añadir, eliminar y actualizar información sobre comidas, así como también para realizar pedidos.

## Funcionamiento

El servidor se encarga de recibir solicitudes de clientes y procesarlas según la lógica de negocio implementada. Utiliza Hibernate como framework de mapeo objeto-relacional para interactuar con la base de datos MySQL.

Al iniciar, el servidor espera conexiones entrantes de los clientes. Una vez que se establece una conexión, el servidor procesa las solicitudes del cliente y envía las respuestas correspondientes.

## Estructura del Proyecto

El proyecto se organiza en los siguientes paquetes y clases:

- **Paquete `servidor`**:
  - `MainServidor.java`: Clase principal que inicia el servidor y gestiona las conexiones entrantes de los clientes.
  - `Conexion.java`: Clase que gestiona la conexión del servidor con los clientes.
  - `Funciones.java`: Clase que proporciona funciones auxiliares para el servidor.
  - `Hilo.java`: Clase que gestiona la comunicación con un cliente a través de un hilo de ejecución.

- **Paquete `bdControler`**:
  - `Servicio.java`: Clase principal que proporciona servicios para interactuar con la base de datos de comidas. Contiene métodos para obtener el rol del usuario, gestionar pedidos y realizar operaciones sobre las comidas.
  - `Usuario.java`: Clase que representa un usuario en la base de datos.
  - `Pedido.java`: Clase que representa un pedido en el sistema.
  - `Comida.java`: Clase que representa la entidad de comida en la base de datos.

- **Paquete `seguridad`**:
  - `Seguridad.java`: Clase que proporciona configuraciones de seguridad para el servidor, incluyendo la creación de un contexto SSL y la configuración de certificados.

- **Paquete `logger`**:
  - `Log.java`: Clase que gestiona la escritura de registros en el archivo log.txt, registrando las conexiones entrantes al servidor (Aun no implementado).

- **Archivo `log.txt`**: Registro de las conexiones entrantes al servidor, incluyendo la dirección IP y, en algunos casos, el usuario asociado a la conexión.

## Dependencias

El proyecto utiliza las siguientes dependencias:

- **Hibernate**: Framework de mapeo objeto-relacional para interactuar con la base de datos.
- **MySQL Connector**: Conector JDBC para la base de datos MySQL.
- **log4j**: Biblioteca para la generación de registros.

Estas dependencias están gestionadas mediante Maven y se encuentran detalladas en el archivo `pom.xml`.
