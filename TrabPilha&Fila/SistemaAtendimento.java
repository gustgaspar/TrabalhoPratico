// Classe Elemento
class Elemento {
    String id;
    String descricao;
    String dataHora; // Opcional para diferenciar entre histórico e fila

    public Elemento(String id, String descricao, String dataHora) {
        this.id = id;
        this.descricao = descricao;
        this.dataHora = dataHora;
    }
}

// Nó da lista encadeada
class Node {
    Elemento elemento;
    Node proximo;

    public Node(Elemento elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }
}

// Classe Pilha (Histórico de Solicitações)
class Pilha {
    private Node topo;

    public Pilha() {
        this.topo = null;
    }

    public void adicionar(Elemento elemento) {
        Node novo = new Node(elemento);
        novo.proximo = topo;
        topo = novo;
    }

    public Elemento remover() throws Exception {
        if (vazia()) {
            throw new Exception("Pilha vazia");
        }
        Elemento elemento = topo.elemento;
        topo = topo.proximo;
        return elemento;
    }

    public boolean vazia() {
        return topo == null;
    }

    public void imprimirPilha() {
        System.out.println("\n----- HISTÓRICO DE SOLICITAÇÕES-----" );
        Node atual = topo;
        while (atual != null) {
            System.out.println(atual.elemento.id + " - " + atual.elemento.descricao + " - " + atual.elemento.dataHora);
            atual = atual.proximo;
        }
    }
}

// Classe Fila (Ordem de Atendimento)
class Fila {
    private Node frente;
    private Node tras;

    public Fila() {
        this.frente = null;
        this.tras = null;
    }

    public void enfileirar(Elemento elemento) {
        Node novo = new Node(elemento);
        if (vazia()) {
            frente = novo;
            tras = novo;
        } else {
            tras.proximo = novo;
            tras = novo;
        }
    }

    public Elemento atender() throws Exception {
        if (vazia()) {
            throw new Exception("Fila vazia");
        }
        Elemento elemento = frente.elemento;
        frente = frente.proximo;
        if (frente == null) {
            tras = null;
        }
        return elemento;
    }

    public boolean vazia() {
        return frente == null;
    }

    public void imprimirFila() {
        System.out.println("\n-----Fila de Atendimento-----");
        Node atual = frente;
        while (atual != null) {
            System.out.println(atual.elemento.id + " - " + atual.elemento.descricao + " - " + atual.elemento.dataHora);
            atual = atual.proximo;
        }
    }
}

// Classe Principal
public class SistemaAtendimento {
    public static void main(String[] args) {
        try {
            // Cria o histórico na pilhaa
            Pilha historico = new Pilha();
            historico.adicionar(new Elemento("REQ001", "Instalação de software", "2024-08-20 10:30"));
            historico.adicionar(new Elemento("REQ002", "Manutenção preventiva", "2024-08-20 11:00"));
            historico.adicionar(new Elemento("REQ003", "Atualização de sistema", "2024-08-20 11:30"));
            historico.adicionar(new Elemento("REQ004", "Suporte técnico", "2024-08-20 12:00"));
            historico.adicionar(new Elemento("REQ005", "Troca de equipamento", "2024-08-20 12:30"));
            historico.adicionar(new Elemento("REQ006", "Consulta de garantia", "2024-08-20 13:00"));
            historico.adicionar(new Elemento("REQ007", "Reparo de impressora", "2024-08-20 13:30"));
            historico.adicionar(new Elemento("REQ008", "Configuração de rede", "2024-08-20 14:00"));
            historico.adicionar(new Elemento("REQ009", "Restauração de dados", "2024-08-20 14:30"));
            historico.adicionar(new Elemento("REQ010", "Consulta técnica", "2024-08-20 15:00"));
            historico.remover();
            historico.remover();
            historico.remover();
            historico.remover();
            historico.remover();
            historico.remover();
            historico.remover();


            // cria a fila de atendimento
            Fila fila = new Fila();
            fila.enfileirar(new Elemento("CLI001", "Maria Silva", "Dúvida sobre produto"));
            fila.enfileirar(new Elemento("CLI002", "João Souza", "Reclamação de serviço"));
            fila.enfileirar(new Elemento("CLI003", "Ana Costa", "Solicitação de reembolso"));
            fila.enfileirar(new Elemento("CLI004", "Pedro Alves", "Informações de entrega"));
            fila.enfileirar(new Elemento("CLI005", "Carla Dias", "Agendamento de visita"));

            fila.imprimirFila();
            fila.atender();

            fila.enfileirar(new Elemento("CLI006", "Lucas Martins", "Alteração de pedido"));
            fila.enfileirar(new Elemento("CLI007", "Patrícia Rocha", "Cancelamento de contrato"));
            fila.enfileirar(new Elemento("CLI008", "Rafael Lima", "Renovação de assinatura"));
            fila.enfileirar(new Elemento("CLI009", "Fernanda Gomes", "Suporte para instalação"));
            fila.enfileirar(new Elemento("CLI010", "Carlos Eduardo", "Pedido de orçamento"));
            fila.atender();
            fila.atender();
            fila.atender();
            fila.atender();


            // Vai imprimir os resultados
            historico.imprimirPilha();
            fila.imprimirFila();

            fila.atender();
            fila.imprimirFila();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
