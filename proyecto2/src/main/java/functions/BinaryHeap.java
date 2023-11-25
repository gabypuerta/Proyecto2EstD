/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

import javax.swing.JOptionPane;


public class BinaryHeap {
    private Document[] heap;
    private int size;
    private int capacity;

    public BinaryHeap() {
        this.capacity = 100;
        this.size = 0;
        this.heap = new Document[capacity];
    }

public void insert(Document doc) {
    if (getSize() == getCapacity()) {
        JOptionPane.showMessageDialog(null, "NÚMERO MÁXIMO DE DOCUMENTOS EN LA COLA");
    }else{
            setSize(getSize() + 1);
    int currentIndex = getSize() - 1;
            getHeap()[currentIndex] = doc;

    while (currentIndex != 0 && getHeap()[parentIndex(currentIndex)].getTime() > getHeap()[currentIndex].getTime()) {
        swap(currentIndex, parentIndex(currentIndex));
        currentIndex = parentIndex(currentIndex);
    }
}}

public Document deleteMin() {
    if (getSize() == 0) {
        return null;
    }

    if (getSize() == 1) {
            setSize(getSize() - 1);
        return getHeap()[0];
    }

    Document root = getHeap()[0];
        getHeap()[0] = getHeap()[getSize() - 1];
        setSize(getSize() - 1);
    heapify(0);

    return root;
}

public void heapify(int index) {
    int smallest = index;
    int leftChild = leftChildIndex(index);
    int rightChild = rightChildIndex(index);

    if (leftChild < getSize() && getHeap()[leftChild].getTime() < getHeap()[smallest].getTime()) {
        smallest = leftChild;
    }

    if (rightChild < getSize() && getHeap()[rightChild].getTime() < getHeap()[smallest].getTime()) {
        smallest = rightChild;
    }

    if (smallest != index) {
        swap(index, smallest);
        heapify(smallest);
    }
}
 public void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        Document currentDocument = getHeap()[index];

        while (index > 0 && getHeap()[parentIndex].getTime() > currentDocument.getTime()) {
            getHeap()[index] = getHeap()[parentIndex];
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }

        getHeap()[index] = currentDocument;
    }

    public void heapifyDown(int index) {
        int smallest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < getSize() && getHeap()[leftChild].getTime() < getHeap()[smallest].getTime()) {
            smallest = leftChild;
        }

        if (rightChild < getSize() && getHeap()[rightChild].getTime() < getHeap()[smallest].getTime()) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }
private int parentIndex(int index) {
    return (index - 1) / 2;
}

public int leftChildIndex(int index) {
    return (2 * index) + 1;
}

public int rightChildIndex(int index) {
    return (2 * index) + 2;
}

private void swap(int index1, int index2) {
    Document temp = getHeap()[index1];
        getHeap()[index1] = getHeap()[index2];
        getHeap()[index2] = temp;
}

public void delete_document(Document doc){
    if( this.getHeap()[0].getTime() == doc.getTime() && this.getHeap()[0].getTitle().equals(doc.getTitle())){
        this.deleteMin();
    }else{
        if( this.getHeap()[0]!= null){
        Document aux = this.deleteMin();
        this.delete_document(doc);
        this.insert(aux);}
        
    }
}

public String print(String binaryPrint){
    Document aux = this.deleteMin();
    if(aux!= null){
        binaryPrint += aux.getTitle() + "\n";
        binaryPrint = print(binaryPrint);
        this.insert(aux);}
    return binaryPrint;
}

    /**
     * @return the heap
     */
    public Document[] getHeap() {
        return heap;
    }

    /**
     * @param heap the heap to set
     */
    public void setHeap(Document[] heap) {
        this.heap = heap;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}


