import java.util.Collections;
import java.util.Scanner;

public class Main {

    private static final String LINHA_DUPLA = "===============================";
    private static final String LINHA = "-------------------------------";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mostrarCabecalho("SISTEMA DE COMPRAS");

        CartaoCredito cartao = criarCartao(scanner);

        boolean continuar = true;

        while (continuar) {

            Compra compra = lerCompra(scanner);

            if (cartao.efetuarCompra(compra)) {
                mostrarCompraEfetuada();
                continuar = perguntarContinuar(scanner);
                System.out.println("\n" + LINHA);
            } else {
                mostrarSaldoInsuficiente();
                continuar = false;
            }
        }

        mostrarExtrato(cartao);

        scanner.close();
    }

    private static CartaoCredito criarCartao(Scanner scanner) {
        System.out.println("Digite o limite do cartão:");
        double limite = scanner.nextDouble();

        System.out.println("\n" + LINHA);

        return new CartaoCredito(limite);
    }

    private static Compra lerCompra(Scanner scanner) {
        System.out.println("\nDigite a descrição da compra:");
        String descricao = scanner.next();

        System.out.println("\nDigite o valor da compra:");
        double valor = scanner.nextDouble();

        return new Compra(descricao, valor);
    }

    private static void mostrarCompraEfetuada() {
        System.out.println("\n" + LINHA);
        System.out.println("Compra efetuada!");
        System.out.println(LINHA + "\n");
    }

    private static void mostrarSaldoInsuficiente() {
        System.out.println("\n" + LINHA);
        System.out.println("Saldo insuficiente!");
        System.out.println(LINHA + "\n");
    }

    private static void mostrarCabecalho(String titulo) {
        System.out.println(LINHA_DUPLA);
        System.out.printf("       %s%n", titulo);
        System.out.println(LINHA_DUPLA);
        System.out.println();
    }

    private static boolean perguntarContinuar(Scanner scanner) {
        System.out.println("Deseja continuar?");
        System.out.println("[1] Sim   [0] Não");

        return scanner.nextInt() == 1;
    }

    private static void mostrarExtrato(CartaoCredito cartao) {
        mostrarCabecalho("EXTRATO DO CARTÃO");

        Collections.sort(cartao.getListaCompras());
        for (Compra compra : cartao.getListaCompras()) {
            System.out.printf("%-19s R$ %.2f%n", compra.getDescricao(), compra.getValor());
        }

        System.out.println("\n" + LINHA);
        System.out.printf("%n%-19s R$ %.2f%n", "Limite inicial", cartao.getLimite());

        System.out.printf("%-19s R$ %.2f%n", "Saldo atual", cartao.getSaldo());

        double totalGasto = cartao.getLimite() - cartao.getSaldo();
        System.out.printf("%-19s R$ %.2f%n", "Total gasto", totalGasto);
        System.out.println("\n" + LINHA_DUPLA);
    }
}