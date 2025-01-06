
package DataStructures;

import Ahorcado.Player;

public class LSEC {
    
    public class Node{
        public Object data;
        public Node next;
        
        public Node(Object data){
            this.data = data;
        }
    }
    
    public Node head;
    public int size = 0;
    
    public boolean prepend(Object data){
        try {
            Node inserted = new Node(data);
            if (this.head == null){
                this.head = inserted;
                this.head.next = inserted;
            }else{
                Node aux = this.head;
                while(aux.next != this.head) aux = aux.next;
                aux.next = inserted;
                inserted.next = this.head;
                this.head = inserted;
            }
            this.size++;
            return true;                        
        } catch (Exception e) {
            return true;
        }
    }
    
    public boolean append(Object data){
        try {
            Node inserted = new Node(data);
            if(this.head == null){
                this.head = inserted;
                inserted.next = this.head;
            }else{
                Node aux = this.head;
                while(aux.next != this.head) aux = aux.next;                
                aux.next = inserted;
            }
            inserted.next = this.head;
            this.size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean appendList(LSEC list){
        if(list.head == null) return false;
        if(this.head == null) this.head = list.head;
        else{
            Node lastCurrentList = this.head;
            while(lastCurrentList.next != this.head)
                lastCurrentList = lastCurrentList.next;
            
            Node lastListRecived = list.head;
            try {
                do{
                    Node inserted = new Node(lastListRecived.data);
                    lastCurrentList.next = inserted;
                    inserted.next = this.head;
                    this.size++;
                    lastListRecived = lastListRecived.next;
                    lastCurrentList = lastCurrentList.next;
                }while(lastListRecived != list.head);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }    
    
    public void reverseList(){
        LSEC auxListReversed = new LSEC();
        Node currentPlayer = this.head;
        do {            
            auxListReversed.prepend(currentPlayer.data);
            currentPlayer = currentPlayer.next;
        } while (currentPlayer != this.head);
        this.head = auxListReversed.head;
    }
    
    public String getPositionName(int position){
        if(this.head==null) return null;
        Node aux = this.head;
        for (int i = 1; i < position; i++) {
            aux = aux.next;
        }
        return ((Player)aux.data).getName();
    }
    
    public int getPositionScore(int position){
        if(this.head==null) return -1;
        Node aux = this.head;
        for (int i = 1; i < position; i++) {
            aux = aux.next;
        }
        return ((Player)aux.data).getScore();
    }
    
    public Node randomNode(){
        if(this.head != null){
            double randomPos = Math.random()*15+1;
            int pos = (int)randomPos, actual = 1;
            if(pos > this.size){
                pos = pos % this.size;
            }            
            Node aux = this.head, word;
            if(this.size == 1){
                this.head = null;
                this.size = 0;
                return aux;
            }
            if(pos == 1){
                word = this.head;
                while(aux.next != this.head){
                    aux = aux.next;
                }
                aux.next = this.head = this.head.next;
                this.size--;
                return word;
            }            
            pos--;
            while(actual < pos){
                aux = aux.next;
                actual++;
            }
            word = aux.next;
            aux.next = aux.next.next;
            this.size--;
            return word;
        }
        return null;
    }
    
    public void sortByScore(){ //Bubble sort
        if(this.head == null) return;
        
        Node currentPlayer = this.head;
        for (int i = 0; i < this.size-1; i++) {
            for (int j = 0; j < this.size-1; j++) {
                if(((Player)currentPlayer.data).getScore()>
                        ((Player)currentPlayer.next.data).getScore()){
                    Object auxData = currentPlayer.data;
                    currentPlayer.data = currentPlayer.next.data;
                    currentPlayer.next.data = auxData;
                }
                currentPlayer = currentPlayer.next;
            }
            currentPlayer = currentPlayer.next;
        }
        this.head = currentPlayer;
    }
    
    /*                       *
     * * * * FOR TESTING * * *
     *                       */
    public void printList(){
        if(this.head == null){
            System.out.println("NULO");
            return;
        }
        Node aux = this.head;
        do {            
            System.out.print(((String)aux.data)+", ");
            aux = aux.next;
        } while (aux != this.head);
        System.out.println();
    }
}
