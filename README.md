
Descrição do Projeto: Aplicativo Java para Consulta de Produtos em banco de dados

Objetivo:
Desenvolver um aplicativo Java completo que demonstre a interação entre um cliente e um servidor via console para consulta de informações de produtos de vestuário. O aplicativo utiliza sockets TCP para comunicação e armazena os dados dos produtos em uma tabela no banco de dados Oracle FIAP.

Funcionalidades:
O cliente solicita informações de um produto específico pelo seu ID.
O servidor busca o produto no banco de dados e retorna as informações completas (ID, nome, preço, validade, tamanho e descrição) para o cliente.
O cliente exibe as informações do produto na tela do console.

Requisitos:
Linguagem: Java
IDE: IntelliJ
Banco de dados: Oracle FIAP
Ferramenta: SQL Developer
Tipo de projeto: Maven
Comunicação: Sockets TCP

Classes:
Cliente: responsável por solicitar informações do produto ao servidor e exibir as informações na tela.
Servidor: responsável por receber a solicitação do cliente, buscar o produto no banco de dados e enviar as informações de volta.
Produto: representa um produto de vestuário com seus atributos (ID, nome, preço, validade, tamanho e descrição).

Banco de dados:
Tabela: TDS_TB_ProdutoCS
Colunas:
ID (Número)
nome (Texto)
preco (Número)
validade (Data)
tamanho (Número)
descricao (Texto)
Arquivo persistence.xml:
Define a configuração básica para conexão com o banco de dados Oracle FIAP.

Exemplo de uso:

O cliente digita o ID do produto desejado no console.
O cliente envia a solicitação para o servidor.
O servidor busca o produto no banco de dados.
O servidor envia as informações do produto para o cliente.
O cliente exibe as informações do produto na tela do console.
Observações:


Benefícios:
Demonstra a comunicação cliente-servidor em Java.
Integra o uso de sockets TCP para transferência de dados.
Apresenta a interação com o banco de dados Oracle FIAP.
Fornece um exemplo prático de consulta de informações de produtos.

Aplicações:
Sistemas de vendas online.
Estoques e controle de produtos.
Catálogos de produtos.
Consultas de preços e disponibilidade.



