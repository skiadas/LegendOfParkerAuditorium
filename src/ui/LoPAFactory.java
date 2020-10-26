package ui;

import minidraw.framework.Drawing;
import minidraw.framework.DrawingEditor;
import minidraw.framework.DrawingView;
import minidraw.framework.Factory;

import javax.swing.*;

public class LoPAFactory implements Factory {
    public DrawingView createDrawingView(DrawingEditor editor) {
        return new LoPADrawingView(editor);
    }

    public Drawing createDrawing(DrawingEditor editor) {
        return new LoPADrawing(editor);
    }

    public JTextField createStatusField(DrawingEditor editor) {
        // TODO: Change this when a status field is needed
        return null;
    }
}
