# TrabalhoPratico
Descrição
Este projeto em Java simula um sistema de atendimento onde gerenciamos solicitações e a ordem de atendimento dos clientes. O sistema usa duas estruturas de dados principais:

Pilha para manter um histórico de solicitações.

Fila para controlar a ordem de atendimento aos clientes.

Estruturas Utilizadas
Elemento
A classe Elemento representa cada item no sistema, seja uma solicitação ou um cliente. Cada elemento tem:

id: um identificador único.

descrição: uma breve descrição sobre o que foi solicitado ou o motivo do contato do cliente.

dataHora: o horário da solicitação ou do contato (opcional).

Node
A classe Node é usada para criar a lista encadeada que armazena os elementos. Cada nó contém:

Um objeto do tipo Elemento.

Uma referência para o próximo nó da lista.

Pilha
A pilha é implementada com a estrutura LIFO (Last In, First Out), o que significa que a última solicitação registrada é a primeira a ser atendida. A pilha tem os seguintes métodos:

adicionar(Elemento): adiciona uma nova solicitação.

remover(): remove a solicitação mais recente.

imprimirPilha(): imprime o histórico de solicitações realizadas.

Fila
A fila é implementada com a estrutura FIFO (First In, First Out), ou seja, o primeiro cliente a entrar será o primeiro a ser atendido. A fila oferece:

enfileirar(Elemento): adiciona um novo cliente à fila.

atender(): remove o cliente da frente da fila (simulando o atendimento).

imprimirFila(): imprime a lista atual de clientes aguardando atendimento.

Funcionamento
O programa adiciona várias solicitações à pilha (simulando o histórico de demandas).

Algumas dessas solicitações são removidas para simular que foram atendidas.

Em paralelo, é criada uma fila de clientes aguardando atendimento.

À medida que o sistema processa os clientes, ele vai atendendo e removendo-os da fila.

O sistema imprime o estado final da pilha (histórico de solicitações) e da fila (clientes ainda aguardando atendimento).

Como Executar
Copie o código e cole em sua IDE, utilize o nome da Classe como SistemaAtendimento.java e em seguida rode.

Exemplo de Saída
O sistema vai gerar a seguinte saída (após simulação de atendimentos):
----- HISTÓRICO DE SOLICITAÇÕES -----
REQ003 - Atualização de sistema - 2024-08-20 11:30
REQ002 - Manutenção preventiva - 2024-08-20 11:00
REQ001 - Instalação de software - 2024-08-20 10:30

----- Fila de Atendimento -----
CLI006 - Lucas Martins - Alteração de pedido
CLI007 - Patrícia Rocha - Cancelamento de contrato
CLI008 - Rafael Lima - Renovação de assinatura
CLI009 - Fernanda Gomes - Suporte para instalação
CLI010 - Carlos Eduardo - Pedido de orçamento

caso deseja adicionar um historico utilize o codigo:
            historico.adicionar(new Elemento("id", "descricao", "datahora"));
caso deseja remover o ultimo historico:
            historico.remover();

caso deseje adicionar a fila de atendimento:
            fila.enfileirar(new Elemento("id", "nome", "motivo atendimento"));
caso deseje retirar (atender) quem está na fila:
            fila.atender();

para imprimir os resultados utilize:
            historico.imprimirPilha();
            fila.imprimirFila();
