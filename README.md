# SuprNationTestAssignment

## Prerequisites
To launch the application you must have java and scala environment installed on your computer
To build application with sbt you must have it installed

## Launch
You can launch the application directly if IDE, or use other preferred way.
However, I suggest to use following flow:
* run `sbt assembly` in project root directory
* after building finished run the application with `java -jar target/scala-2.13/MinTrianglePath.jar`
* if you are using unix-like system you can run initial data from file by 
`cat test_data/test.txt | java -jar target/scala-2.13/MinTrianglePath.jar`

**You can choose comparison algorithm (Max or Min path) by passing "max" or "min" as java argument**

*Please note that by default algorithm is min path*