package agenda;

public class AgendaApplication {

    public static void exibirMenu() {
        System.out.println("**************************");
        System.out.println("           Menu           ");
        System.out.println("**************************");
        System.out.println("Opções:");
        System.out.println("1 - Adicionar Contato");
        System.out.println("2 - Buscar Contato");
        System.out.println("3 - Remover Contato");
        System.out.println("4 - Listar Todos os Contatos");
        System.out.println("5 - Salvar em CSV");
        System.out.println("6 - Carregar de CSV");
        System.out.println("7 - Sair");
    }

    public static void main(String args[]) {
        exibirMenu();
    }
}