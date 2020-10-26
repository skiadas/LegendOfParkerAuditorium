package minidraw.standard;

import java.awt.event.*;

import minidraw.framework.Tool;

/**
 * 
 * Null tool. Null object for tools which does
 * nothing.
 * 
 */

public class NullTool implements Tool {
  @Override
  public void mouseDown(MouseEvent e, int x, int y) {
  }

  @Override
  public void mouseDrag(MouseEvent e, int x, int y) {
  }

  @Override
  public void mouseMove(MouseEvent e, int x, int y) {
  }

  @Override
  public void mouseUp(MouseEvent e, int x, int y) {
  }

  public void activate() {
  }

  public void deactivate() {
  }

  @Override
  public void keyDown(KeyEvent evt, int key) {
  }
}
