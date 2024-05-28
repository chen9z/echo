package com.echo.chat;

import com.echo.domain.Message;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.components.JBList;

import javax.swing.*;
import java.awt.*;

public class ChatWindow {
    private final JPanel contentPanel = new JPanel();
    private final DefaultListModel<Message> listModel = new DefaultListModel<>();
    private final JBList<Message> chatList = new JBList<>(listModel);
    private final JTextField inputField = new JTextField();

    public ChatWindow(ToolWindow toolWindow) {
        contentPanel.setLayout(new BorderLayout(0, 0));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        MessageRenderer messageRenderer = new MessageRenderer();
        chatList.setCellRenderer(messageRenderer);
        contentPanel.add(chatList, BorderLayout.CENTER);

        contentPanel.add(inputField, BorderLayout.PAGE_END);

        inputField.addActionListener(e -> {
            String text = inputField.getText();
            if (!text.isBlank()) {
//                Message userMessage = Message.builder().role("user").content(text).build();
                Message userMessage = new Message("user", text);
                listModel.addElement(userMessage);

//                Message assistantMessage = Message.builder().role("assistant").content(text).build();
                Message assistantMessage = new Message("assistant", text);
                listModel.addElement(assistantMessage);
            }
            inputField.setText("");
        });
    }




    JPanel getContentPanel() {
        return contentPanel;
    }
}
