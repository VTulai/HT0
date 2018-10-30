package com.epam.hometask.entity;


import com.epam.hometask.formatter.RoomFormatter;

import java.util.ArrayList;
import java.util.List;

public class Building {

    private String name;
    private List<Room> roomList;

    public Building(String name) {
        this.name = name;
        roomList = new ArrayList<>();
    }

    public void addRoom(String roomName, int roomSquare, int amountWindowsInRoom) {
        roomList.add(new Room(roomName, roomSquare, amountWindowsInRoom));
    }

    public Room getRoom(String roomName) {
        for(Room r: roomList) {
            if(r.getName().equals(roomName)) {
                return r;
            }
        }
        return null;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public String describe() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s%n", getName()));
        RoomFormatter roomFormatter = new RoomFormatter();

        for(Room room: roomList) {

            List<LightBulb> lightBulbList = new ArrayList<>();
            List<Furniture> furnitureList = new ArrayList<>();
            List<SoftFurniture> softFurnitureList = new ArrayList<>();
            for(Facilities facility: room.getFacilitiesList()) {
                switch (facility.getClass().getSimpleName()){
                    case "LightBulb":
                        lightBulbList.add((LightBulb)facility);
                        break;
                    case "Furniture":
                        furnitureList.add((Furniture)facility);
                        break;
                    case "SoftFurniture":
                        softFurnitureList.add((SoftFurniture)facility);
                }
            }

            sb.append(String.format("%8s%n", room.getName()));

            //Illuminance
            sb.append(String.format("%4s", roomFormatter.getRoomIlluminanceFormat(room, lightBulbList)));

            //Square
            sb.append(String.format("%4s", roomFormatter.getRoomSquareFormat(room, furnitureList, softFurnitureList)));

            //Furniture
            sb.append(String.format("%4s", roomFormatter.getRoomFurnitureFormat(furnitureList, softFurnitureList)));

        }
        return sb.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public String getName() {
        return name;
    }

    public boolean isEmpty() {
        return roomList.size() == 0;
    }

}
