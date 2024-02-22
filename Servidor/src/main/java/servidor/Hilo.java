package servidor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.net.Socket;

public class Hilo extends Thread{
	private static Configuration config = new Configuration();
	private static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	private Socket clienteSocket;
	
	public Hilo(Socket socket) {
		this.clienteSocket = socket;
	}
	
	public void run() {
		
	}
	
	private static String cogerComida(String nomComida, int cantidad) {
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
	
	private static boolean checkUsuario(int rol) {
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
                    return true;
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
    }
}
