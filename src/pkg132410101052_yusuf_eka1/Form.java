package pkg132410101052_yusuf_eka1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author blegoh
 */
public class Form {
    
    /*
    *Atribut" atribut yang di pakai dalam class Form
    *Baik itu object maupun variabel
    *Untuk button angka di sini saya menggunakan array
    */

    JFrame form;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    JPanel panel5;
    JLabel view;
    JLabel isian;
    JButton angka[];
    JButton samaDengan;
    JButton tambah;
    JButton kurangi;
    JButton kali;
    JButton bagi;
    int bil1;
    int bil2;
    boolean isOperated;
    char operation;

    public Form() {
        /*
        *Constructor dari class From
        */
        isOperated = true;
        this.initComponents();
    }

    private void initComponents() {
        angka = new JButton[10]; // inisialisasi object angka
        form = new JFrame("Calculator"); // instantiate JFrame dengan title Calculator
        form.setSize(180, 140); // mengeset ukuran JFrame
        form.setLocationRelativeTo(null); //mengeset lokasi JFrame
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //mengeset close opartion pada JFrame

        panel1 = new JPanel(); // instantiate object panel1
        panel1.setLayout(new GridLayout(2, 1));// mengeset layout manager pada panel1 dengan gridlayout
        view = new JLabel(" "); // instantiate object label view
        view.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);//mengeset label agar rata kanan
        isian = new JLabel(" ");// instantiate object label view
        panel1.add(view);// menambakan label view ke dalam panel1
        panel1.add(isian);// menambakan label isian ke dalam panel1
        form.add(panel1, BorderLayout.NORTH);// menambakan panel1 ke dalam frame form

        panel2 = new JPanel(); // instantiate object panel2
        panel2.setLayout(new GridLayout(3, 3));// mengeset layout manager pada panel2 dengan gridlayout
        for (byte i = 1; i < 10; i++) { // menggunakan perulangan untuk menempatkan tombol 1 - 10
            final byte a = i;
            angka[i] = new JButton(String.valueOf(i));// instantiate object angka[i] dengan text i
            //memberikan event handling pada tombol
            angka[i].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    klikAngka(evt, a);
                }
            });
            // menambakan label tombol [1] ke dalam panel2
            panel2.add(angka[i]);
        }

        panel3 = new JPanel(new GridLayout(1, 2));// instantiate object panel3 dengan gridlayout
        angka[0] = new JButton("0");//instantiate object angka[0] dengan text 0
        //memberikan event handling pada tombol
        angka[0].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                klikAngka(evt, 0);
            }
        });
        panel3.add(angka[0]);// menambakan label tombol [1] ke dalam panel3
        samaDengan = new JButton("=");//instantiate object samaDengan dengan text "="
        //memberikan event handling pada tombol
        samaDengan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                klikSamaDengan(evt);
            }
        });
        panel3.add(samaDengan);// menambakan label tombol samaDengan ke dalam panel3

        panel4 = new JPanel(new BorderLayout());// instantiate object panel4 dengan borderlayout
        panel4.add(panel2, BorderLayout.CENTER);// menambakan panel2 ke dalam panel4
        panel4.add(panel3, BorderLayout.SOUTH);// menambakan panel3 ke dalam panel4

        form.add(panel4, BorderLayout.CENTER); // menambakan panel4 ke dalam frame form

        panel5 = new JPanel(new GridLayout(4, 1));// instantiate object panel5 dengan grid
        tambah = new JButton("+");// instantiate object tambah 
        //memberikan event handling pada tombol
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                klikOperation(evt, '+');
            }
        });
        
        kurangi = new JButton("-");// instantiate object kurangi
        //memberikan event handling pada tombol
        kurangi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                klikOperation(evt, '-');
            }
        });
        kali = new JButton("*");// instantiate object kali
        //memberikan event handling pada tombol
        kali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                klikOperation(evt, '*');
            }
        });
        bagi = new JButton("/");// instantiate object bagi
        //memberikan event handling pada tombol
        bagi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                klikOperation(evt, '/');
            }
        });
        
        panel5.add(tambah);// menambakan tambah ke dalam panel5
        panel5.add(kurangi);// menambakan kurangi ke dalam panel5
        panel5.add(kali);// menambakan kali ke dalam panel5
        panel5.add(bagi);// menambakan bagi ke dalam panel5

        form.add(panel5, BorderLayout.EAST);// menambakan panel5 ke dalam frame form

        form.setVisible(true);//menampilkan form
    }

    /*
    *method yg digunakan untuk menangani event handling dari tombol angka
    *menggunakan parameter int tombole untuk mengetahui angka mana yg di klik
    */
    private void klikAngka(java.awt.event.ActionEvent evt, int tombole) {
        if (isOperated) {
            this.isian.setText(String.valueOf(tombole));
            isOperated = false;
        } else {
            this.isian.setText(this.isian.getText() + String.valueOf(tombole));
        }
    }

    /*
    *method yg digunakan untuk menangani event handling dari tombol samaDengan
    */
    private void klikSamaDengan(java.awt.event.ActionEvent evt) {
        if (!isOperated) {
            bil2 = Integer.parseInt(isian.getText());
            this.operationValue(this.operation);
        }
        view.setText("");
        isian.setText(String.valueOf(bil1));
        bil1 = 0;
        bil2 = 0;
        isOperated = true;
    }

    /*
    *method yg digunakan untuk menangani event handling dari tombol angka
    *menggunakan parameter char operation untuk mengetahui operasi mana yg di klik
    */
    private void klikOperation(java.awt.event.ActionEvent evt, char operation) {
        if (!isOperated) {
            if (bil1 == 0) {
                //jika bil1 0 maka isian di masukan bil1
                bil1 = Integer.parseInt(isian.getText());
                isian.setText("");
                view.setText(String.valueOf(bil1));
            } else if (bil2 == 0) {
                /*
                *jika bil2 0 maka isian di masukan bil2
                * kemudian langsung di operasikan dan hasilnya disimpan ke bil1
                *pengoperasiannya menggunakan method operationValue
                */
                bil2 = Integer.parseInt(isian.getText());
                view.setText(view.getText() + String.valueOf(bil2));
                this.operationValue(this.operation);
                bil2 = 0;
                isian.setText(String.valueOf(bil1));
            }
        }
        if (this.isOperation(view.getText().charAt(view.getText().length() - 1))) {
            view.setText(view.getText() + operation);
        } else {
            view.setText(view.getText().substring(0, view.getText().length() - 1) + operation);
        }
        isOperated = true;
        this.operation = operation;
        //mengganti operation dengan yang terbaru
    }

    /*
    *method yg digunakan untuk menjumlahkan bil1 dan bil2
    */
    private void operationValue(char operator) {
        switch (operator) {
            case '+':
                this.bil1 += this.bil2;
                break;
            case '-':
                this.bil1 -= this.bil2;
                break;
            case '*':
                this.bil1 *= this.bil2;
                break;
            case '/':
                this.bil1 /= this.bil2;
                break;
        }
    }

    /*
    *method yg digunakan untuk mengetahui apakah tombol yg terakhir di klik adalah tombol operasi
    */
    private boolean isOperation(char a) {
        return (a != '+' && a != '-' && a != '*' && a != '/');
    }
}
