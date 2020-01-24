# language: pt

Funcionalidade: Cadastro de cliente

Contexto:
Dado cliente esta no site de eletronicos da AdvantageDEMO
E clicar no icone do login 
E depois clicar em criar novo usuario

@cadastroValido
Cenario: 
E preenche o usuario
E preenche o email
E preenche a senha
E confirma a senha 
E preenche o primeiro nome
E preenche o ultimo nome
E preenche o telefone
E seleciona o pais
E preenche a cidade
E preenche o endereco
E preenche o estado
E preenche o codigo Postal
Quando confirma que esta de acordo com os termos de uso do site
E cliente tera seu cadastro efetuado com sucesso
Entao tira um print da ela

@cadastroInvalido
Cenario: 
E preenche o usuario
E preenche o email
E preenche a senha
E confirma a senha 
E preenche o primeiro nome
E preenche o ultimo nome
E preenche o telefone
E seleciona o pais
E preenche a cidade
E preenche o endereco
E preenche o estado
E preenche o codigo Postal
Quando confirma que esta de acordo com os termos de uso do site
E cliente nao consegue se concluir cadastro
Entao tira um Print da tela
