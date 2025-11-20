package agenda.dominio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import agenda.exceptions.ContatoExistenteException;
import agenda.exceptions.ContatoNaoEncontradoException;

public class AgendaManager implements GerenciadorContatos {

    private Map<String, Contato> contatosMap;
    private final String path = "contatos.csv";

    public AgendaManager() {
        this.contatosMap = new HashMap<>();
    }

    @Override
    public void adicionarContato(Contato contato) throws ContatoExistenteException {
        if (contatosMap.containsKey(contato.getNome())) {
            throw new ContatoExistenteException("O contato " + contato.getNome() + " já existe.");
        }

        contatosMap.put(contato.getNome(), contato);
        salvarContatosCSV(path);
    }

    @Override
    public Contato buscarContato(String nome) throws ContatoNaoEncontradoException {
        if (!contatosMap.containsKey(nome)) {
            throw new ContatoNaoEncontradoException("Contato " + nome + " não encontrado.");
        }
        return contatosMap.get(nome);
    }

    @Override
    public void removerContato(String nome) throws ContatoNaoEncontradoException {
        if (!contatosMap.containsKey(nome)) {
            throw new ContatoNaoEncontradoException("Não foi possível remover. Contato não encontrado.");
        }
        contatosMap.remove(nome);
        salvarContatosCSV(path);
    }

    @Override
    public List<Contato> listarTodosContatos() {
        return new ArrayList<>(contatosMap.values());
    }

    public void salvarContatosCSV(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            
            for (Contato c : contatosMap.values()) {
                writer.write(c.toCSV());
                writer.newLine();
            }
            System.out.println("Salvo com sucesso.");

        } catch (IOException e) {
            System.err.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    public void carregarContatosCSV(String nomeArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            
            String linha;
            contatosMap.clear();

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 3) {
                    Contato c = new Contato(dados[0], dados[1], dados[2]);
                    contatosMap.put(c.getNome(), c);
                }
            }

        } catch (IOException e) {
            System.out.println("Arquivo ainda não existe ou erro de leitura: " + e.getMessage());
        }
    }

    public List<Contato> listarContatosOrdenados() {
        List<Contato> listaOrdenada = new ArrayList<>(contatosMap.values());
        
        Collections.sort(listaOrdenada, new Comparator<Contato>() {
            @Override
            public int compare(Contato c1, Contato c2) {
                return c1.getNome().compareToIgnoreCase(c2.getNome());
            }
        });

        return listaOrdenada;
    }
    
    public List<Contato> buscarPorDominioEmail(String dominio) {
        List<Contato> filtrados = new ArrayList<>();
        for (Contato c : contatosMap.values()) {
            if (c.getEmail().contains(dominio)) {
                filtrados.add(c);
            }
        }
        return filtrados;
    }
}