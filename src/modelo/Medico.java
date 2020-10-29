

package modelo;



public class Medico {
    int precio;
    private int cantidad;
    
    double Total(){
        return precio*cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
