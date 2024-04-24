package net.flaxeneel2.uni.sem2.oop.coursework.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

public class IntegerFilter extends DocumentFilter {
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        Document doc = fb.getDocument();
        String text = doc.getText(0, doc.getLength()) + string;
        try {
            Integer.parseInt(text);
            super.insertString(fb, offset, string, attr);
        } catch (NumberFormatException ignored) {
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        Document document = fb.getDocument();
        StringBuilder fullText = new StringBuilder();
        fullText.append(document.getText(0, document.getLength()));
        fullText.replace(offset, offset + length, text);
        try {
            Integer.parseInt(fullText.toString());
            super.replace(fb, offset, length, text, attrs);
        } catch (NumberFormatException ignored) {
        }
    }
}
