package com.aroundog.map;

public class AreaSelect {
   public double getLati(String area) {
      double lati = 0;
      if(area.equals("����")){
         lati = 37.566576;
      }else if(area.equals("��⵵")){
         lati =37.288728;
      }else if(area.equals("��õ")){
         lati = 37.456137;
      }else if(area.equals("������")){
         lati = 37.886080;
      }else if(area.equals("�λ�")){
         lati = 35.179802;
      }else if(area.equals("����")){
         lati = 37.421120;
      }else if(area.equals("����")){
         lati = 36.350569;
      }
      return lati;
   }
   public double getLongi(String area) {
      double longi = 0;
      if(area.equals("����")){
         longi = 126.978353;
      }else if(area.equals("��⵵")){
         longi =127.053840;
      }else if(area.equals("��õ")){
         longi = 126.705884;
      }else if(area.equals("������")){
         longi = 127.729533;
      }else if(area.equals("�λ�")){
         longi = 129.074994;
      }else if(area.equals("����")){
         longi = 127.257186;
      }else if(area.equals("����")){
         longi = 127.384894;
      }
      return longi;
   }
}