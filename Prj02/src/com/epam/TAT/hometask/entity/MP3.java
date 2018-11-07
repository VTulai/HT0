package com.epam.TAT.hometask.entity;

public class MP3 {

    private String performer;
    private String album;
    private String name;
    private String duration;
    private String folderLink;

    public MP3() {
        setPerformer("Unknown artist");
        setAlbum("Unknown album");
        setName("Unknown song");
        setDuration("0");
        setFolderLink("");
    }

    public MP3(String performer, String album, String name, String duration, String folderLink) {
        setPerformer(performer);
        setAlbum(album);
        setName(name);
        setDuration(duration);
        setFolderLink(folderLink);
    }

    public String getPerformer() {
        return performer;
    }

    public String getFolderLink() {
        return folderLink;
    }

    public void setFolderLink(String folderLink) {
        this.folderLink = folderLink;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getAlbum() {
        return album;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

