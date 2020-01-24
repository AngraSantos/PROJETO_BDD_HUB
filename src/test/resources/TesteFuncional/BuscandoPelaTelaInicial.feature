# language: pt

Funcionalidade: Selecionar algum produto disponivel na tela inicial

Contexto:
Dado cliente esta no site de eletronico da AdvantageDEMO

@SelecionouUmProdutoComSucesso
Cenario:
E deve selecionar um produto na tela inicial
E pode escolher um produto
Entao deve printar a tela


@SelecionouUmProdutoComFalha
Cenario:
E deve selecionar um produto na tela inicial que esteja com erro
Entao deve Printar a tela