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
        boolean test;
        try{
            test = expandCapacity();
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
            // System.out.format("Rear is %s. Local value is %s\n", this.rear, this.arrayList[this.rear]);

            this.arrayList[this.rear] = element;
            // if(test){
            //     System.out.println("New arrayList");
            //     for(int i = 0; i < arrayList.length; i++){
            //         System.out.format("%s, ", arrayList[i]);
            //     }
            //     System.out.println();
            // }
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
        for(int i = 0; i < this.size-1; i++){
            toReturn += String.format("%s, ", get(i));
            // System.out.println(toReturn);
        }
        // toReturn += String.format("%s]", get(this.size-1));
        System.out.println(toReturn);
        return toReturn;
    }

    private int offset(int startIndex, int offsetAmount){
        // int toReturn = (this.arrayList.length + startIndex + offsetAmount) % this.arrayList.length;
        // System.out.format("Offset gives %s from %s and %s\n", toReturn, startIndex, offsetAmount);
        return (this.capacity + startIndex + offsetAmount) % this.capacity;
    }

    private boolean expandCapacity() throws Exception{
        if(size != capacity) {
            return false;
        }
        this.capacity *= 2;
        T[] newArrayList = (T[]) new Object[capacity];
        T[] oldArrayList = this.arrayList;
        for(int i = this.front; i < oldArrayList.length; i++){
            int newIndex = i - oldArrayList.length + newArrayList.length;
            // System.out.format("Old index: %s. New index: %s.\n", i, newIndex);
            newArrayList[newIndex] = oldArrayList[i];
        }
        // System.out.println(this.rear);
        for(int i = 0; i <= this.rear; i++){
            // System.out.format("This for loop visited %s.\n", i);
            newArrayList[i] = oldArrayList[i];
        }
        // System.out.println("Old arrayList");
        // for(int i = 0; i < oldArrayList.length; i++){
        //     System.out.format("%s, ", oldArrayList[i]);
        // }
        this.front = this.front + capacity/2;
        this.arrayList = newArrayList;
        return true;
    }

}
