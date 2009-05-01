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
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JScrollPane;

import controllers.UIController;



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
     */
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
        fileLocationL = new javax.swing.JLabel();
        fileName = new javax.swing.JLabel();
        fileLocation = new javax.swing.JLabel();
        openButton = new javax.swing.JButton();
        fileNameL = new javax.swing.JLabel();
        fileRankL = new javax.swing.JLabel();
        fileRank = new javax.swing.JLabel();
        endOfResultsL = new javax.swing.JLabel();

        fileLocationL.setText("File Location:");

        fileName.setText("None Selected");

        fileLocation.setText("None Selected");

        openButton.setText("Open File");
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });

        fileNameL.setText("File Name:");

        fileRankL.setText("File Rank:");

        fileRank.setText("None Selected");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(openButton))
                    .addComponent(fileLocationL)
                    .addComponent(fileLocation)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fileNameL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileName))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fileRankL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileRank)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileNameL)
                    .addComponent(fileName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileRankL)
                    .addComponent(fileRank))
                .addGap(22, 22, 22)
                .addComponent(fileLocationL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fileLocation)
                .addGap(67, 67, 67)
                .addComponent(openButton)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        endOfResultsL.setText("End Of Results");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(endOfResultsL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(endOfResultsL))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
       if (iconSelected > -1){

       }
    }//GEN-LAST:event_openButtonActionPerformed

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
    public void addDocument(Document doc)
    {
    	//int columns = (UIController.getInstance().getFrame().getWidth() - fileInfoPanel.getWidth())/WIDTH_OF_SLOT;
    	int columns = 3;
        documents.add(doc);
        labels.add(doc.getName());
        icons.add(icons.lastElement());
        
        int lastSlotx = slots.lastElement().x;
        int lastSloty = slots.lastElement().y;
        
        if(lastSlotx/WIDTH_OF_SLOT >= columns){
        	Point p = new Point((WIDTH_OF_SLOT+ lastSlotx) + ICON_OFFSET,
        			lastSloty + ICON_OFFSET);
        	
        	iconPosition.add(p);
            hitBoxes.add(new Rectangle(p.x, p.y, WIDTH_OF_ICON, HEIGHT_OF_ICON));
            slots.add(new Point(WIDTH_OF_SLOT + lastSlotx, lastSloty));
        }
        else{
        	Point p = new Point((WIDTH_OF_SLOT * (0)) + ICON_OFFSET,
        			(HEIGHT_OF_SLOT +lastSloty) + ICON_OFFSET);
        	
        	iconPosition.add(p);
            hitBoxes.add(new Rectangle(p.x, p.y, WIDTH_OF_ICON, HEIGHT_OF_ICON));
            slots.add(new Point(WIDTH_OF_SLOT *(0), HEIGHT_OF_SLOT+ lastSloty));        	
        }
        
        
    }
    
    /**
     * Retrieves and initializes images used in the visual panel.
     */
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
      
        for (int i = 0; i < documents.size(); i++){
            icons.add(icon);
        }
        
        for (int i = 0; i < documents.size(); i++){
            labels.add(documents.elementAt(i).getName());
        }
            
    }
  
    /**
     * Sets up the Grid that the icons will be displayed on.
     */
    public void initGrid(){
        
        int x = 0;
        int y = 0;
        
        
        //int columns = (UIController.getInstance().getFrame().getWidth() - fileInfoPanel.getWidth())/WIDTH_OF_SLOT;
        int columns = 3;
        for(int i = 0; i < documents.size(); i++){
        	
        	Point p = new Point((WIDTH_OF_SLOT *(x)) + ICON_OFFSET, 
                    (HEIGHT_OF_SLOT*y) + ICON_OFFSET);
                
                iconPosition.add(p);
                hitBoxes.add(new Rectangle(p.x, p.y, WIDTH_OF_ICON, HEIGHT_OF_ICON));
                slots.add(new Point(WIDTH_OF_SLOT *(x), HEIGHT_OF_SLOT*y));
                
                x++;
                if (x >= columns){
                	x = 0;
                	y++;
                }
        }
    }
    
    /**
     * Sets up the visualization with the set of documents passed to it.
     * @param d
     * An ArrayList of Documents that will appear in the visualization.
     */
    public void set(ArrayList<Document> d){
        for(int i = 0; i < d.size(); i++)
        	documents.add(d.get(i));
        initGraphics();
        initGrid();
        
    }
    
    /**
     * Clears all data from the visualization
     */
    public void clear(){
        documents.clear();
        slots.clear();
        labels.clear();
    }
    
    @Override
    /**
     * Paints the visualization in the window.
     */
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
        
        for (int i = 0; i < documents.size(); i++){
            slotx   = slots.elementAt(i).x;
            sloty   = slots.elementAt(i).y;

            g2.drawImage(slotImage, slotx, sloty, null);
            }

        for (int i = 0; i < documents.size(); i++){
            iconx   = iconPosition.elementAt(i).x;
            icony   = iconPosition.elementAt(i).y;
            text    = labels.elementAt(i);
            icon    = icons.elementAt(i);
            
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
        validate();

        int maxy = 0;

        for(int i = 0; i < slots.size(); i++){
            if (slots.elementAt(i).y > maxy)
                maxy = slots.elementAt(i).y;
        }

        endOfResultsL.setLocation(15, maxy + HEIGHT_OF_SLOT + 15);
    }
    
    /**
     * Used to find which item has been clicked.
     * @param x
     * X coordinate of where the mouse clicked.
     * @param y
     * Y coordinate of where the mouse clicked.
     * @return
     * Returns the index of the clicked icon.
     * Returns -1 if no icon was clicked.
     */
    private int findClickedIcon(int x, int y){
        for(int i = 0; i < hitBoxes.size(); i++){
            if(hitBoxes.elementAt(i).contains(x, y)){
                return i;              
            }
        }
        return -1;
    }
    
    /**
     * When an icon is clicked, the information in the FileInfoDisplay will change
     * to match the clicked item.
     */
    public void mouseClicked(MouseEvent e) {
        iconSelected = findClickedIcon(e.getX(), e.getY());
        
        if(iconSelected > -1){
           fileName.setText(documents.elementAt(iconSelected).getName());
           fileLocation.setText(documents.elementAt(iconSelected).getPath());
           fileRank.setText(Double.toString(documents.elementAt(iconSelected).getRank()));
        }
        else{
            fileName.setText("None Selected");
            fileLocation.setText("None Selected");
            fileRank.setText("None Selected");
        }

    }


    public void mousePressed(MouseEvent e) {
        iconSelected = findClickedIcon(e.getX(), e.getY());
        
        if(iconSelected > -1){
        	fileName.setText(documents.elementAt(iconSelected).getName());
            fileLocation.setText(documents.elementAt(iconSelected).getPath());
            fileRank.setText(Double.toString(documents.elementAt(iconSelected).getRank()));
            lastx = hitBoxes.elementAt(iconSelected).x - e.getX();
            lasty = hitBoxes.elementAt(iconSelected).y - e.getY();
            updatePosition(e);
            pressedIcon = true;
        }
        else{
        	fileName.setText("None Selected");
            fileLocation.setText("None Selected");
            fileRank.setText("None Selected");
            pressedIcon = false;            
        }

    }

    /**
     * When the mouse button is released, if the selected icon is over the center
     * of another icon, they will switch places. Otherwise, it will return
     * to it's original location.
     */
    public void mouseReleased(MouseEvent e) {
    	if(iconSelected > -1){
    	for(int i = 0; i < slots.size(); i++){
    		if (hitBoxes.elementAt(iconSelected).contains(
    				slots.elementAt(i).x + OFFSET_TO_CENTER,
    				slots.elementAt(i).y + OFFSET_TO_CENTER)){
    			
    			swapElements(documents, iconSelected, i);
    			swapElements(labels, iconSelected, i);
    			swapElements(hitBoxes, iconSelected, i);
    		}	
    	}
    	
    	hitBoxes.elementAt(iconSelected).setLocation(
    			slots.elementAt(iconSelected).x + ICON_OFFSET, 
    			slots.elementAt(iconSelected).y + ICON_OFFSET);
    	
    	iconPosition.elementAt(iconSelected).setLocation(
    			slots.elementAt(iconSelected).x + ICON_OFFSET, 
    			slots.elementAt(iconSelected).y + ICON_OFFSET);
    	
    	validate();
    	repaint();
    	}
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
        if(pressedIcon)
            updatePosition(e);
    }

    public void mouseMoved(MouseEvent e) {
    }
    public boolean isOpaque(){return false;}
    /**
     * Used to update the position of a dragged item.
     * @param e
     * The MouseEvent that was used in one of the MouseListener functions
     */
    private void updatePosition(MouseEvent e){
        hitBoxes.elementAt(iconSelected).setLocation(lastx + e.getX(), lasty + e.getY());
        iconPosition.elementAt(iconSelected).setLocation(lastx + e.getX(), lasty + e.getY());
        validate();
        repaint();
    }
    
    /**
     * Swaps the positions of two items in a vector. Used to change positions of icons
     * int the mouseReleased function.
     * @param v
     * Vector to be manipulated.
     * @param indexA
     * Index of one of the items to be swapped.
     * @param indexB
     * Index of one of the items to be swapped.
     */
    private void swapElements(Vector v, int indexA, int indexB){
        Object temp = v.elementAt(indexA);
        v.set(indexA, v.elementAt(indexB));
        v.set(indexB, temp);        
    }
    

    private Vector<Document> documents			= new Vector();
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
    private javax.swing.JLabel endOfResultsL;
    private javax.swing.JLabel fileLocation;
    private javax.swing.JLabel fileLocationL;
    private javax.swing.JLabel fileName;
    private javax.swing.JLabel fileNameL;
    private javax.swing.JLabel fileRank;
    private javax.swing.JLabel fileRankL;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton openButton;
    // End of variables declaration//GEN-END:variables

}
