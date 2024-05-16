public class Edital {
    FilaItem itensLeilao;

    public Edital() {
        this.itensLeilao = new FilaItem();

    }

    public void adicionarItem(Item item) {
        itensLeilao.inserir(item);

    }

    public Item removerItem() {
        return itensLeilao.remover();

    }

    public void proximoItem(Sessao sessao) {
        Item item = removerItem();
        Cliente cliente = sessao.getUltimoLance();
        cliente.adicionarItemComprado(item);
        System.out.println("Item " + item.nome + " vendido para cliente de ID " + cliente.idCliente + "\n");
        
    }
}
