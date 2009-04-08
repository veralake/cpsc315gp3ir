/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import javax.swing.JFrame;

/**
 *
 * @author Zachary Edens
 */
public class UIController
{
    private static class Holder
    {
        private static UIController instance = new UIController();
    }

    private UIController()
    {
    }

    public static UIController getInstance()
    {
        return Holder.instance;
    }

    public void setFrame(JFrame frame)
    {
        mFrame = frame;
    }

    public JFrame getFrame()
    {
        return mFrame;
    }

    public static void switchActiveView()
    {

    }

    private JFrame mFrame;
}
