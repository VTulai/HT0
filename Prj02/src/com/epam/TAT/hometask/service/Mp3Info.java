package com.epam.TAT.hometask.service;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mp3Info {

    public List<String> getInfo(File file) throws IOException, TikaException, SAXException {
        List<String> mp3Parameters = new ArrayList<>();
        Parser parser = new Mp3Parser();
        ContentHandler handler = new DefaultHandler();
        Metadata metadata = new Metadata();
        FileInputStream inputstream = new FileInputStream(file);
        ParseContext context = new ParseContext();

        parser.parse(inputstream, handler, metadata, context);

        mp3Parameters.add(metadata.get("xmpDM:artist"));
        mp3Parameters.add(metadata.get("xmpDM:album"));
        mp3Parameters.add(metadata.get("title"));
        mp3Parameters.add(getDuration(Double.parseDouble(metadata.get("xmpDM:duration"))));
        mp3Parameters.add(file.getPath());
        return mp3Parameters;
    }

    public String getDuration(double milli) {
        return (new SimpleDateFormat("mm:ss")).format(new Date((long)milli));
    }

}
