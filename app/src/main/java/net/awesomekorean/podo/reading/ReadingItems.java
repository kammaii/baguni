package net.awesomekorean.podo.reading;

public class ReadingItems {

    private String title;
    private String subTitle;
    private int readingImage;
    private boolean isCompleted = true;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getReadingImage() {
        return readingImage;
    }

    public void setReadingImage(int lessonImage) {
        this.readingImage = lessonImage;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean completed) {
        isCompleted = completed;
    }
}
