package utez.gms.eda.cool.listnodos;

import utez.gms.eda.cool.bean.BeanProduct;

public class NodoProduct {
    private BeanProduct dato;
    private NodoProduct next;
    private NodoProduct prev;

    public NodoProduct(BeanProduct dato) {
        this.dato = dato;
        this.next = null;
        this.prev = null;
    }

    public BeanProduct getDato() {
        return dato;
    }

    public void setDato(BeanProduct dato) {
        this.dato = dato;
    }

    public NodoProduct getNext() {
        return next;
    }

    public void setNext(NodoProduct next) {
        this.next = next;
    }

    public NodoProduct getPrev() {
        return prev;
    }

    public void setPrev(NodoProduct prev) {
        this.prev = prev;
    }
}
