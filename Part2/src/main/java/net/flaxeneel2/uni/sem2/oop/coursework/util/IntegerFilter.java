package net.flaxeneel2.uni.sem2.oop.coursework.util;

import net.flaxeneel2.uni.sem2.oop.coursework.UI.modals.GenericMessageModal;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

public class IntegerFilter extends DocumentFilter {
    private Integer min;
    private Integer max;
    public IntegerFilter() {}
    public IntegerFilter(int min, int max) {
        this.min = min;
        this.max = max;
    }
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        Document doc = fb.getDocument();
        String text = doc.getText(0, doc.getLength()) + string;
        try {
            int num = Integer.parseInt(text);
            if(min != null && num < min || max != null && num > max) throw new NumberFormatException();
            super.insertString(fb, offset, string, attr);
        } catch (NumberFormatException ignored) {
            GenericMessageModal modal = new GenericMessageModal("Invalid Input");
            modal.setMessages("Invalid input! The input must be a number between 0 and " + max);
        }
    }

    @SuppressWarnings("MismatchedQueryAndUpdateOfStringBuilder")
    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        Document document = fb.getDocument();
        StringBuilder fullText = new StringBuilder();
        fullText.append(document.getText(0, document.getLength()));
        fullText.replace(offset, offset + length, text);
        try {
            int num = Integer.parseInt(fullText.toString());
            if(min != null && num < min || max != null && num > max) throw new NumberFormatException();
            super.replace(fb, offset, length, text, attrs);
        } catch (NumberFormatException ignored) {
            GenericMessageModal modal = new GenericMessageModal("Invalid Input");
            modal.setMessages("Invalid input! The input must be a number between 0 and " + max);
        }
    }
}
