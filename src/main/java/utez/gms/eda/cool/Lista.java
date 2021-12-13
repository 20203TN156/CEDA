package utez.gms.eda.cool;

public class Lista {
    Nodo primero;
    Nodo ultimo;

    public Lista() {
        this.primero = null;
        this.ultimo = null;
    }

    public boolean isEmpty(){
        return this.primero == null;
    }

    public void add(Object dato){
        Nodo aux = primero;
        if (isEmpty()){
            Nodo nuevo = new Nodo(dato);
            primero = nuevo;
            ultimo = primero;
        }else{
            while(aux.getNext() != null){
                aux = aux.getNext();
            }
            Nodo nuevo = new Nodo(dato);
            ultimo = nuevo;
            nuevo.setPrev(aux);
            aux.setNext(nuevo);
        }
    }

    public void print(){
        if (!isEmpty()){
            Nodo aux = primero;
            while(aux != null){
                System.out.print(aux.getDato() + " --> ");
                aux = aux.getNext();
            }
        }
    }

    public void printReverse(){
        if (!isEmpty()){
            Nodo aux = ultimo;
            while (aux != null){
                System.out.print(" <- " + aux.getDato());
                aux = aux.getPrev();
            }
        }
    }
}
