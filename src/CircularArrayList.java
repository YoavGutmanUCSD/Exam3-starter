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
        this.rear = capacity-1;
        this.arrayList = (T[]) new Object[capacity];
    }

    @Override
    public void addRear(T element) {
        //Method to add element at the rear of the arraylist
        expandCapacity();
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
        expandCapacity();
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
        this.front = offset(front, +1);
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

    private int offset(int startIndex, int offsetAmount){
        return (this.arrayList.length + startIndex + offsetAmount) % this.arrayList.length;
    }

    private void expandCapacity(){
        if(size != capacity) {
            return;
        }
        this.capacity *= 2;
        T[] newArrayList = (T[]) new Object[capacity];
        for(int i = 0; i < this.front; i++){
            newArrayList[i] = arrayList[i];
        }
        for(int i = this.size-1; i < this.rear; i--){
            newArrayList[i] = arrayList[i];
        }
    }

}
