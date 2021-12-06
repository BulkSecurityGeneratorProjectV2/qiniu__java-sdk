package com.qiniu.rtc.model;

import lombok.Data;

import java.util.List;

@Data
public class WatermarksParam {

    private List<Watermarks> watermarks;

    @Data
    public static class Watermarks {
        private String url;
        private int x;
        private int y;
        private int w;
        private int h;
        private String stretchMode;
    }
}
