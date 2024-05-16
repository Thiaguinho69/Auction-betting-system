public class Sessao {
    PilhaCliente ultimosLances;
    double lanceMaisRecente = 0;

    public Sessao() {
        this.ultimosLances = new PilhaCliente();

    }

    public void registrarLance(Cliente cliente, double lance) {
        lanceMaisRecente = lance;
        ultimosLances.inserir(cliente);

    }

    public Cliente getUltimoLance() {
        if (ultimosLances.isEmpty()) {
            throw new IllegalStateException("Nenhum lance registrado");
        }
        return ultimosLances.remover();
    }
}