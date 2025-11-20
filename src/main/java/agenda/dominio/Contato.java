package agenda.dominio; 

public class Contato {
    private String nome; 
    private String telefone; 
    private String email;

    public Contato(String nome, String telefone, String email) {
        this.nome = nome; 
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "nome = " + this.nome + ", telefone= " + this.telefone + ", email= " + this.email + "";
    }

    public String toCSV() {
        return this.nome + ";" + this.telefone + ";" + this.email;
    }
}
