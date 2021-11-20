run: compile
	java SongSearchApp

compile:FrontEnd.class SongSearchApp.class

SongSearchApp.class: SongSearchApp.java
	javac SongSearchApp.java

test: testcompile
	java SongSearchTests

testcompile: Integration.class

Integration.class:FrontEnd.class SongSearchTest.class

FrontEnd.class: BackEndInterface.class SearchFrontEnd.class

SearchFrontEnd.class: SearchFrontEnd.java
	javac SearchFrontEnd.java

SongSearchTest.class: SongSearchTests.java 
	javac SongSearchTests.java

BackEndInterface.class: BackEnd.class SearchBackEnd.class
       
SearchBackEnd.class: SearchBackEnd.java
	javac SearchBackEnd.java

BackEnd.class: DataWranglers.class MapADT.class HashtableMap.class

MapADT.class: MapADT.java
	javac MapADT.java

HashtableMap.class: HashtableMap.java
	javac HashtableMap.java

DataWranglers.class: SongLoader.class SongData.class

SongData.class: SongData.java
	javac SongData.java

SongLoader.class: SongLoader.java
	javac SongLoader.java
