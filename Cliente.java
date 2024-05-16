public class Cliente {
    int idCliente;
    PilhaItem itensComprados;
    Cliente prev;
    Cliente next;

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
        this.itensComprados = new PilhaItem();
        this.prev = null;
        this.next = null;
    }

    public void darLance(double lance, Sessao sessao) {
        System.out.println("Cliente " + idCliente + " deu um lance de R$" + lance + "\n");
        sessao.registrarLance(this, lance);
    }

    public void adicionarItemComprado(Item item) {
        itensComprados.inserir(item);
    }
}