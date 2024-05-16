class Item {
    String nome;
    int idItem;
    Item prev;
    Item next;

    public Item(String nome, int idItem) {
        this.nome = nome;
        this.idItem = idItem;
        this.prev = null;
        this.next = null;

    }
}