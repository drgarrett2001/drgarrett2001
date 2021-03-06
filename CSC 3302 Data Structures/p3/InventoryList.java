public class InventoryList <T> {
    public Node head;

    public void insert(T v) {
        Node<T> node = new Node<>();
        node.value = v;
        node.next = null;
        Node curr = head;
        Node prev = head;
        boolean done = false;
        Inventory j = (Inventory)v;    
        if(head==null) //make a head
            head = node;
        else { //sorting the nodes as they are created
            Inventory i = (Inventory)curr.value;
            curr = head;
            while(!done) {
                i = (Inventory)curr.value;
                if (j.getComponentNum() > i.getComponentNum()){
                    if(curr.next != null){
                        prev = curr;
                        curr = curr.next;
                    }
                    else {
                        curr.next = node;
                        done = true;
                    }
                }
                else if(j.getComponentNum() < i.getComponentNum()){
                    if( curr == head) {
                        node.next = curr;
                        head = node;
                        done = true;
                    }
                    else {
                        prev.next = node;
                        node.next = curr;
                        done = true;
                    }
                }
                else{
                    System.out.println("CANNOT COMPLETE OPERATION: DUPLICATE COMPONENT NUMBER!");
                    done = true;
                }
            }
        }
    }

    public void delete(int componentNum) {
        Node curr = head;
        Node prev = head;
        Inventory i = (Inventory)curr.value;
        boolean done = false;
        while(!done) {//searching for number
            i = (Inventory)curr.value;

            if(componentNum == i.getComponentNum()){
                if( curr == head) {
                    head = head.next;
                    done = true;
                }
                else if(curr.next == null){
                    prev.next = null;
                    done = true;
                }
                else {
                    curr = curr.next;
                    prev.next = curr;
                    done = true;
                }
            }
            else if (componentNum > i.getComponentNum()){
                prev = curr;
                curr = curr.next;
            }
            else{
                System.out.println("CANNOT COMPLETE OPERATION: ITEM DOES NOT EXIST!");
                System.out.println(componentNum);
                done = true;
            }
        }
    }

    public void add(int componentNum,int added) {
        Node curr = head;            
        while(curr.next != null){//find component number
            Inventory i = (Inventory)curr.value;
            if(i.getComponentNum() == componentNum){ //add value
                i.setInStock(i.getInStock() + added);
            }
            curr = curr.next;
        }            
    }

    public void remove(int componentNum,int removed) {
        Node curr = head;            
        while(curr.next != null){//find component number
            Inventory i = (Inventory)curr.value;
            if(i.getComponentNum() == componentNum){
                if((i.getInStock() - removed)>=0)
                    i.setInStock(i.getInStock() - removed);//remove values
                else
                    i.setInStock(0);
            }
            curr = curr.next;
        }            
    }

    public void output(){
        Node curr = head;
        System.out.println("COMPONENT \t\t\t CURRENT # \t \t REORDER");
        System.out.println("NUMBER \t\t DESCRIPTION \t IN STOCK \t\t LEVEL");
        System.out.println("---------------------------------------------------------------------------------------------- ");
        while(curr!=null){
            Inventory i = (Inventory)curr.value;
            if (i.getDescription().length()>16){ //one tab after description
                if(i.getReorderLevel() == 0)
                    System.out.println(i.getComponentNum() + " \t\t" + i.getDescription() + "\t" + i.getInStock() + "\t\t" + i.getReorderLevel() + "  *REORDER*");
                else    
                    System.out.println(i.getComponentNum() + " \t\t" + i.getDescription() + "\t" + i.getInStock() + "\t\t" + i.getReorderLevel());
            }
            else if(i.getDescription().length()<16){//two tabs after description
                if(i.getReorderLevel() == 0)
                    System.out.println(i.getComponentNum() + " \t\t" + i.getDescription() + "\t\t" + i.getInStock() + "\t\t" + i.getReorderLevel() + "  *REORDER*");
                else    
                    System.out.println(i.getComponentNum() + " \t\t" + i.getDescription() + "\t\t" + i.getInStock() + "\t\t" + i.getReorderLevel());
            }

            curr = curr.next;
        }
    }
}

class Inventory {
    private int componentNum = 0;
    private String description = "";
    private int inStock = 0;
    private int reorderLevel = 0;

    public Inventory() {
    }

    public Inventory(int componentNum, String description, int inStock, int reorderLevel) {
        this.componentNum = componentNum;
        this.description = description;
        this.inStock = inStock;
        this.reorderLevel = reorderLevel;
    }

    public void setComponentNum(int componentNum) {
        this.componentNum = componentNum;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public int getComponentNum() {
        return this.componentNum;
    }

    public String getDescription() {
        return this.description;
    }

    public int getInStock() {
        return this.inStock;
    }

    public int getReorderLevel() {
        return this.reorderLevel;
    }

} //end Storage

class Node<T> {
    T value;
    Node next;
}
