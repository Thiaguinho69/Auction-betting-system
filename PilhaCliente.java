class PilhaCliente {
    Cliente topo;

    public PilhaCliente() {
        this.topo = null;

    }

    public void inserir(Cliente cliente) {
        if (isEmpty()) {
            topo = cliente;
        } else {
            cliente.prev = topo;
            topo = cliente;

        }
    }

    public Cliente remover() {
        if (isEmpty()) {
            throw new IllegalStateException("Nenhum lance registrado");
        }

        Cliente cliente = topo;

        if (topo.prev == null) {
            topo = null;
            return cliente;
        }
        
        topo = topo.prev;
        topo.next = null;
        return cliente;

    }

    public boolean isEmpty() {
        return topo == null;
    }

    public Cliente verTopo() {
        if (isEmpty()) {
            throw new IllegalStateException("Nenhum lance registrado");
        }
        return topo;

    }
}
