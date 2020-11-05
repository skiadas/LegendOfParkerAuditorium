package core;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class AssetReader {
    private String filePath;

    public AssetReader(String filePath) {
        this.filePath = filePath;
    }

    public void printFileTxt(){
        InputStream is = getClass().getClassLoader().getResourceAsStream(filePath);
        assert is != null;
        InputStreamReader fileReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(fileReader);
        reader.lines().forEach(System.out::println);
    }
}
