import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

class Min_max extends Frame implements ActionListener

{
   Label lb1, lb2, lb3, lb4, lb5, lb6;

   TextField txt2, txt3, txt4, txt5, txt6;
   TextArea txt1;

   Button btn1, btn2;
   private Scanner scan;
   String a = "";

   public void openFile() {
      try {
         scan = new Scanner(new File("skaiciu_grupes.csv"));
      } catch (Exception e) {
         txt1.setText("file ne najden");
      }
   }

   public void readFile() {
      while (scan.hasNext()) {
         a += scan.next() + ",";
         txt1.setText(String.valueOf(a));
      }
   }

   public Min_max() {
      lb1 = new Label("chislo");
      lb2 = new Label("kiekis");
      lb3 = new Label("sum");
      lb4 = new Label("max");
      lb5 = new Label("min");
      lb6 = new Label("vid");

      txt1 = new TextArea(5, 20);
      txt2 = new TextField(40);
      txt3 = new TextField(40);
      txt4 = new TextField(40);
      txt5 = new TextField(40);
      txt6 = new TextField(42);

      btn1 = new Button("skaiciuoti");
      btn2 = new Button("close");

      add(txt1);
      add(lb1);
      add(txt2);
      add(lb2);
      add(txt3);
      add(lb3);
      add(txt4);
      add(lb4);
      add(txt5);
      add(lb5);
      add(txt6);
      add(lb6);
      add(btn1);
      add(btn2);

      setSize(400, 600);
      setTitle("min_max");
      setLayout(new FlowLayout());
      // setLayout(new FlowLayout(FlowLayout.RIGHT));
      // setLayout(new FlowLayout(FlowLayout.LEFT));
      btn1.addActionListener(this);
      btn2.addActionListener(this);

   }

   public void actionPerformed(ActionEvent ae) {

      DecimalFormat dF = new DecimalFormat("#.###");
      String thisLine = txt1.getText();
      String[] skaiciu_strs = thisLine.split(",");
      int kiekis = 0;
      double sum = 0;
      double vid = 0;

      if (ae.getSource() == btn1) {
         double min_sk = Double.parseDouble(skaiciu_strs[0]);
         double max_sk = Double.parseDouble(skaiciu_strs[0]);
         for (int i = 0; i < skaiciu_strs.length; i++) {
            sum += Double.parseDouble(skaiciu_strs[i]);
            kiekis++;
            if (max_sk < Double.parseDouble(skaiciu_strs[i])) {
               max_sk = Double.parseDouble(skaiciu_strs[i]);
            }
            if (min_sk > Double.parseDouble(skaiciu_strs[i])) {
               min_sk = Double.parseDouble(skaiciu_strs[i]);
            }
            if (min_sk > Double.parseDouble(skaiciu_strs[i])) {
               min_sk = Double.parseDouble(skaiciu_strs[i]);
            }
            vid = sum / kiekis;
         }
         txt2.setText(String.valueOf(kiekis));
         txt3.setText(String.valueOf(sum));
         txt4.setText(String.valueOf(dF.format(max_sk)));
         txt5.setText(String.valueOf(dF.format(min_sk)));
         txt6.setText(String.valueOf(vid));
      }

      if (ae.getSource() == btn2) {
         System.exit(0);
      }
   }

   public static void main(String[] args) {
      Min_max k = new Min_max();
      k.setVisible(true);
      k.setLocation(800, 300);
      k.openFile();
      k.readFile();
   }
}