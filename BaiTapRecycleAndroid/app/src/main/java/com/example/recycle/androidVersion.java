package com.example.recycle;

public class androidVersion {
    private String name;     // Tên album
    private String version;  // Năm phát hành
    private String image;    // Tên file ảnh trong drawable

    public androidVersion(String name, String version, String image) {
        this.name = name;
        this.version = version;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getImage() {
        return image;
    }
}
