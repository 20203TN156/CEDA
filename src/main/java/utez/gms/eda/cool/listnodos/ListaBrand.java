package utez.gms.eda.cool.listnodos;

import utez.gms.eda.cool.bean.BeanBrand;

public class ListaBrand {
    NodoBrand primero;
    NodoBrand ultimo;

    public ListaBrand() {
        this.primero = null;
        this.ultimo = null;
    }

    public boolean isEmpty(){
        return this.primero == null;
    }

    public void add(BeanBrand dato){
        NodoBrand aux = primero;
        if (isEmpty()){
            NodoBrand nuevo = new NodoBrand(dato);
            primero = nuevo;
            ultimo = primero;
        }else{
            while(aux.getNext() != null){
                aux = aux.getNext();
            }
            NodoBrand nuevo = new NodoBrand(dato);
            ultimo = nuevo;
            nuevo.setPrev(aux);
            aux.setNext(nuevo);
        }
    }

    public void print(){
        if (!isEmpty()){
            NodoBrand aux = primero;
            while(aux != null){
                System.out.print(aux.getDato().getId_brand() + " --> ");
                System.out.print(aux.getDato().getName_brand() + " --> ");
                System.out.println(aux.getDato().getDescription() + " --> ");
                aux = aux.getNext();
            }
        }
    }

    public void printReverse(){
        if (!isEmpty()){
            NodoBrand aux = ultimo;
            while (aux != null){
                System.out.print(" <- " + aux.getDato().getId_brand());
                System.out.print(" <- " + aux.getDato().getName_brand());
                System.out.println(" <- " + aux.getDato().getDescription());
                aux = aux.getPrev();
            }
        }
    }
}
