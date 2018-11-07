package com.epam.TAT.hometask;

import com.epam.TAT.hometask.service.GroupSongsByPerformerAndAlbum;
import com.epam.TAT.hometask.service.FilesFolderSearch;
import com.epam.TAT.hometask.service.CreateHTMLTable;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("This program is searching for mp3 files in directories and subdirectories" +
                    " and shows song's list grouped by performer and album in html file");
        }
        try {
            FilesFolderSearch filesFolderSearch = new FilesFolderSearch();
            filesFolderSearch.processFilesFromFolder(args[0]);
            new CreateHTMLTable().createTable(new GroupSongsByPerformerAndAlbum().getListHierarchy(filesFolderSearch.getMp3List()));
        } catch (IOException a) {
            System.out.println(a.getMessage());
        } catch (TikaException b) {
            System.out.println(b.getMessage());
        } catch (SAXException c) {
            System.out.println(c.getMessage());
        }

    }
}
