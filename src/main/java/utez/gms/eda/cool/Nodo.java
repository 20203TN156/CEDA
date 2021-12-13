package utez.gms.eda.cool;

public class Nodo {
    private Object dato;
    private Nodo next;
    private Nodo prev;

    public Nodo(Object dato) {
        this.dato = dato;
        this.next = null;
        this.prev = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public Nodo getPrev() {
        return prev;
    }

    public void setPrev(Nodo prev) {
        this.prev = prev;
    }
}
