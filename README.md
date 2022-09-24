# Desafio projeto Reactor

Para começarmos a nos habituar com programação reativa criamos esse projeto com 3 desafios para serem solucionados utilizando o Project Reactor, cada desafio está localizado em uma classe diferente e cada classe tem testes unitários para ficar fácil de acompanhar se seu código está no caminho certo, os desafios são os seguintes:

 * **Question 1**: Recebe uma lista de longs, incrementa 1 nos valores e retorna um flux dos resultados;

 * **Question 2**: Recebe uma lista de usuários e retorna a quantos usuários admin tem na lista;

 * **Question 3**: Verifica se o usuário passado é valido, caso seja retorna void, caso contrário deve disparar uma exception
    (para esse desafio vamos considerar que o usário é valido quando ele tem uma senha com mais de 8 caractéres).

Para fazer a verificação usando os testes rode o comando *gradle test* ( considerando que você tenha o gradle instalado em seu computador)