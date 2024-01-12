package com.dogbalbirdbal.database.vo;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class WishContainer {

    List<WishBox> wishBoxList = new ArrayList<>();

    public void addWishBox(WishBox wishBox ) {
        this.wishBoxList.add(wishBox);
    }
}
