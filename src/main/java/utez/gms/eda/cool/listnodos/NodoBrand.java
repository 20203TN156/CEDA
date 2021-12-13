package utez.gms.eda.cool.listnodos;

import utez.gms.eda.cool.bean.BeanBrand;

public class NodoBrand {
    private BeanBrand dato;
    private NodoBrand next;
    private NodoBrand prev;

    public NodoBrand(BeanBrand dato) {
        this.dato = dato;
        this.next = null;
        this.prev = null;
    }

    public BeanBrand getDato() {
        return dato;
    }

    public void setDato(BeanBrand dato) {
        this.dato = dato;
    }

    public NodoBrand getNext() {
        return next;
    }

    public void setNext(NodoBrand next) {
        this.next = next;
    }

    public NodoBrand getPrev() {
        return prev;
    }

    public void setPrev(NodoBrand prev) {
        this.prev = prev;
    }
}
