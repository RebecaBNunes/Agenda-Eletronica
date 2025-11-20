package agenda.dominio;

import java.util.List;

import agenda.exceptions.ContatoExistenteException;
import agenda.exceptions.ContatoNaoEncontradoException;

public interface GerenciadorContatos {
    
    //contratos

    public void adicionarContato(Contato contato) throws ContatoExistenteException;
    public Contato buscarContato(String nome) throws ContatoNaoEncontradoException; 
    public void removerContato(String nome) throws ContatoNaoEncontradoException; 
    public List<Contato> listarTodosContatos();
    public List<Contato> listarContatosOrdenados();
}
