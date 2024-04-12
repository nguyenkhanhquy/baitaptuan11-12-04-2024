package vn.iotstar.baitaptuan11_21110282_recycleviewindicatorsearch;

import java.io.Serializable;

public class IconModel implements Serializable {
    private Integer imgId;
    private String desc;

    public IconModel(Integer imgId, String desc) {
        this.imgId = imgId;
        this.desc = desc;
    }

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
