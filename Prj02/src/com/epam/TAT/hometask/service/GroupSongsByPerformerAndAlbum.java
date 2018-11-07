package com.epam.TAT.hometask.service;

import com.epam.TAT.hometask.entity.MP3;

import java.util.ArrayList;
import java.util.List;

public class GroupSongsByPerformerAndAlbum {

    private String performer;
    private String album;
    private List<String> songs;
    private List<GroupSongsByPerformerAndAlbum> groupSongsByPerformerAndAlbumList;

    public GroupSongsByPerformerAndAlbum() {
        performer = "";
        album = "";
        songs = new ArrayList<>();
        groupSongsByPerformerAndAlbumList = new ArrayList<>();
    }

    public GroupSongsByPerformerAndAlbum(String performer, String album) {
        this.performer = performer;
        this.album = album;
        songs = new ArrayList<>();
        groupSongsByPerformerAndAlbumList = new ArrayList<>();
    }

    private void addSong(String song) {
        songs.add(song);
    }

    public String getPerformer() {
        return performer;
    }

    public String getAlbum() {
        return album;
    }

    public List<String> getSongs() {
        return songs;
    }

    public List<GroupSongsByPerformerAndAlbum> getListHierarchy(List<MP3> mp3List) {
        List<MP3> mp3CopyList = new ArrayList<>(mp3List);
        for(int i = 0; i < mp3CopyList.size() - 1; i++) {
            groupSongsByPerformerAndAlbumList.add(new GroupSongsByPerformerAndAlbum(mp3CopyList.get(i).getPerformer(), mp3CopyList.get(i).getAlbum()));
            groupSongsByPerformerAndAlbumList.get(i).addSong(mp3CopyList.get(i).getName() + " " + mp3CopyList.get(i).getDuration() + " " + mp3CopyList.get(i).getFolderLink());
            for(int j = i + 1; j < mp3CopyList.size(); j++) {
                if(mp3CopyList.get(i).getPerformer().equalsIgnoreCase(mp3CopyList.get(j).getPerformer())) {
                    if(mp3CopyList.get(i).getAlbum().equalsIgnoreCase(mp3CopyList.get(j).getAlbum())) {
                        groupSongsByPerformerAndAlbumList.get(i).addSong(mp3CopyList.get(j).getName() + " " + mp3CopyList.get(j).getDuration() + " " + mp3CopyList.get(j).getFolderLink());
                        mp3CopyList.remove(j);
                    }
                }
            }
        }
        return groupSongsByPerformerAndAlbumList;
    }

}
