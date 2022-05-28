classpath="src/:lib/hamcrest-core-1.3.jar:lib/junit-4.12.jar:classes/:."
hash_map="src/DefaultMap.java src/MyHashMap.java src/MaxHeap.java src/MyHashMapTest.java"
file_student="src/FileReader.java src/Student.java"
javac -cp ${classpath} -d classes/ $hash_map # $file_student
java -cp $classpath MyHashMapTest
# javac -cp ${classpath} -d classes/ src/ArrayListADT.java
# javac -cp ${classpath} -d classes/ src/CircularArrayList.java
# javac -cp ${classpath} -d classes/ src/CircularArrayListTest.jav
# javac -cp ${classpath} -d classes/ src/DefaultMap.java
# javac -cp ${classpath} -d classes/ src/FileReader.java
# javac -cp ${classpath} -d classes/ src/MaxHeap.java
# javac -cp ${classpath} -d classes/ src/MyHashMap.java
# javac -cp ${classpath} -d classes/ src/MyHashMapTest.java
# javac -cp ${classpath} -d classes/ src/Student.java


# javac -cp ${classpath} -d classes/ src/ArrayListADT.java
# javac -cp ${classpath} -d classes/ src/CircularArrayList.java
# javac -cp ${classpath} -d classes/ src/CircularArrayListTest.java
