package com.epam.TAT.hometask.service;

import com.epam.TAT.hometask.entity.MP3;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilesFolderSearch {

    private List<MP3> mp3List;

    public FilesFolderSearch() {
        mp3List = new ArrayList<>();
    }

    public void processFilesFromFolder(String path) throws IOException, TikaException, SAXException {
        File folder = new File(path);
        if(!folder.exists()) {
            throw new NullPointerException("There is no such folder here");
        }
        FindFileWithMp3Ext findFileWithMp3Ext = new FindFileWithMp3Ext();
        Mp3Info mp3Info = new Mp3Info();
        for(File file: findFileWithMp3Ext.findMp3Files(folder)) {
            List<String> params = new ArrayList<>(mp3Info.getInfo(file));
            mp3List.add(new MP3(params.get(0), params.get(1), params.get(2), params.get(3), params.get(4)));
        }
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries)
        {
            if (entry.isDirectory())
            {
                processFilesFromFolder(entry.getPath());
                continue;
            }
        }
    }

    public List<MP3> getMp3List() {
        return mp3List;
    }
}
