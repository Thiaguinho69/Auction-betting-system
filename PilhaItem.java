class PilhaItem {
    Item topo;

    public PilhaItem() {
        this.topo = null;

    }

    public void inserir(Item item) {
        if (isEmpty()) {
            topo = item;
        } else {
            item.prev = topo;
            topo = item;

        }
    }

    public Item remover() {
        if (isEmpty()) {
            throw new IllegalStateException("Nenhum lance registrado");
        }
        
        Item item = topo;

        if (topo.prev == null) {
            topo = null;
            return item;
        }

        topo = topo.prev;
        topo.next = null;
        return item;

    }

    public boolean isEmpty() {
        return topo == null;
    }

    public Item verTopo() {
        if (isEmpty()) {
            throw new IllegalStateException("Nenhum lance registrado");
        }
        return topo;

    }
}
