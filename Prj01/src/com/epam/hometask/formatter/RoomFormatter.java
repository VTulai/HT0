package com.epam.hometask.formatter;

import com.epam.hometask.entity.Furniture;
import com.epam.hometask.entity.LightBulb;
import com.epam.hometask.entity.Room;
import com.epam.hometask.entity.SoftFurniture;
import com.epam.hometask.service.SquareCalcService;

import java.util.ArrayList;
import java.util.List;

public class RoomFormatter {

    public String getRoomIlluminanceFormat(Room room, List<LightBulb> lightBulbList) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%10s", "Illuminance = " + room.getIlluminance()));
        if(room.getAmountWindows() == 1) {
            sb.append(String.format("%10s", " (" + room.getAmountWindows() + " window with 700 lk, "));
        } else if(room.getAmountWindows() > 1){
            sb.append(String.format("%10s", " (" + room.getAmountWindows() + " windows with 700 lk, "));
        }

        if(lightBulbList.size() == 0) {
            sb.replace(sb.length() - 2,sb.length(), ")");
            sb.append("\n");
        } else if(lightBulbList.size() == 1) {
            sb.append(String.format("%10s", lightBulbList.size() + " light bulb with " + lightBulbList.get(0).getIlluminance() + " lk)"));
        } else if(lightBulbList.size() > 1) {
            sb.append(String.format("%10s", lightBulbList.size() + " light bulbs with: "));
            for(LightBulb bulb: lightBulbList) {
                sb.append(String.format("%10s", bulb.getIlluminance() + " lk, "));
            }
            sb.replace(sb.length() - 2,sb.length(), ")");
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getRoomSquareFormat(Room room, List<Furniture> furnitureList, List<SoftFurniture> softFurnitureList) {
        StringBuilder sb = new StringBuilder();
        List<Double> listDeltaSquare = new ArrayList<>(new SquareCalcService().calcSquare(furnitureList, softFurnitureList));
        sb.append(String.format("%10s", "Square = " + room.getSquare() + " m^2"));
        if(furnitureList.size() == 0 && softFurnitureList.size() == 0) {
            sb.append(String.format("%10s", " (100% of room square is free)\n"));
        } else if (furnitureList.size() != 0 && softFurnitureList.size() == 0){
            sb.append(String.format("%10s", " (" + room.getOccupiedArea() + " m^2 is occupied, " + (room.getSquare() - room.getOccupiedArea()) + " m^2 or " + (((room.getSquare() - room.getOccupiedArea()) / room.getSquare()) * 100) + "% is guaranteed free)\n"));
        } else {
            sb.append(String.format("%10s", " (" + listDeltaSquare.get(0) + " - " + listDeltaSquare.get(1) + " m^2 is occupied, " + (room.getSquare() - listDeltaSquare.get(1)) + " m^2 or " + (((room.getSquare() - listDeltaSquare.get(1)) / room.getSquare()) * 100) + "% is guaranteed free)\n"));
        }
        return sb.toString();
    }

    public String getRoomFurnitureFormat(List<Furniture> furnitureList, List<SoftFurniture> softFurnitureList) {
        StringBuilder sb = new StringBuilder();
        if((furnitureList.size() == 0) && (softFurnitureList.size() == 0)) {
            sb.append(String.format("%10s", "There is no furniture in the room"));
        } else {
            sb.append(String.format("%10s%n", "Furniture: "));
            for(Furniture furniture: furnitureList) {
                sb.append(String.format("%12s%n", furniture.toString()));
            }
            for(SoftFurniture softFurniture: softFurnitureList) {
                sb.append(String.format("%12s%n", softFurniture.toString()));
            }
        }
        return sb.toString();
    }

}
