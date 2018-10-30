package com.epam.hometask.service;


import com.epam.hometask.entity.Furniture;
import com.epam.hometask.entity.SoftFurniture;

import java.util.ArrayList;
import java.util.List;

public class SquareCalcService {
    public List<Double> calcSquare(List<Furniture> furnitureList, List<SoftFurniture> softFurnitureList) {
        double square = 0;
        double minSquare = 0;
        double maxSquare = 0;
        for(Furniture furniture: furnitureList) {
            square += furniture.getSquare();
        }
        for(SoftFurniture softFurniture: softFurnitureList) {
            minSquare += softFurniture.getMinSquare();
            maxSquare += softFurniture.getMaxSquare();
        }
        List<Double> listDeltaSquare = new ArrayList<>();
        listDeltaSquare.add(minSquare + square);
        listDeltaSquare.add(maxSquare + square);
        return listDeltaSquare;
    }
}
