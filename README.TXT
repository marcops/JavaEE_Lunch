------------TODO------------
Para Acessar
http://localhost:8080/almoco-web/login.jsf
http://localhost:8080/almoco-web/lvoteRestaurant.jsf
http://localhost:8080/almoco-web/result.jsf

------------ALGORITMO PROPOSTO------------
Execução:
-LOGIN: (telas/1_login.png)
-Ao fazer o login,  loga o usuario (obvio?)
-------Ao logar no sistema verifica o horario onde:
--------------Se ja passou do meio dia, traz apenas o resultado(estoria 3) (afinal ja passou do meio dia, e a votacao se encerrou é almoco nao janta.)
---------------------caso ja tenha passado do meio dia (e nao processou os votos ainda), processa os votos, ou seja, armazena qual restaurante ganhou para nao ser utilizado novamente(estoria 2), e salva a votacao (historico)
--------------senao passou do meio dia ainda, verifica se o usuário ja votou hoje:
---------------------se votou, traz o resultado (estoria 3)(nao pode votar 2x,estoria 1)
---------------------senao traz a tela de Votação
-------apos verificar o horario, verifica se nao e segunda para resetar o historico, afinal quero comer no Sabor latrino novamente!

-Votacao: (telas/2_vote.png)
-------Usuário escolhe qual restaurante deseja
--------------apos escolher o restaurante e encaminhado para a tela de resultado (estoria 3)

-RESULTADO: (telas/3_resultEND.png e telas/3_resultTMP.png, dependendo do caso)
-------Traz o resultado da votacao onde traz:
--------------qual restaurante esta vencendo ou venceu no dia
--------------qual restaurante voce votou (e nao pode trocar)
--------------qual a contagem dos votos(afinal nao queremos fraude)

------------REQUISITADO------------
***O que vale destacar no código implementado?
-O projeto está dentro dos patterns. Separação MVC, Tem facade para o MBean nao ter conhecimento de qual serviço esta sendo chamado.
-Separado o projeto no padrao EE.
-Foi ultilizado GLASSFISH4.(pois, ja tinha o ambiente montado)
-Foi ultilizado MAVEN(ou seja, facilita o suporte do projeto nos servidores de integração e deploy)

***O que poderia ser feito para melhorar o sistema?
-Seria interessante ter uma mensagem de erro dentro do LoginMB e mostrar caso o usuário logue com credenciais inválidas.
-Poderia ter feito Message para internacionalizar as mensagens.
-O ideal seria utilizar um sistema de cobertura também para verificar o pacote e as classes
-Foi feito apenas 3 casos de teste
---Depois do meio dia (so pode visualizar o resultado, afinal ja almocamos)
---Antes do meio dia e nao votou (pode votar)
---Antes do meio dia e votou (Nao pode mais votar)

***Algo a mais que você tenha a dizer ?
-Não seria usado Stateful para armazenar na memória (DAO) se estivesse usando hibernate com JPA para o armazenamento, neste caso utilizaria o Stateless e usaria os metodos de SAVE (persist)
-Para os testes foi utilizado uma API de "mocagen" para "mocar" os DAO'S, no caso foi ultilizado o MOKITO.
-Poderia ter utilizado o Bootstrap para fazer uma interface responsiva (integrado com primesface ou richfaces).
-Quando da empate, o restaurante escolhido é o que foi votado primeiro (afinal devemos dar o mérito para o cara que votou as 8h da manha)
-Nao foi feito controle de acesso, o ideial seria ultilizar o springsecurety.