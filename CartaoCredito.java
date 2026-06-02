import java.util.ArrayList;
import java.util.List;

public class CartaoCredito {
    private double limite;
    private double saldo;
    private List<Compra> listaCompras;

    public CartaoCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.listaCompras = new ArrayList<>();
    }

    public boolean efetuarCompra(Compra compra){
        if (compra.getValor() <= this.saldo){
            this.saldo -= compra.getValor();
            this.listaCompras.add(compra);
            return true;
        } 
    
        return false;  
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }
}