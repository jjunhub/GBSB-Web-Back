package com.dogbalbirdbal.database.vo;

import com.dogbalbirdbal.database.vo.PlaceInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 하나의 Wish Box 는 여러개의 @{@link com.dogbalbirdbal.database.vo.WishList } 를 가지고 있다
 */
@Getter @Setter
public class WishBox implements Serializable {


    List<WishList> wishLists = new ArrayList<>();

    public void addWishList(WishList wishList) {

        this.wishLists.add(wishList);

    }
}
