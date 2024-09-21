package com.banmaylanh.view;

import javax.swing.*;

public class LoginView extends JFrame {
    private JButton btnDangNhap;
    private JButton btnDangKy;
    private JLabel lblTenDangNhap;
    private JLabel lblMatKhau;
    private JLabel lblDangNhap;
    private JTextField txtTenDangNhap;
    private JPasswordField txtMatKhau;

    public LoginView() {
        initComponents();
    }

    private void initComponents() {
        // Khởi tạo các thành phần
        btnDangNhap = new JButton();
        btnDangKy = new JButton();
        lblTenDangNhap = new JLabel();
        lblMatKhau = new JLabel();
        txtTenDangNhap = new JTextField();
        txtMatKhau = new JPasswordField();
        lblDangNhap = new JLabel();

        // Đặt tiêu đề cho cửa sổ
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");

        // Thiết lập giao diện cho các thành phần
        lblDangNhap.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblDangNhap.setText("Đăng nhập");

        lblTenDangNhap.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblTenDangNhap.setText("Tên đăng nhập:");

        lblMatKhau.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblMatKhau.setText("Mật khẩu:");

        txtTenDangNhap.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        txtMatKhau.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

        btnDangNhap.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btnDangNhap.setText("Đăng Nhập");

        btnDangKy.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        btnDangKy.setText("Đăng Ký");

        // Tạo layout cho các thành phần
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(lblDangNhap)
                .addContainerGap(120, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenDangNhap)
                    .addComponent(lblMatKhau))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMatKhau)
                    .addComponent(txtTenDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblDangNhap)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenDangNhap)
                    .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatKhau)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangNhap)
                    .addComponent(btnDangKy))
                .addGap(60, 60, 60))
        );

        // Điều chỉnh kích thước cửa sổ
        pack();
        setLocationRelativeTo(null); // Căn giữa cửa sổ
    }

    public JButton getBtnDangNhap() {
        return btnDangNhap;
    }

    public JButton getBtnDangKy() {
        return btnDangKy;
    }

    public String getTenDangNhap() {
        return txtTenDangNhap.getText();
    }

    public String getMatKhau() {
        return new String(txtMatKhau.getPassword());
    }
}
