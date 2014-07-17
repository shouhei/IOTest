#標準入力と標準出力のテスト

##用意すべきもの
hamcrest-core-1.3.jar
junit-4.11.jar


##想定

プロダクトコードとテストコードが同階層に存在し、
hamcrest-core-1.3.jarとjunit-4.11.jarが親ディレクトリに存在する

##実行手順

### プロダクトコードのコンパイル

```
javac Hello.java
```

* テストコードのコンパイル

```
javac -classpath .:../junit-4.11.jar:../hamcrest-core-1.3.jar TestHello.java
```

* テストコードの実行

```
java -classpath .:../junit-4.11.jar:../hamcrest-core-1.3.jar org.junit.runner.JUnitCore TestHello
```
