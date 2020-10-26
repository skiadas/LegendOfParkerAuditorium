package ui;

import minidraw.framework.DrawingEditor;
import minidraw.framework.DrawingView;
import minidraw.standard.StandardDrawingView;
import minidraw.standard.StdViewWithBackground;

import java.awt.*;

public class LoPADrawingView extends StdViewWithBackground {
    private DrawingEditor editor;

    public LoPADrawingView(DrawingEditor editor) {
        super(editor, "parker");
        this.editor = editor;
    }

}
