package Activity;

public class Activity5 {
    public static void main(String[] args) {
        MyBook newNovel = new MyBook();
        newNovel.setTitle("IT ENDS WITH US");
        System.out.println("The title of the book is: " + newNovel.getTitle());
        
    }
    
}


abstract class Book {
    protected String title;

    // Abstract method
    public abstract void setTitle(String title);

    // Concrete method
    public String getTitle() {
        return title;
    }
}

class MyBook extends Book {

    public void setTitle(String s) {
    title = s;
}
}
