git pull origin main
classpath="src/:lib/hamcrest-core-1.3.jar:lib/junit-4.12.jar:classes/:."
# hash_map="src/DefaultMap.java src/MyHashMap.java src/MaxHeap.java src/MyHashMapTest.java"
# heap_only="src/DefaultMap.java src/MaxHeap.java src/MyHashMapTest.java"
# file_student="src/FileReader.java src/Student.java"
circular="src/ArrayListADT.java src/CircularArrayList.java src/CircularArrayListTest.java"
javac -cp ${classpath} -d classes/ $circular
java -cp $classpath org.junit.runner.JUnitCore CircularArrayListTest
