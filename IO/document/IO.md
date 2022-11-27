
# Java IO Stream

在 Java 中所有 IO 类都是基于 InputStream 和 OutputStream 这两个抽象类。
InputStream 和 OutputStream 分别提供了 read 和 write 方法来读取、写入***字节***。
这两个方法在执行时都会阻塞线程。

使用 available() 方法来提前判断流中可读字节，可以使得 read() 不被阻塞。
```java
int byteAvailable = in.available();
if (byteAvailable > 0) {
    byte[] data = new byte[byteAvailable];
    in.read(data);    
}
```

## 文本的输入与输出:

OutputStreamWriter 和 InputStreamReader 可以在字节流和 Unicode 码元流中自由的转换。