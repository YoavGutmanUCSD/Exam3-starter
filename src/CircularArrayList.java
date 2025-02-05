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
    @Override
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
    @Override
    public int getSize(){
        return this.size;
    }
    @Override
    public int getRear(){
        return this.rear;
    }
    @Override
    public int getFront(){
        return this.front;
    }
    @Override
    public int getCapacity(){
        return this.capacity;
    }
    // public String asString() throws Exception {
    //     String toReturn = "[";
    //     for(int i = 0; i < this.size-1; i++){
    //         toReturn += String.format("%s, ", get(i));
    //     }
    //     toReturn += String.format("%s]", get(this.size-1));
    //     return toReturn;
    // }

    private int offset(int startIndex, int offsetAmount){
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
            newArrayList[newIndex] = oldArrayList[i];
        }
        for(int i = 0; i <= this.rear; i++){
            newArrayList[i] = oldArrayList[i];
        }
        this.front = this.front + capacity/2;
        this.arrayList = newArrayList;
        return true;
    }

}
