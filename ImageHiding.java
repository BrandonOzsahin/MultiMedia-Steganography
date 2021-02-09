import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageHiding extends JFrame implements ActionListener
{
  BufferedImage hostImage;
  BufferedImage secretImage;

  JPanel controlPanel;
  JPanel imagePanel;
  
  JTextField encodeBitsText;
  JButton encodeBitsPlus;
  JButton encodeBitsMinus;
  

  JRadioButton MLB;
  JRadioButton MLMB;
  JRadioButton LSM;
  JRadioButton LSMB;
  String mode = "";

  JTextField nBitsText;
  JButton nBitsPlus;
  JButton nBitsMinus;

  ImageCanvas hostCanvas;
  ImageCanvas secretCanvas;

  Steganography s;

  
     static String MLL = "MSB to LSB";
     static String MLM  = "MSB to MSB";
     static String LSLL = "LSB to LSB";
     static String LSBM = "LSB to MSB";
  

 public BufferedImage getHostImage()
 {
   BufferedImage img = null;

   try
   {
    img = ImageIO.read(new File("host_image.jpg"));
   }
   catch (IOException ioe) { ioe.printStackTrace(); }

   return img;
 }

 public BufferedImage getSecretImage()
 {
   BufferedImage img = null;

   try
   {
    img = ImageIO.read(new File("secret_image.jpg"));
   }
   catch (IOException ioe) { ioe.printStackTrace(); }

   return img;
 }

 public int getBits()
 {
   return Integer.parseInt(encodeBitsText.getText());
 }

 public void actionPerformed(ActionEvent event)
 {
 Object source = event.getSource();
 System.out.println(source.toString());
 System.out.println(MLB.toString());
  if (source == MLB)
  {
      mode = ("MSB to LSB");
    }
   else if(source == MLMB)
   {
       mode = ("MSB to MSB");
    }
    else if (source == LSM)
    {
        mode =("LSB to LSB");
    }
    else if (source == LSMB)
    {
        mode = ("LSB to MSB");
    }
   if (source == encodeBitsPlus)
   {
       if(mode == "MSB to LSB")
       {
    System.out.println("other statement");
    int bits = this.getBits() + 1;

    if (bits > 8) { bits = 8; }

    encodeBitsText.setText(Integer.toString(bits));

    s = new Steganography(this.getHostImage());
    s.encode(this.getSecretImage(), bits);


    hostCanvas.setImage(s.getImage());
    hostCanvas.repaint();
    
    

    s = new Steganography(this.getSecretImage());
    s.getMaskedImage(bits);

    secretCanvas.setImage(s.getImage());
    secretCanvas.repaint();
}
   else if(mode == "MSB to MSB")
   {
        int bits = this.getBits() + 1;

    if (bits > 8) { bits = 8; }

    encodeBitsText.setText(Integer.toString(bits));

    s = new Steganography(this.getHostImage());
    s.encode2(this.getSecretImage(), bits);


    hostCanvas.setImage(s.getImage());
    hostCanvas.repaint();
    
    

    s = new Steganography(this.getSecretImage());
 
   
    s.getMaskedImage(bits);

    secretCanvas.setImage(s.getImage());
    secretCanvas.repaint();
    }
    else if (mode == "LSB to LSB")
    {
    int bits = this.getBits() + 1;

    if (bits > 8) { bits = 8; }

    encodeBitsText.setText(Integer.toString(bits));

    s = new Steganography(this.getHostImage());
    s.encode(this.getSecretImage(), bits);


    hostCanvas.setImage(s.getImage());
    hostCanvas.repaint();
    
    

    s = new Steganography(this.getSecretImage());
 
   
    s.getMaskedImage2(bits);

    secretCanvas.setImage(s.getImage());
    secretCanvas.repaint();
    }
    else if (mode == "LSB to MSB")
    {
    int bits = this.getBits() + 1;

    if (bits > 8) { bits = 8; }

    encodeBitsText.setText(Integer.toString(bits));

    s = new Steganography(this.getHostImage());
    s.encode2(this.getSecretImage(), bits);


    hostCanvas.setImage(s.getImage());
    hostCanvas.repaint();
    
    

    s = new Steganography(this.getSecretImage());
 
   
    s.getMaskedImage2(bits);

    secretCanvas.setImage(s.getImage());
    secretCanvas.repaint();
    }
    
}
   else if (source == encodeBitsMinus)
  {
      if(mode == "MSB to LSB"){
    int bits = this.getBits() - 1;

    if (bits < 0)
    {
        bits = 0;
    }

    encodeBitsText.setText(Integer.toString(bits));

    s = new Steganography(this.getHostImage());
    s.encode(this.getSecretImage(), bits);
 

    hostCanvas.setImage(s.getImage());
    hostCanvas.repaint();

    s = new Steganography(this.getSecretImage());
    s.getMaskedImage(bits);


    secretCanvas.setImage(s.getImage());
    secretCanvas.repaint();
  }
  else if(mode == "MSB to MSB"){
          int bits = this.getBits() - 1;

    if (bits < 0)
    {
        bits = 0;
    }

    encodeBitsText.setText(Integer.toString(bits));

    s = new Steganography(this.getHostImage());
    s.encode2(this.getSecretImage(), bits);
 

    hostCanvas.setImage(s.getImage());
    hostCanvas.repaint();

    s = new Steganography(this.getSecretImage());
    s.getMaskedImage(bits);


    secretCanvas.setImage(s.getImage());
    secretCanvas.repaint();
    }
 else if(mode == "LSB to LSB")
 {
      int bits = this.getBits() - 1;

    if (bits < 0)
    {
        bits = 0;
    }

    encodeBitsText.setText(Integer.toString(bits));

    s = new Steganography(this.getHostImage());
    s.encode(this.getSecretImage(), bits);
 

    hostCanvas.setImage(s.getImage());
    hostCanvas.repaint();

    s = new Steganography(this.getSecretImage());
    s.getMaskedImage2(bits);


    secretCanvas.setImage(s.getImage());
    secretCanvas.repaint();
  
}
 else if(mode == "LSB to MSB")
 {
      int bits = this.getBits() - 1;

    if (bits < 0)
    {
        bits = 0;
    }

    encodeBitsText.setText(Integer.toString(bits));

    s = new Steganography(this.getHostImage());
    s.encode2(this.getSecretImage(), bits);
 

    hostCanvas.setImage(s.getImage());
    hostCanvas.repaint();

    s = new Steganography(this.getSecretImage());
    s.getMaskedImage2(bits);


    secretCanvas.setImage(s.getImage());
    secretCanvas.repaint();
  
 }
  }
}



         
 public ImageHiding()
 {
 
  GridBagLayout layout = new GridBagLayout();
  GridBagConstraints gbc = new GridBagConstraints();
  this.setTitle("Image Hiding Homework");

  Container container = this.getContentPane();

  this.setLayout(layout);

  this.add(new JLabel("Bits to encode into host image:"));
  
  encodeBitsText = new JTextField("0", 5);
  encodeBitsText.setEditable(false);

  gbc.weightx = -1.0;
  layout.setConstraints(encodeBitsText, gbc);
  this.add(encodeBitsText);

  encodeBitsPlus = new JButton("+");
  encodeBitsPlus.addActionListener(this);
  
  encodeBitsMinus = new JButton("-");
  encodeBitsMinus.addActionListener(this);
  
  gbc.weightx = 1.0;
  layout.setConstraints(encodeBitsPlus, gbc);
  this.add(encodeBitsPlus);
    
  gbc.gridwidth = GridBagConstraints.REMAINDER;
  layout.setConstraints(encodeBitsMinus, gbc);
  this.add(encodeBitsMinus);

  GridBagLayout imageGridbag = new GridBagLayout();
  GridBagConstraints imageGBC = new GridBagConstraints();

  imagePanel = new JPanel();
  imagePanel.setLayout(imageGridbag);
  
  JLabel hostImageLabel = new JLabel("Host image:");
  JLabel secretImageLabel = new JLabel("Secret image:");
  


  imagePanel.add(hostImageLabel);

  imageGBC.gridwidth = GridBagConstraints.REMAINDER;
  imageGridbag.setConstraints(secretImageLabel, imageGBC);
  imagePanel.add(secretImageLabel);

  hostCanvas = new ImageCanvas(this.getHostImage());  
  secretCanvas = new ImageCanvas(this.getSecretImage());

  imagePanel.add(hostCanvas);
  imagePanel.add(secretCanvas);

  gbc.gridwidth = GridBagConstraints.REMAINDER;
  layout.setConstraints(imagePanel, gbc);
  this.add(imagePanel);
  

  /*
  * 
  * RADIO BUTTONS FOR GUI
  * 
  */
  MLB =  new JRadioButton(MLL);
  MLB.addActionListener(this);

  MLMB =  new JRadioButton(MLM);
  MLMB.addActionListener(this);
  
  LSM =  new JRadioButton(LSLL);
  LSM.addActionListener(this);

 
  LSMB = new JRadioButton(LSBM);
  LSMB.addActionListener(this);


  ButtonGroup group = new ButtonGroup();
  group.add(MLB);
  group.add(MLMB);
  group.add(LSM);
  group.add(LSMB);
  
 
  JPanel buttonPanel = new JPanel(new GridLayout(0,1));
  buttonPanel.add(MLB);
  buttonPanel.add(MLMB);
  buttonPanel.add(LSM);
  buttonPanel.add(LSMB);  
  
  gbc.gridwidth = GridBagConstraints.REMAINDER;
  layout.setConstraints(buttonPanel, gbc);
  this.add(buttonPanel);
  
 ///////////////////


  
  Steganography host = new Steganography(this.getHostImage());
  host.encode(this.getSecretImage(), this.getBits());

  hostCanvas.setImage(host.getImage());

  Steganography secret = new Steganography(this.getSecretImage());
  secret.getMaskedImage(this.getBits());
  
  secretCanvas.setImage(secret.getImage());

  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.pack();

  this.setVisible(true);
 }

 public static void main(String[] args)
 {
  ImageHiding frame = new ImageHiding();
  frame.setVisible(true);
 }

 public class ImageCanvas extends JPanel
 { 
  Image img;

  public void paintComponent(Graphics g)
  {
   g.drawImage(img, 0, 0, this);
  }

  public void setImage(Image img)
  {
   this.img = img;
  }

  public ImageCanvas(Image img)
  {
   this.img = img;

   this.setPreferredSize(new Dimension(img.getWidth(this), img.getHeight(this)));
  }
 }
}

class Steganography
{
  BufferedImage image;

 public void getMaskedImage(int bits) //secret MSB OF
  {
   int[] imageRGB = image.getRGB(0, 0, image.getWidth(null), image.getHeight(null), null, 0, image.getWidth(null));

   int maskBits = (int)(Math.pow(2, bits)) - 1 << (8 - bits);
   int mask = (maskBits << 24) | (maskBits << 16) | (maskBits << 8) | maskBits;

   for (int i = 0; i < imageRGB.length; i++)
   {
    imageRGB[i] = imageRGB[i] & mask;
   }

   image.setRGB(0, 0, image.getWidth(null), image.getHeight(null), imageRGB, 0, image.getWidth(null));
 }
 
   public void getMaskedImage2(int bits) //secret LSB OF
  {
   int[] imageRGB = image.getRGB(0, 0, image.getWidth(null), image.getHeight(null), null, 0, image.getWidth(null));

   int maskBits = (int)(Math.pow(2, bits)) - 1 << (8 - bits);
   int mask = (maskBits << 24) | (maskBits << 16) | (maskBits << 8) | maskBits;

   for (int i = 0; i < imageRGB.length; i++)
   {
    imageRGB[i] = imageRGB[i] & mask >>> (8 - bits);
   }

   image.setRGB(0, 0, image.getWidth(null), image.getHeight(null), imageRGB, 0, image.getWidth(null));
 }
 
 public void encode(BufferedImage encodeImage, int encodeBits) // HOST IMAGE LSB
 {
   int[] encodeRGB = encodeImage.getRGB(0, 0, encodeImage.getWidth(null), encodeImage.getHeight(null), null, 0, encodeImage.getWidth(null));
   int[] imageRGB = image.getRGB(0, 0, image.getWidth(null), image.getHeight(null), null, 0, image.getWidth(null));

   int encodeByteMask = (int)(Math.pow(2, encodeBits)) - 1 << (8 - encodeBits);
   int encodeMask = (encodeByteMask << 24) | (encodeByteMask << 16) | (encodeByteMask << 8) | encodeByteMask;

   int decodeByteMask = ~(encodeByteMask >>>(8 - encodeBits)) & 0xFF;
   int hostMask = (decodeByteMask << 24) | (decodeByteMask << 16) | (decodeByteMask << 8) | decodeByteMask;

  for (int i = 0; i < imageRGB.length; i++)
  {
    int encodeData = (encodeRGB[i] & encodeMask) >>> (8 - encodeBits);
    imageRGB[i] = (imageRGB[i] & hostMask) | (encodeData & ~hostMask);
  }

   image.setRGB(0, 0, image.getWidth(null), image.getHeight(null), imageRGB, 0, image.getWidth(null));
 }
 
  public void encode2(BufferedImage encodeImage, int encodeBits) // HOST IMAGE MSB
 {
   int[] encodeRGB = encodeImage.getRGB(0, 0, encodeImage.getWidth(null), encodeImage.getHeight(null), null, 0, encodeImage.getWidth(null));
   int[] imageRGB = image.getRGB(0, 0, image.getWidth(null), image.getHeight(null), null, 0, image.getWidth(null));

   int encodeByteMask = (int)(Math.pow(2, encodeBits)) - 1 << (8 - encodeBits);
   int encodeMask = (encodeByteMask << 24) | (encodeByteMask << 16) | (encodeByteMask << 8) | encodeByteMask;

   int decodeByteMask = ~(encodeByteMask >>>(8 - encodeBits)) & 0xFF;
   int hostMask = (decodeByteMask << 24) | (decodeByteMask << 16) | (decodeByteMask << 8) | decodeByteMask;

  for (int i = 0; i < imageRGB.length; i++)
  {
    int encodeData = (encodeRGB[i] & encodeMask) >>> (8 - encodeBits);
   // int value =(encodeData & ~hostMask);
    imageRGB[i] = (imageRGB[i] & hostMask)   >>> (encodeBits) | (encodeData << 8-encodeBits);
  }

   image.setRGB(0, 0, image.getWidth(null), image.getHeight(null), imageRGB, 0, image.getWidth(null));
 }
 

 public Image getImage()
 {
   return image;
 }

 public Steganography(BufferedImage image)
 {
   this.image = image;
 }
}
