package com.example.android_project.Common;

import com.example.android_project.Login.MemberVO;

public class CommonVal {


    public static String HTTP_IP="http://192.168.0.47"; //서버 위치에 따른 아이피 주소 변경
    public static String SVRPATH="/erjr/";               //서버 모듈 설정에 따른 변경 필요
    public static MemberVO loginInfo = null;
    //Collection 구조를 가져서 메모리 공간을 많이 차지하는 데이터가 아닌 경우엔 공통으로
    //사용할 변수들을 static으로 놓고, 같이 사용하는 것이 효율적임
    //룰을 정해서 이름 규칙이나 여러가지 형태들을 회의한 후에 결정해서 사용
}
