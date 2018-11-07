package com.epam.TAT.hometask.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateHTMLTable {

    public void createTable(List<GroupSongsByPerformerAndAlbum> hierarchiesList) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("Catalog.html")));
        bufferedWriter.write("<html>\n" + " <body>\n" + "  <head>\n" + "   <meta charset=\"utf-8\">\n" +
                "   <title>Catalog</title>\n" + "    <style>\n" + "     li {\n" + "      list-style-type: none;\n" +
                "     }\n" + "    </style>\n" + "   </head>\n" + "  <body>\n");
        writeFileInfo(hierarchiesList, bufferedWriter);
        bufferedWriter.write(" </body>\n" + "</html>\n");
        bufferedWriter.close();
    }

    private void writeFileInfo(List<GroupSongsByPerformerAndAlbum> hierarchiesList, BufferedWriter bufferedWriter) throws IOException {
        List<GroupSongsByPerformerAndAlbum> hierarchiesCopyList = new ArrayList<>(hierarchiesList);
        bufferedWriter.write("\t<div>\n" + "\t\t<h3>\n" + "\t\t\t<ul>\n");
        for(int i = 0; i < hierarchiesCopyList.size() - 1; i++) {
            bufferedWriter.write("\t\t\t<li>" + hierarchiesCopyList.get(i).getPerformer() + "</li>\n");
            for(int j = i + 1; j < hierarchiesCopyList.size(); j++) {
                if(hierarchiesCopyList.get(i).getPerformer().equalsIgnoreCase(hierarchiesCopyList.get(j).getPerformer())) {
                    bufferedWriter.write("\t\t\t\t<ul>\n" + "\t\t\t\t<li>" + hierarchiesCopyList.get(i).getAlbum() + "</li>\n");
                    bufferedWriter.write("\t\t\t\t\t<ul>\n");
                    for(String song: hierarchiesCopyList.get(i).getSongs()) {
                    bufferedWriter.write("\t\t\t\t\t\t<li>" + song + "</li>\n");
                    }
                    bufferedWriter.write("\t\t\t\t\t</ul>\n" + "\t\t\t\t</ul>\n");
                }
            }
        }
        bufferedWriter.write("\t\t\t</ul>\n" + "\t\t</h3>\n" + "\t</div>\n");
    }


}
