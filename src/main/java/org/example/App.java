package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

class File {
    String name;
    int size;
    String type;

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", type='" + type + '\'' +
                '}';
    }
}
class Files {
    File[] files;
    int count;

    @Override
    public String toString() {
        return "Files{" +
                "files=" + Arrays.toString(files) +
                ", count=" + count +
                '}';
    }

    public void setCount() {
        if (this.count != files.length) {
            this.count = files.length;
            System.out.println("Invalid count in JSON");
        }
    }
}
public class App 
{
    static final String JSON = """
[ { "name": "1.txt", "size": 1234, "type": "txt" }, { "name": "2.png", "size": 456, "type": "png" }]
    """;
    static final String JSON_2 = """
 { "count": 3, "files": [ { "name": "1.txt", "size": 1234, "type": "txt" }, { "name": "2.png", "size": 456, "type": "png" } ] }
    """;

    public static void main( String[] args )
    {
        Gson gson = new GsonBuilder().create();
        File[] files = gson.fromJson(JSON, File[].class);
        System.out.println(Arrays.toString(files));

        Files files_2 = gson.fromJson(JSON_2, Files.class);
        System.out.println(files_2);
        files_2.setCount();
    }
}