package com.epam.TAT.hometask.service;

import java.io.File;

import java.io.FilenameFilter;

public class FindFileWithMp3Ext {

    private static final String EXTENSION = ".mp3";

    public File[] findMp3Files(File folder) {
        return folder.listFiles(new ExtFilter(EXTENSION));
    }

    private class ExtFilter implements FilenameFilter {

        private String ext;

        public ExtFilter(String ext) {
            this.ext = ext;
        }

        public boolean accept(File dir, String name) {
            return (name.toLowerCase().endsWith(ext));
        }
    }

}
