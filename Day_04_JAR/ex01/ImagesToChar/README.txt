#delete target
rm -rf target

#create target
mkdir target

#compile .java file and move in target
javac `find . -name "*.java"` -d target

#copy resources
cp -R src/resources target/.

#add jar file
jar cfm ./target/images-to-chars-printer.jar src/manifest.txt -C target .

#run
java -jar target/images-to-chars-printer.jar --white=. --black=0