package agenda.dominio;

import java.util.List;

import agenda.exceptions.ContatoExistenteException;
import agenda.exceptions.ContatoNaoEncontradoException;

public interface GerenciadorContato {
    
    //contratos

    public void adicionarContato(Contato contato) throws ContatoExistenteException;
    public Contato buscarContato(String nome) throws ContatoNaoEncontradoException; 
    public void removerContato(String nome) throws ContatoNaoEncontradoException; 
    public List<Contato> listarTodosContatos();

}
