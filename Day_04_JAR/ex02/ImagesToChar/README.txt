#delete target
rm -rf target
rm -rf lib

#create target
mkdir target
mkdir lib
#download libs jcomander & jcolor
curl https://repo1.maven.org/maven2/com/beust/jcommander/1.82/jcommander-1.82.jar -o lib/jcommander-1.82.jar
curl https://repo1.maven.org/maven2/com/diogonunes/JColor/5.5.1/JColor-5.5.1.jar -o lib/JColor-5.5.1.jar

#jar into target
cd target && jar xf ../lib/jcommander-1.82.jar && jar xf ../lib/JColor-5.5.1.jar && rm -rf META-INF && cd ..

#compile libs and java files
javac -cp lib/\* `find . -name "*.java"` -d target

#copy
cp -R src/resources target/.

#add jar file
jar cfm  ./target/images-to-chars-printer.jar src/manifest.txt -C target .

#run
java -jar target/images-to-chars-printer.jar --white=RED --black=GREEN
