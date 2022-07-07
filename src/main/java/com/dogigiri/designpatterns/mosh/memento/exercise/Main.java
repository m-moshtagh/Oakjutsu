package com.dogigiri.designpatterns.mosh.memento.exercise;

public class Main {
    public static void main(String[] args) {
        var history = new History<DocumentMemento>();
        var doc = new Document().setContent("Ibrahim").setFontName("BNarges").setFontSize(17);
        history.push(doc.createMemento());
        System.out.println(doc);

        doc.setFontSize(15);
        history.push(doc.createMemento());
        System.out.println(doc);

        doc.restore(history.pop());
        System.out.println(doc);

        doc.setFontName("BNazanin");
        history.push(doc.createMemento());
        System.out.println(doc);

        doc.restore(history.pop());
        System.out.println(doc);

        doc.restore(history.pop());
        System.out.println(doc);
    }
}
