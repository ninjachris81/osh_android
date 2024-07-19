package com.osh.ui.area;

import androidx.fragment.app.FragmentManager;

import com.osh.R;
import com.osh.actor.ActorCmds;
import com.osh.actor.ToggleActor;
import com.osh.databinding.FragmentRoomWzBinding;
import com.osh.service.IServiceContext;

import java.util.List;

public class RoomFragmentWz extends RoomFragmentBase<FragmentRoomWzBinding> {

    public RoomFragmentWz() {
    }

    public RoomFragmentWz(String roomId, String areaId, RoomViewModel.RoomPosition roomPosition) {
        super(roomId, areaId, roomPosition);
        layout = R.layout.fragment_room_wz;

        shutterModeButtons = List.of(R.id.shutterModeButtonWz0, R.id.shutterModeButtonWz1);
    }

    @Override
    protected void setBindingData() {
        binding.setAreaOverlayData(areaOverlayViewModel);
        binding.setAreaData(areaViewModel);
        binding.setRoomData(roomViewModel);
        roomViewModel.initLightStates(lightInfos.size());
        roomViewModel.initShutters(shutterInfos.size());
        roomViewModel.initTemperatures(sensorInfos.temperatureIds.size());
        roomViewModel.initHumidities(sensorInfos.humidityIds.size());
        roomViewModel.initWindowStates(sensorInfos.windowStateIds.size());
        roomViewModel.initPresences(sensorInfos.presenceIds.size());
    }

    protected void handleBackgroundClickEvent() {
        switch(areaOverlayViewModel.currentOverlay.get()) {
            case LIGHTS:
                break;
            case AUDIO:
                handleBackgroundClickEventAudio();
                break;
        }
    }

    protected void initRoom() {
        binding.lightBackgroundWZ1.setOnClickListener(view -> {
            handleBackgroundClickEvent();

            switch(areaOverlayViewModel.currentOverlay.get()) {
                case LIGHTS:
                    handleBackgroundClickEventLight(0);
                    break;
            }
        });

        binding.lightBackgroundWZ2.setOnClickListener(view -> {
            handleBackgroundClickEvent();
            switch(areaOverlayViewModel.currentOverlay.get()) {
                case LIGHTS:
                    handleBackgroundClickEventLight(1);
                    break;
            }
        });

    }
}