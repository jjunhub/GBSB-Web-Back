package com.dogbalbirdbal.database.data;

import java.util.ArrayList;

public class RouteInfo {
    public ArrayList[][] MakeRoute(){
        ArrayList[][] FoodLocation = new ArrayList[4][];
        //  FoodLocation[0] = 부산, FoodLocation[1] = 대구, FoodLocation[2] = 수원
        //  FoodLocation[n][0] = 힐링, FoodLocation[n][1] = 식도락, FoodLocation[n][2] = 커플

        FoodLocation[0] = new ArrayList[3]; // 부산
        FoodLocation[0][0] = new ArrayList<>(); // 부산 힐링
        FoodLocation[0][0].add(new DataSet_URL("감천문화마을", "https://a.cdn-hotels.com/gdcs/production132/d545/0870f01b-96ec-4854-98b6-72dfc747fa92.jpg?impolicy=fcrop&w=1600&h=1066&q=medium",
                "https://map.naver.com/v5/entry/place/21884707?c=14360910.6217881,4177294.2364293,15,0,0,0,dh", "부산광역시 사하구 감내1로 200"));
        FoodLocation[0][0].add(new DataSet_URL("동백섬", "https://media.triple.guide/triple-cms/c_limit,f_auto,h_1024,w_1024/7d64cf8e-4adc-4b6c-b53d-e01ea70d55b9.jpeg",
                "https://map.naver.com/v5/search/%EB%8F%99%EB%B0%B1%EC%84%AC?c=14376689.6809337,4184817.9801856,15,0,0,0,dh", "부산광역시 해운대구 우1동 783-1"));
        FoodLocation[0][0].add(new DataSet_URL("범어사", "https://www.visitbusan.net/uploadImgs/files/cntnts/20191230190106794_oen",
                "https://map.naver.com/v5/search/%EB%B2%94%EC%96%B4%EC%82%AC?c=14367824.9804448,4202515.9354916,18.01,0,0,0,dh", "부산광역시 금정구 범어사로 250"));
        FoodLocation[0][0].add(new DataSet_URL("태종대", "https://www.visitbusan.net/uploadImgs/files/cntnts/20221215173025725_oen",
                "https://map.naver.com/v5/search/%ED%83%9C%EC%A2%85%EB%8C%80?c=14369925.0845300,4171371.8330982,15.72,0,0,0,dh", "부산광역시 영도구 전망로 24"));
        FoodLocation[0][0].add(new DataSet_URL("송정해수욕장", "https://a.cdn-hotels.com/gdcs/production81/d1958/660649a2-7183-4376-ba6d-fa9c72847c83.jpg",
                "https://map.naver.com/v5/search/%EC%86%A1%EC%A0%95%ED%95%B4%EC%88%98%EC%9A%95%EC%9E%A5?c=14382300.7414847,4188100.6353477,15.91,0,0,0,dh", "부산광역시 해운대구 송정동"));
        FoodLocation[0][0].add(new DataSet_URL("해동용궁사", "https://a.cdn-hotels.com/gdcs/production194/d969/ce3eef2e-2e5d-44c3-b0ee-99c3d3bb991e.jpg?impolicy=fcrop&w=800&h=533&q=medium",
                "https://map.naver.com/v5/search/%ED%95%B4%EB%8F%99%EC%9A%A9%EA%B6%81%EC%82%AC?c=14385022.9645746,4189538.2833944,17.88,0,0,0,dh", "부산광역시 기장군 기장읍 시랑리"));

        FoodLocation[1] = new ArrayList[3]; // 대구.
        FoodLocation[1][1] = new ArrayList<>(); // 대구 식도락
        FoodLocation[1][1].add(new DataSet_URL("안지랑곱창골목", "http://www.newstory24.com/news/photo/201812/415_420_46.jpg",
                "https://map.naver.com/v5/search/%EC%95%88%EC%A7%80%EB%9E%91%EA%B3%B1%EC%B0%BD%EA%B3%A8%EB%AA%A9/place/21198304?c=14312904.7761676,4278259.1493925,18.75,0,0,0,dh", "대구 남구 안지랑로16길 67"));
        FoodLocation[1][1].add(new DataSet_URL("서문시장역", "https://w.namu.la/s/1875612d35fb3e46d8ae3a6a6d4677cb50313b6cb0b751522a0a5507da6b7e796a598ec76e8580fedb7554890012bc5ac00c85108e11039c4f90c2a6ee873096ec91fa7a394b3c1c02f0c771307fbbf56fd75725288ae86547c70ffc47651b53d35dbdb8ee31aa3bbc0af06077c5b0be",
                "https://map.naver.com/v5/entry/place/35658742?c=14313670.6861756,4282684.1270241,19.45,0,0,0,dh","대구 중구 대신동"));
        FoodLocation[1][1].add(new DataSet_URL("염매시장", "https://www.yeongnam.com/mnt/file/202012/2020122001000680600028084.jpg",
                "https://map.naver.com/v5/search/%EC%97%BC%EB%A7%A4%EC%8B%9C%EC%9E%A5/place/16156229?c=14314778.8153669,4282317.7904906,19.02,0,0,0,dh", "대구 중구 남성로 158-1"));
        FoodLocation[1][1].add(new DataSet_URL("동성로", "https://www.코리아투데이뉴스.com/imgdata/koreatodaynews_com/202005/2020050518147873.jpg",
                "https://map.naver.com/v5/search/%EB%8F%99%EC%84%B1%EB%A1%9C/place/13491008?c=14315288.4973175,4283309.3399872,17.88,0,0,0,dh&placePath=%3Fentry%253Dbmp", "대구 중구 용덕동 12"));
        FoodLocation[1][1].add(new DataSet_URL("동인동찜갈비골목", "https://ldb-phinf.pstatic.net/20150206_132/1423211224736OLGx8_JPEG/%B4%EB%B1%B8_%B5%BF%C0%CE%B5%BF%C2%F2%B0%A5%BA%F1%B0%F1%B8%F1_1.JPG?type=m500_500",
                "https://map.naver.com/v5/search/%EB%8F%99%EC%9D%B8%EB%8F%99%EC%B0%9C%EA%B0%88%EB%B9%84%EA%B3%A8%EB%AA%A9/place/19497205?c=14315367.8343872,4282720.6885999,15.72,0,0,0,dh", "대구 중구 동인동1가"));
        FoodLocation[1][1].add(new DataSet_URL("수성못", "https://tour.daegu.go.kr/icms/tour/file/getImage.do;jsessionid=97A59807260711162C6690A0392FB706.tomcat_2?atchFileId=FILE_KOATTR_120%20%20%20%20%20&fileSn=3506",
                "https://map.naver.com/v5/search/%EC%88%98%EC%84%B1%EB%AA%BB/place/13470879?c=14317926.9413972,4276784.6852814,16.49,0,0,0,dh&placePath=%2Fphoto%3Fentry%253Dbmp", "대구 수성구 두산동"));

        FoodLocation[2] = new ArrayList[3]; // 수원
        FoodLocation[2][2] = new ArrayList<>(); // 수원 커플
        FoodLocation[2][2].add(new DataSet_URL("행리단길", "https://blog.kakaocdn.net/dn/dgbs7V/btrLns31MBh/51VIpXuCpLSTsduXhA1k6K/img.jpg",
                "https://map.naver.com/v5/search/%ED%96%89%EB%A6%AC%EB%8B%A8%EA%B8%B8/place/1220976474?c=14138861.2807327,4478955.9675938,17.06,0,0,0,dh&placePath=%3Fentry%253Dbmp", "경기 수원시 팔달구 화서문로 43"));
        FoodLocation[2][2].add(new DataSet_URL("수원공방거리", "http://tong.visitkorea.or.kr/cms/resource/15/2667415_image2_1.jpg",
                "https://map.naver.com/v5/search/%EC%88%98%EC%9B%90%EA%B3%B5%EB%B0%A9%EA%B1%B0%EB%A6%AC/place/719865396?c=14139242.7157327,4478066.4358409,19.5,0,0,0,dh", "경기 수원시 팔달구 남창동"));
        FoodLocation[2][2].add(new DataSet_URL("화성행궁", "https://img1.daumcdn.net/thumb/R1280x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/3fuW/image/cSG2A3eZP5rL0WhwkppkVPs0Gok",
                "https://map.naver.com/v5/search/%ED%99%94%EC%84%B1%ED%96%89%EA%B6%81/place/31169145?c=14139108.8920688,4478462.5396039,18.46,0,0,0,dh&placePath=%3Fentry%253Dbmp", "경기 수원시 팔달구 정조로 825"));
        FoodLocation[2][2].add(new DataSet_URL("나혜석거리", "https://t1.daumcdn.net/thumb/R720x0/?fname=http://t1.daumcdn.net/brunch/service/user/5xq2/image/f1YDvgW_HX-nitvqDTkpLKhulrI.jpeg",
                "https://map.naver.com/v5/search/%EB%82%98%ED%98%9C%EC%84%9D%EA%B1%B0%EB%A6%AC/place/1325594997?c=14141411.0155140,4475957.5498229,18.94,0,0,0,dh", "경기 수원시 팔달구 권광로188번길 25-2"));
        FoodLocation[2][2].add(new DataSet_URL("광교카페거리", "https://ggtour.or.kr/cgi/upload_img/20209331614_editor_image.jpg",
                "https://map.naver.com/v5/search/%EA%B4%91%EA%B5%90%EC%B9%B4%ED%8E%98%EA%B1%B0%EB%A6%AC/place/1334830986?c=14143533.4091568,4480232.2386402,18.06,0,0,0,dh", "경기 수원시 영통구 센트럴파크로127번길 51"));
        FoodLocation[2][2].add(new DataSet_URL("광교호수공원", "https://www.suwon.go.kr/common-upload/upload/visitsuwon/2018/6/1/ce135282-8f09-4953-8cc2-03fdb60f377b.png",
                "https://map.naver.com/v5/search/%EA%B4%91%EA%B5%90%ED%98%B8%EC%88%98%EA%B3%B5%EC%9B%90/place/20815787?c=14145224.2196391,4478556.8988009,16.81,0,0,0,dh&placePath=%3Fentry%253Dbmp", "경기 수원시 영통구 광교호수로 165"));


        return FoodLocation;
    }

}
