package com.example.springmysql.newModels;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int feedbackID;

    @Column(name = "Feedback_Text")
    @NotBlank(message = "Текст отзыва не может быть пустым")
    @Size(max = 500, message = "Текст отзыва должен быть не более 500 символов")
    private String Feedback_Text;



    public Feedback(){}
    public Feedback(int feedbackID, String Feedback_Text) {
        this.feedbackID = feedbackID;
        this.Feedback_Text = Feedback_Text;
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getFeedbackText() {
        return Feedback_Text;
    }

    public void setFeedbackText(String Feedback_Text) {
        this.Feedback_Text = Feedback_Text;
    }


}

