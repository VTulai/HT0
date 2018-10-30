package com.epam.hometask.validation;


import com.epam.hometask.entity.Building;
import com.epam.hometask.entity.Room;
import com.epam.hometask.exception.IlluminanceTooLittleException;
import com.epam.hometask.exception.IlluminanceTooMuchException;
import com.epam.hometask.exception.SpaceUsageTooMuchException;

public class BuildingValidator {

    public void validateBuilding(Building building) throws IlluminanceTooMuchException, IlluminanceTooLittleException, SpaceUsageTooMuchException {
        RoomValidator roomValidator = new RoomValidator();
        for(Room room: building.getRoomList()) {
            roomValidator.validateRoom(room);
        }
    }

}
