package utez.gms.eda.cool.listnodos;

import utez.gms.eda.cool.bean.BeanCategory;

public class NodoCategory {
    private BeanCategory dato;
    private NodoCategory next;
    private NodoCategory prev;

    public NodoCategory(BeanCategory dato) {
        this.dato = dato;
        this.next = null;
        this.prev = null;
    }

    public BeanCategory getDato() {
        return dato;
    }

    public void setDato(BeanCategory dato) {
        this.dato = dato;
    }

    public NodoCategory getNext() {
        return next;
    }

    public void setNext(NodoCategory next) {
        this.next = next;
    }

    public NodoCategory getPrev() {
        return prev;
    }

    public void setPrev(NodoCategory prev) {
        this.prev = prev;
    }
}
