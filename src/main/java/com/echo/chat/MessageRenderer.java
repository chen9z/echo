package com.echo.chat;

import com.echo.domain.Message;

import javax.swing.*;
import java.awt.*;

public class MessageRenderer extends JLabel implements ListCellRenderer<Message> {
    public MessageRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Message> list, Message message, int index, boolean isSelected, boolean cellHasFocus) {
        Component panel;
        if ("user".equals(message.getRole())) {
            panel = getInputComponent(message.getContent());
        } else {
            panel = getResponseComponent(message.getContent());
        }
        return panel;
    }

    private Component getInputComponent(String input) {
        JEditorPane markerPanel = new JEditorPane();
        markerPanel.setEditable(false);
        markerPanel.setLayout(new BorderLayout(0, 0));
        markerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        markerPanel.setText("You:\n" + input);
        return markerPanel;
    }

    private Component getResponseComponent(String input) {
        JEditorPane markerPanel = new JEditorPane();
        markerPanel.setEditable(false);
        markerPanel.setLayout(new BorderLayout(0, 0));
        markerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        markerPanel.setText("Assistant:\n" + input);
        return markerPanel;
    }
}
