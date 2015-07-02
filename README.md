# SugarWood-Supermarket
The very best supermarket itselves in the word.
***************************************
Trabalho 4 - POO 2015
***************************************
Alunos:
Luis Paulo Falchi Justino - 8937479
Rafael Biffi Neto - 8937163

***************************************
Instruções de Compilação:
- Executar o .jar de cliente
- Executar o .jar de servidor
- Inicia-se a aplicação

***************************************
Instruções de Uso:
- Escolha uma das perspectivas (client, manager, supplier)
- Preencha o login com email e senha
- Caso seja autenticado, a tela da perspectiva escolhida irá abrir

Perspectiva de Cliente:
- Escolha o produto que quer comprar dentre as possibilidades da lista, clicando no item
- Clique na seta direcionada ao seu Carrinho de Compras para adiciona-lo ao carrinho (a venda é sempre unitária)
- Caso deseje tirar algo do carrinho, selecione o produto neste e clique na seta direcionada ao estoque do supermercado
- Ao finalizar sua compra, clique no botão "checkout", a venda será realizada e a aplicação voltará à tela de login

Perpestiva de Administrador
- Registre novos produtos ou usuários clicando nos botões indicados na aplicação

Perspectiva de Fornecedor
- Ainda não disponivel, doe no crowdfunding do kickstarter!

***************************************
Design Patterns:
- MVC: Implementação de Abstract Model para persistência de dados. Cada objeto que estende AbstractModel tem a capacidade de fornecer seus dados prontos para o CSVManager guarda-lo em arquivo. Ao CSVManager basta recebê-lo e encaminhá-lo

- Factory: os métodos de persistência e leitura de dados do CSVManager tem a capacidade de receber e gerar objetos dinamicamente, desde que estendam a classe AbstractModel


BUGS E LIMITAÇÕES:
- A aplicação só faz vendas unitárias
- Não há como repopular o estoque de produtos, caso acabe
