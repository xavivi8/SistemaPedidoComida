package servidor;

public class MainServidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conexion conexion = new Conexion();
		
		try {

			conexion.conexion();

		} catch (Exception e) {

			System.out.println(e);
			// TODO: handle exception
		}
	}

}
