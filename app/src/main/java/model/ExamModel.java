package model;

/**
 * Created by dali on 26/11/2016.
 */
public class ExamModel {
    private String title;
    private String description;
    private String visibility;
    public ExamModel(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return "Titre :"+title+"\n"+" Description :"+description;
    }
}
