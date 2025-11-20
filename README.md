# Agenda-Eletronica
Desenvolvimento de uma Agenda Eletrônica com Java e Manipulação de Arquivos para a webquest 3 de Programação II

## Equipe
- Bruna Correia Ferreira
- José Valmir de Santana
- Paulo Vinnicius Pereira do Nascimento
- Rebeca Barbosa Nunes da Silva
- Victoria Yolanda Lourenço de Souza

---
## Atividade
1. Crie uma classe Contato com atributos privados: nome, telefone, email;
Implemente construtor, getters, setters e método toString().

2. Crie uma interface GerenciadorContatos com métodos:
● void adicionarContato(Contato contato) throws ContatoExistenteException
● Contato buscarContato(String nome) throws ContatoNaoEncontradoException
● void removerContato(String nome) throws ContatoNaoEncontradoException
● List<Contato> listarTodosContatos()

Implemente essa interface na classe AgendaManager;
Crie exceções personalizadas para as situações específicas.

3. Implemente o método void salvarContatosCSV(String nomeArquivo) para salvar a agenda em
arquivo CSV;
Implemente o método void carregarContatosCSV(String nomeArquivo) para carregar a agenda
de um arquivo CSV;
**Formato do CSV:** nome;telefone;email (um contato por linha).

4. Crie uma classe AgendaApplication com método main;

Implemente um menu interativo no console com Scanner;

Opções do menu: 

1 - Adicionar Contato 

2 - Buscar Contato

3 - Remover Contato 

4 - Listar Todos os Contatos 

5 - Salvar em CSV 

6 - Carregar de CSV 

7 - Sair 

5. Implemente na classe AgendaManager o método List<Contato> listarContatosOrdenados() que
retorne os contatos ordenados alfabeticamente por nome;
Implemente na classe AgendaManager o método List<Contato>
buscarPorDominioEmail(String dominio) para buscar contatos por domínio de email.
