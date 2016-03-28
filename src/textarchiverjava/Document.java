/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textarchiverjava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saketh
 */
public class Document {

    final public String name;
    final public String filePath;
    final public FileProperties properties;

    public Document(String name, String filePath, String author) {
        this.name = name;
        this.filePath = filePath;
        long size = 0;
        String creationDate = "0000/00/00";//Format : YYYY/MM/DD
        String owner = "Unknown";// Init with 'Unknown owner'.
        try {
            Path path = Paths.get(filePath);
            owner = Files.getOwner(path).getName();//Get owner name if possible
            BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
            size = attr.size();
            creationDate = attr.creationTime().toString().substring(0, 10);//Extracting date from date:time format
        } catch (IOException ex) {
            Logger.getLogger(Document.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.properties = new FileProperties(size, author, owner, creationDate);// Create FileProperties with default or given Attributes
        }
    }
}
