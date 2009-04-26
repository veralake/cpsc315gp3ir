/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VisualPanel.java
 *
 * Created on Apr 8, 2009, 1:32:45 AM
 */

package ui;

import documentSearching.Document;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JScrollPane;



/**
 * <b>VisualPanel</b>
 *
 * <p>This class represents the window for viewing the search results of a query
 * in an interactive, visually appealing format</p>
 */
public class VisualPanel extends javax.swing.JPanel implements ResultsDisplay, MouseListener, MouseMotionListener
{
   JScrollPane jsp;

    /** Creates new form VisualPanel
     Might need to change constructor to Document[] and get name from document object*/
    public VisualPanel()
    {
        addMouseListener(this);
        addMouseMotionListener(this);
        initComponents();
                
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fileNameL = new javax.swing.JLabel();
        fileSizeL = new javax.swing.JLabel();
        fileLocationL = new javax.swing.JLabel();
        fileName = new javax.swing.JLabel();
        fileSize = new javax.swing.JLabel();
        fileLocation = new javax.swing.JLabel();

        fileNameL.setText("File Name:");

        fileSizeL.setText("File Size:");

        fileLocationL.setText("File Location:");

        fileName.setText("None Selected");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fileNameL)
                        .addGap(18, 18, 18)
                        .addComponent(fileName))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fileSizeL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileSize))
                    .addComponent(fileLocationL)
                    .addComponent(fileLocation))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileNameL)
                    .addComponent(fileName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileSizeL)
                    .addComponent(fileSize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fileLocationL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fileLocation)
                .addContainerGap(209, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(433, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

     /**
     * Removes all search items contained in the visual panel for another query.
     */
    public void removeSearchItems()
    {
        
    }

    /**
     * Adds a search item that is to be displayed in the visual format.
     * @param doc - <code>Document</code> to displayed
     */
    @Override
    public void addDocument(Document doc)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void initGraphics(){
        BufferedImage icon = null;
        try {
            icon = ImageIO.read(new File("src/ui/icon.jpg"));
        } catch (IOException e) {
            System.out.println("Image not loaded");
        }
        
        try {
            slotImage = ImageIO.read(new File("src/ui/slot.jpg"));
        } catch (IOException e) {
            System.out.println("Image not loaded");
        }
      
        for (int i = 0; i < documents.length; i++){
            icons.add(icon);
        }
        
        for (int i = 0; i < documents.length; i++){
            labels.add(documents[i].getName());
        }
            
    }
    
    public void initGrid(){
        int root = (int) Math.sqrt((double)documents.length);        
        
        setSize(WIDTH_OF_SLOT*root, HEIGHT_OF_SLOT*root);
        
        for(int i = 0; i < root; i++)
            for(int j = 0; j < root; j++){
           
                Point p = new Point((WIDTH_OF_SLOT *(j)) + ICON_OFFSET, 
                    (HEIGHT_OF_SLOT*i) + ICON_OFFSET);
                
                iconPosition.add(p);
                hitBoxes.add(new Rectangle(p.x, p.y, WIDTH_OF_ICON, HEIGHT_OF_ICON));
                slots.add(new Point(WIDTH_OF_SLOT *(j), HEIGHT_OF_SLOT*i));            
        }
    }
    
    public void set(Document d[]){
        documents = d;
        initGraphics();
        initGrid();
        
    }
    
    public void clear(){
        documents = new Document[0];
        slots.clear();
        labels.clear();
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        String text;
        int slotx;
        int sloty;
        int iconx;
        int icony;
        
        BufferedImage icon;
        
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 15);
        Hashtable<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();

        map.put(TextAttribute.FOREGROUND, Color.WHITE);
        font = font.deriveFont(map);
        g.setFont(font);
        

        for (int i = 0; i < labels.size(); i++){
            slotx   = slots.elementAt(i).x;
            sloty   = slots.elementAt(i).y;
            iconx   = iconPosition.elementAt(i).x;
            icony   = iconPosition.elementAt(i).y;
            text    = labels.elementAt(i);
            icon    = icons.elementAt(i);
            
            g2.drawImage(slotImage, slotx, sloty, null);
            g2.drawImage(icon, iconx, icony, null);
            g2.drawString(text, iconx, icony + FONT_OFFSET);
        }
        
        if (iconSelected > -1){
            iconx   = iconPosition.elementAt(iconSelected).x;
            icony   = iconPosition.elementAt(iconSelected).y;
            text    = labels.elementAt(iconSelected);
            icon    = icons.elementAt(iconSelected);
            
            g2.drawImage(icon, iconx, icony, null);
            g2.drawString(text, iconx, icony + FONT_OFFSET);
            
        }
    }
    
    public int findClickedIcon(int x, int y){
        for(int i = 0; i < hitBoxes.size(); i++){
            if(hitBoxes.elementAt(i).contains(x, y)){
                return i;              
            }
        }
        return -1;
    }
    
    public void mouseClicked(MouseEvent e) {
        iconSelected = findClickedIcon(e.getX(), e.getY());
        
        if(iconSelected > -1){
           fileName.setText(documents[iconSelected].getName());
        } 
    }

    public void mousePressed(MouseEvent e) {
        iconSelected = findClickedIcon(e.getX(), e.getY());
        
        if(iconSelected > -1){
            lastx = hitBoxes.elementAt(iconSelected).x - e.getX();
            lasty = hitBoxes.elementAt(iconSelected).y - e.getY();
            updatePosition(e);
            pressedIcon = true;
        }
        else{
            pressedIcon = false;            
        }

    }

    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseDragged(MouseEvent e) {
        if(pressedIcon)
            updatePosition(e);
    }

    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void updatePosition(MouseEvent e){
        hitBoxes.elementAt(iconSelected).setLocation(lastx + e.getX(), lasty + e.getY());
        iconPosition.elementAt(iconSelected).setLocation(lastx + e.getX(), lasty + e.getY());
        repaint();
    }
    
    public void swapElements(Vector<Object> v, int indexA, int indexB){
        Object temp = v.elementAt(indexA);
        v.set(indexA, v.elementAt(indexB));
        v.set(indexB, temp);        
    }
    
    private Document[] documents;
    private Vector<String> labels               = new Vector();
    private Vector<Point> slots                 = new Vector();
    private Vector<Point> iconPosition          = new Vector();
    private Vector<BufferedImage> icons         = new Vector();
    private Vector<Rectangle> hitBoxes          = new Vector();
    
    public static final int HEIGHT_OF_SLOT      = 150;
    public static final int WIDTH_OF_SLOT       = 150;
    public static final int HEIGHT_OF_ICON      = 100;
    public static final int WIDTH_OF_ICON       = 100;
    public static final int ICON_OFFSET         = 25;
    public static final int FONT_OFFSET         = 115;
    public static final int OFFSET_TO_CENTER    = 75;
    
    private BufferedImage slotImage;
    private int iconSelected        = -1;    
    private int lastx               = 0;
    private int lasty               = 0;
    private boolean pressedIcon    = false;
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fileLocation;
    private javax.swing.JLabel fileLocationL;
    private javax.swing.JLabel fileName;
    private javax.swing.JLabel fileNameL;
    private javax.swing.JLabel fileSize;
    private javax.swing.JLabel fileSizeL;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
