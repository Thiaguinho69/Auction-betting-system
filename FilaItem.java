class FilaItem {
    Item inicio;
    Item fim;

    public FilaItem() {
        this.inicio = null;
        this.fim = null;
    }

    public void inserir(Item item) {
        if (isEmpty()) {
            inicio = item;
            fim = item;
        } else {
            item.prev = fim;
            fim.next = item;
            fim = item;

        }
    }

    public Item remover() {
        if (isEmpty()) {
            throw new IllegalStateException("Nenhum item registrado");
        }

        Item item;

        if (inicio == fim) {
            item = inicio;
            inicio = null;
            fim = null;
            return item;
        }

        Item temp = inicio;
        item = inicio;
        inicio = inicio.next;
        inicio.prev = null;
        temp.next = null;

        return item;
    }

    public boolean isEmpty() {
        return fim == null;
    }

    public Item verInicio() {
        if (isEmpty()) {
            throw new IllegalStateException("Nenhum item registrado");
        }
        return inicio;

    }
}