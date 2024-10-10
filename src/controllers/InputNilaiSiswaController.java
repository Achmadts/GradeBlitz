package controllers;

import models.InputNilaiSiswaModel;

public class InputNilaiSiswaController {

    private InputNilaiSiswaModel model;

    public InputNilaiSiswaController() {
        this.model = new InputNilaiSiswaModel();
    }

    public String getGuruMapel(int userId) {
        return model.getGuruMapel(userId);
    }

    public boolean saveNilaiSiswa(String nisSiswa, String namaMapel, int userId, String nilai) {
        int mapelId = model.getMapelId(namaMapel);
        if (mapelId == -1) {
            return false;
        }
        return model.insertNilai(nisSiswa, mapelId, userId, nilai);
    }
}
