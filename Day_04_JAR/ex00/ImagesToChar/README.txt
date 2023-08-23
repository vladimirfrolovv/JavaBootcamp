#delete target
rm -rf target

#create target
mkdir target

#compile .java file and move in target
javac -d ./target src/java/edu/school21/printer/*/*.java

#run
java -classpath target edu.school21.printer.app.Program --white=. --black=0 /home/fixierad/project/JavaBootcamp/Java_Bootcamp.Day04-1/src/ex00/ImagesToChar/it.bmp