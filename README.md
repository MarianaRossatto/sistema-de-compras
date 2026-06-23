## 💳 Controle de Compras no Cartão de Crédito

Projeto desenvolvido como desafio final do curso Java: trabalhando com listas e coleções de dados, da Alura. A aplicação simula o registro de compras realizadas com um cartão de crédito pelo terminal. O usuário informa o limite disponível e pode cadastrar compras com descrição e valor, desde que haja saldo suficiente no cartão. Ao finalizar, o sistema exibe o saldo restante e a lista de compras realizadas, ordenada pelo valor.

### ▸ Funcionalidades

* Definição do limite inicial do cartão de crédito
* Cadastro de compras com descrição e valor
* Validação de saldo disponível antes de registrar uma compra
* Registro das compras aprovadas em uma lista
* Possibilidade de cadastrar várias compras durante a execução
* Exibição do saldo final do cartão
* Ordenação das compras pelo valor

### ▸ Estrutura do projeto

* `Compra` - representa uma compra, armazenando sua descrição e valor;
* `CartaoCredito` - representa o cartão, incluindo limite, saldo disponível e a lista de compras registradas;
* `Main` - contém a execução do programa, interação com o usuário e controle do menu.
