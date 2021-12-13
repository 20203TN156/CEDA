package utez.gms.eda.cool.listnodos;

import utez.gms.eda.cool.bean.BeanProduct;

public class ListaProduct {
    NodoProduct primero;
    NodoProduct ultimo;

    public ListaProduct() {
        this.primero = null;
        this.ultimo = null;
    }

    public boolean isEmpty(){
        return this.primero == null;
    }

    public void add(BeanProduct dato){
        NodoProduct aux = primero;
        if (isEmpty()){
            NodoProduct nuevo = new NodoProduct(dato);
            primero = nuevo;
            ultimo = primero;
        }else{
            while(aux.getNext() != null){
                aux = aux.getNext();
            }
            NodoProduct nuevo = new NodoProduct(dato);
            ultimo = nuevo;
            nuevo.setPrev(aux);
            aux.setNext(nuevo);
        }
    }

    public void print(){
        if (!isEmpty()){
            NodoProduct aux = primero;
            while(aux != null){
                System.out.print(aux.getDato().getId_product() + " --> ");
                System.out.print(aux.getDato().getName() + " --> ");
                System.out.print(aux.getDato().getQuantity() + " --> ");
                System.out.print(aux.getDato().getPrice() + " --> ");
                System.out.println(aux.getDato().getDescription() + " --> ");
                aux = aux.getNext();
            }
        }
    }

    public void printReverse(){
        if (!isEmpty()){
            NodoProduct aux = ultimo;
            while (aux != null){
                System.out.print(" <- " + aux.getDato().getId_product());
                System.out.print(" <- " + aux.getDato().getName());
                System.out.print(" <- " + aux.getDato().getQuantity());
                System.out.print(" <- " + aux.getDato().getPrice());
                System.out.println(" <- " + aux.getDato().getDescription());
                aux = aux.getPrev();
            }
        }
    }
}
