<h1>Trabalho Avaliativo 1 - 2023/1</h1>
<h3>Programação Orientada à Objeto - Marcelo Yamaguti</h3>
<h4>1. Enunciado geral: </h4>
<p>A ACMEPublishing é uma editora que gerencia livros e autores e que deseja automatizar o
seu catálogo. Sendo ele formado por:</p>
<ul>
<dl>
<dt><li>Biblioteca: classe catálogo que gerencia o cadastro de livros:</li><dt>
<dd><li>cadastraLivro(Livro): recebe como parâmetro um novo Livro e cadastra-o no
sistema. Não pode haver Livros com o mesmo código ‘isbn’. Retorna true se o
cadastro teve sucesso; ou false em caso contrário.</dd></li>
<dd><li>pesquisaLivro(String): retorna o livro com o código ‘isbn’ indicado. Se não
houver livro com este código retorna null.</dd></li>
<dd><li>pesquisaLivro(int): retorna uma lista de livros com o ano indicado. Se não
houver nenhum livro com este ano retorna null.</dd></li>
</dl>
• Grupo: classe catálogo que gerencia o cadastro de autores:
o cadastraAutor(Autor): recebe como parâmetro um novo Autor e cadastra-o no
sistema. Não pode haver autores com o mesmo código. Retorna true se o
cadastro teve sucesso; ou false em caso contrário.
o pesquisaAutor(int): retorna o autor com o código indicado. Se não houver
nenhum autor com este código retorna null.
• Livro: classe que representa um livro:
o adicionaAutor(Autor): adiciona um novo autor ao livro.
• Autor: classe que representa um autor:
o Autor(int,String,Livro): construtor.
o adicionaLivro(Livro): adiciona um novo livro ao autor.
o pesquisaLivros(): retorna uma lista de livros do autor.
• ACMEPublishing: classe do aplicativo:
o executa(): executa o funcionamento do aplicativo.
<li>Main: classe principal (inicial) do sistema:
main(String[]): cria um objeto ACMEPublishing e depois chama o método
executa(). </li>
</ul>
O método executa() da classe ACMEPublishing deve realizar a sequência de passos:
1. Cadastrar livros: lê todos os dados de cada livro e, se o isbn não for repetido,
cadastra-o no sistema. Para cada livro cadastrado com sucesso no sistema, mostra
os dados do livro no formato: 1;isbn;titulo;ano
2. Mostrar quantos livros foram cadastrados: mostra a quantidade de livros que
foram cadastrados no sistema no formato: 2;quantidade de livros
cadastrados
3. Cadastrar autores: lê todos os dados de cada autor, inclusive o isbn de um livro,
e, se o código não for repetido, cadastra-o no sistema. Para cada autor cadastrado
com sucesso no sistema, mostra os dados do autor no formato:
3:codigo;nome;isbn
4. Mostrar quantos autores foram cadastrados: mostra a quantidade de autores
que foram cadastrados no sistema no formato: 4;quantidade de autores
cadastrados
5. Adicionar livro a um autor: lê o código de um autor e um isbn de livro, e cadastra
no sistema. Para cada livro adicionado com sucesso no autor, mostra os dados no
formato: 5;codigo;nome;isbn;titulo;ano
6. Mostrar os livros de um determinado autor: lê um código de autor e mostra os
dados de cada livro deste autor no formato: 6;codigo;nome;isbn;titulo;ano
7. Mostrar os nomes dos autores de um determinado livro: lê um isbn e mostra
os nomes dos autores do livro no formato: 7;isbn;nome1;nome2;...
8. Mostrar os títulos dos livros que possuem mais de um autor: mostra o título
dos livros que possuem mais de um autor, no formato: 8;titulo
9. Mostrar os nomes dos autores com mais de um livro: apenas para os autores
com mais de um livro, mostra o nome seguido dos isbn de cada livro no formato:
9;nome;isbn1;isbn2,...
10.Mostrar os livros de um determinado ano: lê um ano e mostra os dados dos
livros do ano indicado, no formato: 10;isbn;titulo;ano
