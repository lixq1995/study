package com.test.local.pojo;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class Msg {
    private List<ImageAndText> img;

    private ImageAndText text;

    /**
     * 返回一个不可修改的list
     * @return
     */
    public List<ImageAndText> getImgAndText() {
        return Collections.unmodifiableList(this.img);
    }
}
