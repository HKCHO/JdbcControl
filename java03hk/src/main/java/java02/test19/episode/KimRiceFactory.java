package java02.test19.episode;

public class KimRiceFactory {
  public KimRice createInstance(String type) {
    KimRice p = null;
    if (type.equals("멸추")) {
      p = new KimRice();
      p.danmuji = "노랑단문지";
      //..
    } else if (type.equals("고추장불고기")) {
      
    }
    return p;
  }
}
