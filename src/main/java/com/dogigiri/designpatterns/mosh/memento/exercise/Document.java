package com.dogigiri.designpatterns.mosh.memento.exercise;

public class Document {
    private String content;
    private String fontName;
    private int fontSize;

    public DocumentMemento createMemento() {
        return new DocumentMemento(content, fontName, fontSize);
    }

    public void restore(DocumentMemento memento) {
        this.content = memento.getContent();
        this.fontName = memento.getFontName();
        this.fontSize = memento.getFontSize();
    }

    public String getContent() {
        return content;
    }

    public Document setContent(String content) {
        this.content = content;
        return this;
    }

    public String getFontName() {
        return fontName;
    }

    public Document setFontName(String fontName) {
        this.fontName = fontName;
        return this;
    }

    public int getFontSize() {
        return fontSize;
    }

    public Document setFontSize(int fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    @Override
    public String toString() {
        return "Document{" +
                "content='" + content + '\'' +
                ", fontName='" + fontName + '\'' +
                ", fontSize=" + fontSize +
                '}';
    }
}
