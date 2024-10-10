package controllers;

import models.UpdateDataMapelModel;

public class UpdateDataMapelController {

    private UpdateDataMapelModel model;

    public UpdateDataMapelController(UpdateDataMapelModel model) {
        this.model = model;
    }

    public boolean updateMapel(String idMapel, String namaMapel) {
        return model.updateDataMapel(idMapel, namaMapel);
    }
}
