/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textarchiverjava;

/**
 *
 * @author Saketh
 */
public class FileProperties { //Pretty Self-Explanatory

    final long size;
    final String author;
    final String owner;
    final String dateCreated;

    public FileProperties(long size, String author, String owner, String dateCreated) {
        this.size = size;
        this.author = author;
        this.owner = owner;
        this.dateCreated = dateCreated;
    }
}
