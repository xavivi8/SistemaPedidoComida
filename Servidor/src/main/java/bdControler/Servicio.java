package bdControler;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Servicio {
	private static Configuration config = new Configuration();
	private static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	
	public int obtenerRolUsuario(String nombreUsuario, String contraseña) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                // Consulta para obtener el rol del usuario basado en el nombre de usuario y contraseña
                Query<Integer> query = session.createQuery("SELECT u.rol FROM Usuario u WHERE u.usuario = :usuario AND u.pass = :pass", Integer.class);
                query.setParameter("usuario", nombreUsuario);
                query.setParameter("pass", contraseña);
                Integer rol = query.uniqueResult(); // Obtiene el rol de la consulta

                if (rol != null) {
                    // Se encontró el usuario, retornamos su rol
                    transaction.commit();
                    return rol;
                } else {
                    // No se encontró el usuario, retornamos -1
                    transaction.rollback();
                    return -1;
                }
            } catch (Exception e) {
                // Manejo de excepciones
                e.printStackTrace();
                transaction.rollback(); // Revierte la transacción
                return -1;
            }
        }
    }
	
	public static String cogerComida(String nomComida, int cantidad) {
		try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                if (cantidadAdecuada(nomComida, cantidad)) {
                    // Actualiza la cantidad de comida restando la cantidad especificada
                    Query query = session.createQuery("UPDATE Comida SET cantidad = cantidad - :cantidad WHERE nombre = :nombre");
                    query.setParameter("cantidad", cantidad);
                    query.setParameter("nombre", nomComida);
                    int updatedCount = query.executeUpdate(); // Ejecuta la actualización

                    if (updatedCount > 0) {
                        transaction.commit(); // Confirma la transacción
                        return "Comida cogida con éxito";
                    } else {
                        transaction.rollback(); // Revierte la transacción
                        return "Error al actualizar la cantidad de comida";
                    }
                } else {
                    // La cantidad no es adecuada
                    transaction.rollback(); // Revierte la transacción
                    return "No hay suficiente cantidad de comida disponible";
                }
            } catch (Exception e) {
                // Manejo de excepciones
                e.printStackTrace();
                transaction.rollback(); // Revierte la transacción
                return "Error al coger comida";
            }
        }
	}
	
	private static boolean cantidadAdecuada(String nomComida,int cantidad) {
		try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                // Consulta para obtener la cantidad de comida por su nombre
                Query<Integer> query = session.createQuery("SELECT c.cantidad FROM Comida c WHERE c.nombre = :nombre", Integer.class);
                query.setParameter("nombre", nomComida);
                Integer cantidadDisponible = query.uniqueResult(); // Obtiene la cantidad de la consulta

                // Verifica si la cantidad disponible es suficiente
                if (cantidadDisponible != null && cantidadDisponible >= cantidad) {
                    // La cantidad es adecuada
                    transaction.commit(); // Confirma la transacción
                    return true;
                } else {
                    // La cantidad no es adecuada
                    transaction.rollback(); // Revierte la transacción
                    return false;
                }
            } catch (Exception e) {
                // Manejo de excepciones
                e.printStackTrace();
                transaction.rollback(); // Revierte la transacción
                return false;
            }
        }
	}
	
	public static List<Comida> obtenerTodasLasComidas() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                // Consulta para obtener todas las comidas
                Query<Comida> query = session.createQuery("FROM Comida", Comida.class);
                List<Comida> comidas = query.list(); // Obtiene la lista de comidas

                transaction.commit(); // Confirma la transacción
                return comidas;
            } catch (Exception e) {
                // Manejo de excepciones
                e.printStackTrace();
                transaction.rollback(); // Revierte la transacción
                return null; // O maneja el error según lo requieras
            }
        }
    }
	
	public static String rellenarComida(String nomComida, int cantidad) {
	    try (Session session = sessionFactory.openSession()) {
	        Transaction transaction = session.beginTransaction();
	        try {
	            // Consulta para obtener la comida por su nombre
	            Query<Comida> query = session.createQuery("FROM Comida WHERE nombre = :nombre", Comida.class);
	            query.setParameter("nombre", nomComida);
	            Comida comida = query.uniqueResult(); // Obtiene la comida de la consulta

	            if (comida != null) {
	                // Incrementa la cantidad de comida
	                comida.setCantidad(comida.getCantidad() + cantidad);
	                session.update(comida); // Actualiza la comida en la base de datos

	                transaction.commit(); // Confirma la transacción
	                return "Comida rellenada con éxito";
	            } else {
	                // No se encontró la comida
	                transaction.rollback(); // Revierte la transacción
	                return "No se encontró la comida";
	            }
	        } catch (Exception e) {
	            // Manejo de excepciones
	            e.printStackTrace();
	            transaction.rollback(); // Revierte la transacción
	            return "Error al rellenar comida";
	        }
	    }
	}
	
	public static String anyadirComida(String nombreComida) {
	    try (Session session = sessionFactory.openSession()) {
	        Transaction transaction = session.beginTransaction();
	        try {
	            // Verificar si la comida ya existe en la base de datos
	            Query<Comida> query = session.createQuery("FROM Comida WHERE nombre = :nombre", Comida.class);
	            query.setParameter("nombre", nombreComida);
	            Comida existingComida = query.uniqueResult();

	            if (existingComida == null) {
	                // Crear una nueva comida con cantidad 0
	                Comida nuevaComida = new Comida(nombreComida, 0);
	                session.save(nuevaComida); // Guardar la nueva comida en la base de datos
	                transaction.commit(); // Confirmar la transacción
	                return "Comida añadida con éxito";
	            } else {
	                // La comida ya existe en la base de datos
	                transaction.rollback(); // Revertir la transacción
	                return "La comida ya existe en la base de datos";
	            }
	        } catch (Exception e) {
	            // Manejo de excepciones
	            e.printStackTrace();
	            transaction.rollback(); // Revertir la transacción
	            return "Error al añadir comida";
	        }
	    }
	}
	
	public static String eliminarComida(String nombreComida) {
	    try (Session session = sessionFactory.openSession()) {
	        Transaction transaction = session.beginTransaction();
	        try {
	            // Buscar la comida por su nombre
	            Query<Comida> query = session.createQuery("FROM Comida WHERE nombre = :nombre", Comida.class);
	            query.setParameter("nombre", nombreComida);
	            Comida comida = query.uniqueResult();

	            if (comida != null) {
	                session.delete(comida); // Eliminar la comida de la base de datos
	                transaction.commit(); // Confirmar la transacción
	                return "Comida eliminada con éxito";
	            } else {
	                // La comida no existe en la base de datos
	                transaction.rollback(); // Revertir la transacción
	                return "La comida no existe en la base de datos";
	            }
	        } catch (Exception e) {
	            // Manejo de excepciones
	            e.printStackTrace();
	            transaction.rollback(); // Revertir la transacción
	            return "Error al eliminar comida";
	        }
	    }
	}


	
	/*public static boolean checkUsuario(int rol) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                // Consulta para verificar si existe un usuario con el rol especificado
                Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Usuario u WHERE u.rol = :rol", Long.class);
                query.setParameter("rol", rol);
                Long count = query.uniqueResult(); // Obtiene el número de usuarios con el rol especificado

                // Verifica si existe al menos un usuario con el rol especificado
                if (count != null && count > 0) {
                    // Existe al menos un usuario con el rol especificado
                	
                    transaction.commit(); // Confirma la transacción
                    if(count == 1) {
                    	return true;
                    } else {
                    	return false;
                    }
                    
                } else {
                    // No existe ningún usuario con el rol especificado
                    transaction.rollback(); // Revierte la transacción
                    return false;
                }
                
            } catch (Exception e) {
                // Manejo de excepciones
                e.printStackTrace();
                transaction.rollback(); // Revierte la transacción
                return false;
            }
        }
    }*/
}