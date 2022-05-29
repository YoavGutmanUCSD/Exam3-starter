public class CircularArrayList<T> implements ArrayListADT<T>{

    int capacity;
    int size;
    int front;
    int rear;
    T[] arrayList;

    public CircularArrayList() {
        this(100);
    }

    public CircularArrayList(int initialCapacity) {
        this.size = 0;
        this.capacity = initialCapacity;
        this.front = 0;
        this.rear = 0;
        this.arrayList = (T[]) new Object[capacity];
    }

    @Override
    public void addRear(T element) {
        //Method to add element at the rear of the arraylist
        try{
            expandCapacity();
        }
        catch (Exception e) {
            System.out.println("Cannot expand capacity. Your instance is likely broken.");
            return;
        }
        // System.out.println(element);
        if(this.size == 0){
            this.arrayList[this.rear] = element;
        }
        else {
            this.rear = offset(rear, +1);
            this.arrayList[this.rear] = element;
        }
        size++;
    }

    @Override
    public void addFront(T element) {
        //Method to add element at the front of the arraylist i.e. towards start
        try{
            expandCapacity();
        }
        catch (Exception e) {
            System.out.println("Cannot expand capacity. Your instance is likely broken.");
            return;
        }
        if(this.size == 0){
            this.arrayList[this.front] = element;
        }
        else {
            this.front = offset(front, -1);
            this.arrayList[this.front] = element;
        }
        size++;
    }

    public T get(int index) throws Exception {
        //Method to get element at a given index of the circularArrayList
        // offset() should accomplish what is necessary here, though it's really REALLY weird.
        return arrayList[offset(this.front, index)];
    }



    @Override
    public T remove() {
        T toReturn = this.arrayList[front];
        this.arrayList[front] = null;
        this.front++;
        this.size--;
        return toReturn;
    }
    public int getSize(){
        return this.size;
    }
    public int getRear(){
        return this.rear;
    }
    public int getFront(){
        return this.front;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public String asString() throws Exception {
        String toReturn = "[";
        for(int i = 0; i < this.size-2; i++){
            toReturn += String.format("%s, ", get(i));
        }
        toReturn += String.format("%s]", get(this.size-1));
        return toReturn;
    }

    private int offset(int startIndex, int offsetAmount){
        int toReturn = (this.arrayList.length + startIndex + offsetAmount) % this.arrayList.length;
        // System.out.format("Offset gives %s from %s and %s\n", toReturn, startIndex, offsetAmount);
        return (this.arrayList.length + startIndex + offsetAmount) % this.arrayList.length;
    }

    private void expandCapacity() throws Exception{
        if(size != capacity) {
            return;
        }
        this.capacity *= 2;
        T[] newArrayList = (T[]) new Object[capacity];
        T[] oldArrayList = this.arrayList;
        for(int i = this.front; i < oldArrayList.length; i++){
            int newIndex = this.front - oldArrayList.length + newArrayList.length;
            newArrayList[newIndex] = oldArrayList[i];
        }
        for(int i = 0; i <= this.rear; i++){
            newArrayList[i] = oldArrayList[i];
        }
        this.arrayList = newArrayList;
    }

}
