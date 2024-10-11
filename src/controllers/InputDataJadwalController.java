package controllers;

import models.InputDataJadwalModel;
import java.util.List;

public class InputDataJadwalController {

    private InputDataJadwalModel model;

    public InputDataJadwalController() {
        this.model = new InputDataJadwalModel();
    }

    public List<String> loadAvailableJam(String hari) {
        return model.getAvailableJam(hari);
    }

    public List<String> loadGuruList() {
        return model.getGuruList();
    }

    public List<String> loadMapelList() {
        return model.getMapelList();
    }

    public boolean saveDataJadwal(String selectedGuru, String selectedMapel, String hari, String jam, String ruang) {
        int guruId = Integer.parseInt(selectedGuru.split(" - ")[0]);
        int mapelId = Integer.parseInt(selectedMapel.split(" - ")[0]);
        return model.insertDataJadwal(guruId, mapelId, hari, jam, ruang);
    }
}
