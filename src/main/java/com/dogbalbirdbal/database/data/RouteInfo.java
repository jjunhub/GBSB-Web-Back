package com.dogbalbirdbal.database.data;

import java.util.ArrayList;

public class RouteInfo {
    public ArrayList[][] MakeRoute(){
        ArrayList[][] FoodLocation = new ArrayList[4][];
        //  FoodLocation[0] = 부산, FoodLocation[1] = 대구, FoodLocation[2] = 수원
        //  FoodLocation[n][0] = 힐링, FoodLocation[n][1] = 음식, FoodLocation[n][2] = 커플

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
        FoodLocation[0][0].add(new DataSet_URL("해동용궁사", "https://a.cdn-hotels.com/gdcs/production194/d969/ce3eef2e-2e5d-44c3-b0ee-99c3d3bb991e.jpg?impolicy=fcrop&w=800&h=533&q=medium",
                "https://map.naver.com/v5/search/%ED%95%B4%EB%8F%99%EC%9A%A9%EA%B6%81%EC%82%AC?c=14385022.9645746,4189538.2833944,17.88,0,0,0,dh", "부산광역시 기장군 기장읍 시랑리"));
        FoodLocation[0][0].add(new DataSet_URL("송정해수욕장", "https://a.cdn-hotels.com/gdcs/production81/d1958/660649a2-7183-4376-ba6d-fa9c72847c83.jpg",
                "https://map.naver.com/v5/search/%EC%86%A1%EC%A0%95%ED%95%B4%EC%88%98%EC%9A%95%EC%9E%A5?c=14382300.7414847,4188100.6353477,15.91,0,0,0,dh", "부산광역시 해운대구 송정동"));


        FoodLocation[0][1] = new ArrayList<>(); // 부산 음식
        FoodLocation[0][1].add(new DataSet_URL("서면역", "https://steemitimages.com/DQmUKSgo3pr1Sj2wmUZR3EVT8X1vfCJzz1srhQecK5XaaPK/1304561925_DPP_0691a.jpg",
                "https://map.naver.com/v5/search/%EC%84%9C%EB%A9%B4%EC%97%AD?c=14366597.3334096,4185132.1770296,16.11,0,0,0,dh", "부산 부산진구 부전동"));
        FoodLocation[0][1].add(new DataSet_URL("남포동", "https://a.cdn-hotels.com/gdcs/production36/d10/45f075e3-5b5a-46cc-8f68-4544c2a9d8b8.jpg",
                "https://map.naver.com/v5/search/%EB%82%A8%ED%8F%AC%EB%8F%99%EB%A7%9B%EC%A7%91?c=14363545.1208631,4177206.7051922,15.5,0,0,0,dh", "부산광역시 중구 남포동"));
        FoodLocation[0][1].add(new DataSet_URL("부경대", "https://w.namu.la/s/55e0e29e6a5f78822530ca4b8c98a320767e2b1a66207b7bf0b42c37b4f6f7b1572c3b1a2b226d3d7bf6b3ac68ea7d9fcb8afb77f5c07d12a7e324b2bbe8328471f5cb8a03ef1fb0b1dacd00742aa1cc16fd651d12f57ff56b953a9ad2b6935e",
                "https://map.naver.com/v5/search/%EB%B6%80%EA%B2%BD%EB%8C%80/place/12104897?c=14371204.2264295,4182046.5839493,15,0,0,0,dh&placePath=%3Fentry%253Dbmp", "부산 남구 대연동"));
        FoodLocation[0][1].add(new DataSet_URL("부산역", "https://mblogthumb-phinf.pstatic.net/MjAxODAzMDdfMjEz/MDAxNTIwNDA1NDQ4MTk1.b97cVtJQaLCuU8i6K9YGyU2BAQ1bASqWuA8APgq-FIUg.MACN4P29231-_OYRvaG6T_WS_Z43ObdXKB3aHfo0Lzog.JPEG.tmddlf/bss1.JPG?type=w800 ",
                "https://map.naver.com/v5/search/%EB%B6%80%EC%82%B0%EC%97%AD/place/13479631?c=14363848.0624738,4179678.1329803,15.05,0,0,0,dh&placePath=%3Fentry%253Dbmp", "부산 동구 초량동"));
        FoodLocation[0][1].add(new DataSet_URL("해리단길카페", "https://www.busan.go.kr/ImagePrint.do?dir=smartEditor&savename=fd3561693e4b4c93bfb7a0093159a54c&realname=4-5-1.jpg&fileext=jpg&filetype=image/jpeg&filesize=284244",
                "https://map.naver.com/v5/search/%ED%95%B4%EB%A6%AC%EB%8B%A8%EA%B8%B8%EC%B9%B4%ED%8E%98?c=14377772.1842158,4186344.9638688,16.19,0,0,0,dh", "부산 해운대구 우동"));
        FoodLocation[0][1].add(new DataSet_URL("부산 기장", "https://t1.daumcdn.net/thumb/R720x0/?fname=http://t1.daumcdn.net/brunch/service/user/3rYK/image/uE9iZW0VytqZHEu85gRHGZ5H3vU.jpg",
                "https://map.naver.com/v5/search/%EB%B6%80%EC%82%B0%20%EA%B8%B0%EC%9E%A5%EC%9D%8D/address/14384232.227179546,4196371.804507967,%EB%B6%80%EC%82%B0%EA%B4%91%EC%97%AD%EC%8B%9C%20%EA%B8%B0%EC%9E%A5%EA%B5%B0%20%EA%B8%B0%EC%9E%A5%EC%9D%8D,adm?c=14383619.6719501,4195086.0793752,13.16,0,0,0,dh&isCorrectAnswer=true", "부산광역시 기장군 기장읍"));

        FoodLocation[0][2] = new ArrayList<>(); // 부산 커플
        FoodLocation[0][2].add(new DataSet_URL("부산기장", "https://t1.daumcdn.net/thumb/R720x0/?fname=http://t1.daumcdn.net/brunch/service/user/3rYK/image/uE9iZW0VytqZHEu85gRHGZ5H3vU.jpg",
                "https://map.naver.com/v5/search/%EB%B6%80%EC%82%B0%20%EA%B8%B0%EC%9E%A5%EC%9D%8D/address/14384232.227179546,4196371.804507967,%EB%B6%80%EC%82%B0%EA%B4%91%EC%97%AD%EC%8B%9C%20%EA%B8%B0%EC%9E%A5%EA%B5%B0%20%EA%B8%B0%EC%9E%A5%EC%9D%8D,adm?c=14383619.6719501,4195086.0793752,13.16,0,0,0,dh&isCorrectAnswer=true", "부산광역시 기장군 기장읍"));
        FoodLocation[0][2].add(new DataSet_URL("부산송도해수욕장", "https://image.goodchoice.kr/resize_1000X500x0/affiliate/2020/07/29/5f213fcbb06f4.jpg",
                "https://map.naver.com/v5/search/%EB%B6%80%EC%82%B0%EC%86%A1%EB%8F%84%ED%95%B4%EC%88%98%EC%9A%95%EC%9E%A5?c=14362199.2727897,4174068.5462002,15.51,0,0,0,dh&isCorrectAnswer=true", "부산 서구 암남동"));
        FoodLocation[0][2].add(new DataSet_URL("달맞이길", "https://www.visitbusan.net/uploadImgs/files/cntnts/20191225172829631_oen",
                "https://map.naver.com/v5/entry/place/13491814?c=14380617.2109276,4186539.2032906,13.82,0,0,0,dh&isCorrectAnswer=true", "부산 해운대구 달맞이길 190"));
        FoodLocation[0][2].add(new DataSet_URL("광안리해수욕장", "https://t1.daumcdn.net/cfile/tistory/1540EF394FAFC3E117",
                "https://map.naver.com/v5/search/%EA%B4%91%EC%95%88%EB%A6%AC%ED%95%B4%EC%88%98%EC%9A%95%EC%9E%A5?c=14373291.7336266,4184581.8241267,15.34,0,0,0,dh&isCorrectAnswer=true", "부산 수영구 민락동"));
        FoodLocation[0][2].add(new DataSet_URL("동백섬", "https://www.visitbusan.net/uploadImgs/files/cntnts/20191225173712086_oen",
                "https://map.naver.com/v5/search/%EB%8F%99%EB%B0%B1%EC%84%AC/place/11491874?c=14376499.5181181,4184843.7417284,15.57,0,0,0,dh&placePath=%3Fentry%253Dbmp", "부산 해운대구 우동"));
        FoodLocation[0][2].add(new DataSet_URL("부산센텀시티", "https://visitbusan.net/uploadImgs/files/cntnts/20200205165858664_ttiel",
                "https://map.naver.com/v5/search/%EB%B6%80%EC%82%B0%EC%84%BC%ED%85%80%EC%8B%9C%ED%8B%B0?c=14374821.1371108,4186894.4971320,15.4,0,0,0,dh&isCorrectAnswer=true", "부산 해운대구 우동"));


        FoodLocation[1] = new ArrayList[3]; // 대구.
        FoodLocation[1][0] = new ArrayList<>(); // 대구 힐링
        FoodLocation[1][0].add(new DataSet_URL("수성못", "https://tour.daegu.go.kr/icms/tour/file/getImage.do;jsessionid=97A59807260711162C6690A0392FB706.tomcat_2?atchFileId=FILE_KOATTR_120%20%20%20%20%20&fileSn=3506",
                "https://map.naver.com/v5/search/%EC%88%98%EC%84%B1%EB%AA%BB/place/13470879?c=14317926.9413972,4276784.6852814,16.49,0,0,0,dh&placePath=%2Fphoto%3Fentry%253Dbmp", "대구 수성구 두산동"));
        FoodLocation[1][0].add(new DataSet_URL("팔공산도립공원", "http://tong.visitkorea.or.kr/cms/resource/55/655755_image2_1.jpg",
                "https://map.naver.com/v5/search/%ED%8C%94%EA%B3%B5%EC%82%B0?c=14326319.5955992,4299136.6793247,16.75,0,0,0,dh", "대구 동구 팔공산로185길"));
        FoodLocation[1][0].add(new DataSet_URL("김광석길", "https://pds.joongang.co.kr/news/component/htmlphoto_mmdata/202008/14/5c8a66d8-a50d-4831-a95b-44d72a6fd53c.jpg",
                "https://map.naver.com/v5/search/%EA%B9%80%EA%B4%91%EC%84%9D%EA%B8%B8/place/33800325?c=14315987.3740753,4281419.6042906,15,0,0,0,dh&placePath=%3Fentry%253Dbmp", "대구 중구 대봉동 6-11"));
        FoodLocation[1][0].add(new DataSet_URL("대구 호산동", "https://cdn.imweb.me/upload/S201701015868e87bb6cc8/5c90e7a2a0117.png",
                "https://map.naver.com/v5/search/%EB%8C%80%EA%B5%AC%20%ED%98%B8%EC%82%B0%EB%8F%99/address/14302584.211948585,4280509.345626501,%EB%8C%80%EA%B5%AC%EA%B4%91%EC%97%AD%EC%8B%9C%20%EB%8B%AC%EC%84%9C%EA%B5%AC%20%ED%98%B8%EC%82%B0%EB%8F%99,adm?c=14302837.1173850,4280387.5530945,15.29,0,0,0,dh&isCorrectAnswer=true", "대구광역시 달서구 호산동"));
        FoodLocation[1][0].add(new DataSet_URL("중앙로역", "https://tour.daegu.go.kr/icms/tour/file/getImage.do?atchFileId=FILE_KOATTR_268",
                "https://map.naver.com/v5/search/%EB%8C%80%EA%B5%AC%EC%A4%91%EC%95%99%EB%A1%9C%EC%97%AD/subway-station/40131?c=14314567.5558950,4282907.5118741,15.6,0,0,0,dh", "대구 중구 남일동"));
        FoodLocation[1][0].add(new DataSet_URL("대구 두류동", "https://cdn.imweb.me/upload/S201701015868e87bb6cc8/5c90e7af20311.png",
                "", "대구광역시 달서구 두류동"));


        FoodLocation[1][1] = new ArrayList<>(); // 대구 음식
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

        FoodLocation[1][2] = new ArrayList<>(); // 대구 커플
        FoodLocation[1][2].add(new DataSet_URL("중앙로역", "https://tour.daegu.go.kr/icms/tour/file/getImage.do?atchFileId=FILE_KOATTR_268",
                "https://map.naver.com/v5/search/%EB%8C%80%EA%B5%AC%EC%A4%91%EC%95%99%EB%A1%9C%EC%97%AD/subway-station/40131?c=14314567.5558950,4282907.5118741,15.6,0,0,0,dh", "대구 중구 남일동"));
        FoodLocation[1][2].add(new DataSet_URL("경북대", "https://newsimg.hankookilbo.com/cms/articlerelease/2016/07/15/201607150912662021_1.jpg ",
                "https://map.naver.com/v5/search/%EA%B2%BD%EB%B6%81%EB%8C%80/place/11591485?c=14315900.3909225,4285476.5357995,14.75,0,0,0,dh&placePath=%3Fentry%253Dbmp", "대구 북구 대학로 80 경북대학교"));
        FoodLocation[1][2].add(new DataSet_URL("삼성라이온즈파크", "https://img7.yna.co.kr/photo/yna/YH/2012/12/27/PYH2012122706240005300_P2.jpg ",
                "https://map.naver.com/v5/entry/place/19909612?c=14324641.8094062,4278757.4303035,16.57,0,0,0,dh", "대구 수성구 야구전설로 1"));
        FoodLocation[1][2].add(new DataSet_URL("신세계백화점대구점", "https://post-phinf.pstatic.net/MjAxODAzMjdfMTIy/MDAxNTIyMDc2OTA3NzQx.osodMiEXsV5DzgV4hMeh4h1ZDP9Fa6RSizTnkgZ9HSgg.cjs_F5didPegRtrrR-pLKnli57IoDOGMk2yvFnGtTMIg.JPEG/DAEGU01.jpg?type=w1200",
                "https://map.naver.com/v5/search/%EC%8B%A0%EC%84%B8%EA%B3%84%EB%B0%B1%ED%99%94%EC%A0%90%20%EB%8C%80%EA%B5%AC%EC%A0%90/place/38003935?c=14318383.6214660,4283783.1034114,15.78,0,0,0,dh&placePath=%3Fentry%253Dbmp", "대구 동구 동부로 149"));
        FoodLocation[1][2].add(new DataSet_URL("수성못", "http://www.kyongbuk.co.kr/news/photo/202209/2111565_547403_1910.jpg ",
                "https://map.naver.com/v5/search/%EC%88%98%EC%84%B1%EB%AA%BB/place/13470879?c=14316682.9905387,4276919.4768944,15,0,0,0,dh&placePath=%3Fentry%253Dbmp", "http://www.kyongbuk.co.kr/news/photo/202209/2111565_547403_1910.jpg"));
        FoodLocation[1][2].add(new DataSet_URL("김광석길", "https://pds.joongang.co.kr/news/component/htmlphoto_mmdata/202008/14/5c8a66d8-a50d-4831-a95b-44d72a6fd53c.jpg",
                "https://map.naver.com/v5/search/%EA%B9%80%EA%B4%91%EC%84%9D%EA%B8%B8/place/33800325?c=14315987.3740753,4281419.6042906,15,0,0,0,dh&placePath=%3Fentry%253Dbmp", "대구 중구 대봉동 6-11"));

        FoodLocation[2] = new ArrayList[3]; // 수원
        FoodLocation[2][0] = new ArrayList<>(); // 수원 힐링
        FoodLocation[2][0].add(new DataSet_URL("수원화성", "https://heritage.unesco.or.kr/wp-content/uploads/2019/04/hd6_394_i1-400x282.jpg",
                "https://map.naver.com/v5/search/%EC%88%98%EC%9B%90%20%ED%99%94%EC%84%B1/place/13491459?c=14140053.1523291,4476992.8187188,13,0,0,0,dh&placePath=%3Fentry%253Dbmp", "경기 수원시 장안구 영화동 320-2"));
        FoodLocation[2][0].add(new DataSet_URL("광교호수공원", "https://www.suwon.go.kr/common-upload/upload/visitsuwon/2018/6/1/ce135282-8f09-4953-8cc2-03fdb60f377b.png",
                "https://map.naver.com/v5/search/%EA%B4%91%EA%B5%90%ED%98%B8%EC%88%98%EA%B3%B5%EC%9B%90/place/20815787?c=14145224.2196391,4478556.8988009,16.81,0,0,0,dh&placePath=%3Fentry%253Dbmp", "경기 수원시 영통구 광교호수로 165"));
        FoodLocation[2][0].add(new DataSet_URL("나혜석거리", "https://t1.daumcdn.net/thumb/R720x0/?fname=http://t1.daumcdn.net/brunch/service/user/5xq2/image/f1YDvgW_HX-nitvqDTkpLKhulrI.jpeg",
                "https://map.naver.com/v5/search/%EB%82%98%ED%98%9C%EC%84%9D%EA%B1%B0%EB%A6%AC/place/1325594997?c=14141411.0155140,4475957.5498229,18.94,0,0,0,dh", "경기 수원시 팔달구 권광로188번길 25-2"));
        FoodLocation[2][0].add(new DataSet_URL("동탄호수공원", "https://t1.daumcdn.net/cfile/blog/9956B64F5EA8CDAE32",
                "https://map.naver.com/v5/search/%EB%8F%99%ED%83%84%ED%98%B8%EC%88%98%EA%B3%B5%EC%9B%90/place/1060208994?c=14150071.1803662,4462807.1632175,18.24,0,0,0,dh&placePath=%3Fentry%253Dbmp", "경기 화성시 산척동 767"));
        FoodLocation[2][0].add(new DataSet_URL("동탄센트럴파크", "http://www.latimes.kr/news/photo/201110/11026_10070_3820.jpg",
                "https://map.naver.com/v5/search/%EB%8F%99%ED%83%84%EC%84%BC%ED%8A%B8%EB%9F%B4%ED%8C%8C%ED%81%AC/place/1000497464?c=14144566.9269414,4467605.4139614,17.92,0,0,0,dh&placePath=%3Fentry%253Dbmp", "경기 화성시 동탄공원로2길 22"));
        FoodLocation[2][0].add(new DataSet_URL("행궁동", "https://imgp.interpark.com/tr/fit/contents/1711/contents_1711_20220216093201_0.jpg",
                "https://map.naver.com/v5/search/%ED%96%89%EA%B6%81%EB%8F%99/address/14138978.635378603,4478774.87929623,%EA%B2%BD%EA%B8%B0%EB%8F%84%20%EC%88%98%EC%9B%90%EC%8B%9C%20%ED%8C%94%EB%8B%AC%EA%B5%AC%20%ED%96%89%EA%B6%81%EB%8F%99,adm?c=14139001.4436049,4478753.7760779,18.87,0,0,0,dh&isCorrectAnswer=true", "경기도 수원시 팔달구 행궁동"));

        FoodLocation[2][1] = new ArrayList<>(); // 수원 음식
        FoodLocation[2][1].add(new DataSet_URL("나혜석거리", "https://t1.daumcdn.net/thumb/R720x0/?fname=http://t1.daumcdn.net/brunch/service/user/5xq2/image/f1YDvgW_HX-nitvqDTkpLKhulrI.jpeg",
                "https://map.naver.com/v5/search/%EB%82%98%ED%98%9C%EC%84%9D%EA%B1%B0%EB%A6%AC/place/1325594997?c=14141411.0155140,4475957.5498229,18.94,0,0,0,dh", "경기 수원시 팔달구 권광로188번길 25-2"));
        FoodLocation[2][1].add(new DataSet_URL("행리단길", "https://blog.kakaocdn.net/dn/dgbs7V/btrLns31MBh/51VIpXuCpLSTsduXhA1k6K/img.jpg",
                "https://map.naver.com/v5/search/%ED%96%89%EB%A6%AC%EB%8B%A8%EA%B8%B8/place/1220976474?c=14138861.2807327,4478955.9675938,17.06,0,0,0,dh&placePath=%3Fentry%253Dbmp", "경기 수원시 팔달구 화서문로 43"));
        FoodLocation[2][1].add(new DataSet_URL("수원역", "http://www.suwonstrodeo.com/wp-content/uploads/2020/09/05-2.png",
                "https://map.naver.com/v5/search/%EC%88%98%EC%9B%90%EC%97%AD?c=14137739.3886806,4476164.0588313,17.15,0,0,0,dh&isCorrectAnswer=true", "경기 수원시 팔달구 덕영대로 924"));
        FoodLocation[2][1].add(new DataSet_URL("화서역먹자골목", "http://bbkk.kr/d/t/4/4596_DSC_0061.jpg",
                "https://map.naver.com/v5/search/%ED%99%94%EC%84%9C%EC%97%AD%EB%A8%B9%EA%B1%B0%EB%A6%AC%EC%B4%8C/place/19209229?c=14136342.0386129,4479255.5205773,18.25,0,0,0,dh&placePath=%3Fentry%253Dbmp", "경기 수원시 팔달구 화서동"));
        FoodLocation[2][1].add(new DataSet_URL("수원곱창골목", "https://mblogthumb-phinf.pstatic.net/MjAxNzEwMjhfMTEz/MDAxNTA5MTYxMjg3NjQz.I_Hdss1mg13YPDWfCNXJ4QOlvLfP3c1P07ew6qD_jowg.D33TWPD53ZWDYNUx9zUglz7OsceILA76ekxJCuOBmNcg.JPEG.punkyfunny/image_2051398381509161182261.jpg?type=w800",
                "https://mblogthumb-phinf.pstatic.net/MjAxNzEwMjhfMTEz/MDAxNTA5MTYxMjg3NjQz.I_Hdss1mg13YPDWfCNXJ4QOlvLfP3c1P07ew6qD_jowg.D33TWPD53ZWDYNUx9zUglz7OsceILA76ekxJCuOBmNcg.JPEG.punkyfunny/image_2051398381509161182261.jpg?type=w800", "경기 수원시 영통구 영통동"));
        FoodLocation[2][1].add(new DataSet_URL("광교카페거리", "https://ggtour.or.kr/cgi/upload_img/20209331614_editor_image.jpg",
                "https://map.naver.com/v5/search/%EA%B4%91%EA%B5%90%EC%B9%B4%ED%8E%98%EA%B1%B0%EB%A6%AC/place/1334830986?c=14143533.4091568,4480232.2386402,18.06,0,0,0,dh", "경기 수원시 영통구 센트럴파크로127번길 51"));

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
