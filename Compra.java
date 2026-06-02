public class Compra implements Comparable<Compra> {
    private String descricao;
    private double valor;

    public Compra(String nome, double valor) {
        this.descricao = nome;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return descricao + " - R$" + String.format("%.2f", valor);
    }

    @Override
    public int compareTo(Compra outraCompra) {
        return Double.compare(this.valor, outraCompra.getValor());
    }
}