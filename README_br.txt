										***GuessingNumberGame v1.0_BETA;***

Jogo de adivinhação programado em Java na IDE NetBeans.


Funcionalidade:

Basicamente, o jogo consiste na adivinhação de um número gerado aleatoriamente dentro de um intervalo específico, de acordo com o nível selecionado. Para cada palpite incorreto, uma dica simples é gerada, fornecendo uma direção ao usuário.

Níveis:
	-Caso o nível selecionado seja fácil, será gerado um número aleatório de 0 a 100;
	-Caso o nível selecionado seja intermediário, será gerado um número aleatório de 0 a 200;
	-Caso o nível selecionado seja difícil, será gerado um número aleatório de 0 a 500;
	-Caso o nível selecionado seja veterano, será gerado um número aleatório de 0 a 1000;
	-E caso o nível selecionado seja custom, o usuário precisará configurar o nível antes de iniciar um jogo personalizado. Se o usuário não configurar um nível, o jogo não inicializará por falta de dados básicos para executar o modo customizado.


Status do projeto:

O jogo ainda está passando por algumas melhorias. Esta versão será Beta, pois o arquivo de interface do menu está muito sobrecarregado. Portanto, vou dividir algumas opções em outras classes de arquivo para que o aplicativo, de maneira geral, tenha um desempenho ligeiramente melhor durante a execução.

Estou disponibilizando esta versão aqui para fins de backup, pois as próximas melhorias que fizer no jogo serão complexas e abruptas, e não sei se o jogo se adaptará bem às mudanças. Assim, deixo esta versão funcional aqui para eventuais clones futuros.

Caso as implementações (não apenas estas, mas também as futuras) tenham sucesso, irei atualizar constantemente o projeto aqui para que ele tenha sempre uma versão melhor e funcional.

Manterei a versão como 1.0 BETA por enquanto...


Teste você mesmo:

-Para clonar este repositório em sua máquina, use o seguinte comando em seu terminal Linux, Termux ou Prompt de Comando do Windows:

	git clone https://github.com/GrimReaper3223/GuessingNumberGame-v1.0-BETA

***Também estarei disponibilizando um arquivo executável .jar para aqueles que desejam executá-lo diretamente no terminal ou Prompt de Comando.

-A sintaxe para executar este jogo no terminal está logo abaixo:

	-Linux & Termux: 

	java -jar GuessingNumberGame-1.0_BETA.jar

	-Para usuários Windows, a pasta contém um arquivo de script .bat que executa o mesmo código acima com apenas dois cliques.

Considerações Finais:

	---NOTA: Por ser uma versão beta com algumas coisas que podem afetar sua execução, pode ocorrer pequenas interrupções no aplicativo ao chamar certas funções (provavelmente nada perceptível);

Espero que goste! :)

