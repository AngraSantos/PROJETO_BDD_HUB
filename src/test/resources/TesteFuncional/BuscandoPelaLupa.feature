# language: pt

Funcionalidade: Buscar produto pela lupa

Contexto: 
Dado cliente esta no site de eletronico da AdvantageDEMO

@BuscaPelaLupaComSucesso
Cenario:  
E na lupa escreva o nome do item desejado
E produto encontrado clique nele
Entao ele ira tirar um print

@BuscaPelaLupaComFalha
Cenario:
E na lupa escreva o nome do produto desejado que nao tenha no site
Entao ele ira tirar um Print 