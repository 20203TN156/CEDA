package utez.gms.eda.cool.listnodos;

import utez.gms.eda.cool.bean.BeanCategory;

public class ListaCategory {
    NodoCategory primero;
    NodoCategory ultimo;

    public ListaCategory() {
        this.primero = null;
        this.ultimo = null;
    }

    public boolean isEmpty(){
        return this.primero == null;
    }

    public void add(BeanCategory dato){
        NodoCategory aux = primero;
        if (isEmpty()){
            NodoCategory nuevo = new NodoCategory(dato);
            primero = nuevo;
            ultimo = primero;
        }else{
            while(aux.getNext() != null){
                aux = aux.getNext();
            }
            NodoCategory nuevo = new NodoCategory(dato);
            ultimo = nuevo;
            nuevo.setPrev(aux);
            aux.setNext(nuevo);
        }
    }

    public void print(){
        if (!isEmpty()){
            NodoCategory aux = primero;
            while(aux != null){
                System.out.print(aux.getDato().getId_category() + " --> ");
                System.out.print(aux.getDato().getName_category() + " --> ");
                System.out.println(aux.getDato().getDescription() + " --> ");
                aux = aux.getNext();
            }
        }
    }

    public void printReverse(){
        if (!isEmpty()){
            NodoCategory aux = ultimo;
            while (aux != null){
                System.out.print(" <- " + aux.getDato().getId_category());
                System.out.print(" <- " + aux.getDato().getName_category());
                System.out.println(" <- " + aux.getDato().getDescription());
                aux = aux.getPrev();
            }
        }
    }
}
