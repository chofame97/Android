package com.example.a00vendingmachine;

import java.util.ArrayList;

public class MachineDAO {

    // 금액입력 버튼 실행
    public String btn_ingo(MachineDTO dto){
        try{
            dto.setMoney(Integer.parseInt(String.valueOf(dto.getText_in().getText())));
            dto.getText_in2().setText("잔액 : "+dto.getMoney()+"원");
        }catch (Exception e){
            return "숫자만 입력가능합니다!";
        }
        return "금액 등록!";
    }
    // 잔돈 반환
    //  public void change1(MachineDAO dao, ArrayList<MachineDTO> list) {

    //  }
    // 콜라 주문
    public String call_coke(MachineDTO dto, MachineDTO list) {
       if(dto.getMoney() >= list.getPrice() &&  list.getCount() >= 1){
           // 개수 카운트
           dto.setCnt_coke(dto.getCnt_coke()+1);
           // 출력  10개 남음
           dto.getText_coke().setText(""+(list.getCount()-1)+"개 남음");

           list.setCount(list.getCount()-1);
           dto.setMoney(dto.getMoney()-list.getPrice());
           dto.getText_in2().setText("잔액 : "+dto.getMoney()+"원");
            return check_money3(list);
       }else{
           if(dto.getMoney() < list.getPrice() && list.getCount() < 1){
               return check_money();
           }else if(dto.getMoney() < list.getPrice()){
               return check_money1();
           }else{
               return check_money2();
           }
       }
    }// 콜라 주문 닫음

    // 사이다 주문
    public String call_cider(MachineDTO dto, MachineDTO list) {
        if(dto.getMoney() >= list.getPrice() &&  list.getCount() >= 1){
            // 개수 카운트
            dto.setCnt_cider(dto.getCnt_cider()+1);
            // 출력  10개 남음
            dto.getText_cider().setText(""+(list.getCount()-1)+"개 남음");

            list.setCount(list.getCount()-1);
            dto.setMoney(dto.getMoney()-list.getPrice());
            dto.getText_in2().setText("잔액 : "+dto.getMoney()+"원");
            return check_money3(list);
        }else{
            if(dto.getMoney() < list.getPrice() && list.getCount() < 1){
                return check_money();
            }else if(dto.getMoney() < list.getPrice()){
                return check_money1();
            }else{
                return check_money2();
            }
        }
    }// 사이다 주문 닫음

    // 환타 주문
    public String call_fanta(MachineDTO dto, MachineDTO list) {
        if(dto.getMoney() >= list.getPrice() &&  list.getCount() >= 1){
            // 개수 카운트
            dto.setCnt_fanta(dto.getCnt_fanta()+1);
            // 출력  10개 남음
            dto.getText_fanta().setText(""+(list.getCount()-1)+"개 남음");

            list.setCount(list.getCount()-1);
            dto.setMoney(dto.getMoney()-list.getPrice());
            dto.getText_in2().setText("잔액 : "+dto.getMoney()+"원");
            return check_money3(list);
        }else{
            if(dto.getMoney() < list.getPrice() && list.getCount() < 1){
                return check_money();
            }else if(dto.getMoney() < list.getPrice()){
                return check_money1();
            }else{
                return check_money2();
            }
        }
    }// 환타 주문 닫음

    // 데미소다 주문
    public String call_demisoda(MachineDTO dto, MachineDTO list) {
        if(dto.getMoney() >= list.getPrice() &&  list.getCount() >= 1){
            // 개수 카운트
            dto.set_cnt_demisoda(dto.get_cnt_demisoda()+1);
            // 출력  10개 남음
            dto.getText_demisoda().setText(""+(list.getCount()-1)+"개 남음");

            list.setCount(list.getCount()-1);
            dto.setMoney(dto.getMoney()-list.getPrice());
            dto.getText_in2().setText("잔액 : "+dto.getMoney()+"원");
            return check_money3(list);
        }else{
            if(dto.getMoney() < list.getPrice() && list.getCount() < 1){
                return check_money();
            }else if(dto.getMoney() < list.getPrice()){
                return check_money1();
            }else{
                return check_money2();
            }
        }
    }// 데미소다 주문 닫음



    // 주문 실행 했을때 결과값
    public String check_money(){
        return "남은수량과 소지금액이 부족합니다";
    }
    public String check_money1(){
        return "소지금액이 부족합니다";
    }
    public String check_money2(){
        return "남은수량이 부족합니다";
    }
    public String check_money3(MachineDTO list){
        String str = ""+list.getDrink()+" 주문완료";
        return str;
    }// 주문 실행 했을때 결과값 닫음


}