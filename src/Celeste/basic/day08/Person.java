package Celeste.basic.day08;
 public class Person {
    public static void main(String[] args) {
        JavaBook j = new JavaBook();
        j.setName("누구나 알기 쉬운 자바: 입문편");
        j.setAuthor("카와바 타게시");
        j.setTranslator("하진일");
        j.setPublisher("혜지원");
        j.setDate("2014년 06월");
        j.setPrimeCost(25000);
        j.setDisCost(22500);
        j.setDiscount(10);
        j.setSaving(10);

        System.out.println(j.getName());
        System.out.println(j.getAuthor());
        System.out.println(j.getTranslator());
        System.out.println(j.getPublisher());
        System.out.println(j.getDate());
        System.out.println(j.getPrimeCost());
        System.out.println(j.getDisCost());
        System.out.println(j.getDiscount());
        System.out.println(j.getSaving());

    }
}
class person {
     private String name;
     private String gender;
     private int age;
     private int height;
     private int weight;

    public person(String name, String gender, int age, int height, int weight) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

class JavaBook {
     private String name;
     private String author;
     private String translator;
     private String publisher;
     private String date;
     private int primeCost;
     private int disCost;
     private double discount;
     private int saving;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrimeCost() {
        return primeCost;
    }

    public void setPrimeCost(int primeCost) {
        this.primeCost = primeCost;
    }

    public int getDisCost() {
        return disCost;
    }

    public void setDisCost(int disCost) {
        this.disCost = disCost;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getSaving() {
        return saving;
    }

    public void setSaving(int saving) {
        this.saving = saving;
    }
}

