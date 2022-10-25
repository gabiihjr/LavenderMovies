package com.api.lavendermovies.domain.entities;

public enum Genre {
    ACTION(1),
    ROMANCE(2),
    THRILLER(3),
    SPORTS(4),
    COMEDY(5),
    SCIFI(6),
    HORROR(7),
    MUSICAL(8);

    private int code;

    private Genre(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Genre valueOf(int code) {
        for (Genre value : Genre.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Genre code!");
    }
}
