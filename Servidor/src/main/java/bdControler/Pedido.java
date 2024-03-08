package bdControler;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * La clase Pedido representa un pedido en el sistema.
 */
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private int idPedido;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "comida")
    private String comida;

    @Column(name = "cantidad")
    private int cantidad;

    /**
     * Constructor predeterminado de Pedido.
     */
    public Pedido() {
    }

    /**
     * Constructor de Pedido con parámetros.
     * 
     * @param usuario  El usuario que realizó el pedido.
     * @param comida   La comida solicitada.
     * @param cantidad La cantidad de la comida solicitada.
     */
    public Pedido(String usuario, String comida, int cantidad) {
        this.usuario = usuario;
        this.comida = comida;
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el ID del pedido.
     * 
     * @return El ID del pedido.
     */
    public int getIdPedido() {
        return idPedido;
    }

    /**
     * Establece el ID del pedido.
     * 
     * @param idPedido El ID del pedido a establecer.
     */
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * Obtiene el usuario que realizó el pedido.
     * 
     * @return El usuario que realizó el pedido.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario que realizó el pedido.
     * 
     * @param usuario El usuario que realizó el pedido a establecer.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la comida solicitada en el pedido.
     * 
     * @return La comida solicitada en el pedido.
     */
    public String getComida() {
        return comida;
    }

    /**
     * Establece la comida solicitada en el pedido.
     * 
     * @param comida La comida solicitada en el pedido a establecer.
     */
    public void setComida(String comida) {
        this.comida = comida;
    }

    /**
     * Obtiene la cantidad de comida solicitada en el pedido.
     * 
     * @return La cantidad de comida solicitada en el pedido.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de comida solicitada en el pedido.
     * 
     * @param cantidad La cantidad de comida solicitada en el pedido a establecer.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
