package com.osh.ui.area;

import androidx.fragment.app.FragmentManager;

import com.osh.R;
import com.osh.databinding.FragmentRoomBBinding;
import com.osh.service.IServiceContext;

import java.util.List;

public class RoomFragmentB extends RoomFragmentBase<FragmentRoomBBinding> {

    public RoomFragmentB() {
    }

    public RoomFragmentB(String roomId, String areaId, RoomViewModel.RoomPosition roomPosition) {
        super(roomId, areaId, roomPosition);
        layout = R.layout.fragment_room_b;

        shutterModeButtons = List.of(R.id.shutterModeButtonB0, R.id.shutterModeButtonB1);
    }

    @Override
    protected void setBindingData() {
        binding.setAreaData(areaViewModel);
        binding.setRoomData(roomViewModel);
        roomViewModel.initLightStates(lightInfos.size());
        roomViewModel.initShutters(shutterInfos.size());
        roomViewModel.initLightStates(lightInfos.size());
        roomViewModel.initTemperatures(sensorInfos.temperatureIds.size());
        roomViewModel.initHumidities(sensorInfos.humidityIds.size());
        roomViewModel.initWindowStates(sensorInfos.windowStateIds.size());
        roomViewModel.initPresences(sensorInfos.presenceIds.size());
    }
}
