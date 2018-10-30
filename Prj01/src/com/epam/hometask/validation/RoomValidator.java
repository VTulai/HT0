package com.epam.hometask.validation;


import com.epam.hometask.entity.Room;
import com.epam.hometask.exception.IlluminanceTooLittleException;
import com.epam.hometask.exception.IlluminanceTooMuchException;
import com.epam.hometask.exception.SpaceUsageTooMuchException;

public class RoomValidator {

    private static final int MIN_ILLUMINANCE = 300;
    private static final int MAX_ILLUMINANCE = 4000;
    private static final double MAX_OCCUPIED_AREA_DELTA = 0.7;

    public void validateRoom(Room room) throws SpaceUsageTooMuchException, IlluminanceTooMuchException, IlluminanceTooLittleException {
        double roomIlluminance = room.getIlluminance();
        if(roomIlluminance <= MIN_ILLUMINANCE) {
            throw new IlluminanceTooLittleException("Room illuminance must be above " + MIN_ILLUMINANCE + "!");
        } else if (roomIlluminance >= MAX_ILLUMINANCE) {
            throw new IlluminanceTooMuchException("Room illuminance must be less than " + MAX_ILLUMINANCE + "!");
        }
        if(room.getOccupiedArea() > MAX_OCCUPIED_AREA_DELTA * room.getSquare()) {
            throw new SpaceUsageTooMuchException("Occupied area can't be above " + MAX_OCCUPIED_AREA_DELTA * 100 + "% of room square!");
        }
    }

}
